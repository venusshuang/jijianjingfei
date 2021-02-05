package jjjf.dao;

import java.util.List;
import jjjf.model.Jungongjiesuan;
import jjjf.model.JungongjiesuanExample;
import org.apache.ibatis.annotations.Param;

public interface JungongjiesuanMapper {
    int countByExample(JungongjiesuanExample example);

    int deleteByExample(JungongjiesuanExample example);

    int deleteByPrimaryKey(String jungongjiesuanid);

    int insert(Jungongjiesuan record);

    int insertSelective(Jungongjiesuan record);

    List<Jungongjiesuan> selectByExample(JungongjiesuanExample example);

    Jungongjiesuan selectByPrimaryKey(String jungongjiesuanid);

    int updateByExampleSelective(@Param("record") Jungongjiesuan record, @Param("example") JungongjiesuanExample example);

    int updateByExample(@Param("record") Jungongjiesuan record, @Param("example") JungongjiesuanExample example);

    int updateByPrimaryKeySelective(Jungongjiesuan record);

    int updateByPrimaryKey(Jungongjiesuan record);
}