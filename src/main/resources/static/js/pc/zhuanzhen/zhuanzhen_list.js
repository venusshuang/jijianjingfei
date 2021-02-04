var vm_zhuanzhen = new Vue({
	el : "#zhuanzhenlist",
	data : {
		patientname : "",
		doctorname : "",
		danwei : "",

		zhuanzhenlist : [],

		referraid : "",
		zhuanzhen : [],			// 转诊信息

		shoujianrenid : "",		// 收件人id即医生id
		shoujianrenname : "",	// 收件人姓名

		xiaoxilist : [],		// 消息列表
		neirong : "",			// 消息内容

	},
	created : function(){
		var _this = this;
		// 查找转诊列表
		_this.findZhuanzhenList();
		
		setInterval(function(){
			_this.findZhuanzhenList();
		},'10000');
	},
	methods : {
		// 查找转诊列表
		findZhuanzhenList : function(){
			var _this = this;

			layer.open({type:3});
			$.post('/referral/find_by_condition',{
				patientname : _this.patientname,
				doctorname : _this.doctorname,
				danwei : _this.danwei,
				rdm : Math.random()
			},function(ppData){

				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == '1'){
						_this.zhuanzhenlist = ppData.resultContent;

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 清除输入框中的值
		toRemove : function(){
			this.patientname = '';
			this.doctorname = '';
			this.danwei = '';
		},

		// 点击全选按钮
		CheckAll : function(){
			if($("#checkAll").is(":checked"))
			{
				$("input[name='checkbox']").prop('checked',true);
			}
			else
			{
				$("input[name='checkbox']").prop('checked',false);
			}
		},

		// 删除选中
		toDeleteChecked : function(){
			var _this = this;

			var mmZhuanzhenIdList = "";
			$("input[name=checkbox]:checked").each(function(){
				if($(this).val() != ""){
					mmZhuanzhenIdList += "," + this.value;
				}
			})

			if(mmZhuanzhenIdList == ""){
				layer.alert("请选择要删除的转诊信息！");
				return false;
			}

			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){

				layer.open({type:3});

				$.post('/referral/delete_by_zhuanzhenidlist',{
					zhuanzhenidlist : mmZhuanzhenIdList,			
					rdm : Math.random()
				},function(ppData){

					layer.closeAll("loading");

					if(ppData != null){
						if(ppData.result == '1'){

							layer.alert("批量删除成功");	
							_this.findZhuanzhenList();

						}else{

							layer.alert(ppData.message);
						}

						$("input[name='checkbox']").prop('checked',false);
						$("input[name='checkall']").prop('checked',false);
					}
				},"json");
			})
		},

		// 点击查看按钮
		toShowDetail : function(ppReferralId){
			$('#detailZhuanzhenModal').modal();

			this.referraid = ppReferralId;

			this.findByZhuanzhenId();
		},

		// 根据转诊id查找转诊病例详情
		findByZhuanzhenId : function(){
			var _this = this;
			layer.open({type:3});

			$.post('/referral/find_one',{
				referraid : _this.referraid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");

				if(ppData != null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;

						_this.zhuanzhen = data;

					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 点击在线联系按钮，弹出聊天框
		toShowNews : function(ppReferralId,ppDoctorId,ppDoctorName){
			var _this = this;

			_this.referraid = ppReferralId;
			_this.shoujianrenid = ppDoctorId;
			_this.shoujianrenname = ppDoctorName;

			$("#listXiaoxiModal").modal();

			_this.bindXiaoxiList();
			setInterval(function(){
				_this.bindXiaoxiList();
			},5000);
		},

		// 查找消息列表
		bindXiaoxiList : function(){
			var _this = this;
			$.post('/news/find_by_ownerid',{
				ownerid : _this.referraid,
				rdm : Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						var div = document.getElementById('messagelist');
						div.scrollTop = div.scrollHeight;
						_this.xiaoxilist = data;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		// 点击发送按钮
		toAdd : function(){
			var _this = this;

			layer.open({type:3});

			if(!$.trim(_this.neirong)){
				return;
			}

			$.post('/news/add', {
				fajianrenid : 'zhuanzhenguanliyuan',
				fajianrenname : '转诊管理员',
				shoujianrenid : _this.shoujianrenid,
				shoujianrenname : _this.shoujianrenname,
				neirong : _this.neirong,
				newstype : '3',
				ownerid : _this.referraid,
				rdm : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					
					var mmData = ppData;
					var result = mmData.result;
					var message = mmData.message;
					var data = mmData.resultContent;
					if(result == "1"){
						_this.neirong = "";
						var div = document.getElementById('messagelist');
						div.scrollTop = div.scrollHeight;
						_this.bindXiaoxiList();
					}else{
						layer.alert(message);
					}
				}
			},"json");
		},

	},



})