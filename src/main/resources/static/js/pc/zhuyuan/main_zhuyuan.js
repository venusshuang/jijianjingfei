var Zhuyuan_Vue = new Vue({
	el : '#Zhuyuan',
	data : {
		
		administratorid:$("#administratorid").val(),
		name : $("#name").val(),
		chuangjianshijian : $("#chuangjianshijian").val(),
		shoujihao : $("#shoujihao").val(),
		zhuyuanlist : [],
		zhuyuan : {},	
		editFlag : 0,// 0:单个，1：批量
		show : true,// 显示列表是否有数据
		zhuyuanid : '',	
		bingzhongid : '',	
		bingzhonglist : [],
		shenheyijian:'',
		ddShenHeCount : 0,
		ddShenHeCurrentIndex : 0,
		
		xiaoxilist : [],
		neirong : '',
		userid : '',
		id : '',
		username : '',
		shenhejieguo:0,
		
		pageindex : 1,
	    pagesize : 10,
	    pageCount : "",
	    recordCount : "",
	    targetpage : "",
	    inputPageIndexValue : "",
	},
	
	created : function() {
		
		var _this = this;
		
		_this.bindBingzhongList();
		_this.bindZhuyuanList();
		
		setInterval(function(){
			_this.bindZhuyuanList();
		},'10000');
	},
	watch : {
		
		//监控分页情况
		pageindex : function(){
			this.bindZhuyuanList();
		},
		pagesize : function(){
			this.pageindex = 1;
			this.bindZhuyuanList();
		},
		
	},
	
	
	methods : {
	
		getDate : function() {
			 var _this=this;
			 
			 _this.chuangjianshijian = $("#chuangjianshijian").val(); 
		},
		
	
		bindZhuyuanList : function(){
			
			var _this = this;
			layer.open({type:3});
			
			$.post('/zhuyuan/find_custom_all',{
				xingming:_this.name,
				shoujihao:_this.shoujihao,
				bingzhong:_this.bingzhongid,
				yuyueriqi:_this.chuangjianshijian,
				shenhejieguo:_this.shenhejieguo,
				pageindex:_this.pageindex,
				pagesize:_this.pagesize,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						var list = data.List;
						var pageinfo = data.PageInfo;
						if(list.length>0){
							
							_this.zhuyuanlist = list;
							_this.recordCount = pageinfo.recordCount;
							_this.pageCount = pageinfo.pageCount;
							_this.targetpage = '';
						}else
						{
							_this.zhuyuanlist = [];
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		bindBingzhongList : function(){
			var _this = this;
			layer.open({type:3});
			$.post('/dict_bingzhong/find_valid', {
				rdm:Math.random()
			},function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.bingzhonglist = ppData.resultContent;
					}
				}
			},"json");
		},
		
		
		toRemove : function(){
			var _this = this;
			_this.name='';
			_this.chuangjianshijian='';
			_this.shoujihao='';
			_this.bingzhongid='';
			$("#name").val("");
			$("#chuangjianshijian").val("");
			$("#shoujihao").val("");
			$("#bingzhongid").val("");
		},
		
		allCheckShenhe : function(){
			var _this = this;

			if($("#allCheckShenhe").is(":checked"))
			{
			    $("input[name='shenheCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='shenheCheckbox']").prop('checked',false);
			}
	
		},
		
		perpareToShenheAll:function(){
			
			var _this = this;

			var mmZhuyuanIdList="";
			_this.ddShenHeCount=0;
			$("[name=shenheCheckbox]:checked").each(function(){
				mmZhuyuanIdList+="|"+this.value;
				 _this.ddShenHeCount++;
			})
			mmZhuyuanIdList=mmZhuyuanIdList!=""?mmZhuyuanIdList.substring(1):"";
			
			if(mmZhuyuanIdList == ""){
				layer.alert("请选择要审核的预约住院信息！");
				return false;
			}
			
			$('#editShenheModal').modal();
			$("#myModalLabel_Shenhe").html("审核预约挂号信息");
			_this.editFlag=1;
			
			_this.zhuyuanid = "";
		
			_this.shenheyijian="";
			$("input[name='YuyueResult']").prop('checked',false);
			
		},
		
		toShenheAll:function(){

			var _this = this;
			_this.ddShenHeCurrentIndex=0;
			_this.editFlag=1;
			$("[name=shenheCheckbox]:checked").each(function(){
				_this.zhuyuanid=this.value;
				_this.toShenhe();
			})

		},

		perpareToShenhe : function(ppZhuyuanId,ppShenhejieguo,ppShenheyijian){
			this.editFlag=0;
			$('#editShenheModal').modal();
			$("#myModalLabel_Shenhe").html("审核预约住院信息");

			this.zhuyuanid = ppZhuyuanId;
			$("input[name='YuyueResult']").prop("checked",false); 
			$("input[name='YuyueResult'][value="+ppShenhejieguo+"]").prop("checked",true); 
			this.shenheyijian = ppShenhejieguo==0 ? "" : ppShenheyijian;
		},
		
		
		toShenhe : function(){
			var _this = this;
			
			if($("input[name='YuyueResult']:checked").val()==""||$("input[name='YuyueResult']:checked").val()==null)
			{
				layer.alert("请选择预约结果！");
				return false;
			}

			if($("input[name='YuyueResult']:checked").val()=="2")
			{
				if(_this.shenheyijian=="")
				{
					layer.alert("预约失败，请填写备注信息！");
					return false;
				}
				
			}
			
			$.post("/zhuyuan/shenhe", {
				zhuyuanid : _this.zhuyuanid,
				shenhejieguo : $("input[name='YuyueResult']:checked").val(),
				shenheyijian : _this.shenheyijian,
				fajianrenid : _this.administratorid,
				neirong : _this.shenheyijian,
				random : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if(ppData.result != "1"){
						layer.alert(ppData.message);
					}else{
						_this.ddShenHeCurrentIndex++;
						
					
						if(_this.ddShenHeCurrentIndex==_this.ddShenHeCount&&_this.editFlag==1)	
						{
							layer.open({
								time:1000,
								btn:[],
								content:"审核成功!",
							});
							$("#editShenheModal").modal("hide");
							_this.bindZhuyuanList();
							$("input[name='shenheAllCheckbox']").prop('checked',false);
							$("input[name='shenheCheckbox']").prop('checked',false);
						}else if(_this.editFlag==0)
						{
							layer.open({
								time:1000,
								btn:[],
								content:"审核成功!",
							});
							$("#editShenheModal").modal("hide");
							_this.bindZhuyuanList();
							
						}

						
						
						
					}
				}
			},"json");
			
		},
		
		ShowNews:function(ppOwnerId,ppUserId,ppUserName){
			var _this = this;
			
			_this.userid = ppUserId;
			_this.id = ppOwnerId;
			_this.username = ppUserName;
			
			$("#listXiaoxiModal").modal();
			_this.bindXiaoxiList();
			setInterval(function(){
				_this.bindXiaoxiList();
			},5000);
		},
		
		bindXiaoxiList:function(){
			var _this = this;
			$.post('/news/find_by_ownerid',{
				ownerid : _this.id,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						var div = document.getElementById('messagelist');
						div.scrollTop = div.scrollHeight;
						_this.xiaoxilist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		//首页
		firstPage : function(){
			this.pageindex = 1;
		},
		
		//尾页
		lastPage : function(){
			this.pageindex = this.pageCount;
		},
		
		//上一页
		prePage : function(){
			var prePage = ((this.pageindex -1) <= 0) ? 1 : (this.pageindex -1);
			this.pageindex = prePage;
		},
		
		//下一页
		nextPage : function(){
			var nextPage = ((this.pageindex +1) >= this.pageCount) ? this.pageCount : (this.pageindex +1);
			this.pageindex = nextPage;
		},
		
		//跳到目标页
		targetPage : function() {
			if( this.targetpage != '' && this.targetpage <= this.pageCount && this.targetpage > 0){
				this.pageindex = this.targetpage;
				this.targetpage = '';
			}
		},
		
		toAdd : function(){
			var _this = this;
			
			layer.open({type:3});
			
			if(!$.trim(_this.neirong)){
				return;
			}
			
			$.post('/news/add', {
				fajianrenid : 'zhuyuanguanliyuan',
				fajianrenname : '住院管理员',
				shoujianrenid : _this.userid,
				shoujianrenname : _this.username,
				neirong : _this.neirong,
				newstype: '2',
				ownerid : _this.id,
				rdm:Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					var data = mmData.resultContent;
					if(result == "1"){
						_this.neirong = "";
						var div = document.getElementById('messagelist');
						div.scrollTop = div.scrollHeight;
						_this.bindXiaoxiList();
					}else{
						_this.showMessage(message);
					}
				}
			},"json");
		},

	}
})
