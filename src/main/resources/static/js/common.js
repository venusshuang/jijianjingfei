function BindDateToday(){
		var NowTime = new Date();
		var NowYear = NowTime.getFullYear();
		var NowMonth = NowTime.getMonth()+1;
		var NowDay = NowTime.getDate();
		if(NowMonth < 10){
			NowMonth = "0"+NowMonth;
		}
		if(NowDay < 10){
			NowDay = "0"+NowDay;
		}
		
		$("#shengxiaoshijian").val(NowYear+"-"+NowMonth+"-"+NowDay);
		$("#shengxiaoshijian_gongrencai").val(NowYear+"-"+NowMonth+"-"+NowDay);
		$("#shengxiaoshijian_qiurencai").val(NowYear+"-"+NowMonth+"-"+NowDay);
	}
	
	function BindDateAddTime(Day,Year){
		var NowTime = new Date();
		
		NowTime.setDate(NowTime.getDate()+parseInt(Day));
		var NowYear = NowTime.getFullYear();
		var NowMonth = NowTime.getMonth()+1;
		var NowDay = NowTime.getDate();
		NowYear = NowYear + parseInt(Year);
		if(NowMonth < 10){
			NowMonth = "0"+NowMonth;
		}
		if(NowDay < 10){
			NowDay = "0"+NowDay;
		}
		$("#shixiaoshijian").val(NowYear+"-"+NowMonth+"-"+NowDay);
		$("#shixiaoshijian_gongrencai").val(NowYear+"-"+NowMonth+"-"+NowDay);
		$("#shixiaoshijian_qiurencai").val(NowYear+"-"+NowMonth+"-"+NowDay);
	}

function HideWindow(ppTargetID) {
	$("#" + ppTargetID).hide();
}

function ShowWindow(ppTargetID) {
	SetCenter0(ppTargetID, false);

	window.onresize = function() {
		SetCenter0(ppTargetID, false);
	};
}

function SetCenter0(ppTargetID, ppMoveCenterUp) {
	$(document).css("position", "relative");

	var mmDocWidth = $(window).width();
	var mmDocHeight = $(window).height();
	var mmTargetWidth = $("#" + ppTargetID).width();
	var mmTargetHeight = $("#" + ppTargetID).height();

	var mmScrollLeft = $(document).scrollLeft();
	var mmScrollTop = $(document).scrollTop();
	var mmLeft = (mmDocWidth - mmTargetWidth) / 2 + mmScrollLeft;
	var mmTop = (mmDocHeight - mmTargetHeight) / 2 + mmScrollTop;

	if (ppMoveCenterUp) {
		mmTop = mmTop / 2;
	}

	$("#" + ppTargetID).show();
	$("#" + ppTargetID).css("position", "absolute");
	$("#" + ppTargetID).css("left", mmLeft + "px");
	$("#" + ppTargetID).css("top", mmTop + "px");
}

function BindSelectControlOfDict(ppUrl, ppControlID, ppCallback) {
	$.post(ppUrl, {
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl(ppControlID, resultContent, ppCallback);
		}

	}, "json");
}

function BindSelectControlOfDict_shenhe(ppUrl, ppControlID, ppCallback) {
	$.post(ppUrl, {
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl_shenhe(ppControlID, resultContent, ppCallback);
		}

	}, "json");
}

function BindSelectControlOfDictByShenfenId(ppUrl, ppShenfenId, ppControlID,
		ppCallback) {
	$.post(ppUrl, {
		shenfenid : ppShenfenId,
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl(ppControlID, resultContent, ppCallback);
		}

	}, "json");

}

function BindSelectControlOfDictByParentID(ppUrl, ppParentID, ppControlID,
		ppCallback) {
	$.post(ppUrl, {
		parentid : ppParentID,
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl(ppControlID, resultContent, ppCallback);
		}

	}, "json");

}

function BindSelectControlOfDictByYijixuekeId(ppUrl, ppParentID, ppControlID,
		ppCallback) {
	$.post(ppUrl, {
		pid : ppParentID,
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl(ppControlID, resultContent, ppCallback);
		}

	}, "json");

}

function BindSelectControlOfDictByJijinmingchengId(ppUrl,ppJijinmingchengId,ppControlID,ppCallback){
	$.post(ppUrl, {
		jijinmingcheng : ppJijinmingchengId,
		random : new Date().getTime()
	}, function(ppData) {

		var mmData = eval(ppData);
		var result = mmData.result;
		var message = mmData.message;
		var resultContent = mmData.resultContent;

		if (result == 1) {
			BindSelectControl(ppControlID, resultContent, ppCallback);
		}

	}, "json");
}


function BindSelectControl(ppControlID, ppJsonData, ppCallback) {
	var mmHtml = "<option value=''>--请选择--</option>";
	for ( var i = 0; i < ppJsonData.length; i++) {
		var mmValue = unescape(ppJsonData[i].id);
		var mmText = unescape(ppJsonData[i].text);

		mmHtml += "<option value='" + mmValue + "'>" + mmText + "</option>";
	}

	var mmControl = $("#" + ppControlID);
	mmControl.append(mmHtml);

	ppCallback != undefined && ppCallback != null && ppCallback();
}

function BindSelectControl_shenhe(ppControlID, ppJsonData, ppCallback) {
	var mmHtml = "<option value=''>所有</option>";
	for ( var i = 0; i < ppJsonData.length; i++) {
		var mmValue = unescape(ppJsonData[i].id);
		var mmText = unescape(ppJsonData[i].text);

		mmHtml += "<option value='" + mmValue + "'>" + mmText + "</option>";
	}

	var mmControl = $("#" + ppControlID);
	mmControl.append(mmHtml);

	ppCallback != undefined && ppCallback != null && ppCallback();
}

function HighlightRow(RowId) {
	if (RowId != "") {
		$("#" + RowId).addClass("success");
	}
}
function ChangeInputBackgroundColor(ppInput) {
	ppInput.focus(function() {
		$(this).css("background-color", "#BFEEEE");
	});
	ppInput.blur(function() {
		$(this).css("background-color", "white");
	});
}
function HighlightHandle(ppId){
	$("#"+ppId).addClass("success").siblings().removeClass("success");
}

function DeleteFile(ppId){
	$("#"+ppId).remove();
	var mmShouJianRen = [];
	$('.shoujianren_input').each(function() {
		if($(this).val() != ''){
			mmShouJianRen.push($(this).val());
		}
	});
	if(mmShouJianRen.length > 0){
		$("#shoujianrenshu").html("共"+mmShouJianRen.length+"人");
	}else{
		$("#shoujianrenshu").html("");
	}
}

function AlertMessage(ppMessage){
	layer.alert(ppMessage);
}

function LayerAlertMessage(ppMessage){
	layer.alert(ppMessage);
}