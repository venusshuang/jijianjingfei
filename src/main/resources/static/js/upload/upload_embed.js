var UploadVue = new Vue({
	el : "#upload",
	data : {
	},
	methods : {
		Init : function(ppExtensions,ppFileSize,successcallback,cancelcallback){
			uploader.settings.filters = [
				{title : "Image files", extensions : ppExtensions}
				];
			//uploader.settings.max_file_size = ppFileSize;
			
			$("#ConfirmUploadButton").unbind();
			$("#ConfirmUploadButton").bind("click",function(){
				var jsonArray = [];
				$(".upload_file").each(function(){
					if($(this).val() != ""){
						var FileValue = $(this).val().split(",");
						var json = {
							'filename':FileValue[0],
							'filesize':FileValue[1],
							'fileurl':FileValue[2]
						}
						jsonArray.push(json);
					}
				});
				successcallback(jsonArray);
			});
			$("#CancelButton").unbind();
			$("#CancelButton").bind("click",function(){
				cancelcallback();
			});
		}
	} 
})