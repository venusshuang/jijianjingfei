
function $$(id) {
	return document.getElementById(id);	
}

var uploader = new plupload.Uploader({
	multi_selection : false,
	runtimes : 'html5,html4,gears,flash,silverlight,browserplus',
	browse_button : 'pickfiles',
	container: 'container',
	max_file_size : '50mb',
	url : '',
	//resize : {width : 320, height : 240, quality : 90},
	flash_swf_url : '../js/plupload/plupload.flash.swf',
	silverlight_xap_url : '../js/plupload/plupload.silverlight.xap',
	filters : [		{title : "Image files", extensions : ""}

	]
});


function InitUpLoader()
{
	uploader.settings.url = '/upload/UploadFile?fujianpath=' + fujianpath + '&filesize=' +filesize;
	
	uploader.bind('Init', function(up, params) {
		$$('filelist').innerHTML = "";
	});
	
	uploader.init();
	
	uploader.bind('FilesAdded', function(up, files) {
		if(filetype != "batch"){
			if($(".fujian_div").length > 0){
				layer.alert("只能上传一个文件！");
				up.splice(0, 1);
				return ;
			}
		}
		uploader.start();
		/*for ( var i in files) {
			$$('filelist').innerHTML = '<span>'
					+'<a href="'+files[i].value+'" target="_blank">'+ files[i].name + ' </a><b></b></span>';
		}*/
		
	});

	uploader.bind('UploadProgress', function(up, file) {
		//$$(file.id).getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
	});

	uploader.bind('FileUploaded', function(up, file, response) {
		var mmResponse = (response.response).replace(/\\/g, "").replace(/(")/g, "");
	    var mmFileUrl = mmResponse;
	    var mmFileType = mmFileUrl.substring(mmFileUrl.lastIndexOf(".")+1).toLowerCase();
	    var mmIcon = "file";
	    if(mmFileType == "doc" || mmFileType == "docx"){
	    	mmIcon = "word";
	    }
	    if(mmFileType == "xls" || mmFileType == "xlsx"){
	    	mmIcon = "xls";
	    }
	    if(mmFileType == "ppt" || mmFileType == "pptx"){
	    	mmIcon = "ppt";
	    }
	    if(mmFileType == "txt"){
	    	mmIcon = "txt";
	    }
	    if(mmFileType == "pdf"){
	    	mmIcon = "pdf";
	    }
	    if(mmFileType == "zip" || mmFileType == "rar"){
	    	mmIcon = "zip";
	    }
	    if(mmFileType == "png" || mmFileType == "jpg" || mmFileType == "jpeg" || mmFileType == "gif" || mmFileType == "bmp"){
	    	mmIcon = "pic";
	    }
	    
	    var filesize = parseInt(file.size);
	    var mmFileSize = 0;
	    var mmBKMG = "B";
	    if(filesize > 1024){
	    	mmFileSize = (filesize/1024).toFixed(2);
	    	var mmBKMG = "K";
	    }
	    if(mmFileSize > 1024){
	    	mmFileSize = (mmFileSize/1024).toFixed(2);
	    	var mmBKMG = "M";
	    }
	    if(mmFileSize > 1024){
	    	mmFileSize = (mmFileSize/1024).toFixed(2);
	    	var mmBKMG = "G";
	    }
	    
	    $("#uploadfilelist").append("<div class='fujian_div' id=" + file.id + ">" +
	    		"<a href='"+mmFileUrl+"' target='_blank'>"+ file.name +"" +
	    		"<span style='color: #798699;'>（"+ mmFileSize +mmBKMG+"）</span></a>" +
	    	/*	"<span onclick='DeleteFile(\""+file.id+"\")'>删除</span>" +*/
	    		"<input type='hidden' class='upload_file' value='"+file.name+","+mmFileSize+mmBKMG+","+mmFileUrl+"'></div>");
	   
	    file.value = unescape(mmFileUrl);
	    up.splice(0, 1);
	});
	uploader.bind('Error', function(up, err) {
		layer.alert(err.code);
		if(err.response == "error_wenjiandaxiao"){
			layer.alert("上传文件过大！");
		}
		if(err.code == "-601"){
			layer.alert("上传文件类型错误！");
		}
	});

//	$("#uploadfiles").bind("onclick",function() {
//		uploader.start();
//		return false;
//	});	
}

