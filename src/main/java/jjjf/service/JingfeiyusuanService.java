package jjjf.service;


import jjjf.dao.JingfeiyusuanMapper;
import jjjf.model.DictJiesuanzhuangtai;
import jjjf.model.DictJiesuanzhuangtaiExample;
import jjjf.model.Jingfeiyusuan;
import jjjf.model.JingfeiyusuanExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JingfeiyusuanService {

    @Resource
    JingfeiyusuanMapper ddMapper;

    public List<Jingfeiyusuan> findJingfeiyusuanByXiangmuId(String ppxiangmuId){
        JingfeiyusuanExample mmExample=new JingfeiyusuanExample();
        mmExample.createCriteria().andXiangmuidEqualTo(ppxiangmuId);
        return ddMapper.selectByExample(mmExample);
    }

    public List<Map<String, Object>> findJingfeiyusuanBydeptId(String ppxiangmuName, String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findJingfeiyusuanBydeptId(ppxiangmuName,ppdeptId, mmStartIndex, ppPageSize);
    }
    public Integer getCountBydeptId(String ppxiangmuName,String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppxiangmuName,ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }

    public Jingfeiyusuan findOne(String ppjingfeiyuansuanId){
        return ddMapper.selectByPrimaryKey(ppjingfeiyuansuanId);
    }

    public boolean add(Jingfeiyusuan ppJingfeiyusuan){
        return ddMapper.insert(ppJingfeiyusuan)==1;
    }

    public boolean modify(Jingfeiyusuan ppJingfeiyusuan){
        return ddMapper.updateByPrimaryKeySelective(ppJingfeiyusuan)==1;
    }

    public boolean delete(String ppjingfeiyuansuanId){
        return ddMapper.deleteByPrimaryKey(ppjingfeiyuansuanId)==1;
    }
}
