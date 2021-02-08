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


    public boolean add(Jungongjiesuan ppjungongJiesuan){
        return ddMapper.insert(ppjungongJiesuan)==1;
    }

    public boolean modify(Jungongjiesuan ppjungongJiesuan){
        return ddMapper.updateByPrimaryKeySelective(ppjungongJiesuan)==1;
    }

   /* public boolean delete(String ppXiangmuId) {
        return ddMapper.deleteByPrimaryKey(ppXiangmuId)==1;
    }*/

}
