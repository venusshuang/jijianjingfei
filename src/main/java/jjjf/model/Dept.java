package jjjf.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Dept {
    private String deptid;

    private String deptname;

    private String depttype;

    private String shangjideptid;

    private String sequencecode;

    private String creator;

    private Date createtime;

    private String modifier;

    private Date lastupdatetime;

    private Integer zhuangtai;

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDepttype() {
        return depttype;
    }

    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    public String getShangjideptid() {
        return shangjideptid;
    }

    public void setShangjideptid(String shangjideptid) {
        this.shangjideptid = shangjideptid;
    }

    public String getSequencecode() {
        return sequencecode;
    }

    public void setSequencecode(String sequencecode) {
        this.sequencecode = sequencecode;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreatetime() {
        return createtime;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getLastupdatetime() {
        return lastupdatetime;
    }
    @DateTimeFormat(pattern="yyyy-MM-dd")  // HH:mm:ss
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
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