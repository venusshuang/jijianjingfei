var vm_zhuanzhenYijian = new Vue({
	el : "#zhuanzhenYijian",
	data : {
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		referraid : $("#referraid").val(),
		
		zhuanzhen : {},			// 转诊信息
		xiaoxilist : [],		// 消息列表
		
		neirong : "",			// 消息内容
	},
	created : function(){
		var _this = this;
		
		// 根据转诊id查询转诊信息
		_this.findByZhuanzhenId();
		
		// 根据转诊id查询消息列表
		_this.findXiaoxiListByOwnerId();
		
		// 设置已读
		_this.setYidu();
		
		// 定时刷新列表
		setInterval(function(){
			_this.findXiaoxiListByOwnerId();
		},5000);
	},
	methods : {
		// 根据转诊id查询转诊信息
		findByZhuanzhenId : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/referral/find_one',{
				referraid : _this.referraid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						
						_this.zhuanzhen = data;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 根据转诊id查询消息列表
		findXiaoxiListByOwnerId : function(){
			var _this = this;
			
			$.post('/news/find_by_ownerid',{
				ownerid : _this.referraid,
				rdm : Math.random()
			},function(ppData){
				
				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.xiaoxilist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 设置已读
		setYidu : function(){
			var _this = this;
			
			layer.open({type:3});
			$.post('/news/set_yidu',{
				ownerid : _this.referraid,
				shoujianrenid : _this.userid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData != null){
					if(ppData.result == '1'){
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 修改
		toModify : function(ppReferraId){
			window.location.href = "/homepage/zhuanzhen_edit.html?referraid="+ppReferraId;
		},
		
		// 删除
		toDelete : function(ppReferraId){
			var _this = this;
			
			var mmContent = "<div style='font-size:40px;font-family: -apple-system-font,Helvetica Neue,sans-serif;'>确定删除该条转诊信息吗？</div>";
			layer.confirm(mmContent,{
				area: ['60%', '360px'],
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				
				$.post("/referral/delete", {
					referraid : ppReferraId,
					rdm : Math.random()
				}, function(ppData) {
					layer.closeAll("loading");
					
					if (ppData != null) {
						if(ppData.result == "1"){
							window.location.href = "/homepage/zhuanzhen_list.html";
						}else{
							layer.alert(ppData.message);
						}
					}
				},"json");
			})
		},
		
		// 发送消息
		toSendMessage : function(){
			var _this = this;
			
			layer.open({type:3});
			
			$.post('/news/add', {
				fajianrenid : _this.userid,
				fajianrenname : _this.zhuanzhen.doctorname,
				shoujianrenid : "zhuanzhenguanliyuan",
				shoujianrenname : "转诊管理员",
				neirong : _this.neirong,
				newstype : '3',
				ownerid : _this.referraid,
				rdm : Math.random()
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
								_this.findXiaoxiListByOwnerId();
								_this.neirong = "";
							}else{
								layer.alert(ppData.message);
							}
						}
					}
				}
			},"json");
		},
		
	}
	
})