package jjjf.dao;

import java.util.List;
import jjjf.model.DictXiangmuzhuangtai;
import jjjf.model.DictXiangmuzhuangtaiExample;
import org.apache.ibatis.annotations.Param;

public interface DictXiangmuzhuangtaiMapper {
    int countByExample(DictXiangmuzhuangtaiExample example);

    int deleteByExample(DictXiangmuzhuangtaiExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictXiangmuzhuangtai record);

    int insertSelective(DictXiangmuzhuangtai record);

    List<DictXiangmuzhuangtai> selectByExample(DictXiangmuzhuangtaiExample example);

    DictXiangmuzhuangtai selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictXiangmuzhuangtai record, @Param("example") DictXiangmuzhuangtaiExample example);

    int updateByExample(@Param("record") DictXiangmuzhuangtai record, @Param("example") DictXiangmuzhuangtaiExample example);

    int updateByPrimaryKeySelective(DictXiangmuzhuangtai record);

    int updateByPrimaryKey(DictXiangmuzhuangtai record);
}