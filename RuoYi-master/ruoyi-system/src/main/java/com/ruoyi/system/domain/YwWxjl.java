package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 维修单对象 yw_wxjl
 * 
 * @author hqq
 * @date 2023-02-06
 */
public class YwWxjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** sid */
    private Long sid;

    /** 维修问题 */
    @Excel(name = "维修问题")
    private String wxwt;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String cljg;

    /** 是否更换设备 */
    private String ifghsb;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private String clzt;

    /** 维修时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "维修时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date wxsj;

    /** 维修人员 */
    @Excel(name = "维修人员")
    private String wxry;

    /** 填表人 */
    @Excel(name = "填表人")
    private String tbr;

    /** 填表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbsj;

    /** 预留1 */
    @Excel(name = "预留1")
    private String yu1;

    /** 预留2 */
    @Excel(name = "是否验收合格")
    private String yu2;

    /** 预留3 */
    @Excel(name = "验收人")
    private String yu3;

    /** 预留4 */
    @Excel(name = "验收人电话")
    private String yu4;

    /** 预留5 */
    @Excel(name ="验收时间")
    private String yu5;

    /** 预留6 */
    @Excel(name = "预留6")
    private String yu6;

    /** 预留7 */
    @Excel(name = "预留7")
    private String yu7;

    /** 预留8 */
    @Excel(name = "预留8")
    private String yu8;

    /** 预留9 */
    @Excel(name = "预留9")
    private String yu9;

    public void setSid(Long sid)
    {
        this.sid = sid;
    }

    public Long getSid()
    {
        return sid;
    }
    public void setWxwt(String wxwt) 
    {
        this.wxwt = wxwt;
    }

    public String getWxwt() 
    {
        return wxwt;
    }
    public void setCljg(String cljg) 
    {
        this.cljg = cljg;
    }

    public String getCljg() 
    {
        return cljg;
    }
    public void setIfghsb(String ifghsb) 
    {
        this.ifghsb = ifghsb;
    }

    public String getIfghsb() 
    {
        return ifghsb;
    }
    public void setClzt(String clzt) 
    {
        this.clzt = clzt;
    }

    public String getClzt() 
    {
        return clzt;
    }
    public void setWxsj(Date wxsj) 
    {
        this.wxsj = wxsj;
    }

    public Date getWxsj() 
    {
        return wxsj;
    }
    public void setWxry(String wxry) 
    {
        this.wxry = wxry;
    }

    public String getWxry() 
    {
        return wxry;
    }
    public void setTbr(String tbr) 
    {
        this.tbr = tbr;
    }

    public String getTbr() 
    {
        return tbr;
    }
    public void setTbsj(Date tbsj)
    {
        this.tbsj = tbsj;
    }

    public Date getTbsj()
    {
        return tbsj;
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
    public void setYu8(String yu8) 
    {
        this.yu8 = yu8;
    }

    public String getYu8() 
    {
        return yu8;
    }
    public void setYu9(String yu9) 
    {
        this.yu9 = yu9;
    }

    public String getYu9() 
    {
        return yu9;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("wxwt", getWxwt())
            .append("cljg", getCljg())
            .append("ifghsb", getIfghsb())
            .append("clzt", getClzt())
            .append("wxsj", getWxsj())
            .append("wxry", getWxry())
            .append("tbr", getTbr())
            .append("tbsj", getTbsj())
            .append("yu1", getYu1())
            .append("yu2", getYu2())
            .append("yu3", getYu3())
            .append("yu4", getYu4())
            .append("yu5", getYu5())
            .append("yu6", getYu6())
            .append("yu7", getYu7())
            .append("yu8", getYu8())
            .append("yu9", getYu9())
            .toString();
    }
}
