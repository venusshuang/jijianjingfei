package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Gongchengjinzhan;
import jjjf.model.GongchengjinzhanExample;
import org.apache.ibatis.annotations.Param;

public interface GongchengjinzhanMapper {

    List<Map<String, Object>> findGongchengjinzhanBydeptId(@Param("xiangmuname") String mmXiangmuName, @Param("deptid") String mmDeptId, @Param("startindex") int mmStartIndex,
                                                           @Param("pagesize") int mmPageSize);

    Object getCountBydeptId(@Param("xiangmuname") String mmXiangmuName,@Param("deptid") String mmDeptId);





    int countByExample(GongchengjinzhanExample example);

    int deleteByExample(GongchengjinzhanExample example);

    int deleteByPrimaryKey(String gongchengjinzhanid);

    int insert(Gongchengjinzhan record);

    int insertSelective(Gongchengjinzhan record);

    List<Gongchengjinzhan> selectByExample(GongchengjinzhanExample example);

    Gongchengjinzhan selectByPrimaryKey(String gongchengjinzhanid);

    int updateByExampleSelective(@Param("record") Gongchengjinzhan record, @Param("example") GongchengjinzhanExample example);

    int updateByExample(@Param("record") Gongchengjinzhan record, @Param("example") GongchengjinzhanExample example);

    int updateByPrimaryKeySelective(Gongchengjinzhan record);

    int updateByPrimaryKey(Gongchengjinzhan record);
}