package jjjf.service;

import jjjf.dao.DictJiesuanqingkuangMapper;
import jjjf.model.DictJiesuanqingkuang;
import jjjf.model.DictJiesuanqingkuangExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JiesuanqingkuangService {

    @Resource
    DictJiesuanqingkuangMapper ddMapper;

    public List<DictJiesuanqingkuang> findAll(String ppText){

        DictJiesuanqingkuangExample mmExample=new DictJiesuanqingkuangExample();
        mmExample.createCriteria().andTextLike(ppText);
        mmExample.setOrderByClause("ordernum ASC");
        return  ddMapper.selectByExample(mmExample);
    }

}
