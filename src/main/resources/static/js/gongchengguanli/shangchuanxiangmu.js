var vm_paichugaoxiao = new Vue({
	el : "#paichugaoxiao",
	data : {
		piciid : $("#piciid").val(),
		piciname : "",
		xianyougaoxiao:{},
		gaoxiao:{},
		xianyougaoxiaolist : [],   //现有高校名单
		xiangmulist : [],		   //需要上传的项目名单

	},
	created : function(){
		/*this.findPiciInfo();
		this.findXianyouGaoxiao();*/
	},
	methods : {

		//弹出上传高校名单xls模态框
		showUploadXls: function () {
			let fileurl=$("#imageurl").val();
			$("#uploadModal").modal("show");
			//this.getFileUrl("gaoxiaomingdan",'51200','xls,xlsx',_this.piciid);
			//this.getValue(fileurl);
		},
		
		// 将文件上传到指定地址,并接受返回过来的路径，																
		getFileUrl : function(ppFolderName,ppFileSize,ppShangChuanWenJianLeiXing,ppPiciId){
			let _this = this;
			alert(111)
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
		getValue : function(){
			let _this = this;
			layer.open({type:3});
			$.post("/import_xiangmu/get_value",{
				fileurl:$("#imageurl").val(),
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
						_this.xiangmulist = ppData.resultContent;
						$("#uploadModal").modal("hide");
						$("#XiangmuListModal").modal("show");
						
					}else{
						layer.alert(message);
					}
				}
			},"json");
		},
		//
		backup : function(){
			let _this = this;
			//layer.open({type:3});
			$.post("/import_xiangmu/backup",{
				random : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData != null){
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					var data = mmData.resultContent;
					alert(111);
				}
			},"json");
		},

		// 批量导入项目目录
		importGaoxiao : function(){
			let _this = this;
			layer.confirm("确定要导入所有项目吗？",{
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
			let _this=this;

			let  CurrentIndex = ppGaoxiaoCurrentIndex+1;
			
			layer.open({
				type: 3,
				content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在导入项目<br/>当前进度    "+CurrentIndex+" / "+_this.xiangmulist.length+"</div>"
			});

			$.post("/import_xiangmu/import",{
				xiangmumingcheng:_this.xiangmulist[ppGaoxiaoCurrentIndex].项目名称,
				pifuqingkuang:_this.xiangmulist[ppGaoxiaoCurrentIndex].两级批复情况,
				pifujine:_this.xiangmulist[ppGaoxiaoCurrentIndex].联保批复金额,
				random : Math.random()
			}, function(ppData) {
				layer.closeAll("loading");
				
				if (ppData.result == "0") {
					// 未成功导入
					$("#"+_this.xiangmulist[ppGaoxiaoCurrentIndex].序号).html("<span style='color:red;'>"+ppData.message+"</span>");
					if(ppGaoxiaoCurrentIndex >= _this.xiangmulist.length - 1){
						layer.alert("导入完成！");
					}else{
						ppGaoxiaoCurrentIndex++; // 将待导入的高校下标+1
						
						_this.daoru(ppGaoxiaoCurrentIndex);
					}

					$("#daoru").removeAttr("disabled");
				}else{
					//成功导入
					$("#"+_this.xiangmulist[ppGaoxiaoCurrentIndex].序号).html("<span style='color:green;'>导入成功</span>");
					if(ppGaoxiaoCurrentIndex >=_this.xiangmulist.length - 1){
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
		dangedaoru : function(ppXiangmu){
			let _this = this;
			let mm序号 = ppXiangmu.序号;
			
			layer.confirm("确定要导入此条项目吗？",{
				btn : ["是","否"]
			},function(){
				layer.open({type: 3});
				$.post("/import_xiangmu/import",{
					xiangmumingcheng:ppXiangmu.项目名称,
					pifuqingkuang:ppXiangmu.两级批复情况,
					pifujine:ppXiangmu.联保批复金额,
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
		
	}	
});