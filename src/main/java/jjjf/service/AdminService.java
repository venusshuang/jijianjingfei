package jjjf.service;

import jjjf.dao.AdminMapper;
import jjjf.model.Admin;
import jjjf.model.AdminExample;
import jjjf.model.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Resource
    AdminMapper ddMapper;

    public boolean  checkAccount(String ppaccount) {
        AdminExample mmExample=new AdminExample();
        mmExample.createCriteria().andAccountEqualTo(ppaccount);
        return ddMapper.selectByExample(mmExample).size()>0?true:false;
    }

    public Admin findOne(String ppAdminId) {
        return ddMapper.selectByPrimaryKey(ppAdminId);
    }
    public boolean modify(Admin ppAdmin) {
        return ddMapper.updateByPrimaryKeySelective(ppAdmin)==1;
    }
    public List<Map<String, Object>> findSomeByDeptId(String ppdeptID){

        return ddMapper.findSomeByDeptId(ppdeptID);
    }
    public boolean add(Admin admin) {
        return ddMapper.insert(admin)==1;
    }
    public boolean delete(String ppadminID){
        return ddMapper.deleteByPrimaryKey(ppadminID)==1;
    }

    public Admin login(String ppAccount, String ppPassword){
        AdminExample mmExample=new AdminExample();
        mmExample.createCriteria().andAccountEqualTo(ppAccount).andPasswordEqualTo(ppPassword).andZhuangtaiEqualTo(100);
        List<Admin> mmList=ddMapper.selectByExample(mmExample);
        return  mmList.size()==1?mmList.get(0):null;
    }
}
