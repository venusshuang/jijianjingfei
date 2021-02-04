var _registerVue = new Vue({
	el:"#register",
	data:{
		shoujihaoma : "",
		password : "",
		name : "",
		type : "",
	},
	created : function(){
	},
	methods:{
		
		cleanFormRegister : function(){
			this.shoujihaoma = "";
			this.password = "";
			this.name = "";
			this.type = "";
		},
		
		showMessage:function(ppMessage){
			var _this = this;
			$("#message").html(ppMessage);
			setTimeout(function(){
				_this.cleanMessage();
			},'2000');
		},
		
		cleanMessage:function(){
			$("#message").html("");
		},
		
		toRegist : function(){
			var _this = this;
			
			if(!_this.shoujihaoma){
				_this.showMessage("请填写手机号码！");
				return false;
			}
			
			var mobileReg =  /^\d{11}$/;
			if(!mobileReg.test(this.shoujihaoma)){
				_this.showMessage("手机号码必须为11位数字！");
				return false;
			}
			
			
			if(!_this.password){
				_this.showMessage("请填写登录密码!");
				return false;
			}
			
			var passwordReg =  /^\d{6}$/;
			if(!passwordReg.test(this.password)){
				_this.showMessage("登录密码必须为6位数字！");
				return false;
			}
			
			
			if(!_this.name){
				_this.showMessage("请填写姓名!");
				return false;
			}
			
			if(!_this.type){
				_this.showMessage("请选择用户类型！");
				return false;
			}
			
			layer.open({type:3});
			
			if(_this.type=='1'){
				$.post('../doctor_login/register_doctor', {
					loginname : _this.shoujihaoma,
					loginpassword : _this.password,
					phonenum : _this.shoujihaoma,
					name : _this.name,
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
									_this.showMessage("注册成功！即将跳转到登录页面。");
									setTimeout(function(){
										location.href="../../homepage/login.html";
									},'2000');
								}else{
									_this.showMessage(message);
								}
							}
						}
					}
				},"json");
			}
			
			else if(_this.type=='2'){
				$.post('../patient_login/register_patient', {
					loginname : _this.shoujihaoma,
					loginpassword : _this.password,
					phonenum : _this.shoujihaoma,
					name : _this.name,
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
									_this.showMessage("注册成功！即将跳转到登录页面。");
									setTimeout(function(){
										location.href="../../homepage/login.html";
									},'2000');
								}else{
									_this.showMessage(message);
								}
							}
						}
					}
				},"json");
			}
		}
	}
})