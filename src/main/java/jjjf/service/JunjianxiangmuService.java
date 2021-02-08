package jjjf.service;


import jjjf.dao.JunjianxiangmuMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JunjianxiangmuService {

    @Resource
    JunjianxiangmuMapper ddMapper;

    public List<Map<String, Object>> findXiangmuBydeptId(String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findXiangmuBydeptId(ppdeptId, mmStartIndex, ppPageSize);
    }

    public Integer getCountBydeptId(String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }

}
