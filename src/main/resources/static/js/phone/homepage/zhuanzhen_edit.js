var vm_zhuanzhen_edit = new Vue({
	el : "#zhuanzhen_edit",
	data : {
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		referraid : $("#referraid").val(),
		
		zhuanzhen : {},
		fujianlist : [],
	},
	created : function(){
		if(this.referraid){// 传值
			// 根据转诊id查找转诊信息
			this.findZhuanzhenInfo();
			
		}else{
			// 根据医生id查找医生信息
			this.findDoctorInfo();
		}
		
		
	},
	methods : {
		
		// 根据医生id查找医生信息
		findDoctorInfo : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/doctor/find_one',{
				doctorid : _this.userid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						
						if(data != null){
							_this.zhuanzhen.doctorname = data.xingming;
							_this.zhuanzhen.danwei = data.danwei;
							// 重新渲染页面，不然绑不到input框中
							_this.$forceUpdate();
						}
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
	
		// 根据转诊id查找转诊信息
		findZhuanzhenInfo : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/referral/find_custom_one',{
				referraid : _this.referraid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				
				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						var mmReferral = data.Referral;
						var mmAttatchmentList = data.AttatchmentList;
						
						// 绑定转诊信息
						_this.zhuanzhen= mmReferral;

						// 绑定附件信息
						_this.fujianlist = mmAttatchmentList;
							
						// 重新渲染页面，不然绑不到input框中
						_this.$forceUpdate();
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		// 修改保存按钮
		modify  : function(){
			var _this = this;
			
			var imageurls = "";
			
			$("img[name='imageurl']").each(function(){
				imageurls += $(this).attr("src")+";";
			});
			
			if(_this.checkInputData()){
				layer.open({type:3});
				
				$.post("/referral/modify",{
					referraid : _this.referraid,
					doctorid : _this.userid,
					doctorname : _this.zhuanzhen.doctorname,
					danwei : _this.zhuanzhen.danwei,
					patientname : _this.zhuanzhen.patientname,
					
					patientage : _this.zhuanzhen.patientage,
					zhusu : _this.zhuanzhen.zhusu,
					imageurls : imageurls,
					rdm : Math.random()
				},function(ppData){
					layer.closeAll("loading");
					
					if(ppData != null){
						if(ppData.result == "1"){
							$("#js_toast").show();
							
							setTimeout(function(){
								window.location.href = "/homepage/zhuanzhen_list.html";
								_this.cleanInputData();
							},'2000');
						}else{
							_this.showMessage(ppData.message);
						}
					}
				},"json")
			}
		},
		
		// 新增保存按钮
		save : function(){
			var _this = this;
			
			var imageurls = "";
			
			$("img[name='imageurl']").each(function(){
				imageurls += $(this).attr("src")+";";
			});
			
			if(_this.checkInputData()){
				layer.open({type:3});
				
				$.post("/referral/add_custom",{
					doctorid : _this.userid,
					doctorname : _this.zhuanzhen.doctorname,
					danwei : _this.zhuanzhen.danwei,
					patientname : _this.zhuanzhen.patientname,
					patientage : _this.zhuanzhen.patientage,
					zhusu : _this.zhuanzhen.zhusu,
					imageurls : imageurls,
					rdm : Math.random()
				},function(ppData){
					layer.closeAll("loading");
					
					if(ppData != null){
						if(ppData.result == "1"){
							$("#js_toast").show();
							
							setTimeout(function(){
								window.location.href = "/homepage/zhuanzhen_list.html";
								_this.cleanInputData();
							},'2000');
						}else{
							_this.showMessage(ppData.message);
						}
					}
				},"json")
			}
		},
		
		
		// 清空数据
		cleanInputData : function(){
			this.zhuanzhen = {};
		},
		
		// 检查数据
		checkInputData : function(){
			this.zhuanzhen.doctorname = !this.zhuanzhen.doctorname ? "" : $.trim(this.zhuanzhen.doctorname);
			this.zhuanzhen.danwei = !this.zhuanzhen.danwei ? "" : $.trim(this.zhuanzhen.danwei);
			this.zhuanzhen.patientname = !this.zhuanzhen.patientname ? "" : $.trim(this.zhuanzhen.patientname);
			this.zhuanzhen.patientage = !this.zhuanzhen.patientage ? "" : $.trim(this.zhuanzhen.patientage);
			this.zhuanzhen.zhusu = !this.zhuanzhen.zhusu ? "" : $.trim(this.zhuanzhen.zhusu);
			
			if(this.zhuanzhen.doctorname == ""){
				this.showMessage("请填写医师姓名！");
				return false;
			}
			
			if(this.zhuanzhen.danwei == ""){
				this.showMessage("请填写医院名称！");
				return false;
			}
			
			if(this.zhuanzhen.patientname == ""){
				this.showMessage("请填写患者姓名！");
				return false;
			}
			
			if(this.zhuanzhen.patientage == ""){
				this.showMessage("请填写患者年龄！");
				return false;
			}
			var ageReg =  /[0-9]*/;
			if(!ageReg.test(this.age)){
				this.showMessage("患者年龄必须为数字！");
				return false;
			}
			
			if(this.zhuanzhen.zhusu == ""){
				this.showMessage("请选择病情描述！");
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
