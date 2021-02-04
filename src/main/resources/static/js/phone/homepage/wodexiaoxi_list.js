var wodexiaoxiVue = new Vue({
	el:"#wodexiaoxi",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		
		wodexiaoxilist : [],//消息列表
		id : '',//挂号或住院ID
		
		show : true,
	},
	created : function(){
		var _this = this;
		
		$("#listPart").show();
		_this.bindNewsList();
	},
	methods:{
		
		// 绑定消息列表 
		bindNewsList : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/news/find_news_by_userid',{
				userid : _this.userid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						if(data.length>0){
							_this.show = true;
							_this.wodexiaoxilist = data;
						}else{
							_this.show = false;
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toCancelZhuyuan : function(ppId){
			var _this = this;
			
			layer.open({type:3});
			
			$.post('../zhuyuan/cancel', {
				zhuyuanid : ppId,
				shenhejieguo : '3',//3用户取消
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
								$("#js_toast").show()
								setTimeout(function(){
									location.reload();
								},'2000');
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