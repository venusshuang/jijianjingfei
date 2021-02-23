package jjjf.service;

import jjjf.dao.JungongjiesuanMapper;
import jjjf.model.Jungongjiesuan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JungongjiesuanService {

    @Resource
    JungongjiesuanMapper ddMapper;

    public List<Map<String, Object>> findJungongjiesuanBydeptId(String ppxiangmuName, String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findJungongjiesuanBydeptId(ppxiangmuName,ppdeptId, mmStartIndex, ppPageSize);
    }

    public Integer getCountBydeptId(String ppxiangmuName,String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppxiangmuName,ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }


    public Jungongjiesuan findOne(String ppjungongJiesuanId){
        return ddMapper.selectByPrimaryKey(ppjungongJiesuanId);
    }


    public boolean add(Jungongjiesuan ppjungongJiesuan){
        return ddMapper.insertSelective(ppjungongJiesuan)==1;
    }


    public boolean modify(Jungongjiesuan ppjungongJiesuan){
        return ddMapper.updateByPrimaryKeySelective(ppjungongJiesuan)==1;
    }

    public boolean delete(String ppjungongJiesuanId){
        return ddMapper.deleteByPrimaryKey(ppjungongJiesuanId)==1;
    }



}
