package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Junjianxiangmu;
import jjjf.model.JunjianxiangmuExample;
import org.apache.ibatis.annotations.Param;

public interface JunjianxiangmuMapper {


    List<Map<String, Object>> findXiangmuBydeptId(@Param("deptid") String mmDeptId, @Param("startindex") int mmStartIndex,
                                                  @Param("pagesize") int mmPageSize);

    Object getCountBydeptId(@Param("deptid") String mmDeptId);


    int countByExample(JunjianxiangmuExample example);

    int deleteByExample(JunjianxiangmuExample example);

    int deleteByPrimaryKey(String xiangmuid);

    int insert(Junjianxiangmu record);

    int insertSelective(Junjianxiangmu record);

    List<Junjianxiangmu> selectByExample(JunjianxiangmuExample example);

    Junjianxiangmu selectByPrimaryKey(String xiangmuid);

    int updateByExampleSelective(@Param("record") Junjianxiangmu record, @Param("example") JunjianxiangmuExample example);

    int updateByExample(@Param("record") Junjianxiangmu record, @Param("example") JunjianxiangmuExample example);

    int updateByPrimaryKeySelective(Junjianxiangmu record);

    int updateByPrimaryKey(Junjianxiangmu record);
}