var info_url = "../info/";

// 获取信息列表（后台管理）
function FindByCategoryIdPaging_info(ppCategoryId, ppPageIndex, ppPageSize,
		ppCallBack) {
	$.post(info_url + "find_by_categoryid_paging", {
		categoryid : ppCategoryId,
		pageindex : ppPageIndex,
		pagesize : ppPageSize,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 获取信息列表（前台网页）
function FindPassedByCategoryIdPaging_info(ppCategoryId, ppPageIndex,
		ppPageSize, ppCallBack) {
	$.post(info_url + "find_passed_by_categoryid_paging", {
		categoryid : ppCategoryId,
		pageindex : ppPageIndex,
		pagesize : ppPageSize,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 获取一条信息
function FindCustomOne_info(ppInfoId, ppCallBack) {
	$.post(info_url + "find_custom_one", {
		infoid : ppInfoId,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 添加信息
function Add_info(ppDataObject, ppCallBack) {
	$.post(info_url + "add", {
		categoryid : ppDataObject.categoryid,
		jianti:ppDataObject.jianti,
		infotitle : ppDataObject.infotitle,
		infotitle2 : ppDataObject.infotitle2,
		summary : ppDataObject.summary,
		source : ppDataObject.source,
		author : ppDataObject.author,
		infocontent : ppDataObject.infocontent,
		releasetime : ppDataObject.releasetime,
		imageurl : ppDataObject.imageurl,
		videourl : ppDataObject.videourl,
		returnurl : ppDataObject.returnurl,
		checkpass : ppDataObject.checkpass,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

// 修改信息
function Modify_info(ppDataObject, ppCallBack) {
	$.post(info_url + "modify", {
		infoid : ppDataObject.infoid,
		jianti:ppDataObject.jianti,
		infotitle : ppDataObject.infotitle,
		infotitle2 : ppDataObject.infotitle2,
		summary : ppDataObject.summary,
		source : ppDataObject.source,
		author : ppDataObject.author,
		infocontent : ppDataObject.infocontent,
		releasetime : ppDataObject.releasetime,
		imageurl : ppDataObject.imageurl,
		videourl : ppDataObject.videourl,
		returnurl : ppDataObject.returnurl,
		checkpass : ppDataObject.checkpass,
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}

function GenerateVideoName_info(ppCallBack) {
	$.post(info_url + "GenerateVideoName", {
		rdm : Math.random()
	}, function(ppData) {
		ppCallBack != undefined && ppCallBack != null && ppCallBack(ppData);
	}, "json");
}