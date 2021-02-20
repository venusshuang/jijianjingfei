package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Zijinbaozhang;
import jjjf.model.ZijinbaozhangExample;
import org.apache.ibatis.annotations.Param;

public interface ZijinbaozhangMapper {

    List<Map<String, Object>> findZijinbaozhangBydeptId(@Param("xiangmuname") String mmXiangmuName, @Param("deptid") String mmDeptId, @Param("startindex") int mmStartIndex,
                                                           @Param("pagesize") int mmPageSize);

    Object getCountBydeptId(@Param("xiangmuname") String mmXiangmuName,@Param("deptid") String mmDeptId);





    int countByExample(ZijinbaozhangExample example);

    int deleteByExample(ZijinbaozhangExample example);

    int deleteByPrimaryKey(String zijinbaozhangid);

    int insert(Zijinbaozhang record);

    int insertSelective(Zijinbaozhang record);

    List<Zijinbaozhang> selectByExample(ZijinbaozhangExample example);

    Zijinbaozhang selectByPrimaryKey(String zijinbaozhangid);

    int updateByExampleSelective(@Param("record") Zijinbaozhang record, @Param("example") ZijinbaozhangExample example);

    int updateByExample(@Param("record") Zijinbaozhang record, @Param("example") ZijinbaozhangExample example);

    int updateByPrimaryKeySelective(Zijinbaozhang record);

    int updateByPrimaryKey(Zijinbaozhang record);
}