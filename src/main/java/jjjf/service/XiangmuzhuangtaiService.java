package jjjf.service;


import jjjf.dao.DictXiangmuzhuangtaiMapper;
import jjjf.model.DictXiangmuzhuangtai;
import jjjf.model.DictXiangmuzhuangtaiExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class XiangmuzhuangtaiService {

    @Resource
    DictXiangmuzhuangtaiMapper ddMapper;

    public List<DictXiangmuzhuangtai> findAll(String ppZhuangtaiText){
        DictXiangmuzhuangtaiExample mmExample=new DictXiangmuzhuangtaiExample();
        mmExample.createCriteria().andTextLike(ppZhuangtaiText);
        mmExample.setOrderByClause("ordernum ASC");
        return  ddMapper.selectByExample(mmExample);
    }
}
