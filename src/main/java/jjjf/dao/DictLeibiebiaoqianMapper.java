package jjjf.dao;

import java.util.List;
import jjjf.model.DictLeibiebiaoqian;
import jjjf.model.DictLeibiebiaoqianExample;
import org.apache.ibatis.annotations.Param;

public interface DictLeibiebiaoqianMapper {
    int countByExample(DictLeibiebiaoqianExample example);

    int deleteByExample(DictLeibiebiaoqianExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictLeibiebiaoqian record);

    int insertSelective(DictLeibiebiaoqian record);

    List<DictLeibiebiaoqian> selectByExample(DictLeibiebiaoqianExample example);

    DictLeibiebiaoqian selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictLeibiebiaoqian record, @Param("example") DictLeibiebiaoqianExample example);

    int updateByExample(@Param("record") DictLeibiebiaoqian record, @Param("example") DictLeibiebiaoqianExample example);

    int updateByPrimaryKeySelective(DictLeibiebiaoqian record);

    int updateByPrimaryKey(DictLeibiebiaoqian record);

    Object getMaxOrderNum();
}