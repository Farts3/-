package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 报修单对象 yw_bxjl
 * 
 * @author hqq
 * @date 2023-02-06
 */
public class YwBxjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String sid;

    /** 报修单位 */
    @Excel(name = "报修单位")
    private String bxDw;

    /** 报修部门 */
    @Excel(name = "报修部门")
    private String bxBm;

    /** 故障类型 */
    @Excel(name = "故障类型")
    private String bxLx;

    /** 故障问题 */
    @Excel(name = "故障问题")
    private String bxWt;

    /** 报修姓名 */
    @Excel(name = "报修姓名")
    private String bxXm;

    /** 报修电话 */
    @Excel(name = "报修电话")
    private String bxDh;

    /** 预留1 */
    @Excel(name = "预留1")
    private String yu1;

    /** 预留2 */
    @Excel(name = "预留2")
    private String yu2;

    /** 预留3 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date yu3;

    /** 预留4 */
    @Excel(name = "预留4")
    private String yu4;

    /** 预留5 */
    @Excel(name = "预留5")
    private String yu5;

    /** 预留6 */
    @Excel(name = "预留6")
    private String yu16;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setBxDw(String bxDw) 
    {
        this.bxDw = bxDw;
    }

    public String getBxDw() 
    {
        return bxDw;
    }
    public void setBxBm(String bxBm) 
    {
        this.bxBm = bxBm;
    }

    public String getBxBm() 
    {
        return bxBm;
    }
    public void setBxLx(String bxLx) 
    {
        this.bxLx = bxLx;
    }

    public String getBxLx() 
    {
        return bxLx;
    }
    public void setBxWt(String bxWt) 
    {
        this.bxWt = bxWt;
    }

    public String getBxWt() 
    {
        return bxWt;
    }
    public void setBxXm(String bxXm) 
    {
        this.bxXm = bxXm;
    }

    public String getBxXm() 
    {
        return bxXm;
    }
    public void setBxDh(String bxDh) 
    {
        this.bxDh = bxDh;
    }

    public String getBxDh() 
    {
        return bxDh;
    }
    public void setYu1(String yu1) 
    {
        this.yu1 = yu1;
    }

    public String getYu1() 
    {
        return yu1;
    }
    public void setYu2(String yu2) 
    {
        this.yu2 = yu2;
    }

    public String getYu2() 
    {
        return yu2;
    }
    public void setYu3(Date yu3)
    {
        this.yu3 = yu3;
    }

    public Date getYu3()
    {
        return yu3;
    }
    public void setYu4(String yu4) 
    {
        this.yu4 = yu4;
    }

    public String getYu4() 
    {
        return yu4;
    }
    public void setYu5(String yu5) 
    {
        this.yu5 = yu5;
    }

    public String getYu5() 
    {
        return yu5;
    }
    public void setYu16(String yu16) 
    {
        this.yu16 = yu16;
    }

    public String getYu16() 
    {
        return yu16;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("bxDw", getBxDw())
            .append("bxBm", getBxBm())
            .append("bxLx", getBxLx())
            .append("bxWt", getBxWt())
            .append("bxXm", getBxXm())
            .append("bxDh", getBxDh())
            .append("yu1", getYu1())
            .append("yu2", getYu2())
            .append("yu3", getYu3())
            .append("yu4", getYu4())
            .append("yu5", getYu5())
            .append("yu16", getYu16())
            .toString();
    }
}
