package jjjf.service;

import jjjf.dao.AdminMapper;
import jjjf.model.Admin;
import jjjf.model.AdminExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    AdminMapper ddMapper;

    public Admin login(String ppAccount, String ppPassword){
        AdminExample mmExample=new AdminExample();
        mmExample.createCriteria().andAccountEqualTo(ppAccount).andPasswordEqualTo(ppPassword).andZhuangtaiEqualTo(100);
        List<Admin> mmList=ddMapper.selectByExample(mmExample);
        return  mmList.size()==1?mmList.get(0):null;
    }
}
