package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 操作记录对象 xm_czxx
 * 
 * @author hqq
 * @date 2022-12-13
 */
public class XmCzxx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String sid;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date kssj;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date jssj;

    /** 说明 */
    @Excel(name = "说明")
    private String sm;

    /** 标题 */
    @Excel(name = "标题")
    private String bt;

    /** 调表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbsj;

    /** 附件 */
    @Excel(name = "附件")
    private String fj;

    /** 项目id */
    @Excel(name = "项目id")
    private String xmid;

    private long userid;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setKssj(Date kssj) 
    {
        this.kssj = kssj;
    }

    public Date getKssj() 
    {
        return kssj;
    }
    public void setJssj(Date jssj) 
    {
        this.jssj = jssj;
    }

    public Date getJssj() 
    {
        return jssj;
    }
    public void setSm(String sm) 
    {
        this.sm = sm;
    }

    public String getSm() 
    {
        return sm;
    }
    public void setBt(String bt) 
    {
        this.bt = bt;
    }

    public String getBt() 
    {
        return bt;
    }
    public void setTbsj(Date tbsj) 
    {
        this.tbsj = tbsj;
    }

    public Date getTbsj() 
    {
        return tbsj;
    }
    public void setFj(String fj) 
    {
        this.fj = fj;
    }

    public String getFj() 
    {
        return fj;
    }
    public void setXmid(String xmid) 
    {
        this.xmid = xmid;
    }

    public String getXmid() 
    {
        return xmid;
    }
    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("kssj", getKssj())
            .append("jssj", getJssj())
            .append("sm", getSm())
            .append("bt", getBt())
            .append("tbsj", getTbsj())
            .append("fj", getFj())
            .append("xmid", getXmid())
                .append("userid",getUserid())
            .toString();
    }
}
