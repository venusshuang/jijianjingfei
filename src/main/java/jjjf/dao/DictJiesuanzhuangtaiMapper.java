package jjjf.dao;

import java.util.List;
import jjjf.model.DictJiesuanzhuangtai;
import jjjf.model.DictJiesuanzhuangtaiExample;
import org.apache.ibatis.annotations.Param;

public interface DictJiesuanzhuangtaiMapper {
    int countByExample(DictJiesuanzhuangtaiExample example);

    int deleteByExample(DictJiesuanzhuangtaiExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictJiesuanzhuangtai record);

    int insertSelective(DictJiesuanzhuangtai record);

    List<DictJiesuanzhuangtai> selectByExample(DictJiesuanzhuangtaiExample example);

    DictJiesuanzhuangtai selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictJiesuanzhuangtai record, @Param("example") DictJiesuanzhuangtaiExample example);

    int updateByExample(@Param("record") DictJiesuanzhuangtai record, @Param("example") DictJiesuanzhuangtaiExample example);

    int updateByPrimaryKeySelective(DictJiesuanzhuangtai record);

    int updateByPrimaryKey(DictJiesuanzhuangtai record);
}