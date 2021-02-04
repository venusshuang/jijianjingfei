var Tool_Vue = new Vue({
	el : "#Tool",
	data : {
		tizhong : "",
		tibiaomianji : "",
		
		niaogai : "",
		niaojigan : "",
		niaogaijigan : "",
		
		nianling : "",
		shenchang : "",
		K : "",
		src : "",
		eGFR : "",
		
		niaosuan : "",
		niaoliang : "",
		tbmj : "",
		niaosuanpaixielv : "",
		
		niaoniaosuan : "",
		xuejigan : "",
		xueniaosuan : "",
		niaojigan2 : "",
		fenxing : "",
		fenshu : "",
		
		age_fanwei : "",
		xingbie : "",
		tizhong : "",
		age : "",
		shengao : "",
		PAL : "",
		EER : "",
		
		gjy : "",
		xgy : "",
		pz : "",
		qpz : "",
		tf : "",
		ky : "",
		bxz : "",
		dna : "",
		ldb : "",
		xxb : "",
		bxb : "",
		sjsl : "",
		qsxxgx : "",
		sl : "",
		jy : "",
		jmy : "",
		rxxpx : "",
		gjs : "",
		ndbsp : "",
		xxbjs : "",
		bxbjs : "",
		SLE : "",
		
		
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
	methods : {
		
		jisuanTbmj : function(){
			var _this = this;

			if(_this.checkInputTbmjData()){
				switch(true) {
					case _this.tizhong <= 30:
						_this.tibiaomianji = 0.035*_this.tizhong+0.1;
						break;
					case _this.tizhong > 30:
						_this.tibiaomianji = (_this.tizhong-30)*0.02+1.05;
						break;
				}

			}

		},
		
		jisuanniaojigan : function(){
			var _this = this;

			if(_this.checkInputNjgData()){

				 _this.niaogaijigan = (_this.niaogai*40)/(_this.niaojigan*113);
					
				}

		},
		
		jisuaneGFR : function(){
			var _this = this;

			if(_this.checkInputeGFRData()){

				switch(true) {
				case _this.nianling == 1:
					_this.K = 29;
					break;
				case _this.nianling == 2:
					_this.K = 40;
					break;
				case (_this.nianling == 3||_this.nianling == 4):
					_this.K = 49;
					break;
				case _this.nianling == 5:
					_this.K = 62;
					break;
					}
				}
			_this.eGFR=_this.shenchang*_this.K*_this.src;
			
		},
		
		jisuanpaixielv : function(){
			var _this = this;

			if(_this.checkInputPaixieLvData()){

				 _this.niaosuanpaixielv = _this.niaosuan*_this.niaoliang/_this.tbmj;
					
				}

		},
		
		jisuanfenshu : function(){
			var _this = this;

			if(_this.checkInputFenshuData()){

				 _this.fenshu = ((_this.niaoniaosuan*_this.xuejigan)/(_this.xueniaosuan*_this.niaojigan2))*100;
				 
				 switch(true) {
					case _this.niaosuanpaixielv < 3600 && _this.fenshu<5.5:
						_this.fenxing = "排泄不良型";
						break;
					case _this.niaosuanpaixielv > 3600 && _this.fenshu>=5.5:
						_this.fenxing = "生成过多型";
						break;
					case _this.niaosuanpaixielv > 3600 && _this.fenshu<5.5:
						_this.fenxing = "混合型";
						break;
					
				}
			}

		},
		
		// 计算EER
		jisuanEER : function(){
			var _this = this;

			if(_this.checkInputDataEER()){
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
						layer.alert("输入年龄范围错误！");
						break;
				}

				// 根据性别和年龄范围套用公式
				switch(_this.age_fanwei) {
				
					case '1':
						_this.EER = (89 * _this.tizhong - 100) + 175;
						break;
					case '2':
						_this.EER = (89 * _this.tizhong - 100) + 56;
						break;
					case '3':
						_this.EER = (89 * _this.tizhong - 100) + 22;
						break;
					case '4':
						_this.EER = (89 * _this.tizhong - 100) + 20;
						break;
					case '5':
						if(_this.xingbie == '1'){
							_this.EER = 88.5 - 61.9 * _this.age + _this.PAL * (26.7 * _this.tizhong + 903 * _this.shengao) + 20;
						}else if(_this.xingbie == '2'){
							_this.EER = 135.3 - 30.8 * _this.age + _this.PAL * (10 * _this.tizhong + 934 * _this.shengao) + 20;
						}
						break;
					case '6':
						if(_this.xingbie == '1'){
							_this.EER = 88.5 - 61.9 * _this.age + _this.PAL * (26.7 * _this.tizhong + 903 * _this.shengao) + 25;
						}else if(_this.xingbie == '2'){
							_this.EER = 135.3 - 30.8 * _this.age + _this.PAL * (10 * _this.tizhong + 934 * _this.shengao) + 25;
						}
						break;
					default:
						layer.alert("计算错误！");
						break;
				}

			}

		},
		
		jisuanSLE : function(){
			var _this = this;

			if(_this.checkInputSLEData()){

				 _this.SLE = 0.366+3.132*_this.gjy+0.454*_this.gjs+4.408*_this.xgy+3.138*_this.pz+3.887*_this.qpz+ 0.973*_this.tf+2.769*_this.ky+0.754*_this.bxz+0.956*_this.dna-17.584*_this.ldb+3.811*_this.ldb* Math.log(_this.ndbsp)+26.105*_this.xxb-5.577*_this.xxb*Math.log(_this.xxbjs)+6.118*_this.bxb-5.058*_this.bxb*Math.log(_this.bxbjs)+18*_this.sjsl+18*_this.qsxxgx+18*_this.sl+9*_this.jy+6*_this.jmy+9*_this.rxxpx;
					
				}

		},

		toShow : function(p){
			$(".blue").removeClass("blue");
			switch(true) {
			case p==1:
				$("#div_tbmj").toggleClass("blue");
				$("#tbmj").show();
			    $("#niaojigan").hide();
			    $("#egfr").hide();
			    $("#gaoniaosuanxuezheng").hide();
				$("#cdkhuanernengliang").hide();
				$("#SLE").hide();
				break;
			case p==2:
				
				$("#div_niaogai").toggleClass("blue");
				$("#niaojigan").show();
				$("#tbmj").hide();
				$("#egfr").hide();
				$("#gaoniaosuanxuezheng").hide();
				$("#cdkhuanernengliang").hide();
				$("#SLE").hide();
				break;
			case p==3:
				$("#div_eGFR").toggleClass("blue");
				$("#niaojigan").hide();
				$("#tbmj").hide();
				$("#egfr").show();
				$("#gaoniaosuanxuezheng").hide();
				$("#cdkhuanernengliang").hide();
				$("#SLE").hide();
				break;
			case p==4:
				$("#div_gaoniao").toggleClass("blue");
				$("#niaojigan").hide();
				$("#tbmj").hide();
				$("#egfr").hide();
				$("#gaoniaosuanxuezheng").show();
				$("#cdkhuanernengliang").hide();
				$("#SLE").hide();
				break;
			case p==5:
				$("#div_EER").toggleClass("blue");
				$("#niaojigan").hide();
				$("#tbmj").hide();
				$("#egfr").hide();
				$("#gaoniaosuanxuezheng").hide();
				$("#SLE").hide();
				$("#cdkhuanernengliang").show();
				break;
			case p==6:
				$("#div_SLE").toggleClass("blue");
				$("#niaojigan").hide();
				$("#tbmj").hide();
				$("#egfr").hide();
				$("#gaoniaosuanxuezheng").hide();
				$("#cdkhuanernengliang").hide();
				$("#SLE").show();
			
				break;
			
			
			}

		},
		
		checkInputSLEData : function(){
			
			var _this = this;
			
			_this.gjy = $("input[name='gjy']:checked").val()?$("input[name='gjy']:checked").val():"";
			if(_this.gjy == ""){
				layer.alert("请选择是否存在关节炎！");
				return false;
			}
			
			_this.xgy = $("input[name='xgy']:checked").val()?$("input[name='xgy']:checked").val():"";
			if(_this.xgy == ""){
				layer.alert("请选择是否存在皮肤黏膜血管炎！");
				return false;
			}
			
			_this.pz = $("input[name='pz']:checked").val()?$("input[name='pz']:checked").val():"";
			if(_this.pz == ""){
				layer.alert("请选择是否存在局部皮疹！");
				return false;
			}
			
			_this.qpz = $("input[name='qpz']:checked").val()?$("input[name='qpz']:checked").val():"";
			if(_this.qpz == ""){
				layer.alert("请选择是否存在全身皮疹！");
				return false;
			}
			
			_this.tf = $("input[name='tf']:checked").val()?$("input[name='tf']:checked").val():"";
			if(_this.tf == ""){
				layer.alert("请选择是否存在脱发！");
				return false;
			}
			
			_this.ky = $("input[name='ky']:checked").val()?$("input[name='ky']:checked").val():"";
			if(_this.ky == ""){
				layer.alert("请选择是否存在黏膜溃疡！");
				return false;
			}
			
			_this.bxz = $("input[name='bxz']:checked").val()?$("input[name='bxz']:checked").val():"";
			if(_this.bxz == ""){
				layer.alert("请选择是否存在低补体血症！");
				return false;
			}
			
			_this.dna = $("input[name='dna']:checked").val()?$("input[name='dna']:checked").val():"";
			if(_this.dna == ""){
				layer.alert("请选择是否存在抗ds-DNA升高！");
				return false;
			}
			
			_this.ldb = $("input[name='ldb']:checked").val()?$("input[name='ldb']:checked").val():"";
			if(_this.ldb == ""){
				layer.alert("请选择是否存在蛋白尿！");
				return false;
			}
			
			_this.xxb = $("input[name='xxb']:checked").val()?$("input[name='xxb']:checked").val():"";
			if(_this.xxb == ""){
				layer.alert("请选择是否存在血小板减少症！");
				return false;
			}
			
			_this.bxb = $("input[name='bxb']:checked").val()?$("input[name='bxb']:checked").val():"";
			if(_this.bxb == ""){
				layer.alert("请选择是否存在白细胞减少！");
				return false;
			}
			
			_this.sjsl = $("input[name='sjsl']:checked").val()?$("input[name='sjsl']:checked").val():"";
			if(_this.sjsl == ""){
				layer.alert("请选择是否存在神经精神受累！");
				return false;
			}
			
			_this.qsxxgx = $("input[name='qsxxgx']:checked").val()?$("input[name='qsxxgx']:checked").val():"";
			if(_this.qsxxgx == ""){
				layer.alert("请选择是否存在全身性血管炎！");
				return false;
			}
			
			_this.sl = $("input[name='sl']:checked").val()?$("input[name='sl']:checked").val():"";
			if(_this.sl == ""){
				layer.alert("请选择是否存在心脏/肺部受累！");
				return false;
			}
			
			_this.jy = $("input[name='jy']:checked").val()?$("input[name='jy']:checked").val():"";
			if(_this.jy == ""){
				layer.alert("请选择是否存在肌炎！");
				return false;
			}
			
			_this.jmy = $("input[name='jmy']:checked").val()?$("input[name='jmy']:checked").val():"";
			if(_this.jmy == ""){
				layer.alert("请选择是否存在浆膜炎！");
				return false;
			}
			
			_this.rxxpx = $("input[name='rxxpx']:checked").val()?$("input[name='rxxpx']:checked").val():"";
			if(_this.rxxpx == ""){
				layer.alert("请选择是否存在溶血性贫血！");
				return false;
			}
			
			if(_this.gjs == ""){
				layer.alert("请填写肿胀关节数！");
				return false;
			}
			
			if(_this.ndbsp == ""){
				layer.alert("请填写尿蛋白水平！");
				return false;
			}
			
			if(_this.xxbjs == ""){
				layer.alert("请填写血小板计数！");
				return false;
			}
			
			if(_this.bxbjs == ""){
				layer.alert("请填写白细胞计数！");
				return false;
			}
		
			return true;
		},
		
		
	
		checkInputTbmjData : function(){
			this.tizhong = !this.tizhong ? "" : $.trim(this.tizhong);

			if(this.tizhong == ""){
				layer.alert("请填写体重！");
				return false;
			}
			
			/*var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.tizhong)){
				layer.alert("体重最多为含有两位小数的数字！");
				return false;
			}	*/

			return true;
		},
		
		checkInputNjgData : function(){
			this.niaogai = !this.niaogai ? "" : $.trim(this.niaogai);
			this.niaojigan = !this.niaojigan ? "" : $.trim(this.niaojigan);
			
			if(this.niaogai == ""){
				layer.alert("请填写尿钙！");
				return false;
			}
			
			if(this.niaojigan == ""){
				layer.alert("请填写尿肌酐！");
				return false;
			}
			
		/*	var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.niaogai)){
				layer.alert("尿钙最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.niaojigan)){
				layer.alert("尿肌酐最多为含有两位小数的数字！");
				return false;
			}
*/
			return true;
		},
		
		checkInputeGFRData : function(){
			this.shenchang = !this.shenchang ? "" : $.trim(this.shenchang);

			if(this.nianling == ""){
				layer.alert("请选择年龄及性别范围！");
				return false;
			}
			
			if(this.shenchang == ""){
				layer.alert("请填写身长！");
				return false;
			}
			
			if(this.src == ""){
				layer.alert("请填写Src！");
				return false;
			}

			/*var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.shenchang)){
				layer.alert("身长最多为含有两位小数的数字！");
				return false;
			}	*/

			return true;
		},
		
		checkInputPaixieLvData : function(){
			this.niaosuan = !this.niaosuan ? "" : $.trim(this.niaosuan);
			this.niaoliang = !this.niaoliang ? "" : $.trim(this.niaoliang);
			this.tbmj = !this.tbmj ? "" : $.trim(this.tbmj);

			if(this.niaosuan == ""){
				layer.alert("请填写尿酸！");
				return false;
			}
			
			if(this.niaoliang == ""){
				layer.alert("请填写尿量！");
				return false;
			}

			if(this.tbmj == ""){
				layer.alert("请填写体表面积！");
				return false;
			}

			var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			/*if(!fudianshuReg.test(this.niaosuan)){
				layer.alert("尿酸最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.niaoliang)){
				layer.alert("尿量最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.tbmj)){
				layer.alert("体表面积最多为含有两位小数的数字！");
				return false;
			}	*/


			return true;
		},
		
		checkInputFenshuData : function(){
			this.niaoniaosuan = !this.niaoniaosuan ? "" : $.trim(this.niaoniaosuan);
			this.xuejigan = !this.xuejigan ? "" : $.trim(this.xuejigan);
			this.xueniaosuan = !this.xueniaosuan ? "" : $.trim(this.xueniaosuan);
			this.niaojigan2 = !this.niaojigan2 ? "" : $.trim(this.niaojigan2);

			if(this.niaoniaosuan == ""){
				layer.alert("请填写尿尿酸！");
				return false;
			}
			
			if(this.xuejigan == ""){
				layer.alert("请填写血肌酐！");
				return false;
			}

			if(this.xueniaosuan == ""){
				layer.alert("请填写血尿酸！");
				return false;
			}
			
			if(this.niaojigan2 == ""){
				layer.alert("请填写尿肌酐！");
				return false;
			}
			
			if(this.niaosuanpaixielv == ""){
				layer.alert("尿酸排泄率还未计算！");
				return false;
			}

			/*var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.niaoniaosuan)){
				layer.alert("尿尿酸最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.xuejigan)){
				layer.alert("血肌酐最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.xueniaosuan)){
				layer.alert("血尿酸最多为含有两位小数的数字！");
				return false;
			}	
			
			if(!fudianshuReg.test(this.niaojigan)){
				layer.alert("尿肌酐最多为含有两位小数的数字！");
				return false;
			}	*/


			return true;
		},


		// 检查输入的数据
		checkInputDataEER : function(){
			this.age_fanwei = !this.age_fanwei ? "" : $.trim(this.age_fanwei);
			this.xingbie = !this.xingbie ? "" : $.trim(this.xingbie);
			this.tizhong = !this.tizhong ? "" : $.trim(this.tizhong);
			this.age = !this.age ? "" : $.trim(this.age);
			this.shengao = !this.shengao ? "" : $.trim(this.shengao);

			if(this.age_fanwei == ""){
				layer.alert("请选择年龄范围！");
				return false;
			}

			if(this.xingbie == ""){
				layer.alert("请选择性别！");
				return false;
			}

			if(this.tizhong == ""){
				layer.alert("请填写体重！");
				return false;
			}
			var fudianshuReg = /^[1-9]\d*(\.\d{1,2})?$|^0+(\.\d{1,2})?$/;
			if(!fudianshuReg.test(this.tizhong)){
				layer.alert("体重最多为含有两位小数的数字！");
				return false;
			}	

			// 超过35个月才需要写年龄
			if(this.age_fanwei == "5" || this.age_fanwei == "6"){
				if(this.age == ""){
					layer.alert("请填写年龄！");
					return false;
				}	
				var shuziReg = /^[1-9]\d*$|^0$/;
				if(!shuziReg.test(this.age)){
					layer.alert("年龄必须为数字！");
					return false;
				}
				if(this.age > 18){
					layer.alert("年龄不能超过18岁！");
					return false;
				}
			}
			

			if(this.shengao == ""){
				layer.alert("请填写身高！");
				return false;
			}
			if(!fudianshuReg.test(this.shengao)){
				layer.alert("身高最多为含有两位小数的数字！");
				return false;
			}

			return true;
		},

	},
})