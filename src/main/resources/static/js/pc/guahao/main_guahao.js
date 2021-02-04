var Guahao_Vue = new Vue({
	el : '#Guahao',
	data : {

		administratorid:$("#administratorid").val(),
		name : $("#name").val(),
		chuangjianshijian : $("#chuangjianshijian").val(),
		shoujihao : $("#shoujihao").val(),
		bingzhong : "",
		guahaolist : [],
		guahao : {},	
		editFlag : 0,// 0:单个，1：批量
		show : true,// 显示列表是否有数据
		guahaoid : '',	
		expertid : '',	
		expertlist : [],// 下拉框的专家集合
		shenheyijian:'',
		ddShenHeCount : 0,
		ddShenHeCurrentIndex : 0,

		xiaoxilist : [],
		neirong : '',
		userid : '',
		id : '',
		username : '',

		shenhejieguo:0,

		xiaoxineirong : "",			// 批量发消息中的消息内容
		
		bingzhonglist : [],			// 病种字典表

		pageindex : 1,
		pagesize : 10,
		pageCount : "",
		recordCount : "",
		targetpage : "",
		inputPageIndexValue : "",
	},

	created : function() {
		var _this = this;

		_this.bindExpertList();
		_this.bindGuahaoList();
		
		// 加载字典表
		_this.initDict();

		setInterval(function(){
			_this.bindGuahaoList();
		},'10000');
	},

	watch : {

		//监控分页情况
		pageindex : function(){
			this.bindGuahaoList();
		},
		pagesize : function(){
			this.pageindex = 1;
			this.bindGuahaoList();
		},

	},


	methods : {
		initDict:function(){
			var _this = this;
			
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
		

		getDate : function() {
			var _this=this;

			_this.chuangjianshijian = $("#chuangjianshijian").val(); 
		},


		// 根据条件搜索列表
		bindGuahaoList : function(){

			var _this = this;
			layer.open({type:3});

			$.post('/guahao/find_custom_all',{
				xingming:_this.name,
				shoujihao:_this.shoujihao,
				bingzhong : _this.bingzhong,
				expertid:_this.expertid,
				yuyueriqi:_this.chuangjianshijian,
				shenhejieguo:_this.shenhejieguo,
				pageindex:_this.pageindex,
				pagesize:_this.pagesize,
				rdm:Math.random()
			},function(ppData){

				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){

						var data = ppData.resultContent;
						var list = data.List;
						var pageinfo = data.PageInfo;
						if(list.length>0){

							_this.guahaolist = list;
							_this.recordCount = pageinfo.recordCount;
							_this.pageCount = pageinfo.pageCount;
							_this.targetpage = '';
						}else
						{
							_this.guahaolist = [];
						}


					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},

		//绑定专家下拉列表
		bindExpertList : function(){
			var _this = this;
			layer.open({type:3});
			$.post('/expert/findExpertByName', {
				name:"",
				rdm:Math.random()
			},function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					if(ppData.result == "1"){
						_this.expertlist = ppData.resultContent;
					}
				}
			},"json");
		},


		toRemove : function(){
			var _this = this;
			_this.name='';
			_this.chuangjianshijian='';
			_this.shoujihao='';
			_this.expertid='';
			$("#name").val("");
			$("#chuangjianshijian").val("");
			$("#shoujihao").val("");
			$("#expertid").val("");
		},

		allCheckShenhe : function(){
			var _this = this;

			if($("#allCheckShenhe").is(":checked"))
			{
				$("input[name='shenheCheckbox']").prop('checked',true);
			}
			else
			{
				$("input[name='shenheCheckbox']").prop('checked',false);
			}

		},

		// 点击“批量发消息”按钮
		piliangSendMessage : function(){			
			var _this = this;

			var mmGuahaoIdList = "";
			_this.ddShenHeCount = 0;
			$("[name=shenheCheckbox]:checked").each(function(){
				mmGuahaoIdList += "|" + this.value;
				_this.ddShenHeCount++;
			})
			mmGuahaoIdList = mmGuahaoIdList != "" ? mmGuahaoIdList.substring(1) : "";

			if(mmGuahaoIdList == ""){
				layer.alert("请选择需要发消息的预约挂号信息！");
				return false;
			}

			$('#piliangSendMessageModal').modal();
			$("#myModalLabel_sendmessage").html("批量发消息");

			_this.xiaoxineirong = "";

		},

		// 点击批量发消息模态框中的“发送”按钮
		toSendMessage : function(){
			var _this = this;

			_this.ddShenHeCurrentIndex = 0;
			$("[name=shenheCheckbox]:checked").each(function(){
				_this.guahaoid = this.value;
				_this.sendMessage();
			})

		},

		// 发消息
		sendMessage : function(){
			var _this = this;

			_this.xiaoxineirong = !_this.xiaoxineirong ? "" : _this.xiaoxineirong;
			if(_this.xiaoxineirong == "")
			{
				layer.alert("请填写需要发送的消息内容！");
				return false;
			}

			$.post("/news/add", {
				fajianrenid : 'guahaoguanliyuan',
				fajianrenname : '挂号管理员',
				shoujianrenid : '',
				shoujianrenname : '',
				neirong : _this.xiaoxineirong,
				newstype: '1',
				ownerid : _this.guahaoid,
				rdm : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if(ppData.result != "1"){
						layer.alert(ppData.message);
					}else{
						_this.ddShenHeCurrentIndex++;


						if(_this.ddShenHeCurrentIndex == _this.ddShenHeCount)	
						{
							layer.open({
								time:1000,
								btn:[],
								content:"消息发送成功!",
							});

							$("#piliangSendMessageModal").modal("hide");
							$("input[name='shenheAllCheckbox']").prop('checked',false);
							$("input[name='shenheCheckbox']").prop('checked',false);

							_this.bindGuahaoList();

						}
					}
				}
			},"json");
		},

		// 点击“批量审核”按钮
		perpareToShenheAll:function(){

			var _this = this;

			var mmGuahaoIdList="";
			_this.ddShenHeCount=0;
			$("[name=shenheCheckbox]:checked").each(function(){
				mmGuahaoIdList+="|"+this.value;
				_this.ddShenHeCount++;
			})
			mmGuahaoIdList=mmGuahaoIdList!=""?mmGuahaoIdList.substring(1):"";

			if(mmGuahaoIdList == ""){
				layer.alert("请选择要审核的预约挂号信息！");
				return false;
			}

			$('#editShenheModal').modal();
			$("#myModalLabel_Shenhe").html("审核预约挂号信息");
			_this.editFlag=1;

			_this.guahaoid = "";

			_this.shenheyijian="";
			$("input[name='YuyueResult']").prop('checked',false);

		},

		// 点击批量审核模态框中的“保存”
		toShenheAll:function(){

			var _this = this;
			_this.ddShenHeCurrentIndex=0;
			_this.editFlag=1;
			$("[name=shenheCheckbox]:checked").each(function(){
				_this.guahaoid=this.value;
				_this.toShenhe();
			})

		},

		perpareToShenhe : function(ppGuahaoId,ppShenhejieguo,ppShenheyijian){
			this.editFlag=0;
			$('#editShenheModal').modal();
			$("#myModalLabel_Shenhe").html("审核预约挂号信息");

			this.guahaoid = ppGuahaoId;
			$("input[name='YuyueResult']").prop("checked",false); 
			$("input[name='YuyueResult'][value="+ppShenhejieguo+"]").prop("checked",true); 
			this.shenheyijian = ppShenhejieguo==0 ? "" : ppShenheyijian;

		},


		toShenhe : function(){
			var _this = this;

			if($("input[name='YuyueResult']:checked").val()==""||$("input[name='YuyueResult']:checked").val()==null)
			{
				layer.alert("请选择预约结果！");
				return false;
			}


			if($("input[name='YuyueResult']:checked").val()=="2")
			{
				if(_this.shenheyijian=="")
				{
					layer.alert("预约失败，请填写备注信息！");
					return false;
				}

			}


			$.post("/guahao/shenhe", {
				guahaoid : _this.guahaoid,
				shenhejieguo : $("input[name='YuyueResult']:checked").val(),
				shenheyijian : _this.shenheyijian,
				fajianrenid : _this.administratorid,
				neirong : _this.shenheyijian,
				random : Math.random()
			}, function(ppData) {
				if (ppData != null) {
					layer.closeAll("loading");
					if(ppData.result != "1"){
						layer.alert(ppData.message);
					}else{
						_this.ddShenHeCurrentIndex++;


						if(_this.ddShenHeCurrentIndex==_this.ddShenHeCount&&_this.editFlag==1)	
						{
							layer.open({
								time:1000,
								btn:[],
								content:"审核成功!",
							});
							$("#editShenheModal").modal("hide");
							_this.bindGuahaoList();
							$("input[name='shenheAllCheckbox']").prop('checked',false);
							$("input[name='shenheCheckbox']").prop('checked',false);
						}else if(_this.editFlag==0)
						{
							layer.open({
								time:1000,
								btn:[],
								content:"审核成功!",
							});
							$("#editShenheModal").modal("hide");
							_this.bindGuahaoList();
						}

					}
				}
			},"json");

		},

		ShowNews:function(ppOwnerId,ppUserId,ppUserName){
			var _this = this;

			_this.userid = ppUserId;
			_this.id = ppOwnerId;
			_this.username = ppUserName;

			$("#listXiaoxiModal").modal();
			_this.bindXiaoxiList();
			setInterval(function(){
				_this.bindXiaoxiList();
			},5000);
		},

		bindXiaoxiList:function(){
			var _this = this;
			$.post('/news/find_by_ownerid',{
				ownerid : _this.id,
				rdm:Math.random()
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

		//首页
		firstPage : function(){
			this.pageindex = 1;
		},

		//尾页
		lastPage : function(){
			this.pageindex = this.pageCount;
		},

		//上一页
		prePage : function(){
			var prePage = ((this.pageindex -1) <= 0) ? 1 : (this.pageindex -1);
			this.pageindex = prePage;
		},

		//下一页
		nextPage : function(){
			var nextPage = ((this.pageindex +1) >= this.pageCount) ? this.pageCount : (this.pageindex +1);
			this.pageindex = nextPage;
		},

		//跳到目标页
		targetPage : function() {
			if( this.targetpage != '' && this.targetpage <= this.pageCount && this.targetpage > 0){
				this.pageindex = this.targetpage;
				this.targetpage = '';
			}
		},

		toAdd : function(){
			var _this = this;

			layer.open({type:3});

			if(!$.trim(_this.neirong)){
				return;
			}

			$.post('/news/add', {
				fajianrenid : 'guahaoguanliyuan',
				fajianrenname : '挂号管理员',
				shoujianrenid : _this.userid,
				shoujianrenname : _this.username,
				neirong : _this.neirong,
				newstype: '1',
				ownerid : _this.id,
				rdm:Math.random()
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
						_this.showMessage(message);
					}
				}
			},"json");
		},

	}
})
