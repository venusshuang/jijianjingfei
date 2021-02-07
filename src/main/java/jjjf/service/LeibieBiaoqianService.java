package jjjf.service;

import jjjf.dao.DictLeibiebiaoqianMapper;
import jjjf.model.DictLeibiebiaoqian;
import jjjf.model.DictLeibiebiaoqianExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeibieBiaoqianService {

    @Resource
    DictLeibiebiaoqianMapper ddMapper;

    public boolean add(DictLeibiebiaoqian ppDictLeibiebiaoqian){
        return  ddMapper.insert(ppDictLeibiebiaoqian)==1;
    }

    public boolean delete(String ppDictLeibiebiaoqianId){
        return  ddMapper.deleteByPrimaryKey(ppDictLeibiebiaoqianId)==1;
    }
    public boolean modify(DictLeibiebiaoqian ppDictLeibiebiaoqian){
        return  ddMapper.updateByPrimaryKey(ppDictLeibiebiaoqian)==1;
    }
    public DictLeibiebiaoqian findOne(String ppDictLeibiebiaoqianId){
        return  ddMapper.selectByPrimaryKey(ppDictLeibiebiaoqianId);
    }
    public List<DictLeibiebiaoqian> findAll(String ppBiaoqianText){
        DictLeibiebiaoqianExample mmExample=new DictLeibiebiaoqianExample();
        mmExample.createCriteria().andTextLike(ppBiaoqianText);
        mmExample.setOrderByClause("ordernum ASC");
        return  ddMapper.selectByExample(mmExample);
    }

    public Integer getMaxOrderNum() {
        return  ddMapper.getMaxOrderNum()==null?0:(Integer) ddMapper.getMaxOrderNum();
    }
}
