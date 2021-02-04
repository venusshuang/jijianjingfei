var mmPageSize = 8;
var mmPageIndex = 1;
var mmPageCount = 0;
var mmRecordCount = 0;

function BindList_Info() {
	FindByCategoryIdPaging_info(
			CurrentCategoryId,
			mmPageIndex,
			mmPageSize,
			function(ppData) {
				if (ppData != null) {
					var mmData = eval(ppData);
					var result = mmData.result;
					var data = mmData.resultContent;
					var mmInfoList = data.list;
					mmPageCount = data.pages;
					mmRecordCount = data.size;
					if (result == "1") {
						var mmHtml = "<table id='InfoTable' class='table table-striped table-hover' width='100%'>";
						mmHtml += "<thead style='background-color:#D9EDF7'><tr>";
						mmHtml += "<th style='text-align:ce" +
								"nter;'>#</th>";
						mmHtml += "<th style='text-align:center;'>图片</th>";
						mmHtml += "<th style='text-align:center;'>标题</th>";
						mmHtml += "<th style='text-align:center;'>添加时间</th>";
						mmHtml += "<th style='text-align:center;'>作者</th>";
						mmHtml += "<th style='text-align:center;'>是否通过</th>";
						mmHtml += "<th style='text-align:center;'>操作</th>";
						mmHtml += "</tr></thead>";
						mmHtml += "<tbody>";

						for (var i = 0; i < mmInfoList.length; i++) {
							var mmInfoId = mmInfoList[i].infoid;
							var mmTitle = mmInfoList[i].infotitle;
							var mmAddTime = (mmInfoList[i].addtime == undefined) ? ""
									: mmInfoList[i].addtime;
							var mmAuthor = mmInfoList[i].author;
							var mmCheckPass = mmInfoList[i].checkpass;
							var mmPicUrl = mmInfoList[i].imageurl;
							
							

							var mmCheckText = "";
							if (mmCheckPass == 1) {
								mmCheckText = "<span style='color:green;font-size:14px;font-weight:bold;  font-family:微软雅黑;'>√</span>";
							} else {
								mmCheckText = "<span style='color:red;font-size:14px;font-weight:bold;font-family:微软雅黑;'>×</span>";
							}

							mmHtml += "<tr style='height:77px;' id=Info" + mmInfoId + "> ";
							mmHtml += "<td style='text-align:center;vertical-align:middle;'>" + (i + 1) + "</td>";
							
							if(mmPicUrl==""){
								mmHtml += "<td style='text-align:center;vertical-align:middle;'></td>";
							}else{
								mmHtml += "<td style='text-align:center;vertical-align:middle;'><img src='"+mmPicUrl+"' width=80 height=60/></td>";
							}
							
							mmHtml += "<td style='text-align:center;vertical-align:middle;' align='left'><a target=\"_blank\" href='../homepage/showinfo?infoid="
									+ mmInfoId + "'>" + mmTitle + "</a></td>";
							mmHtml += "<td style='text-align:center;vertical-align:middle;'>" + mmAddTime + "</td>";
							mmHtml += "<td style='text-align:center;vertical-align:middle;'>" + mmAuthor + "</td>";
							mmHtml += "<td style='text-align:center;vertical-align:middle;'>" + mmCheckText + "</td>";
							mmHtml += "<td style='text-align:center;vertical-align:middle;'><button type='button' class='btn btn-xs btn-info' onclick=\"ToMoveUp_Info('"
									+ mmInfoId
									+ "');\">上移</button>"
									+ "　<button type='button' class='btn btn-xs btn-info' class='movespan' onclick=\"ToMoveDown_Info('"
									+ mmInfoId
									+ "');\">下移</button>"
									+ "　<button type='button' class='btn btn-xs btn-primary' onclick=\"PrepareToModify_Info('"
									+ mmInfoId
									+ "');\">修改</button>"
									+ "　<button type='button' class='btn btn-xs btn-danger' onclick=\"ToDelete_Info('"
									+ mmInfoId + "');\">删除</button></td>";
							mmHtml += "</tr>";
						}
						// 分页
						mmHtml += "<tr style='text-align:center;'><td colspan='7'>"
								+ GetPageNav() + "</td></tr>";
						mmHtml += "</tbody></table>";
						$("#ListPart_info").html(mmHtml);
					}
				}
			});
}

