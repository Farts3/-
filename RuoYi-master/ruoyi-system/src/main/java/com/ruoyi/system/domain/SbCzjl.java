package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作记录对象 sb_czjl
 * 
 * @author y
 * @date 2022-12-13
 */
public class SbCzjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String sid;

    /** 标题 */
    @Excel(name = "标题")
    private String bt;

    /** 说明 */
    @Excel(name = "说明")
    private String sm;

    /** 添加时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tjdate;

    /** 添加人 */
    @Excel(name = "添加人")
    private String uname;

    /** 附件 */
    @Excel(name = "附件")
    private String fj;

    /** 主表id */
    @Excel(name = "主表id")
    private String sbid;

    private long userid;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "添加时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lrsj;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setBt(String bt) 
    {
        this.bt = bt;
    }

    public String getBt() 
    {
        return bt;
    }
    public void setSm(String sm) 
    {
        this.sm = sm;
    }

    public String getSm() 
    {
        return sm;
    }
    public void setTjdate(Date tjdate) 
    {
        this.tjdate = tjdate;
    }

    public Date getTjdate() 
    {
        return tjdate;
    }
    public void setUname(String uname) 
    {
        this.uname = uname;
    }

    public String getUname() 
    {
        return uname;
    }
    public void setFj(String fj) 
    {
        this.fj = fj;
    }

    public String getFj() 
    {
        return fj;
    }
    public void setSbid(String sbid) 
    {
        this.sbid = sbid;
    }

    public String getSbid() 
    {
        return sbid;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    public Date getLrsj() {
        return lrsj;
    }

    public void setLrsj(Date lrsj) {
        this.lrsj = lrsj;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("bt", getBt())
            .append("sm", getSm())
            .append("tjdate", getTjdate())
            .append("uname", getUname())
            .append("fj", getFj())
            .append("sbid", getSbid())
                .append("userid",getUserid())
                .append("lrsj",getLrsj())
            .toString();
    }
}
