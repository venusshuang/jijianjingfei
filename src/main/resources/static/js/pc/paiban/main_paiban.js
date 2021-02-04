var Paiban_Vue = new Vue({
	el : '#Paiban',
	data : {
		
		name : $("#name").val(),
		paibanriqi : $("#paibanriqi").val(),
		paibanlist : [],// 排班列表
		paiban : {},	//某一排班情况
		editFlag : 0,// 0:新增，1：修改
		show : true,// 显示列表是否有数据
		paibanid : '',	//当前的排班id
		expertid : '',	//下拉框的专家id
		expertlist : [],// 下拉框的专家集合
		
		
	},
	
	created : function() {
		var _this = this;

		_this.bindPaibanList();
	},
	
	
	methods : {
		
		 getDate : function() {
			 var _this=this;
			 
			 _this.paiban.paibanriqi = $("#paibanriqi2").val(); 
		},
		getDate2 : function() {
			 var _this=this;
			 
			 _this.paibanriqi = $("#paibanriqi").val(); 
		},
	
		// 绑定排班列表 
		bindPaibanList : function(){
			
			var _this = this;
			layer.open({type:3});
			$.post('/paiban/findPaiBanGuanLiByNameAndDateAndShangxiawu',{
				name:_this.name,
				paibanriqi:_this.paibanriqi,
				shangxiawu:"",
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						_this.paibanlist =ppData.resultContent;
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toRemove : function(){
			var _this = this;
			_this.name='';
			_this.paibanriqi='';
			$("#name").val("");
			$("#paibanriqi").val("");
		},
		
		perparetoAddPaiban : function(){
			$('#editPaibanModal').modal();
			$("#myModalLabel_paiban").html("新增排班信息");
			this.editFlag = 0;
			this.paiban = {};
			this.paibanid="";
			this.bindExpertList();
		
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
		
		perpareToModifyPaiban : function(ppPaibanId){

			$('#editPaibanModal').modal();
			$("#myModalLabel_paiban").html("修改排班信息");
			this.editFlag = 1;

			this.paibanid = ppPaibanId;
			this.bindExpertList();
			this.bindPaiban();
			
		},
		
		bindPaiban : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/paiban/find_one', {
				paibanid : _this.paibanid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.paiban = data;
						_this.expertid = data.expertid;
						$("input[name='shangxiawu'][value="+data.shangxiawu+"]").attr("checked",true); 
						
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		addPaiban : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/paiban/savePaiban',{
					paibanid:_this.paibanid,
					expertid:_this.expertid,
					name : !_this.paiban.name ? "" : $.trim(_this.paiban.name),
					guahaoleibie : !_this.paiban.guahaoleibie ? "" : $.trim(_this.paiban.guahaoleibie),
					paibanriqi : !_this.paiban.paibanriqi ? "" : $.trim(_this.paiban.paibanriqi),
					shangxiawu : !_this.paiban.shangxiawu ? "" : $.trim(_this.paiban.shangxiawu),
					xianhaoshu : !_this.paiban.xianhaoshu ? 0 : $.trim(_this.paiban.xianhaoshu),
					shengyuhaoshu : !_this.paiban.shengyuhaoshu ? 0 : $.trim(_this.paiban.shengyuhaoshu),
					jiage : !_this.paiban.jiage ? 0 : $.trim(_this.paiban.jiage),
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"新增成功!",
							});
							$("#editPaibanModal").modal("hide");
							_this.bindPaibanList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		
		
		
		
		//检查输入信息
		checkInputData : function(){
			var _this = this;
			
			var expertid = !_this.expertid ? "" : $.trim(_this.expertid);
			if("" == expertid){
				layer.alert("请选择专家姓名！");
	    		return false;
			}
			
			_this.paiban.name = $("#expertid").find("option:selected").text();
			
			
			var paibanriqi = !_this.paiban.paibanriqi ? "" : $.trim(_this.paiban.paibanriqi);
			if("" == paibanriqi){
				layer.alert("请选择排班日期！");
	    		return false;
			}
			
			_this.paiban.shangxiawu = $("input[name='shangxiawu']:checked").val();
			
			
			var xianhaoshu = !_this.paiban.xianhaoshu ? "" : $.trim(_this.paiban.xianhaoshu);
			if("" == xianhaoshu){
				layer.alert("请填写预约人数！");
	    		return false;
			}
			
			var jiage = !_this.paiban.jiage ? "" : $.trim(_this.paiban.jiage);
			if("" == jiage){
				layer.alert("请填写价格！");
	    		return false;
			}

			return true;
		},
		
		allCheckPaiban : function(){
			var _this = this;
			
			//var mmValue=$("#allCheckPaiban:checked").val();
			
			if($("#allCheckPaiban").is(":checked"))
			{
			    $("input[name='paibanCheckbox']").prop('checked',true);
			}
			else
			{
			    $("input[name='paibanCheckbox']").prop('checked',false);
			}
			
			
		},
		
		toDeleteChecked:function(){
			var _this = this;

			var mmPaibanIdList="";
			$("[name=paibanCheckbox]:checked").each(function(){
				mmPaibanIdList+="|"+this.value;
			})
			mmPaibanIdList=mmPaibanIdList!=""?mmPaibanIdList.substring(1):"";
			
			if(mmPaibanIdList == ""){
				layer.alert("请选择要删除的排班！");
				return false;
			}
			
			layer.confirm('是否确定删除？',{
				btn : ['是','否']
			},function(){
			
			layer.open({type:3});
			
			$.post('/paiban/deletePaibanIdList',{
				paibanIdList :mmPaibanIdList,			
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				
				if(ppData!=null){
					if(ppData.result == '1'){
						
						layer.alert("批量删除成功");	
						_this.bindPaibanList();
						
					}else{
						
						layer.alert(ppData.message);
					}
				}
			},"json");
			
			})
		},
			
		
		
		
		modifyPaiban : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/paiban/savePaiban',{
					paibanid:_this.paibanid,
					expertid:_this.expertid,
					name : !_this.paiban.name ? "" : $.trim(_this.paiban.name),
					guahaoleibie : !_this.paiban.guahaoleibie ? "" : $.trim(_this.paiban.guahaoleibie),
					paibanriqi : !_this.paiban.paibanriqi ? "" : $.trim(_this.paiban.paibanriqi),
					shangxiawu : !_this.paiban.shangxiawu ? "" : $.trim(_this.paiban.shangxiawu),
					xianhaoshu : !_this.paiban.xianhaoshu ? 0 : $.trim(_this.paiban.xianhaoshu),
					shengyuhaoshu : !_this.paiban.shengyuhaoshu ? 0 : $.trim(_this.paiban.shengyuhaoshu),
					jiage : !_this.paiban.jiage ? 0 : $.trim(_this.paiban.jiage),
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"修改成功!",
							});
							$("#editExpertModal").modal("hide");
							_this.bindPaibanList();
					   }else{
						   layer.alert(ppData.message);
					   }
					}
				},"json")
			}
		},
		
		toDelete : function(ppPaibanId){
			var _this = this;
			layer.confirm("确定删除该排班信息吗？",{
				btn : ['是','否']
			},function(){
				layer.open({type:3});
				$.post("/paiban/deletePaiban", {
					paibanid : ppPaibanId,
					random : Math.random()
				}, function(ppData) {
					if (ppData != null) {
						layer.closeAll("loading");
						if(ppData.result != "1"){
							layer.alert(ppData.message);
						}else{
							layer.open({
								time:1000,
								btn:[],
								content:"删除成功!",
							});
							_this.bindPaibanList();
						}
					}
				},"json");
			})
		},
		
		
		
		
		
		
	}
})
