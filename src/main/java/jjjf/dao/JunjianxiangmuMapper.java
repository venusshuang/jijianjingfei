package jjjf.dao;

import java.util.List;
import java.util.Map;

import jjjf.model.Junjianxiangmu;
import jjjf.model.JunjianxiangmuExample;
import org.apache.ibatis.annotations.Param;

public interface JunjianxiangmuMapper {


    List<Map<String, Object>> findXiangmuBydeptId(@Param("xiangmuname") String mmXiangmuName,@Param("deptid") String mmDeptId, @Param("startindex") int mmStartIndex,
                                                  @Param("pagesize") int mmPageSize);

    Object getCountBydeptId(@Param("xiangmuname") String mmXiangmuName,@Param("deptid") String mmDeptId);


    List<Map<String, Object>> searchXiangmu(@Param("xiangmuname") String mmXiangmuName,@Param("deptname") String mmDeptName,
                                            @Param("xiangmupifu") String mmXiangmuPifu, @Param("jingfeixiadaqingkuang") String mmJingfeixiadaqingkuang,
                                            @Param("jingfeikemu") String mmJingfeikemu,@Param("xiangmuzhuangtaiid") String mmXiangmuzhuangtaiid,
                                            @Param("jiesuanzhuangtaiid") String mmJiesuanzhuangtaiid,@Param("jiesuanqingkuangid") String mmJiesuanqingkuangid,
                                            @Param("startindex") int mmStartIndex,@Param("pagesize") int mmPageSize);
    Object getSearchXiangmuCount(@Param("xiangmuname") String mmXiangmuName,@Param("deptname") String mmDeptName,
                                 @Param("xiangmupifu") String mmXiangmuPifu, @Param("jingfeixiadaqingkuang") String mmJingfeixiadaqingkuang,
                                 @Param("jingfeikemu") String mmJingfeikemu,@Param("xiangmuzhuangtaiid") String mmXiangmuzhuangtaiid,
                                 @Param("jiesuanzhuangtaiid") String mmJiesuanzhuangtaiid,@Param("jiesuanqingkuangid") String mmJiesuanqingkuangid);


    int countByExample(JunjianxiangmuExample example);

    int deleteByExample(JunjianxiangmuExample example);

    int deleteByPrimaryKey(String xiangmuid);

    int insert(Junjianxiangmu record);

    int insertSelective(Junjianxiangmu record);

    List<Junjianxiangmu> selectByExample(JunjianxiangmuExample example);

    Junjianxiangmu selectByPrimaryKey(String xiangmuid);

    int updateByExampleSelective(@Param("record") Junjianxiangmu record, @Param("example") JunjianxiangmuExample example);

    int updateByExample(@Param("record") Junjianxiangmu record, @Param("example") JunjianxiangmuExample example);

    int updateByPrimaryKeySelective(Junjianxiangmu record);

    int updateByPrimaryKey(Junjianxiangmu record);
}