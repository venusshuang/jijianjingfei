function SetCurrentCategoryBackground() {
	$(".dTreeNode").css("background-color", "");
	$("#" + CurrentCategoryId).parents(".dTreeNode").css("background-color",
			"#FF2");
}

function SelectCurrentOfActionType(ppType) {
	ActionType = ppType;
	SelectCategory(CurrentCategoryId, CurrentCategoryName);
}

function SelectCategory(ppID, ppCategoryName) {
	CurrentCategoryId = ppID;
	CurrentCategoryName = ppCategoryName;
	$("#CategoryName")
			.html(
					"<span class='Subject'>"
							+ ppCategoryName
							+ "</span>"
							+ " <span style='margin-left:25px;display:none;'><input type='text' class='form-control' style='color:#777;width:350px;font-size:16px; padding-left:10px;font-family:微软雅黑;' value='"
							+ ppID + "' /></span>");
	//BindList_InfoCategoryDept();
	SetCurrentCategoryBackground();
	ShowOrHideMenu(true);
	ShowOrHideInfoCategoryEditPart(false);
	ShowOrHideInfoListPart(false);
	ShowOrHideInfoEditPart(false);
	ShowOrHideDeptListPart(false);
	
	if (ActionType == "1") {
		if (ppID != "0") {
			$("#movediv_infocategory").show();
		} else {
			$("#movediv_infocategory").hide();
		}
		$("#isvaliddiv_infocategory").show();
		ShowOrHideInfoCategoryEditPart(true);
		PrepareToModify_InfoCategory();
	} else if (ActionType == "2") {
		$("#movediv_infocategory").hide();
		$("#isvaliddiv_infocategory").hide();
		ShowOrHideInfoCategoryEditPart(true);
		PrepareToAdd_InfoCategory();
	} else if (ActionType == "3") {
		ToDelete_InfoCategory(CurrentCategoryId);
	} else if (ActionType == "4") {
		ShowOrHideInfoListPart(true);
		BindList_Info();
	} else if (ActionType == "5") {
		PrepareToAdd_Info();
	} else if (ActionType == "6") {
		ShowOrHideDeptListPart(true);
		BindDeptTree_InfoCategoryDept();
		BindList_InfoCategoryDept();
	}
}

function ShowOrHideMenu(ppIsShow) {
	if (ppIsShow) {
		$("#Menu").show();
	} else {
		$("#Menu").hide();
	}
}

function ShowOrHideInfoCategoryEditPart(ppIsShow) {
	if (ppIsShow) {
		$("#EditPart_InfoCategory").show();
	} else {
		$("#EditPart_InfoCategory").hide();
	}
}

function ShowOrHideInfoListPart(ppIsShow) {
	if (ppIsShow) {
		$("#ListPart_info").show();
	} else {
		$("#ListPart_info").hide();
	}
}

function ShowOrHideDeptListPart(ppIsShow) {
	if (ppIsShow) {
		$("#ListPart_dept").show();
	} else {
		$("#ListPart_dept").hide();
	}
}

function ShowOrHideInfoEditPart(ppIsShow) {
	if (ppIsShow) {
		$("#EditPart_Info").show();
	} else {
		$("#EditPart_Info").hide();
	}
}

function ViewImage() {
	var mmIMG_PATH = $("#imageurl").val();
	if (mmIMG_PATH !== "") {
		window.open(mmIMG_PATH);
	}
}

function ViewImage2() {
	var mmIMG_PATH = $("#imageurl2").val();
	if (mmIMG_PATH !== "") {
		window.open(mmIMG_PATH);
	}
}