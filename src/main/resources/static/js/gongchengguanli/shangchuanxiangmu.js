var vm_paichugaoxiao = new Vue({
	el : "#paichugaoxiao",
	data : {
		piciid : $("#piciid").val(),
		piciname : "",
		xianyougaoxiao:{},
		gaoxiao:{},
		xianyougaoxiaolist : [],   //现有高校名单
		gaoxiaolist : [],		   //需要上传的高校名单

	},
	created : function(){
		this.findPiciInfo();
		this.findXianyouGaoxiao();
	},
	methods : {
		
		// 绑定批次名称
		findPiciInfo : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post("/ds/sszhuanxiang/api/guojijiaoliupici/find_one", {
				piciid :  _this.piciid,
				rdm : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					
					if(result == "1") {
						var data = ppData.resultContent;
						_this.piciname = data.批次;
					}else{
						layer.alert(message);
					}
				}
			}, "json");
		},

		// 查询此批次现有高校名单
		findXianyouGaoxiao : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post("/ds/sszhuanxiang/api/guojijiaoliuxuexiao/find_gaoxiaolist_by_piciid", {
				piciid :  _this.piciid,
				rdm : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					
					if(result == "1") {
						_this.xianyougaoxiaolist = ppData.resultContent;
					}else{
						layer.alert(message);
					}
				}
			}, "json");
		},

		
		//弹出上传高校名单xls模态框
		showUploadXls: function () {
			let _this= this;
			$("#uploadModal").modal("show");
			this.getFileUrl("gaoxiaomingdan",'51200','xls,xlsx',_this.piciid);
		},
		
		// 将文件上传到指定地址,并接受返回过来的路径，																
		getFileUrl : function(ppFolderName,ppFileSize,ppShangChuanWenJianLeiXing,ppPiciId){
			var _this = this;
			
			// load统一上传项目
			$("#uploadModal-body").load("/ds/sszhuanxiang/upload_batch.html?fujianpath=/ds/paichu/"+ppFolderName+"&filesize="+ppFileSize, function(){
				UploadVue.Init(ppShangChuanWenJianLeiXing,ppFileSize+"kb",function(jsonList){
					if(jsonList.length==0){
						return;
					}
					var filename=jsonList[0].filename;
					var fileurl=jsonList[0].fileurl;
					var filesize=jsonList[0].filesize;
					_this.getValue(fileurl,ppPiciId);
				},function(){
					$("#uploadModal").modal("hide");
				});
			});
		},
		
		// 
		getValue : function(ppFileurl,ppPiciId){
			var _this = this;
			layer.open({type:3});
			$.post("/ds/sszhuanxiang/api/import_paichugaoxiao/get_value",{
				fileurl:ppFileurl,
				piciid:ppPiciId,
				random : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData != null){
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					var data = mmData.resultContent;
					if(result == "1") {
						$(".daoruzhuangtai").html("");
						_this.gaoxiaolist = ppData.resultContent;
						$("#uploadModal").modal("hide");
						$("#PaichuGaoxiaolistModal").modal("show");
						
					}else{
						layer.alert(message);
					}
				}
			},"json");
		},

		// 批量导入项目目录
		importGaoxiao : function(){
			var _this = this;
			layer.confirm("确定要导入所有高校名单吗？",{
				btn : ["是","否"]
			},function(){
				layer.closeAll("dialog");
				_this.startDaoru();
			});
		},

		// 开始批量导入
		startDaoru : function(){
			var _this = this;
			layer.open({type:3});
			$("#daoru").attr("disabled","disabled");
			
			// 从第一个开始导入
			_this.daoru(0); 
		},

		// 单个导入
		daoru : function(ppGaoxiaoCurrentIndex){
			layer.open({type:3});
			var _this=this;
			
			var  CurrentIndex = ppGaoxiaoCurrentIndex+1;
			
			layer.open({
				type: 3,
				content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在导入高校名单<br/>当前进度    "+CurrentIndex+" / "+_this.gaoxiaolist.length+"</div>"
			});

			$.post("/ds/sszhuanxiang/api/import_paichugaoxiao/import",{
				piciid:_this.piciid,
				zhongwenming:_this.gaoxiaolist[ppGaoxiaoCurrentIndex].中文名称,
				yinwenming:_this.gaoxiaolist[ppGaoxiaoCurrentIndex].英文名称,
				guojiamingcheng:_this.gaoxiaolist[ppGaoxiaoCurrentIndex].国家,
				random : Math.random()
			}, function(ppData) {
				layer.closeAll("loading");
				
				if (ppData.result == "0") {
					// 未成功导入
					$("#"+_this.gaoxiaolist[ppGaoxiaoCurrentIndex].序号).html("<span style='color:red;'>"+ppData.message+"</span>");
					if(ppGaoxiaoCurrentIndex >= _this.gaoxiaolist.length - 1){
						layer.alert("导入完成！");
					}else{
						ppGaoxiaoCurrentIndex++; // 将待导入的高校下标+1
						
						_this.daoru(ppGaoxiaoCurrentIndex);
					}

					$("#daoru").removeAttr("disabled");
				}else{
					//成功导入
					$("#"+_this.gaoxiaolist[ppGaoxiaoCurrentIndex].序号).html("<span style='color:green;'>导入成功</span>");
					if(ppGaoxiaoCurrentIndex >=_this.gaoxiaolist.length - 1){
						$("#daoru").removeAttr("disabled");
						layer.alert("导入完成！");	
					}else{
						ppGaoxiaoCurrentIndex++; // 将待导入的高校下标+1
						
						_this.daoru(ppGaoxiaoCurrentIndex);
					}
				}
			},"json") 
		},

		// 单个手动导入
		dangedaoru : function(ppGaoxiao){
			var _this = this;
			var mm序号 = ppGaoxiao.序号;
			
			layer.confirm("确定要导入此条高校吗？",{
				btn : ["是","否"]
			},function(){
				layer.open({type: 3});
				$.post("/ds/sszhuanxiang/api/import_paichugaoxiao/import",{
					piciid : _this.piciid,
					zhongwenming:ppGaoxiao.中文名称,
					yinwenming:ppGaoxiao.英文名称,
					guojiamingcheng:ppGaoxiao.国家,
					random : Math.random()
				}, function(ppData) {
					layer.closeAll("loading");
					
					if (ppData.result == "0") {
						layer.alert(ppData.message);
						$("#"+mm序号).html("<span style='color:red;'>"+ppData.message+"</span>");
					}else{
						layer.alert("导入成功！");	
						$("#"+mm序号).html("<span style='color:green;'>导入成功</span>");
					}
				},"json")
			})
		},

		// 重写关闭模态框的方法 -- 刷新列表
		close : function(){
			this.findXianyouGaoxiao();
		},

		// 删除此批次下的全部项目目录
		toDelete : function(){
			var _this = this;

			layer.confirm("确定要删除列表中的全部高校吗？",{
				btn : ["是","否"]
			},function(){
				layer.open({type: 3});
				$.post("/ds/sszhuanxiang/api/import_paichugaoxiao/delete_gaoxiaomingdan",{
					piciid : _this.piciid,
					random : Math.random()
				}, function(ppData) {
					layer.closeAll("loading");
					
					if (ppData.result == "0") {
						layer.alert(ppData.message);
					}else{
						layer.open({
							time:1000,
							btn:[],
							content:"删除成功！",
						});
						
						_this.findXianyouGaoxiao();
					}
				},"json")
			})
		},
		
	}	
});