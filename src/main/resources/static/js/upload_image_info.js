function $$(id) {
	return document.getElementById(id);	
}

var uploader_info = new plupload.Uploader({
	multi_selection : false,
	runtimes : 'gears,html5,html4,flash,silverlight,browserplus',
	browse_button : 'pickfiles',
	container: 'container',
	max_file_size : '500kb',
	url : '../upload/UploadImage',
	//resize : {width : 320, height : 240, quality : 90},
	flash_swf_url : '../js/plupload/plupload.flash.swf',
	silverlight_xap_url : '../js/plupload/plupload.silverlight.xap',
	filters : [
		{title : "Image files", extensions : "jpg,gif,png,bmp,jpeg"}
	]
});

function InitUpLoader_Info()
{
	uploader_info.bind('Init', function(up, params) {
		$$('filelist').innerHTML = "";
	});
	
	uploader_info.init();

	uploader_info.bind('FilesAdded', function(up, files) {

		for ( var i in files) {
			$$('filelist').innerHTML = '<span id="' + files[i].id + '">'
					+ files[i].name + ' (' + plupload.formatSize(files[i].size)
					+ ') <b></b></span>';
			$("#fujianmingcheng").val(files[i].name);
		}
		uploader_info.start();
	});

	uploader_info.bind('UploadProgress', function(up, file) {
		$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader_info.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;
	    console.log(mmFileUrl);
	   
	    $("#imageurl").val(mmFileUrl);

	    file.value = unescape(mmFileUrl);
	});
	uploader_info.bind('Error', function(up, err) {
	    //alert("Error #" + err.code + ": " + err.message);
	});

//	$("#uploadfiles").bind("onclick",function() {
//		uploader_info.start();
//		return false;
//	});	
}

/*function DestroyUploader(){
	uploader_info.destroy();
}*/