function GetPageNav() {
	// mmPageCount = Math.ceil(mmRecordCount / mmPageSize);
	var PrePage = ((mmPageIndex - 1) <= 0) ? 1 : (mmPageIndex - 1);
	var NextPage = ((mmPageIndex + 1) >= mmPageCount) ? mmPageCount
			: (parseInt(mmPageIndex) + 1);
	var mmHtml = "<input type='button' value='首页' onclick=\"SetPageIndex(1);\"/>";
	mmHtml += "　<input type='button' value='上一页' onclick=\"SetPageIndex("
			+ PrePage + ");\"/>　";
	mmHtml += mmPageIndex + "/" + mmPageCount;
	mmHtml += "　总记录数:" + mmRecordCount;
	if (mmRecordCount == 0) {
		NextPage = 1;
		mmPageCount = 1;
	}
	mmHtml += "　<input type='button' value='下一页' onclick=\"SetPageIndex("
			+ NextPage + ");\"/>";
	mmHtml += "　<input type='button' value='末页' onclick=\"SetPageIndex("
			+ mmPageCount + ");\"/>";
	mmHtml += "　跳到第<input id='JumpPage' type='text' style='width:25px;'/>页<input type='button' value='跳' onclick=\"JumpPage();\"/>";

	return mmHtml;
}

function SetPageIndex(ppPageIndex) {
	mmPageIndex = ppPageIndex;
	BindList_Info();
}

function JumpPage() {
	var mmPage = $("#JumpPage").val();
	if (mmPage <= 1) {
		mmPage = 1;
	} else if (mmPage > mmPageCount) {
		mmPage = mmPageCount;
	}
	SetPageIndex(mmPage);
}

function PrepareToAdd_Info() {
	$("#ActionText_Info").html("信息添加");
	ClearForm_Info();
	ShowOrHideInfoListPart(false);
	ShowOrHideInfoEditPart(true);
	$(".SaveButton_Info").unbind();
	$(".SaveButton_Info").bind("click", ToAdd_Info);
}

function ToAdd_Info() {
	GetInputAndCheck_Info(function(ppMessage) {
	}, function(ppDataObject) {
		Add_info(ppDataObject, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var result = mmData.result;
				var data = mmData.resultContent;
				var message = mmData.message;
				if (result == "1") {
					if (confirm("添加成功，是否返回列表？")) {
						ClearForm_Info();
						CurrentNewsInfoId = data.infoid;
						SelectCurrentOfActionType('4');
					} else {
						ClearForm_Info();
					}
				} else {
					alert(message);
				}
			}
		});
	});
}

function PrepareToModify_Info(ppInfoId) {
	CurrentNewsInfoId = ppInfoId;
	$("#ActionText_Info").html("修改信息");
	ShowOrHideInfoListPart(false);
	ShowOrHideInfoEditPart(true);
	ClearForm_Info();
	BindOldValue_Info(ppInfoId);
	$(".SaveButton_Info").unbind();
	$(".SaveButton_Info").bind("click", ToModify_Info);
}

function BindOldValue_Info(ppInfoId) {
	FindCustomOne_info(ppInfoId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var result = mmData.result;
			var message = mmData.message;
			var data = mmData.resultContent;
			if (result == "1") {
				CurrentCategoryId = data.categoryid;
				$("#infoid").val(data.infoid);
				$("#jianti").val(data.jianti);
				$("#infotitle").val(data.infotitle);
				$("#infotitle2").val(data.infotitle2);
				$("#summary").val(data.summary);
				$("#author").val(data.author);
				$("#source").val(data.source);
				$("#releasetime").val(data.releasetime);
				$("#returnurl").val(data.returnurl);
				$("#imageurl").val(data.imageurl);
				$("#videourl").val(data.videourl);
				if (data.checkpass == "1") {
					$("#checkpass").prop({checked:true});
				} else {
					$("#checkpass").prop({checked:false});
				}
				UE.getEditor('editor').ready(
						function() {
							UE.getEditor('editor').setContent(
									data.infocontent.toString());
						});
			} else {
				alert(message);
			}
		} else {
			alert("绑定失败");
		}
	});
}

