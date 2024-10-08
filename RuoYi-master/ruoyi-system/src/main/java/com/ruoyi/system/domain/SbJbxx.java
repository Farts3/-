package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 基本信息对象 sb_jbxx
 * 
 * @author y
 * @date 2022-12-13
 */
public class SbJbxx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String sid;

    /** 型号品牌 */
    @Excel(name = "型号品牌")
    private String xhpp;

    /** 安装时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "安装时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date azdate;

    /** 产品id */
    @Excel(name = "产品id")
    private String cpid;

    /** 责任人 */
    @Excel(name = "责任人")
    private String zrr;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String iph;

    /** 紧急联系人 */
    @Excel(name = "紧急联系人")
    private String jjlxr;

    /** 所属单位 */
    @Excel(name = "所属单位")
    private String ssdw;

    /** 办公室 */
    @Excel(name = "办公室")
    private String bgs;

    /** 办公室负责人 */
    @Excel(name = "办公室负责人")
    private String bgsry;

    /** 负责人电话 */
    @Excel(name = "负责人电话")
    private String ip2;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String lx;

    private long userid;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setXhpp(String xhpp) 
    {
        this.xhpp = xhpp;
    }

    public String getXhpp() 
    {
        return xhpp;
    }
    public void setAzdate(Date azdate) 
    {
        this.azdate = azdate;
    }

    public Date getAzdate() 
    {
        return azdate;
    }
    public void setCpid(String cpid) 
    {
        this.cpid = cpid;
    }

    public String getCpid() 
    {
        return cpid;
    }
    public void setZrr(String zrr) 
    {
        this.zrr = zrr;
    }

    public String getZrr() 
    {
        return zrr;
    }
    public void setIph(String iph) 
    {
        this.iph = iph;
    }

    public String getIph() 
    {
        return iph;
    }
    public void setJjlxr(String jjlxr) 
    {
        this.jjlxr = jjlxr;
    }

    public String getJjlxr() 
    {
        return jjlxr;
    }
    public void setSsdw(String ssdw) 
    {
        this.ssdw = ssdw;
    }

    public String getSsdw() 
    {
        return ssdw;
    }
    public void setBgs(String bgs) 
    {
        this.bgs = bgs;
    }

    public String getBgs() 
    {
        return bgs;
    }
    public void setBgsry(String bgsry) 
    {
        this.bgsry = bgsry;
    }

    public String getBgsry() 
    {
        return bgsry;
    }
    public void setIp2(String ip2) 
    {
        this.ip2 = ip2;
    }

    public String getIp2() 
    {
        return ip2;
    }
    public void setLx(String lx) 
    {
        this.lx = lx;
    }

    public String getLx() 
    {
        return lx;
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
            .append("xhpp", getXhpp())
            .append("azdate", getAzdate())
            .append("cpid", getCpid())
            .append("zrr", getZrr())
            .append("iph", getIph())
            .append("jjlxr", getJjlxr())
            .append("ssdw", getSsdw())
            .append("bgs", getBgs())
            .append("bgsry", getBgsry())
            .append("ip2", getIp2())
            .append("lx", getLx())
                .append("userid",getUserid())
            .toString();
    }
}
