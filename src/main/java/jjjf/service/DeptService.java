package jjjf.service;

import jjjf.dao.DeptMapper;
import jjjf.model.Dept;
import jjjf.model.DeptExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class DeptService {
    @Resource
    DeptMapper ddMapper;

    public List<Map<String, Object>> findVaild(int ppPageIndex, int ppPageSize){

        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;

        return ddMapper.findDanweiByzhuangtai(mmStartIndex, ppPageSize);

    }
    public boolean  checkDeptname(String ppdeptname) {
        DeptExample mmExample=new DeptExample();
        mmExample.createCriteria().andDeptnameEqualTo(ppdeptname);
        return ddMapper.selectByExample(mmExample).size()>0?true:false;
    }
    public boolean  checkDeptnameBydeptid(String ppdeptname,String ppdeptid) {
        DeptExample mmExample=new DeptExample();
        mmExample.createCriteria().andDeptnameEqualTo(ppdeptname).andDeptidNotEqualTo(ppdeptid);
        return ddMapper.selectByExample(mmExample).size()>0?true:false;
    }
    public Integer getCountByisvalid() {
        Object mmCount = ddMapper.getCountByzhuangtai();
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }
    public Dept findOne(String ppdeptID){
        return ddMapper.selectByPrimaryKey(ppdeptID);
    }
    public boolean add(Dept dept) {
        return ddMapper.insert(dept)==1;
    }
    public boolean delete(String ppdeptID){
        return ddMapper.deleteByPrimaryKey(ppdeptID)==1;
    }
    public boolean modify(Dept ppDept) {
        return ddMapper.updateByPrimaryKey(ppDept)==1;
    }

    public List<Dept> findAll(String ppDeptName){
        DeptExample mmExample=new DeptExample();
        mmExample.createCriteria().andDeptnameEqualTo(ppDeptName);
        return  ddMapper.selectByExample(mmExample);
    }


}
