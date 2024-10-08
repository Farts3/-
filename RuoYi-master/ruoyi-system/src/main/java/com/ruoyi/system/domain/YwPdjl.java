package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 派单记录对象 yw_pdjl
 * 
 * @author hqq
 * @date 2023-02-07
 */
public class YwPdjl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** sid */
    private String sid;

    /** 报修记录id */
    @Excel(name = "报修记录id")
    private String bxjlid;

    /** 派遣时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "派遣时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pqsj;

    /** 派遣人员 */
    @Excel(name = "派遣人员")
    private String pqry;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String lxdh;

    /** 填表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbsj;

    /** 填表人 */
    @Excel(name = "填表人")
    private String tbr;

    /** 预留1 */
    @Excel(name = "派遣人员id")
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

    /** 预留8 */
    @Excel(name = "预留8")
    private String yu8;

    public void setSid(String sid) 
    {
        this.sid = sid;
    }

    public String getSid() 
    {
        return sid;
    }
    public void setBxjlid(String bxjlid) 
    {
        this.bxjlid = bxjlid;
    }

    public String getBxjlid() 
    {
        return bxjlid;
    }
    public void setPqsj(Date pqsj) 
    {
        this.pqsj = pqsj;
    }

    public Date getPqsj() 
    {
        return pqsj;
    }
    public void setPqry(String pqry) 
    {
        this.pqry = pqry;
    }

    public String getPqry() 
    {
        return pqry;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("sid", getSid())
            .append("bxjlid", getBxjlid())
            .append("pqsj", getPqsj())
            .append("pqry", getPqry())
            .append("lxdh", getLxdh())
            .append("tbsj", getTbsj())
            .append("tbr", getTbr())
            .append("yu1", getYu1())
            .append("yu2", getYu2())
            .append("yu3", getYu3())
            .append("yu4", getYu4())
            .append("yu5", getYu5())
            .append("yu6", getYu6())
            .append("yu7", getYu7())
            .append("yu8", getYu8())
            .toString();
    }
}
