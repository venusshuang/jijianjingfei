package jjjf.dao;

import java.util.List;
import jjjf.model.DictJiesuanqingkuang;
import jjjf.model.DictJiesuanqingkuangExample;
import org.apache.ibatis.annotations.Param;

public interface DictJiesuanqingkuangMapper {
    int countByExample(DictJiesuanqingkuangExample example);

    int deleteByExample(DictJiesuanqingkuangExample example);

    int deleteByPrimaryKey(String id);

    int insert(DictJiesuanqingkuang record);

    int insertSelective(DictJiesuanqingkuang record);

    List<DictJiesuanqingkuang> selectByExample(DictJiesuanqingkuangExample example);

    DictJiesuanqingkuang selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") DictJiesuanqingkuang record, @Param("example") DictJiesuanqingkuangExample example);

    int updateByExample(@Param("record") DictJiesuanqingkuang record, @Param("example") DictJiesuanqingkuangExample example);

    int updateByPrimaryKeySelective(DictJiesuanqingkuang record);

    int updateByPrimaryKey(DictJiesuanqingkuang record);
}