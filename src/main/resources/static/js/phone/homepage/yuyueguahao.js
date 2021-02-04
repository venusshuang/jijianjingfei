var _yuyueguahaoVue = new Vue({
	el:"#yuyueguahao",
	data:{
		usertype : $("#usertype").val(),
		userid : $("#userid").val(),
		jiuzhenxinxiid : $("#jiuzhenxinxiid").val(),
		
		paibanlist : [],//排班列表
		paibanid : '',
		
		riqilist : [],//一周日期列表
		today: '',
		
		show : true,
	},
	created : function(){
		var _this = this;
		
		$("#listPart").show();
		_this.getDay();
		setTimeout(function(){
			_this.bindPaibanList(_this.getToday(),"上午","a");
		},'1000');
	},
	methods:{
		
		getDay:function(){
			var _this = this;
			
			for(var i=0;i<=5;i++){
				var map = {};
				
				var dd = new Date();
				dd.setDate(dd.getDate()+i);//获取i天后的日期
				var y = dd.getFullYear(); //得到年份
				var m = (dd.getMonth()+1)<10?"0"+(dd.getMonth()+1):(dd.getMonth()+1);//得到月份
				var d = dd.getDate()<10?"0"+dd.getDate():dd.getDate();//得到日期
				var mmXQ = "";
				if(dd.getDay()==0){
					mmXQ = "周日";
				}else if(dd.getDay()==1){
					mmXQ = "周一";
				}else if(dd.getDay()==2){
					mmXQ = "周二";
				}else if(dd.getDay()==3){
					mmXQ = "周三";
				}else if(dd.getDay()==4){
					mmXQ = "周四";
				}else if(dd.getDay()==5){
					mmXQ = "周五";
				}else if(dd.getDay()==6){
					mmXQ = "周六";
				}
				
				map.date = m+"月"+d+"日";
				map.xingqi = mmXQ;
				map.day = y+"-"+m+"-"+d;
				
				_this.riqilist.push(map);
			}
		},
		
		getToday:function(){
			var _this = this;
			
			var dd = new Date();
			var y = dd.getFullYear(); //得到年份
			var m = (dd.getMonth()+1)<10?"0"+(dd.getMonth()+1):(dd.getMonth()+1);//得到月份
			var d = dd.getDate()<10?"0"+dd.getDate():dd.getDate();//得到日期
			
			return y+"-"+m+"-"+d;
		},
		
		// 绑定排班列表 
		bindPaibanList : function(ppPaibanriqi,ppShangxiawu,ppSX){
			var _this = this;
			layer.open({type:3});
			
			$(".riqiitem").removeClass("currentday");
			$("#"+ppPaibanriqi+ppSX).addClass("currentday");
			
			$.post('/paiban/findPaiBanGuanLiByNameAndDateAndShangxiawu',{
				name : "",
				paibanriqi : ppPaibanriqi,
				shangxiawu : ppShangxiawu,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						var data = ppData.resultContent;
						if(data.length>0){
							_this.show = true;
							_this.paibanlist = data;
						}else{
							_this.show = false;
						}
					}else{
						layer.alert(ppData.message);
					}
				}
			},"json");
		},
		
		toDetail:function(ppPaibanId){
			var _this = this;
			
			location.href="/homepage/yuyueguahao_detail.html?paibanid="+ppPaibanId+"&jiuzhenxinxiid="+_this.jiuzhenxinxiid;
		},
		
		// 挂号
		toGuahao : function(ppPaibanId){
			var _this = this;
			layer.open({type:3});
			
			$.post('/guahao/add',{
				jiuzhenxinxiid : _this.jiuzhenxinxiid,
				userid : _this.userid,
				paibanid : ppPaibanId,
				rdm:Math.random()
			},function(ppData){
				layer.closeAll("loading");
				if(ppData!=null){
					if(ppData.result == '1'){
						$(".weui-toast__content").html(ppData.resultContent);
						$("#js_toast").show()
						setTimeout(function(){
							location.href="/homepage/yuyueguahao.html?jiuzhenxinxiid="+_this.jiuzhenxinxiid;
						},'3000');
					}else{
						$(".weui-toast__content").html(ppData.message);
						$("#js_toast").show()
						setTimeout(function(){
							location.href="/homepage/yuyueguahao.html?jiuzhenxinxiid="+_this.jiuzhenxinxiid;
						},'3000');
					}
				}
			},"json");
		},
		
	}
})