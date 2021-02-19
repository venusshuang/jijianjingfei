package jjjf.service;


import jjjf.dao.GongchengjinzhanMapper;
import jjjf.model.Gongchengjinzhan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class GongchengjinzhanService {

    @Resource
    GongchengjinzhanMapper ddMapper;

    public List<Map<String, Object>> findGongchengjinzhanBydeptId(String ppxiangmuName, String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findGongchengjinzhanBydeptId(ppxiangmuName,ppdeptId, mmStartIndex, ppPageSize);
    }

    public Integer getCountBydeptId(String ppxiangmuName,String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppxiangmuName,ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }

    public Gongchengjinzhan findOne(String ppgongchengjinzhanId){
        return ddMapper.selectByPrimaryKey(ppgongchengjinzhanId);
    }

    public boolean add(Gongchengjinzhan ppGongchengjinzhan){
        return ddMapper.insert(ppGongchengjinzhan)==1;
    }

    public boolean modify(Gongchengjinzhan ppGongchengjinzhan){
        return ddMapper.updateByPrimaryKeySelective(ppGongchengjinzhan)==1;
    }

    public boolean delete(String ppgongchengjinzhanId){
        return ddMapper.deleteByPrimaryKey(ppgongchengjinzhanId)==1;
    }

}
