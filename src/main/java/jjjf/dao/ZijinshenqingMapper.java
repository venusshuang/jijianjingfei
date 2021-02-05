package jjjf.dao;

import java.util.List;
import jjjf.model.Zijinshenqing;
import jjjf.model.ZijinshenqingExample;
import org.apache.ibatis.annotations.Param;

public interface ZijinshenqingMapper {
    int countByExample(ZijinshenqingExample example);

    int deleteByExample(ZijinshenqingExample example);

    int deleteByPrimaryKey(String zijinshenqingid);

    int insert(Zijinshenqing record);

    int insertSelective(Zijinshenqing record);

    List<Zijinshenqing> selectByExample(ZijinshenqingExample example);

    Zijinshenqing selectByPrimaryKey(String zijinshenqingid);

    int updateByExampleSelective(@Param("record") Zijinshenqing record, @Param("example") ZijinshenqingExample example);

    int updateByExample(@Param("record") Zijinshenqing record, @Param("example") ZijinshenqingExample example);

    int updateByPrimaryKeySelective(Zijinshenqing record);

    int updateByPrimaryKey(Zijinshenqing record);
}