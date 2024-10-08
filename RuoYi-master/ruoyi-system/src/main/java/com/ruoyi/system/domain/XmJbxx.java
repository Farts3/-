package com.ruoyi.system.domain;

import java.util.List;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 基本信息对象 xm_jbxx
 * 
 * @author y
 * @date 2022-12-13
 */
public class XmJbxx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**  */
    private String sid;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String xmmc;

    /** 所属单位 */
    @Excel(name = "所属单位")
    private String ssdw;

    /** 立项时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "立项时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lxsj;

    /** 主要负责人 */
    @Excel(name = "主要负责人")
    private String fzr;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String ip1;

    /** 其他人员 */
    @Excel(name = "其他人员")
    private String qtry;

    private long userid;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setXmmc(String xmmc) 
    {
        this.xmmc = xmmc;
    }

    public String getXmmc() 
    {
        return xmmc;
    }
    public void setSsdw(String ssdw) 
    {
        this.ssdw = ssdw;
    }

    public String getSsdw() 
    {
        return ssdw;
    }
    public void setLxsj(Date lxsj) 
    {
        this.lxsj = lxsj;
    }

    public Date getLxsj() 
    {
        return lxsj;
    }
    public void setFzr(String fzr) 
    {
        this.fzr = fzr;
    }

    public String getFzr() 
    {
        return fzr;
    }
    public void setIp1(String ip1) 
    {
        this.ip1 = ip1;
    }

    public String getIp1() 
    {
        return ip1;
    }
    public void setQtry(String qtry) 
    {
        this.qtry = qtry;
    }

    public String getQtry() 
    {
        return qtry;
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
            .append("xmmc", getXmmc())
            .append("ssdw", getSsdw())
            .append("lxsj", getLxsj())
            .append("fzr", getFzr())
            .append("ip1", getIp1())
            .append("qtry", getQtry())
                .append("userid",getUserid())
            .toString();
    }
}
