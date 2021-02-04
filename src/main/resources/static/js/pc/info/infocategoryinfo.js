var infocategoryinfo_url = "../infocategoryinfo/";

// 删除
function Delete_infocategoryinfo(ppInfoId, ppCategoryId, ppCallBack) {
	$.post(infocategoryinfo_url + "delete", {
		infoid : ppInfoId,
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 上移
function MoveUp_infocategoryinfo(ppInfoId, ppCategoryId, ppCallBack) {
	$.post(infocategoryinfo_url + "move_down", {
		infoid : ppInfoId,
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 下移
function MoveDown_infocategoryinfo(ppInfoId, ppCategoryId, ppCallBack) {
	$.post(infocategoryinfo_url + "move_up", {
		infoid : ppInfoId,
		categoryid : ppCategoryId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}