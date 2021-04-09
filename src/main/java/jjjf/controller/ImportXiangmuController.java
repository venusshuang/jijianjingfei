package jjjf.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
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

import jjjf.model.*;
import jjjf.service.*;
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
	@Resource
	JingfeiyusuanService ddJingfeiyusuanService;
	@Resource
	GongchengjinzhanService ddGongchengjinzhanService;
	@Resource
	ZijinbaozhangService ddZijinbaozhangService;
	@Resource
	JungongjiesuanService ddJungongjiesuanService;
	@Resource
	LeibieBiaoqianService ddLeibieBiaoqianService;
	@Resource
	DeptService ddDeptService;
	@Resource
	XiangmuzhuangtaiService ddXiangmuzhuangtaiService;
	@Resource
	JiesuanzhuangtaiService ddJiesuanzhuangtaiService;
	@Resource
	JiesuanqingkuangService ddJiesuanqingkuangService;

	@Value("${userfilepath}")
	private String userfilepath;
	@Value("${command}")
    private String command;




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

			mmFileUrl=mmFileUrl.substring(mmFileUrl.indexOf("importexecl"));
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

			for (int i = 1; i < rows ; i++) { //行
				Map<String,Object> mmMap = new HashMap<String,Object>();
				mmMap.put("序号", getCellFormatValue(sheet.getRow(i).getCell(0)));
				mmMap.put("项目名称", getCellFormatValue(sheet.getRow(i).getCell(1)));
				mmMap.put("两级批复情况", getCellFormatValue(sheet.getRow(i).getCell(2)));
				mmMap.put("联保批复金额", getCellFormatValue(sheet.getRow(i).getCell(3)));
				mmMap.put("中心批复金额", getCellFormatValue(sheet.getRow(i).getCell(4)));
				mmMap.put("联保预留预备费", getCellFormatValue(sheet.getRow(i).getCell(5)));

				mmMap.put("两级经费下达情况", getCellFormatValue(sheet.getRow(i).getCell(6)));
				mmMap.put("预算年度", getCellFormatValue(sheet.getRow(i).getCell(7)));
				mmMap.put("联保下达经费指标", getCellFormatValue(sheet.getRow(i).getCell(8)));
				mmMap.put("中心下达经费指标", getCellFormatValue(sheet.getRow(i).getCell(9)));
				mmMap.put("中心预留预备费", getCellFormatValue(sheet.getRow(i).getCell(10)));
				mmMap.put("中心会计账凭证号", getCellFormatValue(sheet.getRow(i).getCell(11)));
				mmMap.put("承受经费单位名称", getCellFormatValue(sheet.getRow(i).getCell(12)));
				mmMap.put("经费科目", getCellFormatValue(sheet.getRow(i).getCell(13)));

				mmMap.put("项目状态", getCellFormatValue(sheet.getRow(i).getCell(14)));
				mmMap.put("开工时间", getCellFormatValue(sheet.getRow(i).getCell(15)));
				mmMap.put("各类合同总价", getCellFormatValue(sheet.getRow(i).getCell(16)));
				mmMap.put("完成投资", getCellFormatValue(sheet.getRow(i).getCell(17)));
				mmMap.put("进度款支付", getCellFormatValue(sheet.getRow(i).getCell(18)));
				mmMap.put("进度款占总合同比例", getCellFormatValue(sheet.getRow(i).getCell(19)));
				mmMap.put("完工时间", getCellFormatValue(sheet.getRow(i).getCell(20)));

				mmMap.put("向中心申请资金", getCellFormatValue(sheet.getRow(i).getCell(21)));
				mmMap.put("申请时间", getCellFormatValue(sheet.getRow(i).getCell(22)));
				mmMap.put("向联保申请拨付金额", getCellFormatValue(sheet.getRow(i).getCell(23)));
				mmMap.put("向联保申请拨付时间", getCellFormatValue(sheet.getRow(i).getCell(24)));
				mmMap.put("联保拨付金额", getCellFormatValue(sheet.getRow(i).getCell(25)));
				mmMap.put("联保拨付时间", getCellFormatValue(sheet.getRow(i).getCell(26)));
				mmMap.put("中心资金拨付金额", getCellFormatValue(sheet.getRow(i).getCell(27)));
				mmMap.put("中心拨付时间", getCellFormatValue(sheet.getRow(i).getCell(28)));

				mmMap.put("竣工结算状态", getCellFormatValue(sheet.getRow(i).getCell(29)));
				mmMap.put("竣工结算完成时间", getCellFormatValue(sheet.getRow(i).getCell(30)));
				mmMap.put("竣工决算情况", getCellFormatValue(sheet.getRow(i).getCell(31)));
				mmMap.put("是否记账和登记", getCellFormatValue(sheet.getRow(i).getCell(32)));
				mmMap.put("两级决算批复文号", getCellFormatValue(sheet.getRow(i).getCell(33)));
				mmMap.put("决算批复金额", getCellFormatValue(sheet.getRow(i).getCell(34)));
				mmMap.put("结余上缴金额", getCellFormatValue(sheet.getRow(i).getCell(35)));

				mmMap.put("类别", getCellFormatValue(sheet.getRow(i).getCell(36)));
				mmMap.put("备注", getCellFormatValue(sheet.getRow(i).getCell(37)));

				mmReturnList.add(mmMap);
			}
			in.close();
			return JsonResult.getSuccessResult(mmReturnList);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ImportPaichuGaoxiaoController -> get_value: "+e.getMessage());
			return JsonResult.getErrorResult("获取项目经费中的数据失败！");
		}
	}


	@RequestMapping("import")
	public JsonResult<?> importvalue(
			@RequestParam("xiangmuname") String ppxiangmuname,
			@RequestParam("xiangmupifu") String ppxiangmupifu,
			@RequestParam("lianbaopifujine") Double pplianbaopifujine,
			@RequestParam("zhongxinpifujine") Double ppzhongxinpifujine,
			@RequestParam("lianbaoyuliujine") Double pplianbaoyuliujine,

			@RequestParam("jingfeixiadaqingkuang") String ppjingfeixiadaqingkuang,
			@RequestParam("yusuanniandu") String ppyusuanniandu,
			@RequestParam("lianbaojingfeizhibiao") Double pplianbaojingfeizhibiao,
			@RequestParam("zhongxinjingfeizhibiao") Double ppzhongxinjingfeizhibiao,
			@RequestParam("zhongxinyuliujine") Double ppzhongxinyuliujine,
			@RequestParam("zhongxinkuaijihao") String ppzhongxinkuaijihao,
			@RequestParam("chengshoujingfeidanwei") String ppchengshoujingfeidanwei,
			@RequestParam("jingfeikemu") String ppjingfeikemu,

			@RequestParam("xiangmuzhuangtai") String ppxiangmuzhuangtai,
			@RequestParam("kaigongshijian") String ppkaigongshijian,
			@RequestParam("hetongzongjia") Double pphetongzongjia,
			@RequestParam("wangchengtouzi") Double ppwangchengtouzi,
			@RequestParam("jindukuaizhifu") Double ppjindukuaizhifu,
			@RequestParam("jindukuanbili") String ppjindukuanbili,
			@RequestParam("wangongshijian") String ppwangongshijian,

			@RequestParam("xiangzhongxinshenqingzijin") Double ppxiangzhongxinshenqingzijin,
			@RequestParam("shenqingshijian") String ppshenqingshijian,
			@RequestParam("xianglianbaoshenqingzijin") Double ppxianglianbaoshenqingzijin,
			@RequestParam("xianglianbaoshenqingbofushijian") String ppxianglianbaoshenqingbofushijian,
			@RequestParam("lianbaobofujine") Double pplianbaobofujine,
			@RequestParam("lianbaobofushijian") String pplianbaobofushijian,
			@RequestParam("zhongxinbofujine") Double ppzhongxinbofujine,
			@RequestParam("zhongxinbofushijian") String ppzhongxinbofushijian,

			@RequestParam("jiesuanzhuangtai") String ppjiesuanzhuangtai,
			@RequestParam("jiesuanwanchengtime") String ppjiesuanwanchengtime,
			@RequestParam("jiesuanqingkuang") String ppjiesuanqingkuang,
			@RequestParam("shifoujizhang") String ppshifoujizhang,
			@RequestParam("jiesuanpifuwenhao") String ppjiesuanpifuwenhao,
			@RequestParam("jiesuanpifujine") Double ppjiesuanpifujine,
			@RequestParam("jieyushangjiaojine") Double ppjieyushangjiaojine,

			@RequestParam("xiangmuleibie") String ppxiangmuleibie,
			@RequestParam("beizhu") String ppbeizhu,
			HttpServletRequest request
	){
		try {
			SimpleDateFormat simdate=new SimpleDateFormat("yyyy-MM");
			//从session里取出adminid作为creator和modifier
			String mmUserId=request.getSession().getAttribute("ADMINID").toString();

			List<Junjianxiangmu> mmList= ddService.findByXiangmuMingcheng(ppxiangmuname);
			if (mmList.size()>=1){
				return JsonResult.getErrorResult("已存在该项目："+ppxiangmuname+"，跳过导入！");
			}

			String mmXiangmuId=UUID.randomUUID().toString();

			Junjianxiangmu mmJunjianxiangmu = new Junjianxiangmu();
			mmJunjianxiangmu.setXiangmuid(mmXiangmuId);
			mmJunjianxiangmu.setXiangmuname(ppxiangmuname);
			mmJunjianxiangmu.setXiangmupifu(ppxiangmupifu);
			mmJunjianxiangmu.setLianbaopifujine(pplianbaopifujine);
			mmJunjianxiangmu.setZhongxinpifujine(ppzhongxinpifujine);
			mmJunjianxiangmu.setLianbaoyuliujine(pplianbaoyuliujine);
			List<DictLeibiebiaoqian> mmLeibieBiaoqianList = ddLeibieBiaoqianService.findAll(ppxiangmuleibie);
			if(mmLeibieBiaoqianList.size()>0)
			{
				mmJunjianxiangmu.setXiangmuleibie(mmLeibieBiaoqianList.get(0).getId());
			}
			List<Dept> mmDeptList=ddDeptService.findAll(ppchengshoujingfeidanwei);
			if(mmDeptList.size()>0){
				mmJunjianxiangmu.setJieshoudanweiid(mmDeptList.get(0).getDeptname());
			}
			mmJunjianxiangmu.setBeizhu(ppbeizhu);
			mmJunjianxiangmu.setCreater("1");
			mmJunjianxiangmu.setCreatetime(new Date());
			mmJunjianxiangmu.setModifier("1");
			mmJunjianxiangmu.setLastupdatetime(new Date());
			mmJunjianxiangmu.setZhuangtai(100);

			Jingfeiyusuan mmJingfeiyusuan=new Jingfeiyusuan();
			mmJingfeiyusuan.setJingfeiyuansuanid(UUID.randomUUID().toString());
			mmJingfeiyusuan.setXiangmuid(mmXiangmuId);
			mmJingfeiyusuan.setJingfeixiadaqingkuang(ppjingfeixiadaqingkuang);
			mmJingfeiyusuan.setYusuanniandu(ppyusuanniandu);
			mmJingfeiyusuan.setLianbaojingfeizhibiao(pplianbaojingfeizhibiao);
			mmJingfeiyusuan.setZhongxinjingfeizhibiao(ppzhongxinjingfeizhibiao);
			mmJingfeiyusuan.setZhongxinyuliujine(ppzhongxinyuliujine);
			mmJingfeiyusuan.setZhongxinkuaijihao(ppzhongxinkuaijihao);
			mmJingfeiyusuan.setChengshoujingfeidanwei(ppchengshoujingfeidanwei);
			mmJingfeiyusuan.setJingfeikemu(ppjingfeikemu);
			mmJingfeiyusuan.setCreater("1");
			mmJingfeiyusuan.setCreatetime(new Date());
			mmJingfeiyusuan.setModifier("1");
			mmJingfeiyusuan.setLastupdatetime(new Date());
			mmJingfeiyusuan.setZhuangtai(100);

			Gongchengjinzhan mmGongchengjinzhan=new Gongchengjinzhan();
			mmGongchengjinzhan.setGongchengjinzhanid(UUID.randomUUID().toString());
			mmGongchengjinzhan.setXiangmuid(mmXiangmuId);
			List<DictXiangmuzhuangtai> mmXiangmuzhuangtaiList=ddXiangmuzhuangtaiService.findAll(ppxiangmuzhuangtai);
			if(mmXiangmuzhuangtaiList.size()>0){
				mmGongchengjinzhan.setXiangmuzhuangtaiid(mmXiangmuzhuangtaiList.get(0).getId());
			}
			if(!ppkaigongshijian.equals("")){
				Date mmkaigongshijian=simdate.parse(ppkaigongshijian);
				mmGongchengjinzhan.setKaigongshijian(mmkaigongshijian);
			}
			mmGongchengjinzhan.setHetongzongjia(pphetongzongjia);
			mmGongchengjinzhan.setWangchengtouzi(ppwangchengtouzi);
			mmGongchengjinzhan.setJindukuaizhifu(ppjindukuaizhifu);
			mmGongchengjinzhan.setJindukuanbili(ppjindukuanbili);
			if(!ppwangongshijian.equals("")){
				Date mmwangongshijian=simdate.parse(ppwangongshijian);
				mmGongchengjinzhan.setWangongshijian(mmwangongshijian);
			}
			mmGongchengjinzhan.setCreater("1");
			mmGongchengjinzhan.setCreatetime(new Date());
			mmGongchengjinzhan.setModifier("1");
			mmGongchengjinzhan.setLastupdatetime(new Date());
			mmGongchengjinzhan.setZhuangtai(100);

			Zijinbaozhang mmZijinbaozhang=new Zijinbaozhang();
			mmZijinbaozhang.setZijinbaozhangid(UUID.randomUUID().toString());
			mmZijinbaozhang.setXiangmuid(mmXiangmuId);
			mmZijinbaozhang.setXiangzhongxinshenqingzijin(ppxiangzhongxinshenqingzijin);
			if(!ppshenqingshijian.equals("")){
				Date mmshenqingshijian=simdate.parse(ppshenqingshijian);
				mmZijinbaozhang.setShenqingshijian(mmshenqingshijian);
			}
			mmZijinbaozhang.setXianglianbaoshenqingzijin(ppxianglianbaoshenqingzijin);
			if(!ppxianglianbaoshenqingbofushijian.equals("")){
				Date mmxianglianbaoshenqingbofushijian=simdate.parse(ppxianglianbaoshenqingbofushijian);
				mmZijinbaozhang.setXianglianbaoshenqingbofushijian(mmxianglianbaoshenqingbofushijian);
			}
			mmZijinbaozhang.setLianbaobofujine(pplianbaobofujine);
			if(!pplianbaobofushijian.equals("")){
				Date mmlianbaobofushijian=simdate.parse(pplianbaobofushijian);
				mmZijinbaozhang.setLianbaobofushijian(mmlianbaobofushijian);
			}
			mmZijinbaozhang.setZhongxinbofujine(ppzhongxinbofujine);
			if(!ppzhongxinbofushijian.equals("")){
				Date mmzhongxinbofushijian=simdate.parse(ppzhongxinbofushijian);
				mmZijinbaozhang.setZhongxinbofushijian(mmzhongxinbofushijian);
			}
			mmZijinbaozhang.setCreater("1");
			mmZijinbaozhang.setCreatetime(new Date());
			mmZijinbaozhang.setModifier("1");
			mmZijinbaozhang.setLastupdatetime(new Date());
			mmZijinbaozhang.setZhuangtai(100);

			Jungongjiesuan mmJungongjiesuan=new Jungongjiesuan();
			mmJungongjiesuan.setJungongjiesuanid(UUID.randomUUID().toString());
			mmJungongjiesuan.setXiangmuid(mmXiangmuId);
			List<DictJiesuanzhuangtai> mmJiesuanzhuangtaiList=ddJiesuanzhuangtaiService.findAll(ppjiesuanzhuangtai);
			if(mmJiesuanzhuangtaiList.size()>0){
				mmJungongjiesuan.setJiesuanzhuangtaiid(mmJiesuanzhuangtaiList.get(0).getId());
			}
			if(!ppjiesuanwanchengtime.equals("")){
				Date mmjiesuanwanchengtime=simdate.parse(ppjiesuanwanchengtime);
				mmJungongjiesuan.setJiesuanwanchengtime(mmjiesuanwanchengtime);
			}
			List<DictJiesuanqingkuang> mmJiesuanqingkuangList=ddJiesuanqingkuangService.findAll(ppjiesuanqingkuang);
			if(mmJiesuanqingkuangList.size()>0){
				mmJungongjiesuan.setJiesuanqingkuangid(mmJiesuanqingkuangList.get(0).getId());
			}
			if(ppshifoujizhang.equals("是")){
				mmJungongjiesuan.setShifoujizhang(1);
			}else{
				mmJungongjiesuan.setShifoujizhang(0);
			}
			mmJungongjiesuan.setJiesuanpifuwenhao(ppjiesuanpifuwenhao);
			mmJungongjiesuan.setJiesuanpifujine(ppjiesuanpifujine);
			mmJungongjiesuan.setJieyushangjiaojine(ppjieyushangjiaojine);
			mmJungongjiesuan.setCreator("1");
			mmJungongjiesuan.setCreatetime(new Date());
			mmJungongjiesuan.setModifier("1");
			mmJungongjiesuan.setLastupdatetime(new Date());
			mmJungongjiesuan.setZhuangtai(100);


			if(!ddService.add(mmJunjianxiangmu)) {
				return JsonResult.getErrorResult("导入军建下达错误！");
			}
			if(!ddJingfeiyusuanService.add(mmJingfeiyusuan)) {
				return JsonResult.getErrorResult("导入经费预算错误！");
			}
			if(!ddGongchengjinzhanService.add(mmGongchengjinzhan)) {
				return JsonResult.getErrorResult("导入工程进展情况错误！");
			}
			if(!ddZijinbaozhangService.add(mmZijinbaozhang)) {
				return JsonResult.getErrorResult("导入资金保障情况错误！");
			}
			if(!ddJungongjiesuanService.add(mmJungongjiesuan)) {
				return JsonResult.getErrorResult("导入竣工结算和决算情况错误！");
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
            HttpServletRequest request,
			HttpServletResponse response
    ){
	    try{
	    	System.out.println(command);
			DataBaseUtil.backup(response);
        }catch (Exception e){
            e.printStackTrace();

        }
    }



	/*public void backup(
			HttpServletRequest request
	){
		try {
			DataBaseUtil.backup();
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("ImportPaichuGaoxiaoController -> get_value: "+e.getMessage());
		}
	}*/


}
