package jjjf.service;

import jjjf.dao.JungongjiesuanMapper;
import jjjf.model.Jungongjiesuan;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JungongjiesuanService {

    @Resource
    JungongjiesuanMapper ddMapper;

    public Jungongjiesuan findOne(String ppjungongJiesuanId){
        return ddMapper.selectByPrimaryKey(ppjungongJiesuanId);
    }

}
