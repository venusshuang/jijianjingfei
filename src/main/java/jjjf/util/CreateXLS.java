package jjjf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class CreateXLS {

	public static String createExcel(List dataList,String path,String filename,String sheetName,
			HttpServletRequest request,HttpServletResponse response){
		String file = path + filename;
		File dir = new File(path);
		if(!dir.exists()){
			dir.mkdirs();
		}
		File excelFile = new File(file);
		WritableWorkbook excel;
		try {
			excel = Workbook.createWorkbook(excelFile);
			WritableSheet sheet = excel.createSheet(sheetName, 0);
			for(int i = 0;i<dataList.size();i++){
				ArrayList datas = (ArrayList) dataList.get(i);
				for(int j = 0;j<datas.size();j++){
					Label label2 = new Label(j, i, (String) datas.get(j));
					sheet.addCell(label2);
				}
			}
			excel.write();
			excel.close();
			excelFile = null;
			reutrnfile(path,filename,request,response);
		} catch (Exception e) {
			return e.getMessage();
		}
		return file;
	}
	
	public static void reutrnfile(String filepath,String filename,
			HttpServletRequest request,HttpServletResponse response) throws IOException {
		ServletOutputStream out = null;
		FileInputStream ips = null;
		try {
			
			// 获取文件存放的路径
			File file = new File(filepath + filename);
			String newFileName = filename;
			if (!file.exists()) {
				// 如果文件不存在就跳出
				return;
			}
			ips = new FileInputStream(file);
			response.setContentType("multipart/form-data");
			// 为文件重新设置名字，采用数据库内存储的文件名称
			response.addHeader("Content-Disposition", "attachment; filename=\""
					+ newFileName
					+ "\"");
			out = response.getOutputStream();
			// 读取文件流
			int len = 0;
			byte[] buffer = new byte[1024 * 10];
			while ((len = ips.read(buffer)) != -1) {
				out.write(buffer, 0, len);
			}
			out.flush();
			ips.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
