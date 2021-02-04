var _jiuzhenxinxiVue = new Vue({
	el:"#jiuzhenxinxi",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),

		jiuzhenxinxilist : [],//就诊信息列表
		jiuzhenxinxi : {},
		jiuzhenxinxiid : '',

		xingbie : '',

		nianlingduanlist : [],
		bingzhonglist : [],

		editFlag : 0,//0:add,1:modify
		show : true,
		fujianlist : [],
	},
	created : function(){
		var _this = this;

		$("#listPart").show();
		_this.initDict();
		_this.bindJiuzhenxinxiList();
	},
	methods:{
		initDict:function(){
			var _this = this;

			// 年龄段
			$.post('/dict_nianlingduan/find_valid',{
				rdm:Math.random()
			},function(ppData){
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.nianlingduanlist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");

			// 病种
			$.post('/dict_bingzhong/find_valid', {
				rdm : Math.random()
			},function(ppData) {
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.bingzhonglist = ppData.resultContent;
					}
				}
			},"json");
		},

		// 绑定就诊信息列表 
		bindJiuzhenxinxiList : function(){
			var _this = this;
			layer.open({type:3});

			$.post('/patient_jiuzhenxinxi/find_by_userid',{
				userid : _this.userid,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						if(data.length>0){
							_this.show = true;
							_this.jiuzhenxinxilist = data;
						}else{
							_this.show = false;
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");

			$.post('/dict_nianlingduan/find_valid',{
				rdm:Math.random()
			},function(ppData){
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						_this.nianlingduanlist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		cleanForm : function(){
			this.jiuzhenxinxi = {};
			this.xingbie = '';
			$("input[name='xingbie']").removeAttr("checked");
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

		prepareToAdd:function(){
			var _this = this;

			_this.editFlag = 0;
			_this.cleanForm();
			$("#editPart").show();
			$(".listPart").hide();

			// 根据用户id绑定登录用户信息
			_this.bindByUserId();
		},


		// 根据用户id绑定登录用户信息
		bindByUserId :function(){
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
							_this.jiuzhenxinxi.name = data.name;
							_this.jiuzhenxinxi.shoujihao = data.shoujihao;

							// 重新渲染页面，不然绑不到input框中
							_this.$forceUpdate();
						}

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		toAdd : function(){
			var _this = this;

			var imageurls = "";

			$("img[name='imageurl']").each(function(){
				imageurls += $(this).attr("src")+";";
			});

			if(_this.checkInputData()){
				layer.open({type:3});

				$.post('../patient_jiuzhenxinxi/add', {
					userid : _this.userid,
					name : _this.jiuzhenxinxi.name,
					shenfenzhenghaoma : _this.jiuzhenxinxi.shenfenzhenghaoma,
					xingbie : _this.xingbie,
					zhuyaozhengzhuang : _this.jiuzhenxinxi.zhuyaozhengzhuang,
					shoujihao : _this.jiuzhenxinxi.shoujihao,
					age : _this.jiuzhenxinxi.age,
					lianxidizhi : _this.jiuzhenxinxi.lianxidizhi,
					bingzhong : _this.jiuzhenxinxi.bingzhong,
					imageurls : imageurls,
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
									var _this = this;
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
			}
		},

		prepareToModify:function(ppJiuzhenxinxiId){
			var _this = this;

			_this.editFlag = 1;
			_this.jiuzhenxinxiid = ppJiuzhenxinxiId;
			//_this.cleanForm();
			_this.bindOldValue();
			$("#editPart").show();
			$(".listPart").hide();
		},

		bindOldValue:function(){
			var _this = this;

			layer.open({type:3});

			$.post('../patient_jiuzhenxinxi/find_one', {
				jiuzhenxinxiid : _this.jiuzhenxinxiid,
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
								_this.jiuzhenxinxi = data.Jiuzhenxinxi;
								var mmAttatchmentList = data.AttatchmentList;

								// 绑定附件信息
								_this.fujianlist = mmAttatchmentList;
								//console.log(_this.fujianlist);
								$("#uploaderFiles").html("");
								for ( var i=0;i< _this.fujianlist.length;i++) {

									var mmHtml = "<img name='imageurl' src='"+_this.fujianlist[i].url+"' width=200 height=200 style='margin:10px;'/>";
									
									
									$("#uploaderFiles").append(mmHtml);
								}



								$("input[name='xingbie'][value='"+_this.jiuzhenxinxi.xingbie+"']").attr("checked","checked");

								// 重新渲染页面，不然绑不到input框中
								_this.$forceUpdate();
							}else{
								_this.showMessage(message);
							}
						}
					}
				}
			},"json");
		},

		toModify : function(){
			var _this = this;

			var imageurls = "";

			$("img[name='imageurl']").each(function(){
				imageurls += $(this).attr("src")+";";
			});

			if(_this.checkInputData()){
				layer.open({type:3});

				$.post('../patient_jiuzhenxinxi/modify', {
					jiuzhenxinxiid : _this.jiuzhenxinxiid,
					name : _this.jiuzhenxinxi.name,
					shenfenzhenghaoma : _this.jiuzhenxinxi.shenfenzhenghaoma,
					xingbie : _this.xingbie,
					zhuyaozhengzhuang : _this.jiuzhenxinxi.zhuyaozhengzhuang,
					shoujihao : _this.jiuzhenxinxi.shoujihao,
					age : _this.jiuzhenxinxi.age,
					lianxidizhi : _this.jiuzhenxinxi.lianxidizhi,
					bingzhong : _this.jiuzhenxinxi.bingzhong,
					imageurls : imageurls,
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
			}
		},

		checkInputData : function(){
			var _this = this;

			_this.jiuzhenxinxi.name = !_this.jiuzhenxinxi.name ? "" : $.trim(_this.jiuzhenxinxi.name);
			_this.jiuzhenxinxi.shenfenzhenghaoma = !_this.jiuzhenxinxi.shenfenzhenghaoma ? "" : $.trim(_this.jiuzhenxinxi.shenfenzhenghaoma);
			_this.xingbie = !$("input[name='xingbie']:checked").val() ? "" : $("input[name='xingbie']:checked").val();
			_this.jiuzhenxinxi.age = !_this.jiuzhenxinxi.age ? "" : $.trim(_this.jiuzhenxinxi.age);
			_this.jiuzhenxinxi.bingzhong = !_this.jiuzhenxinxi.bingzhong ? "" : $.trim(_this.jiuzhenxinxi.bingzhong);

			_this.jiuzhenxinxi.shoujihao = !_this.jiuzhenxinxi.shoujihao ? "" : $.trim(_this.jiuzhenxinxi.shoujihao);
			_this.jiuzhenxinxi.lianxidizhi = !_this.jiuzhenxinxi.lianxidizhi ? "" : $.trim(_this.jiuzhenxinxi.lianxidizhi);
			_this.jiuzhenxinxi.zhuyaozhengzhuang = !_this.jiuzhenxinxi.zhuyaozhengzhuang ? "" : $.trim(_this.jiuzhenxinxi.zhuyaozhengzhuang);

			if(_this.jiuzhenxinxi.name == ""){
				_this.showMessage("请填写姓名！");
				return false;
			}

			if(_this.jiuzhenxinxi.shenfenzhenghaoma == ""){
				_this.showMessage("请填写身份证号码！");
				return false;
			}
			var regShenfenzheng = /^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$/;
			if(!regShenfenzheng.test(_this.jiuzhenxinxi.shenfenzhenghaoma)){
				_this.showMessage("请填写规范的身份证号码！");
				return false;
			}

			if(_this.xingbie == ""){
				_this.showMessage("请选择患者性别！");
				return false;
			}

			if(_this.jiuzhenxinxi.age == ""){
				_this.showMessage("请选择年龄！");
				return false;
			}

			if(_this.jiuzhenxinxi.bingzhong == ""){
				_this.showMessage("请选择临床诊断！");
				return false;
			}

			if(_this.jiuzhenxinxi.shoujihao == ""){
				_this.showMessage("请填写手机号码！");
				return false;
			}
			var mobileReg =  /^\d{11}$/;
			if(!mobileReg.test(_this.jiuzhenxinxi.shoujihao)){
				_this.showMessage("手机号码必须为11位数字！");
				return false;
			}

			/*if(_this.jiuzhenxinxi.zhuyaozhengzhuang == ""){
				_this.showMessage("请填写主要症状！");
				return false;
			}*/

			return true;
		},

		prepareToGuahao:function(ppJiuzhenxinxiId){
			location.href="/homepage/yuyueguahao.html?jiuzhenxinxiid="+ppJiuzhenxinxiId;
		}
	}
})