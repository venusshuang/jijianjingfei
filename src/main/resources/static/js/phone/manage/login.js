var _loginVue = new Vue({
	el:"#login",
	data:{
		shoujihaoma : "",
		password : "",
		type : "",
		
	},
	created : function(){
		
		// 根据cookie的key值去找value
		var cookie = this.getMyCookie("loginInfo");

		var mmDecCookie = decodeURIComponent(cookie);
		
		var mmDecCookie_array = mmDecCookie.split("&");
		
		// 赋值
		$("#loginname").val(mmDecCookie_array[0]);
		this.shoujihaoma = $("#loginname").val();
		
		$("#password").val(mmDecCookie_array[1]);
		this.password = $("#password").val();
		
		$("#sel_type").val(mmDecCookie_array[2]);
		this.type = $("#sel_type").val();
	},
	methods:{
		// 根据cookie的key值去找value
		getMyCookie : function (key){
			var val = "";
		
			// 对cookie操作
			
			// 获取cookie中的值
			var cookies = document.cookie;
			cookies = cookies.replace(/\s/,"");
			
			// 可能存在多个用";"分隔的值
			var cookie_array = cookies.split(";");
			
			// 循环cookie中的值
			for(i = 0 ; i < cookie_array.length ; i++){
				
				// 获取循环中的值
				var cookie = cookie_array[i];
				var array = cookie.split("=");
				
				// 若key值等于传过来的key值，则把val返回
				if(array[0] == key){
					val = array[1];
				}
			}
			
			return val;
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
		
		toLogin : function(){
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
			
			if(!_this.type){
				_this.showMessage("请选择用户类型！");
				return false;
			}
			
			var mmIsRememberPassword = $("#remember_password").is(":checked") ? '1' : '0';
			
			layer.open({type:3});
			
			if(_this.type=='1'){
				$.post('../doctor_login/check_doctor_login', {
					loginname : _this.shoujihaoma,
					loginpassword : _this.password,
					rememberpassword : mmIsRememberPassword,
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
									_this.showMessage("登录成功！即将跳转到登录页面。");
									
									setTimeout(function(){
										location.href="../../homepage/index_doctor.html";
									},'1000');
									
								}else{
									_this.showMessage(message);
								}
							}
						}
					}
				},"json");
			}
			else if(_this.type =='2'){
				$.post('../patient_login/check_patient_login', {
					loginname : _this.shoujihaoma,
					loginpassword : _this.password,
					rememberpassword : mmIsRememberPassword,
					rdm:Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");
						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							_this.showMessage("登录成功！即将跳转到登录页面。");
							setTimeout(function(){
								location.href="../../homepage/index_patient.html";
							},'1000');
							
						}else{
							_this.showMessage(message);
						}
					}
				},"json");
			}
		}
	}
})