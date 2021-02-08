package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Dept;
import jjjf.model.DeptExample;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    List<Map<String, Object>> findDanweiByzhuangtai(@Param("startindex") int mmStartIndex, @Param("pagesize") int mmPageSize);

    Object getCountByzhuangtai();

    int countByExample(DeptExample example);

    int deleteByExample(DeptExample example);

    int deleteByPrimaryKey(String deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptExample example);

    Dept selectByPrimaryKey(String deptid);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptExample example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}