function ToModify_Info() {
	GetInputAndCheck_Info(function(ppMessage) {
	}, function(ppDataObject) {
		Modify_info(ppDataObject, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var result = mmData.result;
				var message = mmData.message;
				if (result == "1") {
					alert("修改成功");
					ClearForm_Info();
					SelectCurrentOfActionType('4');
				} else {
					alert(message);
				}
			}
		});
	});
}

function ToDelete_Info(ppInfoId) {
	if (confirm("确定要删除吗？")) {
		Delete_infocategoryinfo(ppInfoId, CurrentCategoryId, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var message = mmData.message;
				var result = mmData.result;
				var data = mmData.resultContent;
				if (result == "1") {
					alert(data);
					SelectCurrentOfActionType('4');
				} else {
					alert(message);
				}
			}
		});
	}
}

function ToMoveUp_Info(ppInfoId) {
	MoveUp_infocategoryinfo(ppInfoId, CurrentCategoryId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {
				BindList_Info();
			} else {
				alert(message);
			}
		}
	});
}

function ToMoveDown_Info(ppInfoId) {
	MoveDown_infocategoryinfo(ppInfoId, CurrentCategoryId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {
				BindList_Info();
			} else {
				alert(message);
			}
		}
	});
}

function GetInputAndCheck_Info(ppErrorCallback, ppSuccessCallback) {
	var mmDataObject = new Object();

	var mmInfoId = $("#infoid").val();
	var mmJianti = $("#jianti").val();
	var mmInfotitle = $("#infotitle").val();
	var mmInfotitle2 = $("#infotitle2").val();
	var mmSummary = $("#summary").val();
	var mmAuthor = $("#author").val();
	var mmSource = $("#source").val();
	var mmReleasetime = $("#releasetime").val();
	var mmCheckpass = $("#checkpass").is(":checked") ? "1" : "0";
	var mmReturnurl = $("#returnurl").val();
	var mmImageurl = $("#imageurl").val();
	var mmVideourl = $("#videourl").val();
	var mmInfocontent = UE.getEditor('editor').getContent();

	if (mmInfotitle == "") {
		alert("请填写标题");
		$("#infotitle").focus();
		return false;
	}
	if (mmInfocontent == "") {
		alert("请填写正文");
		return false;
	}

	mmDataObject.categoryid = CurrentCategoryId;
	mmDataObject.infoid = mmInfoId;
	mmDataObject.jianti = mmJianti;
	mmDataObject.infotitle = mmInfotitle;
	mmDataObject.infotitle2 = mmInfotitle2;
	mmDataObject.summary = mmSummary;
	mmDataObject.source = mmSource;
	mmDataObject.author = mmAuthor;
	mmDataObject.infocontent = mmInfocontent;
	mmDataObject.releasetime = mmReleasetime;
	mmDataObject.imageurl = mmImageurl;
	mmDataObject.videourl = mmVideourl;
	mmDataObject.returnurl = mmReturnurl;
	mmDataObject.checkpass = mmCheckpass;
	ppSuccessCallback(mmDataObject);
}

function ClearForm_Info() {
	$("#infoid").val("");
	$("#jianti").val("");
	$("#infotitle").val("");
	$("#infotitle2").val("");
	$("#filelist").html("");
	$("#summary").val("");
	$("#author").val("");
	$("#source").val("");
	$("#releasetime").val(y + '-' + m + '-' + d);
	$("#returnurl").val("");
	$("#imageurl").val("");
	$("#videourl").val("");
	UE.getEditor('editor').setContent("");
}

function PrepareEditor() {
	ue = UE.getEditor('editor', {
		// focus时自动清空初始化时的内容
		// autoClearinitialContent:true,
		// 关闭字数统计
		wordCount : true,
		// 关闭elementPath
		elementPathEnabled : true,
		// 默认的编辑区域宽度
		// initialFrameWidth:500,
		// 默认的编辑区域高度
		initialFrameHeight : 500
	});
}

function ToGenerateVideoName() {
	GenerateVideoName_info(function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			var resultContent = mmData.resultContent;
			if (result == "1") {
				$("#videourl").val(resultContent);
			} else {
				alert(message);
			}
		}
	});
}

function ClearVideoName() {
	if ($("#videourl").val() != "") {
		if (confirm("确定清空现有视频吗？")) {
			$("#videourl").val("");
		}
	}
}

function ToAddClicknum_Info(ppInfoId) {
	AddClicknum_Info(ppInfoId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {

			}
		}
	});
}