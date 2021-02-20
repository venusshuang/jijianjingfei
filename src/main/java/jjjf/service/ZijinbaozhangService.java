package jjjf.service;

import jjjf.dao.ZijinbaozhangMapper;
import jjjf.model.Zijinbaozhang;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ZijinbaozhangService {

    @Resource
    ZijinbaozhangMapper ddMapper;

    public List<Map<String, Object>> findZijinbaozhangBydeptId(String ppxiangmuName, String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findZijinbaozhangBydeptId(ppxiangmuName,ppdeptId, mmStartIndex, ppPageSize);
    }

    public Integer getCountBydeptId(String ppxiangmuName,String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppxiangmuName,ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }

    public Zijinbaozhang findOne(String ppzijinbaozhangId){
        return ddMapper.selectByPrimaryKey(ppzijinbaozhangId);
    }

    public boolean add(Zijinbaozhang ppZijinbaozhang){
        return ddMapper.insert(ppZijinbaozhang)==1;
    }

    public boolean modify(Zijinbaozhang ppZijinbaozhang) {
        return ddMapper.updateByPrimaryKeySelective(ppZijinbaozhang) == 1;
    }

    public boolean delete(String ppzijinbaozhangId){
        return ddMapper.deleteByPrimaryKey(ppzijinbaozhangId)==1;
    }


}
