var _loginVue = new Vue({
	el:"#login",
	data:{
		loginname : "",
		password : "",
	},
	created : function(){
	},
	methods:{
		
		cleanFormRegister : function(){
			this.loginname = "";
			this.password = "";
		},
		
		showMessage:function(ppMessage){
			var _this = this;
			$("#message").html(ppMessage);
			setTimeout(function(){
				_this.cleanMessage();
			},'2000');
		},
		
		cleanMessage:function(){
			var _this = this;
			_this.showMessage("");
		},
		
		toLogin : function(){
			var _this = this;
			
			if(!_this.loginname){
				_this.showMessage("请填写登录账号！");
				return false;
			}
			
			if(!_this.password){
				_this.showMessage("请填写登录密码!");
				return false;
			}
		
			layer.open({type:3});
			
			$.post('../administrator/login', {
				zhanghao : _this.loginname,
				password : _this.password,
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
								_this.showMessage("登录成功！");
								setTimeout(function(){
									location.href="/index.html";
								},'1000');
							}else{
								_this.showMessage(message);
							}
						}
					}
				}
			},"json");
		}
	}
})