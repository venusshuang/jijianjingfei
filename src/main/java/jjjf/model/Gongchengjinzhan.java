package jjjf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Gongchengjinzhan {
    private String gongchengjinzhanid;

    private String xiangmuid;

    private String xiangmuzhuangtaiid;

    private Date kaigongshijian;

    private Double hetongzongjia;

    private Double wangchengtouzi;

    private Double jindukuaizhifu;

    private String jindukuanbili;

    private Date wangongshijian;

    private String creater;

    private Date createtime;

    private String modifier;

    private Date lastupdatetime;

    private Integer zhuangtai;

    public String getGongchengjinzhanid() {
        return gongchengjinzhanid;
    }

    public void setGongchengjinzhanid(String gongchengjinzhanid) {
        this.gongchengjinzhanid = gongchengjinzhanid;
    }

    public String getXiangmuid() {
        return xiangmuid;
    }

    public void setXiangmuid(String xiangmuid) {
        this.xiangmuid = xiangmuid;
    }

    public String getXiangmuzhuangtaiid() {
        return xiangmuzhuangtaiid;
    }

    public void setXiangmuzhuangtaiid(String xiangmuzhuangtaiid) {
        this.xiangmuzhuangtaiid = xiangmuzhuangtaiid;
    }

    @DateTimeFormat(pattern="yyyy-MM")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public Date getKaigongshijian() {
        return kaigongshijian;
    }

    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public void setKaigongshijian(Date kaigongshijian) {
        this.kaigongshijian = kaigongshijian;
    }

    public Double getHetongzongjia() {
        return hetongzongjia;
    }

    public void setHetongzongjia(Double hetongzongjia) {
        this.hetongzongjia = hetongzongjia;
    }

    public Double getWangchengtouzi() {
        return wangchengtouzi;
    }

    public void setWangchengtouzi(Double wangchengtouzi) {
        this.wangchengtouzi = wangchengtouzi;
    }

    public Double getJindukuaizhifu() {
        return jindukuaizhifu;
    }

    public void setJindukuaizhifu(Double jindukuaizhifu) {
        this.jindukuaizhifu = jindukuaizhifu;
    }

    public String getJindukuanbili() {
        return jindukuanbili;
    }

    public void setJindukuanbili(String jindukuanbili) {
        this.jindukuanbili = jindukuanbili;
    }

    @DateTimeFormat(pattern="yyyy-MM")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public Date getWangongshijian() {
        return wangongshijian;
    }

    @JsonFormat(pattern="yyyy-MM",timezone = "GMT+8")
    public void setWangongshijian(Date wangongshijian) {
        this.wangongshijian = wangongshijian;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public Integer getZhuangtai() {
        return zhuangtai;
    }

    public void setZhuangtai(Integer zhuangtai) {
        this.zhuangtai = zhuangtai;
    }
}