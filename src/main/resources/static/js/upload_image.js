function $$(id) {
	return document.getElementById(id);	
}

var uploader = new plupload.Uploader({
	multi_selection : false,
	runtimes : 'gears,html5,html4,flash,silverlight,browserplus',
	browse_button : 'pickfiles',
	container: 'container',
	max_file_size : '10mb',
	url : '../upload/UploadImage',
	resize : {width : 320, height : 240, quality : 90},
	flash_swf_url : '../js/plupload/plupload.flash.swf',
	silverlight_xap_url : '../js/plupload/plupload.silverlight.xap',
	filters : [
		{title : "Image files", extensions : "*"}
	]
});

function InitUpLoader()
{
	
	uploader.bind('Init', function(up, params) {
		$$('filelist').innerHTML = "";
	});
	
	uploader.init();

	uploader.bind('FilesAdded', function(up, files) {

		for ( var i in files) {
			$$('filelist').innerHTML = '<span id="' + files[i].id + '">'
					+ files[i].name + ' (' + plupload.formatSize(files[i].size)
					+ ') <b></b></span>';
			$("#fujianmingcheng").val(files[i].name);
		}
		uploader.start();
	});

	uploader.bind('UploadProgress', function(up, file) {
		$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;

	    console.log(mmFileUrl);

	    $("#imageurl").append(mmFileUrl+";");
	    mmImageUrls += mmFileUrl+";";
	    
	    var mmHtml = "<img name='imageurl'  src='"+mmFileUrl+"' width=200 height=200 style='margin:10px;'/>";

	    $("#uploaderFiles").append(mmHtml);

	    file.value = unescape(mmFileUrl);
	});
	uploader.bind('Error', function(up, err) {
	    alert("Error #" + err.code + ": " + err.message);
	});
}

