package jjjf.service;


import jjjf.dao.JunjianxiangmuMapper;
import jjjf.model.Junjianxiangmu;
import jjjf.model.JunjianxiangmuExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class JunjianxiangmuService {

    @Resource
    JunjianxiangmuMapper ddMapper;

    public List<Map<String, Object>> findXiangmuBydeptId(String ppxiangmuName,String ppdeptId, int ppPageIndex, int ppPageSize){
        int mmStartIndex = (ppPageIndex - 1) * ppPageSize;
        return ddMapper.findXiangmuBydeptId(ppxiangmuName,ppdeptId, mmStartIndex, ppPageSize);
    }

    public Integer getCountBydeptId(String ppxiangmuName,String ppdeptId) {
        Object mmCount = ddMapper.getCountBydeptId(ppxiangmuName,ppdeptId);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }

    public Junjianxiangmu findOne(String ppxiangmuId) {
        return ddMapper.selectByPrimaryKey(ppxiangmuId);
    }

    public boolean add(Junjianxiangmu ppJunjianxiangmu){
        return ddMapper.insert(ppJunjianxiangmu)==1;
    }

    public boolean modify(Junjianxiangmu ppJunjianxiangmu){
        return ddMapper.updateByPrimaryKeySelective(ppJunjianxiangmu)==1;
    }

    public boolean delete(String ppxiangmuId){
        return ddMapper.deleteByPrimaryKey(ppxiangmuId)==1;
    }


    public List<Junjianxiangmu> findByXiangmuMingcheng(String ppXiangmuMingcheng) {
        JunjianxiangmuExample mmExample=new JunjianxiangmuExample();
        mmExample.createCriteria().andXiangmunameEqualTo(ppXiangmuMingcheng).andZhuangtaiEqualTo(100);
        return ddMapper.selectByExample(mmExample);
    }


    public List<Map<String, Object>>searchXiangmu(String ppxiangmuName,String mmDeptName,
                                                  String mmXiangmuPifu,String mmJingfeixiadaqingkuang,
                                                  String mmJingfeikemu,String mmXiangmuzhuangtaiid,
                                                  String mmJiesuanzhuangtaiid,String mmJiesuanqingkuangid,
                                                  String mmxiangmuleibie,String mmbeizhu,
                                                  int mmStartIndex,int mmPageSize){
        int ppStartIndex = (mmStartIndex - 1) * mmPageSize;
        return ddMapper.searchXiangmu(ppxiangmuName,mmDeptName, mmXiangmuPifu, mmJingfeixiadaqingkuang,
                mmJingfeikemu,mmXiangmuzhuangtaiid,mmJiesuanzhuangtaiid,mmJiesuanqingkuangid,mmxiangmuleibie,mmbeizhu,
                ppStartIndex, mmPageSize);
    }
    public Integer getSearchXiangmuCount(String ppxiangmuName,String mmDeptName,
                                         String mmXiangmuPifu,String mmJingfeixiadaqingkuang,
                                         String mmJingfeikemu,String mmXiangmuzhuangtaiid,
                                         String mmJiesuanzhuangtaiid,String mmJiesuanqingkuangid,
                                         String mmxiangmuleibie,String mmbeizhu) {
        Object mmCount = ddMapper.getSearchXiangmuCount(ppxiangmuName,mmDeptName, mmXiangmuPifu, mmJingfeixiadaqingkuang,
                mmJingfeikemu,mmXiangmuzhuangtaiid,mmJiesuanzhuangtaiid,mmJiesuanqingkuangid,mmxiangmuleibie,mmbeizhu);
        return mmCount == null ? 0 : Integer.parseInt(mmCount.toString());
    }
}
