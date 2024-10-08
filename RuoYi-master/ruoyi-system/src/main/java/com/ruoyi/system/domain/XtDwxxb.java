package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 单位管理对象 xt_dwxxb
 * 
 * @author hqq
 * @date 2023-02-06
 */
public class XtDwxxb extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long sid;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 单位地址 */
    @Excel(name = "单位地址")
    private String dwdz;

    /** 上级单位 */
    @Excel(name = "上级单位")
    private Long sjdw;

    /** 填表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbsj;

    /** 填表人 */
    @Excel(name = "填表人")
    private String tbr;

    /** 维修次数 */
    @Excel(name = "维修次数")
    private Long wxcs;

    /** 报修次数 */
    @Excel(name = "报修次数")
    private Long bxcs;

    /** 预留1 */
    @Excel(name = "预留1")
    private String yu1;

    /** 预留2 */
    @Excel(name = "预留2")
    private String yu2;

    /** 预留3 */
    @Excel(name = "预留3")
    private String yu3;

    /** 预留4 */
    @Excel(name = "预留4")
    private String yu4;

    /** 预留5 */
    @Excel(name = "预留5")
    private String yu5;

    /** 预留6 */
    @Excel(name = "预留6")
    private String yu6;

    /** 预留7 */
    @Excel(name = "预留7")
    private String yu7;

    public void setSid(Long sid) 
    {
        this.sid = sid;
    }

    public Long getSid() 
    {
        return sid;
    }
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
    }
    public void setDwdz(String dwdz) 
    {
        this.dwdz = dwdz;
    }

    public String getDwdz() 
    {
        return dwdz;
    }
    public void setSjdw(Long sjdw) 
    {
        this.sjdw = sjdw;
    }

    public Long getSjdw() 
    {
        return sjdw;
    }
    public void setTbsj(Date tbsj) 
    {
        this.tbsj = tbsj;
    }

    public Date getTbsj() 
    {
        return tbsj;
    }
    public void setTbr(String tbr) 
    {
        this.tbr = tbr;
    }

    public String getTbr() 
    {
        return tbr;
    }
    public void setWxcs(Long wxcs) 
    {
        this.wxcs = wxcs;
    }

    public Long getWxcs() 
    {
        return wxcs;
    }
    public void setBxcs(Long bxcs) 
    {
        this.bxcs = bxcs;
    }

    public Long getBxcs() 
    {
        return bxcs;
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
    public void setYu3(String yu3) 
    {
        this.yu3 = yu3;
    }

    public String getYu3() 
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
    public void setYu6(String yu6) 
    {
        this.yu6 = yu6;
    }

    public String getYu6() 
    {
        return yu6;
    }
    public void setYu7(String yu7) 
    {
        this.yu7 = yu7;
    }

    public String getYu7() 
    {
        return yu7;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("dwmc", getDwmc())
            .append("dwdz", getDwdz())
            .append("sjdw", getSjdw())
            .append("tbsj", getTbsj())
            .append("tbr", getTbr())
            .append("wxcs", getWxcs())
            .append("bxcs", getBxcs())
            .append("yu1", getYu1())
            .append("yu2", getYu2())
            .append("yu3", getYu3())
            .append("yu4", getYu4())
            .append("yu5", getYu5())
            .append("yu6", getYu6())
            .append("yu7", getYu7())
            .toString();
    }
}
