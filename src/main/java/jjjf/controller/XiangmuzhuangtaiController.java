package jjjf.controller;

import jjjf.service.XiangmuzhuangtaiService;
import jjjf.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("xiangmuzhuangtai")
public class XiangmuzhuangtaiController {

    @Resource
    XiangmuzhuangtaiService ddService;

    public Logger log = LoggerFactory.getLogger(XiangmuzhuangtaiController.class);


    @RequestMapping("find_all")
    public JsonResult<?> findAll(
            @RequestParam("zhuangtai") String ppZhuangtai){
        try {
            return JsonResult.getSuccessResult(ddService.findAll("%"+ppZhuangtai+"%"));
        }catch(Exception e) {
            e.printStackTrace();
            return JsonResult.getErrorResult("查询失败！"+e);
        }
    }

}
