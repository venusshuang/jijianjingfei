function BindTree_InfoCategory(ppUserType, ppDeptId) {
	if (ppUserType == 'SuperAdmin') {
		FindAll_infocategory(function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var result = mmData.result;
				var data = mmData.resultContent;
				if (result == "1") {
					myTree = new dTree("myTree");
					for (var i = 0; i < data.length; i++) {
						var mmID = data[i].categoryid;
						var mmPID = data[i].parentcategoryid;
						var mmLMNAME = data[i].categoryname;
						var mmText = "<span id=" + mmID + ">";
						mmText += "<span style='cursor:pointer;' title=\'"
								+ mmLMNAME + "\' onclick=\"SelectCategory('"
								+ mmID + "','" + mmLMNAME + "');\">" + mmLMNAME
								+ "</span>";
						mmText += "</span>";
						if (mmID == "0") {
							myTree.add(mmID, "-1", mmText);
						} else {
							myTree.add(mmID, mmPID, mmText);
						}
					}
					$("#Tree_InfoCategory").html("" + myTree);
				}
			}
		});
	} else if (ppUserType == 'Admin') {
		FindAllByDeptId_infocategory(ppDeptId, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var result = mmData.result;
				var data = mmData.resultContent;
				if (result == "1") {
					myTree = new dTree("myTree");
					for (var i = 0; i < data.length; i++) {
						var mmID = data[i].categoryid;
						var mmPID = data[i].parentcategoryid;
						var mmLMNAME = data[i].categoryname;
						var mmText = "<span id=" + mmID + ">";
						if (mmID == "0") {
							mmText += "<span title=\'" + mmLMNAME + "\'>"
									+ mmLMNAME + "</span>";
							mmText += "</span>";
							myTree.add(mmID, "-1", mmText);
						} else {
							mmText += "<span style='cursor:pointer;' title=\'"
									+ mmLMNAME
									+ "\' onclick=\"SelectCategory('" + mmID
									+ "','" + mmLMNAME + "');\">" + mmLMNAME
									+ "</span>";
							mmText += "</span>";
							myTree.add(mmID, mmPID, mmText);
						}
					}
					$("#Tree_InfoCategory").html("" + myTree);
				}
			}
		});
	}

}

function PrepareToAdd_InfoCategory() {
	ActionType = "2";
	ClearForm_InfoCategory();
	$("#ActionText_infocategory").html("添加下级栏目");
	$("#SaveButton_infocategory").unbind();
	$("#SaveButton_infocategory").bind("click", ToAdd_InfoCategory);
}

function ToAdd_InfoCategory() {
	GetInputAndCheck_InfoCategory(function(ppMessage) {
		alert(ppMessage);
	}, function(ppDataObject) {
		Add_infocategory(ppDataObject, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var message = mmData.message;
				var result = mmData.result;
				if (result == "1") {
					alert("保存成功");
					BindTree_InfoCategory(UserType, DeptId);
				} else {
					alert(message);
				}
			}
		});
	});
}

function PrepareToModify_InfoCategory() {
	ActionType = "1";
	ClearForm_InfoCategory();
	BindOldValue_InfoCategory();
	$("#ActionText_infocategory").html("修改栏目");
	$("#SaveButton_infocategory").unbind();
	$("#SaveButton_infocategory").bind("click", ToModify_InfoCategory);
}

function BindOldValue_InfoCategory() {
	FindOne_infocategory(
			CurrentCategoryId,
			function(ppData) {
				if (ppData != null) {
					var mmData = eval(ppData);
					var result = mmData.result;
					var data = mmData.resultContent;
					if (result == "1") {
						var mmCategoryId = data.categoryid;
						var mmCategoryName = data.categoryname;
						var mmPicurl = data.picurl;
						var mmScore = data.score;
						var mmAllowTougao = data.allowtougao;
						var mmIsvalid = data.isvalid;
						var mmBeizhu = data.beizhu;
						var mmMove = "<span style='cursor:pointer;' class='movespan' onclick=\"ToMoveUp_InfoCategory('"
								+ mmCategoryId + "');\">上移</span>";
						mmMove += "<span style='color:#999;'>|</span>";
						mmMove += "<span style='cursor:pointer;' class='movespan' onclick=\"ToMoveDown_InfoCategory('"
								+ mmCategoryId + "');\">下移</span>";
						$("#categoryname_infocategory").val(mmCategoryName);
						$("#imageurl2").val(mmPicurl);
						$("#score_infocategory").val(mmScore);
						$("#beizhu_infocategory").val(mmBeizhu);
						$("#move_infocategory").html(mmMove);
						if (mmIsvalid == "1") {
							$("#isvalid_infocategory").prop({
								checked : true
							});
						} else {
							$("#isvalid_infocategory").prop({
								checked : false
							});
						}
						if (mmAllowTougao == "1") {
							$("#allowtougao_infocategory").prop({
								checked : true
							});
						} else {
							$("#allowtougao_infocategory").prop({
								checked : false
							});
						}
					}
				}
			});
}

