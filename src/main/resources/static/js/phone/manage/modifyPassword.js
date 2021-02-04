var vm_modifyPassword = new Vue({
	el : "#modifypas",
	data : {
		usertype : $("#usertype").val(),	// 当前登录的用户类型
		userid : $("#userid").val(),	// 当前登录的用户id

		shoujihaoma : "",
		password : "",
	},
	created : function(){
		
	},
	methods : {
		// 点击“确认修改”按钮
		toModifyPassword : function(){
			var _this = this;

			if(!_this.shoujihaoma){
				_this.showMessage("请填写登录账号！");
				return false;
			}

			if(!_this.password){
				_this.showMessage("请填写新密码!");
				return false;
			}
			
			var passwordReg =  /^\d{6}$/;
			if(!passwordReg.test(this.password)){
				_this.showMessage("新密码必须为6位数字！");
				return false;
			}

			layer.open({type:3});

			if(_this.usertype == "doctor"){
				// 医生
				$.post('../doctor_login/modify_password', {
					loginname : _this.shoujihaoma,
					password : _this.password,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#js_toast").show();
							
							setTimeout(function(){
								$("#js_toast").hide();
								_this.cleanForm();
							},'2000');
							
						}else{
							$("#message").html(message);
						}

					}
				},"json");
			}
			else if(_this.usertype == "patient"){
				// 患者
				$.post('../patient_login/modify_password', {
					loginname : _this.shoujihaoma,
					password : _this.password,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#js_toast").show();
							
							setTimeout(function(){
								$("#js_toast").hide();
								_this.cleanForm();
							},'2000');
							
						}else{
							$("#message").html(message);
						}
					}
				},"json");
			}
		},

		// 清空输入框
		cleanForm : function(){
			this.shoujihaoma = "";
			this.password = "";
		},

		// 提示
		showMessage : function(ppMessage){
			var _this = this;
			$("#message").html(ppMessage);
			setTimeout(function(){
				_this.cleanMessage();
			},'3000');
		},

		// 清空提示
		cleanMessage:function(){
			$("#message").html("");
		},

	},
})