var vm_yingyangguanli = new Vue({
	el : "#yingyangguanli",
	data : {
		age_fanwei : "",
		xingbie : "",
		tizhong : "",
		age : "",
		shengao : "",
		
		PAL : "",
		result : "",
	},
	created : function(){

	},
	methods : {
		// 计算EER
		jisuan : function(){
			var _this = this;

			if(_this.checkInputData()){
				// 根据年龄获取PAL的值
				switch(true) {
					case _this.age <= 3:
						_this.PAL = 1.4;
						break;
					case 4 <= _this.age && _this.age <= 9:
						_this.PAL = 1.6;
						break;
					case 10 <= _this.age && _this.age <= 18:
						_this.PAL = 1.8;
						break;
					default:
						this.showMessage("输入年龄范围错误！");
						break;
				}
				
				// 根据性别和年龄范围套用公式
				switch(_this.age_fanwei) {
				
					case '1':
						_this.result = (89 * _this.tizhong - 100) + 175;
						break;
					case '2':
						_this.result = (89 * _this.tizhong - 100) + 56;
						break;
					case '3':
						_this.result = (89 * _this.tizhong - 100) + 22;
						break;
					case '4':
						_this.result = (89 * _this.tizhong - 100) + 20;
						break;
					case '5':
						if(_this.xingbie == '1'){
							_this.result = 88.5 - 61.9 * _this.age + _this.PAL * (26.7 * _this.tizhong + 903 * _this.shengao) + 20;
						}else if(_this.xingbie == '2'){
							_this.result = 135.3 - 30.8 * _this.age + _this.PAL * (10 * _this.tizhong + 934 * _this.shengao) + 20;
						}
						break;
					case '6':
						if(_this.xingbie == '1'){
							_this.result = 88.5 - 61.9 * _this.age + _this.PAL * (26.7 * _this.tizhong + 903 * _this.shengao) + 25;
						}else if(_this.xingbie == '2'){
							_this.result = 135.3 - 30.8 * _this.age + _this.PAL * (10 * _this.tizhong + 934 * _this.shengao) + 25;
						}
						break;
					default:
						this.showMessage("计算错误！");
						break;
				}

			}

		},

		// 检查输入的数据
		checkInputData : function(){
			this.age_fanwei = !this.age_fanwei ? "" : $.trim(this.age_fanwei);
			this.xingbie = !this.xingbie ? "" : $.trim(this.xingbie);
			this.tizhong = !this.tizhong ? "" : $.trim(this.tizhong);
			this.age = !this.age ? "" : $.trim(this.age);
			this.shengao = !this.shengao ? "" : $.trim(this.shengao);

			if(this.age_fanwei == ""){
				this.showMessage("请选择年龄范围！");
				return false;
			}

			if(this.xingbie == ""){
				this.showMessage("请选择性别！");
				return false;
			}

			if(this.tizhong == ""){
				this.showMessage("请填写体重！");
				return false;
			}
			var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.tizhong)){
				this.showMessage("体重最多为含有两位小数的数字！");
				return false;
			}	

			// 超过35个月才需要写年龄
			if(this.age_fanwei == "5" || this.age_fanwei == "6"){
				if(this.age == ""){
					this.showMessage("请填写年龄！");
					return false;
				}	
				var shuziReg = /^[1-9]\d*$|^0$/;
				if(!shuziReg.test(this.age)){
					this.showMessage("年龄必须为数字！");
					return false;
				}
				if(this.age > 18){
					this.showMessage("年龄不能超过18岁！");
					return false;
				}
			}
			

			if(this.shengao == ""){
				this.showMessage("请填写身高！");
				return false;
			}
			if(!fudianshuReg.test(this.shengao)){
				this.showMessage("身高最多为含有两位小数的数字！");
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

	},
	
	watch : {
		age_fanwei : function(){
			this.age = "";
			if(this.age_fanwei == "5" || this.age_fanwei == "6"){
				$("#div_age").css("display","flex");
			}else{
				$("#div_age").css("display","none");
			}
		},
		
	},
})