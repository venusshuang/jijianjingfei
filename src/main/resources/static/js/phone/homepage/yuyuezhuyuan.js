var vm_yuyuezhuyuan = new Vue({
	el : "#yuyuezhuyuan",
	data : {
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		
		name : "",
		shenfenzhenhao : "",
		xingbie : "",
		age : "",
		bingzhong : "",
		shoujihao : "",
		lianxidizhi : "",

		bingzhonglist : [],
		
		nianlingduanlist : [],
	},
	created : function(){
		var _this = this;
		
		// 绑定字典表
		_this.initDict();
		
		// 根据用户id绑定登录用户信息
		_this.bindByUserId();
	},
	methods : {

		// 绑定字典表
		initDict : function(){
			var _this = this;
			var _layer = layer.open({type:3});

			// 病种
			$.post('/dict_bingzhong/find_valid', {
				rdm : Math.random()
			},function(ppData) {
				layer.close(_layer);
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.bingzhonglist = ppData.resultContent;
					}
				}
			},"json");
			
			// 年龄段
			$.post('/dict_nianlingduan/find_valid',{
				rdm:Math.random()
			},function(ppData){
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.nianlingduanlist = data;
					}
				}
			},"json");
		},

		// 根据用户id绑定登录用户信息
		bindByUserId : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/patient_login/find_one',{
				userid : _this.userid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						
						if(data != null){
							_this.name = data.name;
							_this.shoujihao = data.shoujihao;
						}
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 点击预约 按钮
		yuyue : function(){
			var _this = this;
			
			var imageurls = "";
			
			$("img[name='imageurl']").each(function(){
				imageurls += $(this).attr("src")+";";
			});
			
			if(_this.checkInputData()){
				layer.open({type:3});
				
				$.post("/zhuyuan/add_custom",{
					userid : _this.userid,
					name : _this.name,
					shenfenzhenghaoma : _this.shenfenzhenhao,
					xingbie : _this.xingbie,
					age : _this.age,
					
					bingzhong : _this.bingzhong,
					shoujihao : _this.shoujihao,
					lianxidizhi : _this.lianxidizhi,
					imageurls : imageurls,
					rdm : Math.random()
				},function(ppData){
					layer.closeAll("loading");
					
					if(ppData != null){
						if(ppData.result == "1"){
							$("#js_toast").show();
							
							setTimeout(function(){
								$("#js_toast").hide();
								_this.cleanInputData();
							},'4000');
							
							
						}else{
							_this.showMessage(ppData.message);
						}
					}
				},"json")
			}
		},
		
		// 清空数据
		cleanInputData : function(){
			this.name = "";
			this.shenfenzhenhao = "";
			$("input[name='xingbie']").attr("checked",false);
			this.xingbie = "" ;
			this.age = "";
			this.bingzhong = "";
			this.shoujihao = "" ;
			this.lianxidizhi =  "";
			$("#uploaderFiles").html("");
		},
		
		// 检查数据
		checkInputData : function(){
			this.name = !this.name ? "" : $.trim(this.name);
			this.shenfenzhenhao = !this.shenfenzhenhao ? "" : $.trim(this.shenfenzhenhao);
			this.xingbie = !$("input[name='xingbie']:checked").val() ? "" : $("input[name='xingbie']:checked").val();
			this.age = !this.age ? "" : $.trim(this.age);
			this.bingzhong = !this.bingzhong ? "" : $.trim(this.bingzhong);
			this.shoujihao = !this.name ? "" : $.trim(this.shoujihao);
			this.lianxidizhi = !this.lianxidizhi ? "" : $.trim(this.lianxidizhi);
			
			if(this.name == ""){
				this.showMessage("请填写患者姓名！");
				return false;
			}
			
			if(this.shenfenzhenhao == ""){
				this.showMessage("请填写患者身份证号码！");
				return false;
			}
			var regShenfenzheng = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
			if(!regShenfenzheng.test(this.shenfenzhenhao)){
				this.showMessage("请填写规范的身份证号码！");
				return false;
			}
			
			if(this.xingbie == ""){
				this.showMessage("请选择患者性别！");
				return false;
			}
			
			if(this.age == ""){
				this.showMessage("请选择患者年龄！");
				return false;
			}
			var ageReg =  /[0-9]*/;
			if(!ageReg.test(this.age)){
				this.showMessage("年龄必须为数字！");
				return false;
			}
			
			if(this.bingzhong == ""){
				this.showMessage("请选择病种！");
				return false;
			}
			
			if(this.shoujihao == ""){
				this.showMessage("请填写手机号！");
				return false;
			}
			var mobileReg =  /[0-9]*/;
			if(this.shoujihao.length != 11 || !mobileReg.test(this.shoujihao)){
				this.showMessage("手机号码必须为11位数字！");
				return false;
			}
			
			if(this.lianxidizhi == ""){
				this.showMessage("请填写联系地址！");
				return false;
			}
			
			return true;
		},
		
		showMessage : function(ppMessage){
			var _this = this;
			$("#message").html(ppMessage);
			setTimeout(function(){
				_this.cleanMessage();
			},'3000');
		},
		
		cleanMessage : function(){
			$("#message").html("");
		},
	}

})