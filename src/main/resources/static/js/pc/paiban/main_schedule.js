var Schedule_Vue = new Vue({
	el : '#Schedule',
	data : {
		
		expertid : '',	//下拉框的专家id
		expertlist : [],// 下拉框的专家集合
		
		schedulelist : [],//周排班
		scheduleid : $("#scheduleid").val(),
		xingqi : $("#xingqi").val(),
		shangxiawu : $("#shangxiawu").val(),
		expertid : $("#input_expertid").val(),
		jiage : $("#input_jiage").val(),
		xianhaoshu : $("#input_xianhaoshu").val(),
		
		schedule : {},
		
		xingqi:'',
		shangxaiwu:'',
		
	},
	
	created : function() {
		var _this = this;

		_this.initExpertList();
		//_this.bindSchedule();
		_this.bindOnedaySchedule("1","上午");
		_this.bindOnedaySchedule("2","上午");
		_this.bindOnedaySchedule("3","上午");
		_this.bindOnedaySchedule("4","上午");
		_this.bindOnedaySchedule("5","上午");
		_this.bindOnedaySchedule("6","上午");

		_this.bindOnedaySchedule("1","下午");
		_this.bindOnedaySchedule("2","下午");
		_this.bindOnedaySchedule("3","下午");
		_this.bindOnedaySchedule("4","下午");
		_this.bindOnedaySchedule("5","下午");
		_this.bindOnedaySchedule("6","下午");
	},
	
	
	methods : {
		
		//初始化专家下拉列表
		initExpertList : function(){
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
		
		// 绑定周排班 
		bindSchedule : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/schedule/find_all',{
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						_this.schedulelist =ppData.resultContent;
						for(var i=0;i<_this.schedulelist.length;i++){
							
							var mmHtml = "<div>专家姓名："+_this.schedulelist[i].zhuanjiaxingming+"</div><div>价格："+_this.schedulelist[i].jiage+"元</div><div>限号数："+_this.schedulelist[i].xianhaoshu+"</div>" +
									"<div><div onclick=\"toShowSchedule('"+_this.schedulelist[i].id+"','"+_this.schedulelist[i].xingqi+"','"+_this.schedulelist[i].shangxiawu+"')\" style='border:1px solid #bbb;float:left;width:50%;color:#08b6fc;'>修改</div><div onclick=\"toDelete('"+_this.schedulelist[i].id+"')\" style='border:1px solid #bbb;float:left;width:50%;color:red;'>删除</div>";
							$("#"+_this.schedulelist[i].xingqi+_this.schedulelist[i].shangxiawu).html(mmHtml);
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		bindOnedaySchedule :function(ppXingqi,ppShangxiawu){
			var _this = this;
			layer.open({type:3});
			
			$.post('/schedule/find_by_xingqi_and_shangxiawu',{
				xingqi:ppXingqi,
				shangxiawu:ppShangxiawu,
				rdm:Math.random()
			},function(ppData){
				
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data =ppData.resultContent;
						var mmHtml = "";
						for(var i=0;i<data.length;i++){
							
							if(data[i].zhuangtai == 1){
								mmHtml += "<div style='width:100%;height:240px;float:left;'>" +
								"<div>专家姓名："+data[i].zhuanjiaxingming+"</div>" +
								"<div>价格："+data[i].jiage+"元</div>" +
								"<div>限号数："+data[i].xianhaoshu+"</div>" +
								"<div>状态：<span style='color:green'>启用</span></div>" +
								"<div>" +
									"<div onclick=\"toShowSchedule('"+data[i].id+"','"+data[i].xingqi+"','"+data[i].shangxiawu+"')\" style='border:1px solid #bbb;float:left;width:33%;color:#08b6fc;'>修改</div>" +
									"<div onclick=\"toDelete('"+data[i].id+"')\" style='border:1px solid #bbb;float:left;width:34%;color:red;'>删除</div>" +
									"<div onclick=\"toSetZhuangtai('"+data[i].id+"','0')\" style='border:1px solid #bbb;float:left;width:33%;color:#f0ad4e;'>停诊</div>" +
								"</div>" +
								"</div>";
							}else if(data[i].zhuangtai == 0){
								mmHtml += "<div style='width:100%;height:240px;float:left;'>" +
								"<div>专家姓名："+data[i].zhuanjiaxingming+"</div>" +
								"<div>价格："+data[i].jiage+"元</div>" +
								"<div>限号数："+data[i].xianhaoshu+"</div>" +
								"<div>状态：<span style='color:#f0ad4e'>停诊</span></div>" +
								"<div>" +
									"<div onclick=\"toShowSchedule('"+data[i].id+"','"+data[i].xingqi+"','"+data[i].shangxiawu+"')\" style='border:1px solid #bbb;float:left;width:33%;color:#08b6fc;'>修改</div>" +
									"<div onclick=\"toDelete('"+data[i].id+"')\" style='border:1px solid #bbb;float:left;width:34%;color:red;'>删除</div>" +
									"<div onclick=\"toSetZhuangtai('"+data[i].id+"','1')\" style='border:1px solid #bbb;float:left;width:33%;color:green;'>启用</div>" +
								"</div>" +
								"</div>";
							}
							
						}
						var mmHtml2 = "<div onclick=\"toShowSchedule('','"+ppXingqi+"','"+ppShangxiawu+"')\" style='float:left;cursor:pointer;width:100%;height:50px;line-height:50px;color:#08a3fe'>新增周排班</div>";

						$("#"+ppXingqi+ppShangxiawu).html(mmHtml);
						$("#"+ppXingqi+ppShangxiawu).append(mmHtml2);
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toShowSchedule : function(ppScheduleId,ppXingqi,ppShangxiawu){
			var _this = this;
			
			_this.clearInput();
			
			$("#xingqi").val(ppXingqi);
			$("#shangxiawu").val(ppShangxiawu);
			_this.xingqi = ppXingqi;
			_this.shangxiawu = ppShangxiawu;
			
			if(ppScheduleId!=""){
				$("#scheduleid").val(ppScheduleId);
				_this.scheduleid = ppScheduleId;
				_this.bindOneSchedule();
				
				$("#myModalLabel").html("修改周排班");
			}else{
				$("#myModalLabel").html("新增周排班");
			}
			
			$('#editScheduleModal').modal();
		},
		
		bindOneSchedule : function(){
			var _this = this;
			layer.open({type:3});
			
			$.post('/schedule/find_one', {
				scheduleid : _this.scheduleid,
				rdm : Math.random()
			},function(ppData) {
				
				layer.closeAll("loading");
				if(ppData != null){
					if(ppData.result == "1"){
						
						var data = ppData.resultContent;
						_this.schedule = data;
						_this.expertid = _this.schedule.expertid;
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		saveSchedule : function(){
			var _this = this;
			if(_this.checkInputData()){
				layer.open({type:3});
				$.post('/schedule/save',{
					scheduleid:$("#scheduleid").val(),
					xingqi:$("#xingqi").val(),
					expertid : $("#input_expertid").val(),
					guahaoleibie : "专家号",
					shangxiawu : $("#shangxiawu").val(),
					xianhaoshu : $("#input_xianhaoshu").val(),
					jiage : $("#input_jiage").val(),
					zhuangtai : 1,
					random : Math.random()
				},function(ppData){
					if(ppData != null){
						layer.closeAll("loading");
						if(ppData.result == "1"){
							layer.open({
								time:1000,
								btn:[],
								content:"保存成功!",
							});
							$("#editScheduleModal").modal("hide");
							_this.bindOnedaySchedule($("#xingqi").val(),$("#shangxiawu").val());
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
			
			var expertid = $("#input_expertid").val();
			if("" == expertid){
				layer.alert("请选择专家！");
	    		return false;
			}
			
			var jiage = $("#input_jiage").val()
			if("" == jiage){
				layer.alert("请填写价格！");
	    		return false;
			}

			var xianhaoshu = $("#input_xianhaoshu").val()
			if("" == xianhaoshu){
				layer.alert("请填写限号数！");
	    		return false;
			}

			return true;
		},
		
		clearInput:function(){
			$("#input_expertid").val("");
			$("#input_jiage").val("");
			$("#input_xianhaoshu").val("");
		}
	}
})
