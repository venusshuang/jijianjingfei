package jjjf.controller;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




import jjjf.service.JunjianxiangmuService;
import jjjf.util.CreateXLS;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("exportexcel")
public class ExportExcelController {
    @Value("${userfilepath}")
    private String userfilepath;
    @Resource
    JunjianxiangmuService ddJunjianxiangmuService;

    public Logger log = LoggerFactory.getLogger(ExportExcelController.class);

    @RequestMapping("exportxiangmu")
    public String exportxiangmu(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam("xiangmumingcheng") String ppxiangmumingcheng,
                                @RequestParam("danweimingcheng") String ppdanweimingcheng,
                                @RequestParam("jihuawenhao") String ppjihuawenhao,
                                @RequestParam("yusuanwenhao") String ppyusuanwenhao,
                                @RequestParam("jingfeikemu") String ppjingfeikemu,
                                @RequestParam("xiangmuzhuangtaiid") String ppxiangmuzhuangtaiid,
                                @RequestParam("jungongzhuangtaiid") String ppjungongzhuangtaiid,
                                @RequestParam("jiesuanqingkuangid") String ppjiesuanqingkuangid,
                                @RequestParam("leibieid") String ppleibieid,
                                @RequestParam("beizhu") String ppbeizhu,
                                @RequestParam("pageindex") int ppPageIndex,
                                @RequestParam("pagesize") int ppPageSize) {
        List<List<String>> mmResultList = new ArrayList<List<String>>();
        List<String> mmTitleList = new ArrayList<String>();

        mmTitleList.add("序号");
        mmTitleList.add("项目名称");
        mmTitleList.add("两级建设计划或设计任务书批复情况");
        mmTitleList.add("联保建设计划批复金额");
        mmTitleList.add("中心建设计划批复金额");
        mmTitleList.add("联保预留预备费");

        mmTitleList.add("两级经费下达情况");
        mmTitleList.add("预算年度");
        mmTitleList.add("联保下达经费指标");
        mmTitleList.add("中心下达经费指标");
        mmTitleList.add("中心预留预备费");
        mmTitleList.add("中心会计账凭证号");
        mmTitleList.add("承受经费指标单位名称");
        mmTitleList.add("经费科目");

        mmTitleList.add("项目状态");
        mmTitleList.add("开工时间");
        mmTitleList.add("各类合同总价");
        mmTitleList.add("完成投资");
        mmTitleList.add("进度款支付");
        mmTitleList.add("进度款占总合同比例％");
        mmTitleList.add("完工时间（预计）");

        mmTitleList.add("向中心申请资金");
        mmTitleList.add("申请时间");
        mmTitleList.add("向联保申请拨付金额");
        mmTitleList.add("向联保申请拨付时间");
        mmTitleList.add("联保拨付金额");
        mmTitleList.add("联保拨付时间");
        mmTitleList.add("中心资金拨付金额");
        mmTitleList.add("中心拨付时间");

        mmTitleList.add("竣工结算状态");
        mmTitleList.add("竣工结算完成时间（未完成不填）");
        mmTitleList.add("竣工决算情况");
        mmTitleList.add("决算是否记账和登记资产");
        mmTitleList.add("两级决算批复文号");
        mmTitleList.add("决算批复金额");
        mmTitleList.add("结余上缴金额");

        mmTitleList.add("类别");
        mmTitleList.add("备注");
        mmResultList.add(mmTitleList);

        if(!ppxiangmumingcheng.equals("")) {
            ppxiangmumingcheng = "%" + ppxiangmumingcheng + "%";
        }
        if(!ppdanweimingcheng.equals("")) {
            ppdanweimingcheng = "%" + ppdanweimingcheng + "%";
        }
        if(!ppjihuawenhao.equals("")) {
            ppjihuawenhao = "%" + ppjihuawenhao + "%";
        }
        if(!ppyusuanwenhao.equals("")) {
            ppyusuanwenhao = "%" + ppyusuanwenhao + "%";
        }
        if(!ppjingfeikemu.equals("")) {
            ppjingfeikemu = "%" + ppjingfeikemu + "%";
        }
        if(!ppbeizhu.equals("")){
            ppbeizhu="%" + ppbeizhu + "%";
        }


        List<Map<String, Object>> mmXiangmuList = ddJunjianxiangmuService.searchXiangmu(ppxiangmumingcheng,ppdanweimingcheng,
                ppjihuawenhao,ppyusuanwenhao,ppjingfeikemu,ppxiangmuzhuangtaiid,ppjungongzhuangtaiid,ppjiesuanqingkuangid,
                ppleibieid,ppbeizhu,ppPageIndex,ppPageSize);
        int mmXiangmushu = mmXiangmuList.size();
        if(mmXiangmushu > 0) {
            for (int i = 0; i < mmXiangmushu; i++) {
                Map<String, Object> mmXiangmuMap=mmXiangmuList.get(i);
                String mmXuhao = String.valueOf(i + 1);
                String mmXiangmumingcheng=mmXiangmuMap.get("xiangmuname")==null ? "" :mmXiangmuMap.get("xiangmuname").toString();
                String mmXiangmupifu=mmXiangmuMap.get("xiangmupifu")==null ? "" :mmXiangmuMap.get("xiangmupifu").toString();
                String mmLianbaopifujine=mmXiangmuMap.get("lianbaopifujine")==null ? "" :mmXiangmuMap.get("lianbaopifujine").toString();
                String mmZhongxinpifujine=mmXiangmuMap.get("zhongxinpifujine")==null ? "" :mmXiangmuMap.get("zhongxinpifujine").toString();
                String mmLianbaoyuliujine=mmXiangmuMap.get("lianbaoyuliujine")==null ? "" :mmXiangmuMap.get("lianbaoyuliujine").toString();

                String mmJingfeixiadaqingkuang=mmXiangmuMap.get("jingfeixiadaqingkuang")==null ? "" :mmXiangmuMap.get("jingfeixiadaqingkuang").toString();
                String mmYusuanniandu=mmXiangmuMap.get("yusuanniandu")==null ? "" :mmXiangmuMap.get("yusuanniandu").toString();
                String mmLianbaojingfeizhibiao=mmXiangmuMap.get("lianbaojingfeizhibiao")==null ? "" :mmXiangmuMap.get("lianbaojingfeizhibiao").toString();
                String mmZhongxinjingfeizhibiao=mmXiangmuMap.get("zhongxinjingfeizhibiao")==null ? "" :mmXiangmuMap.get("zhongxinjingfeizhibiao").toString();
                String mmZhongxinyuliujine=mmXiangmuMap.get("zhongxinyuliujine")==null ? "" :mmXiangmuMap.get("zhongxinyuliujine").toString();
                String mmZhongxinkuaijihao=mmXiangmuMap.get("zhongxinkuaijihao")==null ? "" :mmXiangmuMap.get("zhongxinkuaijihao").toString();
                String mmChengshoujingfeidanwei=mmXiangmuMap.get("chengshoujingfeidanwei")==null ? "" :mmXiangmuMap.get("chengshoujingfeidanwei").toString();
                String mmJingfeikemu=mmXiangmuMap.get("jingfeikemu")==null ? "" :mmXiangmuMap.get("jingfeikemu").toString();

                String mmXmzttext=mmXiangmuMap.get("xmzttext")==null ? "" :mmXiangmuMap.get("xmzttext").toString();
                String mmKaigongshijian=mmXiangmuMap.get("kaigongshijian")==null ? "" :mmXiangmuMap.get("kaigongshijian").toString();
                String mmHetongzongjia=mmXiangmuMap.get("hetongzongjia")==null ? "" :mmXiangmuMap.get("hetongzongjia").toString();
                String mmWangchengtouzi=mmXiangmuMap.get("wangchengtouzi")==null ? "" :mmXiangmuMap.get("wangchengtouzi").toString();
                String mmJindukuaizhifu=mmXiangmuMap.get("jindukuaizhifu")==null ? "" :mmXiangmuMap.get("jindukuaizhifu").toString();
                String mmJindukuanbili=mmXiangmuMap.get("jindukuanbili")==null ? "" :mmXiangmuMap.get("jindukuanbili").toString();
                String mmWangongshijian=mmXiangmuMap.get("wangongshijian")==null ? "" :mmXiangmuMap.get("wangongshijian").toString();

                String mmXiangzhongxinshenqingzijin=mmXiangmuMap.get("xiangzhongxinshenqingzijin")==null ? "" :mmXiangmuMap.get("xiangzhongxinshenqingzijin").toString();
                String mmShenqingshijian=mmXiangmuMap.get("shenqingshijian")==null ? "" :mmXiangmuMap.get("shenqingshijian").toString();
                String mmXianglianbaoshenqingzijin=mmXiangmuMap.get("xianglianbaoshenqingzijin")==null ? "" :mmXiangmuMap.get("xianglianbaoshenqingzijin").toString();
                String mmXianglianbaoshenqingbofushijian=mmXiangmuMap.get("xianglianbaoshenqingbofushijian")==null ? "" :mmXiangmuMap.get("xianglianbaoshenqingbofushijian").toString();
                String mmLianbaobofujine=mmXiangmuMap.get("lianbaobofujine")==null ? "" :mmXiangmuMap.get("lianbaobofujine").toString();
                String mmLianbaobofushijian=mmXiangmuMap.get("lianbaobofushijian")==null ? "" :mmXiangmuMap.get("lianbaobofushijian").toString();
                String mmZhongxinbofujine=mmXiangmuMap.get("zhongxinbofujine")==null ? "" :mmXiangmuMap.get("zhongxinbofujine").toString();
                String mmZhongxinbofushijian=mmXiangmuMap.get("zhongxinbofushijian")==null ? "" :mmXiangmuMap.get("zhongxinbofushijian").toString();

                String mmJszttext=mmXiangmuMap.get("jszttext")==null ? "" :mmXiangmuMap.get("jszttext").toString();
                String mmJiesuanwanchengtime=mmXiangmuMap.get("jiesuanwanchengtime")==null ? "" :mmXiangmuMap.get("jiesuanwanchengtime").toString();
                String mmJsqktext=mmXiangmuMap.get("jsqktext")==null ? "" :mmXiangmuMap.get("jsqktext").toString();
                String mmShifoujizhang=mmXiangmuMap.get("shifoujizhang")==null ? "" :mmXiangmuMap.get("shifoujizhang").toString();
                String mmJiesuanpifuwenhao=mmXiangmuMap.get("jiesuanpifuwenhao")==null ? "" :mmXiangmuMap.get("jiesuanpifuwenhao").toString();
                String mmJiesuanpifujine=mmXiangmuMap.get("jiesuanpifujine")==null ? "" :mmXiangmuMap.get("jiesuanpifujine").toString();
                String mmJieyushangjiaojine=mmXiangmuMap.get("jieyushangjiaojine")==null ? "" :mmXiangmuMap.get("jieyushangjiaojine").toString();

                String mmLbtext=mmXiangmuMap.get("lbtext")==null ? "" :mmXiangmuMap.get("lbtext").toString();
                String mmBeizhu=mmXiangmuMap.get("beizhu")==null ? "" :mmXiangmuMap.get("beizhu").toString();

                List<String> mmTempList = new ArrayList<String>();
                mmTempList.add(mmXuhao);
                mmTempList.add(mmXiangmumingcheng);
                mmTempList.add(mmXiangmupifu);
                mmTempList.add(mmLianbaopifujine);
                mmTempList.add(mmZhongxinpifujine);
                mmTempList.add(mmLianbaoyuliujine);

                mmTempList.add(mmJingfeixiadaqingkuang);
                mmTempList.add(mmYusuanniandu);
                mmTempList.add(mmLianbaojingfeizhibiao);
                mmTempList.add(mmZhongxinjingfeizhibiao);
                mmTempList.add(mmZhongxinyuliujine);
                mmTempList.add(mmZhongxinkuaijihao);
                mmTempList.add(mmChengshoujingfeidanwei);
                mmTempList.add(mmJingfeikemu);

                mmTempList.add(mmXmzttext);
                mmTempList.add(mmKaigongshijian);
                mmTempList.add(mmHetongzongjia);
                mmTempList.add(mmWangchengtouzi);
                mmTempList.add(mmJindukuaizhifu);
                mmTempList.add(mmJindukuanbili);
                mmTempList.add(mmWangongshijian);

                mmTempList.add(mmXiangzhongxinshenqingzijin);
                mmTempList.add(mmShenqingshijian);
                mmTempList.add(mmXianglianbaoshenqingzijin);
                mmTempList.add(mmXianglianbaoshenqingbofushijian);
                mmTempList.add(mmLianbaobofujine);
                mmTempList.add(mmLianbaobofushijian);
                mmTempList.add(mmZhongxinbofujine);
                mmTempList.add(mmZhongxinbofushijian);

                mmTempList.add(mmJszttext);
                mmTempList.add(mmJiesuanwanchengtime);
                mmTempList.add(mmJsqktext);
                if(mmShifoujizhang.equals("1")){
                    mmTempList.add("是");
                }else {
                    mmTempList.add("否");
                }
                mmTempList.add(mmJiesuanpifuwenhao);
                mmTempList.add(mmJiesuanpifujine);
                mmTempList.add(mmJieyushangjiaojine);

                mmTempList.add(mmLbtext);
                mmTempList.add(mmBeizhu);

                mmResultList.add(mmTempList);

            }
        }

            try {
            //取出文档存放的根目录，并去除文件最后的斜杠
            if (userfilepath.endsWith("/")) {
                userfilepath = userfilepath.substring(0, userfilepath.length()-1);
            }

            SimpleDateFormat mmDateFormat = new SimpleDateFormat("yyyyMMdd");
            String mmSavePath = userfilepath +  "/temp/"+mmDateFormat.format(new Date()) + "/";

            CreateXLS.createExcel(mmResultList, mmSavePath,  "jijianxiangmu_"+ UUID.randomUUID().toString()+".xls",
                    "jijianxiangmu", request, response);
            return "/jjjf/jijianxiangmu.xls";

        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
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
