package jjjf.controller;

import jjjf.service.JungongjiesuanService;
import jjjf.util.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("jungongjiesuan")
public class JungongjiesuanController {

    @Resource
    JungongjiesuanService ddService;

    public Logger log = LoggerFactory.getLogger(JungongjiesuanController.class);

    @RequestMapping("findOne")
    public JsonResult<?> findOne(@RequestParam("jungongJiesuanId") String ppjungongJiesuanId){
        try {
            return JsonResult.getSuccessResult(ddService.findOne(ppjungongJiesuanId));
        }catch (Exception e){
            e.printStackTrace();
            log.error("jungongjiesuan/findOne:error",e);
            return JsonResult.getErrorResult("jungongjiesuan/findOne:error " + e.getMessage());
        }
    }

}
