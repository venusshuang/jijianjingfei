package jjjf.dao;

import java.util.List;
import jjjf.model.Jingfeiyusuan;
import jjjf.model.JingfeiyusuanExample;
import org.apache.ibatis.annotations.Param;

public interface JingfeiyusuanMapper {
    int countByExample(JingfeiyusuanExample example);

    int deleteByExample(JingfeiyusuanExample example);

    int deleteByPrimaryKey(String jingfeiyuansuanid);

    int insert(Jingfeiyusuan record);

    int insertSelective(Jingfeiyusuan record);

    List<Jingfeiyusuan> selectByExample(JingfeiyusuanExample example);

    Jingfeiyusuan selectByPrimaryKey(String jingfeiyuansuanid);

    int updateByExampleSelective(@Param("record") Jingfeiyusuan record, @Param("example") JingfeiyusuanExample example);

    int updateByExample(@Param("record") Jingfeiyusuan record, @Param("example") JingfeiyusuanExample example);

    int updateByPrimaryKeySelective(Jingfeiyusuan record);

    int updateByPrimaryKey(Jingfeiyusuan record);
}