package jjjf.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jjjf.model.Junjianxiangmu;
import jjjf.service.JunjianxiangmuService;
import jjjf.util.DataBaseUtil;
import jjjf.util.JsonResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("import_xiangmu")
public class ImportXiangmuController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Resource
	JunjianxiangmuService ddService;

	@Value("${userfilepath}")
	private String userfilepath;


	// 解析上传的EXCEL文件
	@SuppressWarnings("resource")
	@RequestMapping("get_value")
	public JsonResult<?> get_value(
			@RequestParam("fileurl") String mmFileUrl,
			HttpServletRequest request
	){
		try {
			//取出文档存放的根目录，并去除文件最后的斜杠
			if(userfilepath.endsWith("/")){
				userfilepath  = userfilepath.substring(0, userfilepath.length()-1);
			}

			mmFileUrl=mmFileUrl.substring(mmFileUrl.indexOf("jjjf"));
			String url = userfilepath+"/"+mmFileUrl;
			Workbook book = null;

			File f = new File(url);
			InputStream in = new FileInputStream(f);

			String prefix = url.substring(url.lastIndexOf(".")+1);
			if(prefix.equals("xls")) {
				book = new HSSFWorkbook(in);
			}else if(prefix.equals("xlsx")) {
				book = new XSSFWorkbook(in);
			}else {
				return JsonResult.getErrorResult("请上传xls或xlsx类型的文件！");
			}

			Sheet sheet = book.getSheetAt(0);
			if (sheet==null){
				return JsonResult.getErrorResult("请上传规范格式的EXCEL（确保上传数据在SHEET1中）！");
			}
			//int column= sheet.getRow(0).getPhysicalNumberOfCells();
			int rows = sheet.getPhysicalNumberOfRows();
			List<Map<String,Object>> mmReturnList = new ArrayList<Map<String,Object>>();

			for (int i = 4; i < rows ; i++) { //行
				Map<String,Object> mmMap = new HashMap<String,Object>();
				mmMap.put("序号", getCellFormatValue(sheet.getRow(i).getCell(0)));
				mmMap.put("项目名称", getCellFormatValue(sheet.getRow(i).getCell(1)));
				mmMap.put("两级批复情况", getCellFormatValue(sheet.getRow(i).getCell(2)));
				mmMap.put("联保批复金额", getCellFormatValue(sheet.getRow(i).getCell(3)));
				mmReturnList.add(mmMap);
			}
			in.close();
			return JsonResult.getSuccessResult(mmReturnList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ImportPaichuGaoxiaoController -> get_value: "+e.getMessage());
			return JsonResult.getErrorResult("获取派出项目上传文件中的数据失败！");
		}
	}

	// 导入高校名单
	@RequestMapping("import")
	public JsonResult<?> importvalue(
			@RequestParam("xiangmumingcheng") String ppXiangmuMingcheng,
			@RequestParam("pifuqingkuang") String ppPifuQingkuang,
			@RequestParam("pifujine") Double ppPifuJine,
			HttpServletRequest request
	){
		try {

			//从session里取出adminid作为creator和modifier
			String mmUserId=request.getSession().getAttribute("ADMINID").toString();

			List<Junjianxiangmu> mmList= ddService.findByXiangmuMingcheng(ppXiangmuMingcheng);
			if (mmList.size()>=1){
				return JsonResult.getErrorResult("已存在该项目："+ppXiangmuMingcheng+"，跳过导入！");
			}

			String mmXiangmuId=UUID.randomUUID().toString();

			Junjianxiangmu mmJunjianxiangmu = new Junjianxiangmu();
			mmJunjianxiangmu.setXiangmuid(mmXiangmuId);
			mmJunjianxiangmu.setCreater(mmUserId);
			mmJunjianxiangmu.setCreatetime(new Date());
			mmJunjianxiangmu.setLastupdatetime(new Date());
			mmJunjianxiangmu.setBeizhu("");
			mmJunjianxiangmu.setJieshoudanweiid("");
			mmJunjianxiangmu.setLianbaopifujine(ppPifuJine);
			mmJunjianxiangmu.setLianbaoyuliujine(0.0);
			mmJunjianxiangmu.setXiangmuleibie("");
			mmJunjianxiangmu.setModifier(mmUserId);
			mmJunjianxiangmu.setXiangmuname(ppXiangmuMingcheng);
			mmJunjianxiangmu.setXiangmupifu(ppPifuQingkuang);
			mmJunjianxiangmu.setZhongxinpifujine(0.0);
			mmJunjianxiangmu.setZhuangtai(100);

			if(!ddService.add(mmJunjianxiangmu)) {
				return JsonResult.getErrorResult("导入错误！");
			}
			return JsonResult.getSuccessResult("导入成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ImportPaichuGaoxiaoController -> importvalue: "+e.getMessage());
			return JsonResult.getErrorResult("导入项目失败！");
		}
	}

	private Object getCellFormatValue(Cell cell) {
		Object cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
				case Cell.CELL_TYPE_FORMULA: {
					// 判断当前的cell是否为Date
					if (DateUtil.isCellDateFormatted(cell)) {
						// 如果是Date类型则，转化为Data格式
						// data格式是带时分秒的：2013-7-10 0:00:00
						// cellvalue = cell.getDateCellValue().toLocaleString();
						// data格式是不带带时分秒的：2013-7-10
						Date date = cell.getDateCellValue();
						cellvalue = date;
					} else {// 如果是纯数字
						cell.setCellType(1);
						// 取得当前Cell的数值
						//cellvalue = String.valueOf(cell.getNumericCellValue());
						cellvalue=cell.getStringCellValue();
					}
					break;
				}
				case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
					// 取得当前的Cell字符串
					cellvalue = cell.getRichStringCellValue().getString();
					break;
				default:// 默认的Cell值
					cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	// 备份数据库
	@SuppressWarnings("resource")
	@RequestMapping("backup")
	public void backup(
			HttpServletRequest request
	){
		try {
			DataBaseUtil.backup();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ImportPaichuGaoxiaoController -> get_value: "+e.getMessage());
		}
	}


}
