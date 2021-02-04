var vm_forgotPassword = new Vue({
	el : "#forgotpass",
	data : {
		shoujihaoma : "",
		name : "",
		type : "",
		password : "",
	},
	created : function(){

	},
	methods : {
		// 点击“找回密码”按钮
		toFindPassword : function(){
			var _this = this;
			
			// 清空message
			_this.cleanMessage();
			$("#password").css("display","none");

			if(!_this.shoujihaoma){
				_this.showMessage("请填写手机号！");
				return false;
			}

			var mobileReg =  /^\d{11}$/;
			if(!mobileReg.test(this.shoujihaoma)){
				_this.showMessage("手机号码必须为11位数字！");
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

			if(_this.type == '1'){
				// 医生
				$.post('../doctor_login/find_by_loginname_and_name', {
					loginname : _this.shoujihaoma,
					name : _this.name,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#password").css("display","block");
							_this.password = data.loginpassword;
							_this.cleanForm();
						}else{
							$("#message").html(message);
						}

					}
				},"json");
			}
			else if(_this.type =='2'){
				// 患者
				$.post('../patient_login/find_by_loginname_and_name', {
					loginname : _this.shoujihaoma,
					name : _this.name,
					rdm : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");

						var mmData = ppData;
						var result = mmData.result;
						var message = mmData.message;
						var data = mmData.resultContent;
						if(result == "1"){
							$("#password").css("display","block");
							_this.password = data.loginpassword;
							_this.cleanForm();
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
			this.name = "";
			this.type = "";
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
