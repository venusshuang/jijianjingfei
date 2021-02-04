var xiaoxieditVue = new Vue({
	el:"#xiaoxiedit",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		type : $("#type").val(),
		id : $("#id").val(),//挂号或住院ID
		
		detail : {},
		xiaoxilist : [],//消息列表
		neirong : '',
		
		show : true,
	},
	created : function(){
		var _this = this;
		
		$("#listPart").show();
		_this.setYidu();
		_this.bindDetailList();
		_this.bindXiaoxiList();
		setInterval(function(){
			_this.bindXiaoxiList();
		},5000);
	},
	methods:{
		setYidu:function(){
			var _this = this;
			
			$.post('/news/set_yidu',{
				ownerid : _this.id,
				shoujianrenid : _this.userid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
					}else{
					}
				}
			},"json");
		},
		
		// 绑定详情
		bindDetailList : function(){
			var _this = this;
			layer.open({type:3});
			
			if(_this.type=='guahao'){
				$.post('/guahao/find_custom_one',{
					guahaoid : _this.id,
					rdm:Math.random()
				},function(ppData){
					layer.closeAll("loading");
					if(ppData!=null){
						if(ppData.result == '1'){
							var data = ppData.resultContent;
							_this.detail = data;
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json");
			}else if(_this.type=='zhuyuan'){
				$.post('/zhuyuan/find_one',{
					zhuyuanid : _this.id,
					rdm:Math.random()
				},function(ppData){
					layer.closeAll("loading");
					if(ppData!=null){
						if(ppData.result == '1'){
							var data = ppData.resultContent;
							_this.detail = data;
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json");
			}
		},
		
		// 绑定详情
		bindXiaoxiList : function(){
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
		
		toAdd : function(){
			var _this = this;
			
			var mmShoujianrenId = "";
			var mmShoujianrenName = "";
			var mmNewsType = "";
			var mmFajianrenName = "";
			if(_this.type=='guahao'){
				mmShoujianrenId = "guahaoguanliyuan";
				mmShoujianrenName = "挂号管理员";
				mmNewsType = "1";
				mmFajianrenName = _this.detail.jiuzhenxingming;
			}else if(_this.type=='zhuyuan'){
				mmShoujianrenId = "zhuyuanguanliyuan";
				mmShoujianrenName = "住院管理员";
				mmNewsType = "2";
				mmFajianrenName = _this.detail.xingming;
			}
			
			if(!$.trim(_this.neirong)){
				return;
			}
			
			$.post('/news/add', {
				fajianrenid : _this.userid,
				fajianrenname : mmFajianrenName,
				shoujianrenid : mmShoujianrenId,
				shoujianrenname : mmShoujianrenName,
				neirong : _this.neirong,
				newstype: mmNewsType,
				ownerid : _this.id,
				rdm:Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if (ppData != null) {
						if(ppData != null){
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
					}
				}
			},"json");
		},
	}
})