package jjjf.common.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest;


@Controller
@RequestMapping("upload")
public class UploadController {
	@Value("${uploadimage_url}")
	String UPLOADIMAGE_URL;
	
	@Value("${userfilepath}")
	String USERFILEPATH;
	
	@RequestMapping("UploadFile")
	public ResponseEntity<?> UploadImage(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			//MultipartHttpServletRequest  mmRequest = (MultipartHttpServletRequest) request;
			//取出文件信息
			//org.springframework.web.multipart.support.DefaultMultipartHttpServletRequest mmRequest = (DefaultMultipartHttpServletRequest) request;
			
			MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			MultipartHttpServletRequest mmRequest = resolver.resolveMultipart(request);
			
			Iterator<String> mm = mmRequest.getFileNames();
			String mmKeyString = mm.next();

			MultipartFile mmFile = mmRequest.getFile(mmKeyString);

			SimpleDateFormat mmDateFormat = new SimpleDateFormat("yyyyMMdd");
			String SaveFolder = "/importexecl/" +mmDateFormat.format(new Date()) + "/";
			String FullUrl = USERFILEPATH + "/importexecl/"+ mmDateFormat.format(new Date()) + "/";
			//String FullUrl = SaveFolder;
			ServletContext mmContext = request.getServletContext();
			String FileUrl = mmContext.getContextPath() + SaveFolder;
			
			String templatepath = ResourceUtils.getURL("classpath:static").getPath();
			String userfilepath = USERFILEPATH;
			
			String mmRootPath = mmContext.getRealPath("/");
			
			//String mmSavePath = mmRootPath + SaveFolder;
			
			//String mmSavePath = templatepath + SaveFolder;
			
			String mmSavePath = userfilepath + SaveFolder;

			File mmFold = new File(mmSavePath);
			if (!mmFold.isDirectory() || !mmFold.exists()) {
				mmFold.mkdirs();
			}
			String mmExt = mmFile.getOriginalFilename().substring(
					mmFile.getOriginalFilename().lastIndexOf("."));
			String mmSaveName = UUID.randomUUID().toString() + mmExt;

			FullUrl += mmSaveName;

			String mmFilePath = mmSavePath + mmSaveName;
			
			SaveFileFromInputStream(mmFile.getInputStream(), mmFilePath);
			return new ResponseEntity<String>(FullUrl, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}

	}

	public static void SaveFileFromInputStream(InputStream stream, String path)
			throws IOException {
		FileOutputStream fs = new FileOutputStream(path);
		byte[] buffer = new byte[1024 * 1024];
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {

			fs.write(buffer, 0, byteread);
			fs.flush();
		}
		fs.close();
		stream.close();
	}
}
