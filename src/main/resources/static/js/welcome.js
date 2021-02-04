var Welcome = new Vue({
	el : '#Welcome',
	data : {
		
		tongjiList : [],
		tongjiList2 : [],
		tongjiList3 : [],
		
		starttime : '',
		endtime : '',
	},

	created : function() {
		var _this = this;

		_this.BindTongjiRenshu();
		_this.BindTongjiNianling();
		_this.BindTongjiBingzhong();
	},

	watch : {
		
	},

	methods : {

		BindTongjiRenshu : function() {
			var _this = this;
			layer.open({
			    type: 3,
			    content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在统计，请稍候。</div>"
			});

			$.post('/guahao/tongji_renshu', {
				rdm : Math.random()
			}, function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					var mmData = ppData;
					var message = mmData.message;
					var result = mmData.result;
					var data = mmData.resultContent;
					if (result == '1') {
						_this.eChart("charts", [ '就诊患者人数统计' ], data);
						_this.tongjiList = data;
					}
				}
			});
		},

		/* 柱状图 */
		eChart : function(imageId, typeArr, data) {
			var ListFirstArr = new Array();
			var XArr = new Array();
			var dataArr = new Array();
			for (var j = 0; j < data.length; j++) {
				dataArr.push(data[j].COUNT);
				XArr.push(data[j].SHIJIAN);
			}
			var item = {
				name : '就诊患者人数统计',
				type : 'bar',
				data : dataArr
			};
			ListFirstArr.push(item);

			var myChart = echarts.init(document.getElementById(imageId));

			option = {
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				toolbox : { // 很关键的一个功能，自由切换柱状图曲线图的工具盒子
					show : true, // 让它显示
					feature : {
						mark : {
							show : true
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						}, // 类型让他两种都存在
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				legend : {
					data : typeArr
				},
				title : {
					text : typeArr,
					x : 'center',
					y : 'top',
					textAlign : 'center'
				},
				yAxis : [ {
					type : 'value'
				} ],
				grid : {
					x : 40,
					x2 : 100,
					y2 : 150,
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},

				xAxis : [ {
					type : 'category',
					data : XArr,
				/* type : 'value' */
				} ],
				series : [ {
					data : dataArr,
					type : 'bar',
					itemStyle : {
						normal : {
							color : function(params) {
								var colorList = [ '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622' ];
								return colorList[params.dataIndex]
							},
							label : {
								show : true,
								position : 'top'
							}
						}
					}
				} ]

			}
			myChart.setOption(option);
		},

		BindTongjiNianling : function() {
			var _this = this;
			layer.open({
			    type: 3,
			    content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在统计，请稍候。</div>"
			});

			$.post('/guahao/tongji_nianling', {
				rdm : Math.random()
			}, function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					var mmData = ppData;
					var message = mmData.message;
					var result = mmData.result;
					var data = mmData.resultContent;
					if (result == '1') {
						_this.eChart2("charts2", [ '就诊患者人数统计' ], data);
						_this.tongjiList2 = data;
					}
				}
			});
		},

		/* 柱状图 */
		eChart2 : function(imageId, typeArr, data) {
			var ListFirstArr = new Array();
			var XArr = new Array();
			var dataArr = new Array();
			for (var j = 0; j < data.length; j++) {
				dataArr.push(data[j].COUNT);
				XArr.push(data[j].SHIJIAN);
			}
			var item = {
				name : '就诊患者年龄统计',
				type : 'pie',
				data : data
			};
			ListFirstArr.push(item);
			var myChart = echarts.init(document.getElementById(imageId));

			option = {
				toolbox : { // 很关键的一个功能，自由切换柱状图曲线图的工具盒子
					show : true, // 让它显示
					feature : {
						mark : {
							show : true
						},
						magicType : {
							show : true,
							type : []
						}, // 类型让他两种都存在
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				legend : {
					data : typeArr
				},
				title : {
					text : typeArr,
					x : 'center',
					y : 'top',
					textAlign : 'center'
				},
				series : [ 
			        {
			            name: '访问来源',
			            type: 'pie',    // 设置图表类型为饼图
			            radius: '55%',  // 饼图的半径，外半径为可视区尺寸（容器高宽中较小一项）的 55% 长度。
			            data:data,
			            label: {
			                normal: {
			                    formatter: '{b}:{c}' + '\n\r' + '({d}%)',
			                    show: true,
			                    position: 'left'
			                },
			                emphasis: {
			                    show: true,
			                    textStyle: {
			                        fontSize: '20',
			                        fontWeight: 'bold'
			                    }
			                }
			            },
			        }
				]

			}
			myChart.setOption(option);
		},
		
		BindTongjiBingzhong : function() {
			var _this = this;
			layer.open({
			    type: 3,
			    content: "<div style='font-size:18px;font-weight:bold;padding-top:40px;width:200px;text-align:left;'>正在统计，请稍候。</div>"
			});

			$.post('/zhuyuan/tongji_bingzhong', {
				rdm : Math.random()
			}, function(ppData) {
				layer.closeAll("loading");
				if (ppData != null) {
					var mmData = ppData;
					var message = mmData.message;
					var result = mmData.result;
					var data = mmData.resultContent;
					if (result == '1') {
						_this.eChart3("charts3", [ '住院患者病种统计' ], data);
						_this.tongjiList3 = data;
					}
				}
			});
		},

		/* 柱状图 */
		eChart3 : function(imageId, typeArr, data) {
			var ListFirstArr = new Array();
			var XArr = new Array();
			var dataArr = new Array();
			for (var j = 0; j < data.length; j++) {
				dataArr.push(data[j].COUNT);
				XArr.push(data[j].BINGZHONG);
			}
			var item = {
				name : '住院患者病种统计',
				type : 'bar',
				data : dataArr
			};
			ListFirstArr.push(item);

			var myChart = echarts.init(document.getElementById(imageId));

			option = {
				tooltip : {
					trigger : 'axis',
					axisPointer : { // 坐标轴指示器，坐标轴触发有效
						type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
					}
				},
				toolbox : { // 很关键的一个功能，自由切换柱状图曲线图的工具盒子
					show : true, // 让它显示
					feature : {
						mark : {
							show : true
						},
						magicType : {
							show : true,
							type : [ 'bar','line']
						}, // 类型让他两种都存在
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				},
				legend : {
					data : typeArr
				},
				title : {
					text : typeArr,
					x : 'center',
					y : 'top',
					textAlign : 'center'
				},
				yAxis : [ {
					type : 'value'
				} ],
				grid : {
					x : 40,
					x2 : 100,
					y2 : 150,
					left : '3%',
					right : '4%',
					bottom : '3%',
					containLabel : true
				},

				xAxis : [ {
					type : 'category',
					data : XArr,
				/* type : 'value' */
				} ],
				series : [ 
					{
					data : dataArr,
					type : 'bar',
					itemStyle : {
						normal : {
							color : function(params) {
								var colorList = [ '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622',
										'#c23531', '#2f4554', '#61a0a8',
										'#d48265', '#91c7ae', '#749f83',
										'#ca8622', '#c23531', '#2f4554',
										'#61a0a8', '#d48265', '#91c7ae',
										'#749f83', '#ca8622', '#c23531',
										'#2f4554', '#61a0a8', '#d48265',
										'#91c7ae', '#749f83', '#ca8622' ];
								return colorList[params.dataIndex]
							},
							label : {
								show : true,
								position : 'top'
							}
						}
					}
				} ]

			}
			myChart.setOption(option);
		}
	}
})
