package jjjf.controller;


import jjjf.service.JiesuanzhuangtaiService;
import jjjf.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("jiesuanzhuangtai")
public class JiesuanzhuangtaiController {

    @Resource
    JiesuanzhuangtaiService ddService;
    public Logger log = LoggerFactory.getLogger(JiesuanzhuangtaiController.class);

    @RequestMapping("find_all")
    public JsonResult<?> findAll(
            @RequestParam("text") String ppText){
        try {
            return JsonResult.getSuccessResult(ddService.findAll("%"+ppText+"%"));
        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("查询失败！"+e);
        }
    }

}
