package jjjf.dao;

import java.util.List;
import jjjf.model.Junjianxiangmu;
import jjjf.model.JunjianxiangmuExample;
import org.apache.ibatis.annotations.Param;

public interface JunjianxiangmuMapper {
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