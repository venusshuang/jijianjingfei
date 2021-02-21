package jjjf.service;


import jjjf.dao.DictJiesuanzhuangtaiMapper;
import jjjf.model.DictJiesuanzhuangtai;
import jjjf.model.DictJiesuanzhuangtaiExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JiesuanzhuangtaiService {
    @Resource
    DictJiesuanzhuangtaiMapper ddMapper;
    public List<DictJiesuanzhuangtai> findAll(String ppText){
        DictJiesuanzhuangtaiExample mmExample=new DictJiesuanzhuangtaiExample();
        mmExample.createCriteria().andTextLike(ppText);
        mmExample.setOrderByClause("ordernum ASC");
        return  ddMapper.selectByExample(mmExample);
    }

}
