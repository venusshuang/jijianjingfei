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

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("import_paichugaoxiao")
public class ImportXiangmuController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Value("${userfilepath}")
	private String userfilepath;


	// 解析上传的EXCEL文件
	@SuppressWarnings("resource")
	@RequestMapping("get_value")
	public JsonResult<?> get_value(
			@RequestParam("fileurl") String mmFileUrl,
			@RequestParam("piciid") String ppPiciId,
			HttpServletRequest request
	){
		try {
			//取出文档存放的根目录，并去除文件最后的斜杠
			if(userfilepath.endsWith("/")){
				userfilepath  = userfilepath.substring(0, userfilepath.length()-1);
			}

			String url = userfilepath+mmFileUrl;
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
			int column= sheet.getRow(0).getPhysicalNumberOfCells();
			int rows = sheet.getPhysicalNumberOfRows();

			List<Map<String,Object>> mmReturnList = new ArrayList<Map<String,Object>>();

			for (int i = 1; i < rows ; i++) { //行
				Map<String,Object> mmMap = new HashMap<String,Object>();
				mmMap.put("序号", getCellFormatValue(sheet.getRow(i).getCell(0)));
				mmMap.put("中文名称", getCellFormatValue(sheet.getRow(i).getCell(1)));
				mmMap.put("英文名称", getCellFormatValue(sheet.getRow(i).getCell(2)));
				mmMap.put("国家", getCellFormatValue(sheet.getRow(i).getCell(3)));
				mmMap.put("批次", ppPiciId);
				mmReturnList.add(mmMap);
			}
			in.close();
			return JsonResult.getSuccessResult(mmReturnList);
		} catch (Exception e) {
			logger.error("ImportPaichuGaoxiaoController -> get_value: "+e.getMessage());
			return JsonResult.getErrorResult("获取派出项目上传文件中的数据失败！");
		}
	}

	// 导入高校名单
	@RequestMapping("import")
	public JsonResult<?> importvalue(
			@RequestParam("piciid") String ppPiciId,
			@RequestParam("zhongwenming") String ppZhongwenming,
			@RequestParam("yinwenming") String ppYinwenming,
			@RequestParam("guojiamingcheng") String ppGuojiamingcheng,
			HttpServletRequest request
	){
		try {

			/*// 判断导入的高校国家是否与字典表匹配
			Map<String, Object> mmMap = dd引进项目世界前100高校Service.findByGuojiamingcheng(ppGuojiamingcheng);
			if(mmMap==null) {
				return JsonResult.getErrorResult("国家"+ppGuojiamingcheng+"不存在！请检查修改后重新导入该数据！");
			}else {

				boolean mmGuojijiaoliuxuexiaoResult = dd国际交流学校Service.findByPiciIdAndZhongwenming(ppPiciId, ppZhongwenming);

				// 判断是否重复导入高校
				if(!mmGuojijiaoliuxuexiaoResult) {
					return JsonResult.getErrorResult("同批次已存在高校"+ppZhongwenming+"，跳过导入！");
				}
				String mmGuojiaID = mmMap.get("国家ID")==null?"":mmMap.get("国家ID").toString();

				// 添加国际交流学校
				国际交流学校 mm国际交流学校 = new 国际交流学校();
				mm国际交流学校.set学校id(UUID.randomUUID().toString());
				mm国际交流学校.set学校名称(ppZhongwenming);
				mm国际交流学校.set学校名称英文(ppYinwenming);
				mm国际交流学校.set批次id(ppPiciId);
				mm国际交流学校.set排序号(null);
				mm国际交流学校.set国家id(mmGuojiaID);

				if(!dd国际交流学校Service.add(mm国际交流学校)) {
					return JsonResult.getErrorResult("导入错误！");
				}
				return JsonResult.getSuccessResult("导入成功！");
			}*/
			return JsonResult.getSuccessResult("导入成功！");
		} catch (Exception e) {
			logger.error("ImportPaichuGaoxiaoController -> importvalue: "+e.getMessage());
			return JsonResult.getErrorResult("导入派出项目高校名单失败！");
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
}
