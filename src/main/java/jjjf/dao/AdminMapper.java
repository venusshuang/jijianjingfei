package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Admin;
import jjjf.model.AdminExample;
import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    List<Map<String, Object>> findSomeByDeptId(@Param("deptID") String mmdeptID);

    int countByExample(AdminExample example);

    int deleteByExample(AdminExample example);

    int deleteByPrimaryKey(String adminid);

    int insert(Admin record);

    int insertSelective(Admin record);

    List<Admin> selectByExample(AdminExample example);

    Admin selectByPrimaryKey(String adminid);

    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
}