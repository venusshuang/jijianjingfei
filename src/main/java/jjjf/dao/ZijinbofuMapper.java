package jjjf.dao;

import java.util.List;
import jjjf.model.Zijinbofu;
import jjjf.model.ZijinbofuExample;
import org.apache.ibatis.annotations.Param;

public interface ZijinbofuMapper {
    int countByExample(ZijinbofuExample example);

    int deleteByExample(ZijinbofuExample example);

    int deleteByPrimaryKey(String zijinbofuid);

    int insert(Zijinbofu record);

    int insertSelective(Zijinbofu record);

    List<Zijinbofu> selectByExample(ZijinbofuExample example);

    Zijinbofu selectByPrimaryKey(String zijinbofuid);

    int updateByExampleSelective(@Param("record") Zijinbofu record, @Param("example") ZijinbofuExample example);

    int updateByExample(@Param("record") Zijinbofu record, @Param("example") ZijinbofuExample example);

    int updateByPrimaryKeySelective(Zijinbofu record);

    int updateByPrimaryKey(Zijinbofu record);
}