function ToModify_InfoCategory() {
	GetInputAndCheck_InfoCategory(function(ppMessage) {
		alert(ppMessage);
	}, function(ppDataObject) {
		Modify_infocategory(ppDataObject, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var message = mmData.message;
				var result = mmData.result;
				if (result == "1") {
					alert("保存成功");
					BindTree_InfoCategory(UserType, DeptId);
				} else {
					alert(message);
				}
			}
		});
	});
}

function ToDelete_InfoCategory(ppCategoryId) {
	if (confirm("确定要删除吗？")) {
		Delete_infocategory(ppCategoryId, function(ppData) {
			if (ppData != null) {
				var mmData = eval(ppData);
				var message = mmData.message;
				var result = mmData.result;
				if (result == "1") {
					alert("删除成功");
					SelectCurrentOfActionType('2');
					BindTree_InfoCategory(UserType, UserId);
				} else {
					SelectCurrentOfActionType('1');
					alert(message);
				}
			}
		});
	} else {
		SelectCurrentOfActionType('1');
	}
}

function ToMoveUp_InfoCategory(ppCategoryId) {
	MoveUp_infocategory(ppCategoryId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {
				BindTree_InfoCategory(UserType, DeptId);
			} else {
				alert(message);
			}
		}
	});
}

function ToMoveDown_InfoCategory(ppCategoryId) {
	MoveDown_infocategory(ppCategoryId, function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {
				BindTree_InfoCategory(UserType, DeptId);
			} else {
				alert(message);
			}
		}
	});
}

function GetInputAndCheck_InfoCategory(ppErrorCallback, ppSuccessCallback) {
	var mmDataObject = new Object();
	var mmCategoryId = CurrentCategoryId;
	var mmCategoryName = $("#categoryname_infocategory").val();
	var mmPicurl = $("#imageurl2").val();
	var mmScore = $("#score_infocategory").val();
	var mmAllowTougao = $("#allowtougao_infocategory").is(":checked") ? "1"
			: "0";
	var mmIsValid = $("#isvalid_infocategory").is(":checked") ? "1" : "0";
	var mmBeizhu = $("#beizhu_infocategory").val();
	if (mmCategoryName == "") {
		ppErrorCallback("请填写栏目名称");
		$("#categoryname_infocategory").focus();
		return false;
	}
	if (mmScore == "") {
		ppErrorCallback("请设置栏目分值");
		$("#score_infocategory").focus();
		return false;
	}
	mmScore = parseFloat(mmScore);
	// 判断是否含有中文
	if (isNaN(mmScore)) {
		ppErrorCallback("请将分值设为数字");
		$("#score_infocategory").focus();
		return false;
	} else {
		mmDataObject.categoryid = mmCategoryId;
		mmDataObject.categoryname = mmCategoryName;
		mmDataObject.picurl = mmPicurl;
		mmDataObject.score = mmScore;
		mmDataObject.allowtougao = mmAllowTougao;
		mmDataObject.isvalid = mmIsValid;
		mmDataObject.beizhu = mmBeizhu;
		ppSuccessCallback(mmDataObject);
	}
}

function ClearForm_InfoCategory() {
	$("#categoryname_infocategory").val("");
	$("#imageurl2").val("");
	$("#filelist2").html("");
	$("#score_infocategory").val("1");
	$("#allowtougao_infocategory").prop({
		checked : false
	});
	$("#isvalid_infocategory").prop({
		checked : true
	});
	$("#beizhu_infocategory").val("");
}

function CheckDeptInfoCategory() {
	CheckDeptInfoCategory_InfoCategory(function(ppData) {
		if (ppData != null) {
			var mmData = eval(ppData);
			var message = mmData.message;
			var result = mmData.result;
			if (result == "1") {
				alert("检查完成");
				BindTree_InfoCategory(UserType, UserId);
			} else {
				alert(message);
			}
		}
	});
}

function BindCategoryByParentId_InfoCategory(ppCategoryId) {
	FindByParentId_InfoCategory(
			ppCategoryId,
			function(ppData) {
				if (ppData != null) {
					var mmData = eval(ppData);
					var message = mmData.message;
					var result = mmData.result;
					var data = mmData.resultContent;
					if (result == '1') {
						var mmHtml = "<ul>";

						if (data.length == 0) {
							mmHtml += "<li><a id='parentcategoryname' href='../homepage/infolist?categoryid="
									+ ppCategoryId
									+ "'>"
									+ CurrentCategoryName
									+ "</a></li>";
							To_Bind_InfoList(ppCategoryId);
						}else{
							To_Bind_InfoList(data[0].categoryid);
							GetCategoryName_InfoList(data[0].categoryid);
						}

						for (var i = 0; i < data.length; i++) {
							var mmCategoryId = data[i].categoryid;
							var mmCategoryName = data[i].categoryname;
							mmHtml += "<li><a style='cursor:pointer;' id='parentcategoryname' onclick=\"To_Bind_InfoList('"
									+ mmCategoryId
									+ "');GetCategoryName_InfoList('"+mmCategoryId+"');\">"
									+ mmCategoryName
									+ "</a></li>";
						}
						mmHtml += "</ul>";
						$(".secondary-navlist").html(mmHtml);
					}
				}
			});
}
