package jjjf.controller;


import jjjf.service.JunjianxiangmuService;
import jjjf.util.JsonResult;
import jjjf.util.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("junjianxiangmu")
public class JunjianxiangmuContorller {

    @Resource
    JunjianxiangmuService ddService;

    public Logger log = LoggerFactory.getLogger(JunjianxiangmuContorller.class);

    @RequestMapping("findXiangmuBydeptId")
    public JsonResult<?> findVaildByAdminId(@RequestParam("deptid") String ppDeptId,
                                            @RequestParam("pageindex") int ppPageIndex,
                                            @RequestParam("pagesize") int ppPageSize) {
        try {

            List<Map<String, Object>> mmList=ddService.findXiangmuBydeptId(ppDeptId,ppPageIndex,ppPageSize);
            Integer mmCount = ddService.getCountBydeptId(ppDeptId);
            PageInfo mmPageInfo = new PageInfo(ppPageIndex, ppPageSize, mmCount);

            Map<String, Object> mmMap = new HashMap<String, Object>();
            mmMap.put("XiangMuList", mmList);
            mmMap.put("PageInfo", mmPageInfo);
            return JsonResult.getSuccessResult(mmMap);

        }catch (Exception e) {
            e.printStackTrace();
            log.error("junjianxiangmu/findXiangmuBydeptId:error",e);
            return JsonResult.getErrorResult("junjianxiangmu/findXiangmuBydeptId:error " + e.getMessage());
        }
    }


}
