var infocategory_url = "../infocategory/";
// 获取子栏目
function FindByParentId_InfoCategory(ppParentCategoryId, ppCallBack) {
	$.post(infocategory_url + "find_by_parentcategoryid", {
		parentcategoryid : ppParentCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 获取所有栏目
function FindAll_infocategory(ppCallBack) {
	$.post(infocategory_url + "find_all", {
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 获取有效栏目
function FindValid_infocategory(ppCallBack) {
	$.post(infocategory_url + "find_valid", {
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 根据单位ID获取栏目
function FindAllByDeptId_infocategory(ppDeptId, ppCallBack) {
	$.post(infocategory_url + "find_all_by_deptid", {
		deptid : ppDeptId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 获取单个栏目
function FindOne_infocategory(ppCategoryId, ppCallBack) {
	$.post(infocategory_url + "find_one", {
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 添加
function Add_infocategory(ppDataObject, ppCallBack) {
	$.post(infocategory_url + "add", {
		parentcategoryid : ppDataObject.categoryid,
		categoryname : ppDataObject.categoryname,
		picurl : ppDataObject.picurl,
		score : ppDataObject.score,
		allowtougao : ppDataObject.allowtougao,
		isvalid : ppDataObject.isvalid,
		beizhu:ppDataObject.beizhu,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 修改
function Modify_infocategory(ppDataObject, ppCallBack) {
	$.post(infocategory_url + "modify", {
		categoryid : ppDataObject.categoryid,
		categoryname : ppDataObject.categoryname,
		picurl : ppDataObject.picurl,
		score : ppDataObject.score,
		allowtougao : ppDataObject.allowtougao,
		isvalid : ppDataObject.isvalid,
		beizhu:ppDataObject.beizhu,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 刪除
function Delete_infocategory(ppCategoryId, ppCallBack) {
	$.post(infocategory_url + "delete", {
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 上移
function MoveUp_infocategory(ppCategoryId, ppCallBack) {
	$.post(infocategory_url + "move_up", {
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 下移
function MoveDown_infocategory(ppCategoryId, ppCallBack) {
	$.post(infocategory_url + "move_down", {
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}