package jjjf.service;

import jjjf.dao.DeptMapper;
import jjjf.model.Dept;
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
    public Integer getCountByisvalid() {
        Object mmCount = ddMapper.getCountByzhuangtai();
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }
    public Dept findOne(String ppjungongJiesuanId){
        return ddMapper.selectByPrimaryKey(ppjungongJiesuanId);
    }
    public boolean add(Dept dept) {
        return ddMapper.insert(dept)==1;
    }

}
