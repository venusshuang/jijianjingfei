package jjjf.controller;

import jjjf.model.Admin;
import jjjf.model.DictLeibiebiaoqian;
import jjjf.service.LeibieBiaoqianService;
import jjjf.util.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController
@RequestMapping("leibiebiaoqian")
public class LeibiebiaoqianController {

    @Resource
    LeibieBiaoqianService ddService;


    @RequestMapping("add")
    public JsonResult<?> add(
            @RequestParam("text") String ppText,
            @RequestParam("isvalid") Integer ppIsvalid){
        try {

            DictLeibiebiaoqian mmLeibieBiaoqian=new DictLeibiebiaoqian();

            mmLeibieBiaoqian.setId(UUID.randomUUID().toString());
            mmLeibieBiaoqian.setIsvalid(ppIsvalid);
            mmLeibieBiaoqian.setText(ppText.trim());
            mmLeibieBiaoqian.setOrdernum(ddService.getMaxOrderNum()+1);

            if (!ddService.add(mmLeibieBiaoqian)){
                return JsonResult.getErrorResult("类别标签添加失败!");
            }
            return JsonResult.getSuccessResult("类别标签添加成功!");

        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("类别标签添加失败！"+e);
        }
    }

    @RequestMapping("modify")
    public JsonResult<?> modify(
            @RequestParam("id") String ppID,
            @RequestParam("text") String ppText,
            @RequestParam("isvalid") Integer ppIsvalid){
        try {

            DictLeibiebiaoqian mmLeibieBiaoqian=ddService.findOne(ppID);
            if (mmLeibieBiaoqian==null){
                return JsonResult.getErrorResult("类别标签不存在!");
            }

            mmLeibieBiaoqian.setIsvalid(ppIsvalid);
            mmLeibieBiaoqian.setText(ppText.trim());

            if (!ddService.modify(mmLeibieBiaoqian)){
                return JsonResult.getErrorResult("类别标签修改失败!");
            }
            return JsonResult.getSuccessResult("类别标签修改成功!");

        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("类别标签修改失败！"+e);
        }
    }

    @RequestMapping("find_one")
    public JsonResult<?> findOne(
            @RequestParam("id") String ppID
          ){
        try {

            DictLeibiebiaoqian mmLeibieBiaoqian=ddService.findOne(ppID);
            if (mmLeibieBiaoqian==null){
                return JsonResult.getErrorResult("类别标签不存在!");
            }
            return JsonResult.getSuccessResult(mmLeibieBiaoqian);
        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("单个类别标签查询失败！"+e);
        }
    }

    @RequestMapping("find_all")
    public JsonResult<?> findAll(
            @RequestParam("biaoqian") String ppBiaoqian
    ){
        try {
            return JsonResult.getSuccessResult(ddService.findAll("%"+ppBiaoqian+"%"));
        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("全部类别标签查询失败！"+e);
        }
    }

    @RequestMapping("delete")
    public JsonResult<?> delete(
            @RequestParam("id") String ppID
    ){
        try {
            DictLeibiebiaoqian mmLeibieBiaoqian=ddService.findOne(ppID);
            if (mmLeibieBiaoqian==null){
                return JsonResult.getErrorResult("类别标签不存在!");
            }
            if (!ddService.delete(ppID)){
                return JsonResult.getErrorResult("类别标签删除失败!");
            }
            return JsonResult.getSuccessResult("类别标签删除成功!");
        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("类别标签删除失败！"+e);
        }
    }
}
