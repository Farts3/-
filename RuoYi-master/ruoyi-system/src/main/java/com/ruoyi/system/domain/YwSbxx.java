package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 设备管理对象 yw_sbxx
 * 
 * @author hqq
 * @date 2023-02-06
 */
public class YwSbxx extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String sid;

    /** 单位名称 */
    @Excel(name = "单位名称")
    private String dwmc;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String sbnc;

    /** 设备类型 */
    @Excel(name = "设备类型")
    private String sblx;

    /** 设备型号 */
    @Excel(name = "经销商")
    private String sbxh;

    /** 序列号 */
    private String xlh;

    /** 软件名称 */
    private String rjmc;

    /** 对应激活码 */
    private String jhm;

    /** 售后服务时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date shsj;

    /** 密级 */
    @Excel(name = "密级")
    private String mj;

    /** 采购时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "销售时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cgsj;

    /** 过保时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "过保时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date gbsj;

    /** 地址 */
    @Excel(name = "地址")
    private String dz;

    /** 备注 */
    @Excel(name = "备注")
    private String bc;

    /** 单位联系人 */
    @Excel(name = "单位联系人")
    private String lxr;

    /** 电话 */
    @Excel(name = "电话")
    private String lxdh;

    /** 报修次数 */
    @Excel(name = "报修次数")
    private Long bxcs;

    /** 维修次数 */
    @Excel(name = "维修次数")
    private Long wxcs;

    /** 填表时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "填表时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date tbsj;

    /** 填表人 */
    @Excel(name = "填表人")
    private String tbr;

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
    public void setDwmc(String dwmc) 
    {
        this.dwmc = dwmc;
    }

    public String getDwmc() 
    {
        return dwmc;
    }
    public void setSbnc(String sbnc) 
    {
        this.sbnc = sbnc;
    }

    public String getSbnc() 
    {
        return sbnc;
    }
    public void setSblx(String sblx) 
    {
        this.sblx = sblx;
    }

    public String getSblx() 
    {
        return sblx;
    }
    public void setSbxh(String sbxh) 
    {
        this.sbxh = sbxh;
    }

    public String getSbxh() 
    {
        return sbxh;
    }
    public void setXlh(String xlh) 
    {
        this.xlh = xlh;
    }

    public String getXlh() 
    {
        return xlh;
    }
    public void setRjmc(String rjmc) 
    {
        this.rjmc = rjmc;
    }

    public String getRjmc() 
    {
        return rjmc;
    }
    public void setJhm(String jhm) 
    {
        this.jhm = jhm;
    }

    public String getJhm() 
    {
        return jhm;
    }
    public void setShsj(Date shsj) 
    {
        this.shsj = shsj;
    }

    public Date getShsj() 
    {
        return shsj;
    }
    public void setMj(String mj) 
    {
        this.mj = mj;
    }

    public String getMj() 
    {
        return mj;
    }
    public void setCgsj(Date cgsj) 
    {
        this.cgsj = cgsj;
    }

    public Date getCgsj() 
    {
        return cgsj;
    }
    public void setGbsj(Date gbsj) 
    {
        this.gbsj = gbsj;
    }

    public Date getGbsj() 
    {
        return gbsj;
    }
    public void setDz(String dz) 
    {
        this.dz = dz;
    }

    public String getDz() 
    {
        return dz;
    }
    public void setBc(String bc) 
    {
        this.bc = bc;
    }

    public String getBc() 
    {
        return bc;
    }
    public void setLxr(String lxr) 
    {
        this.lxr = lxr;
    }

    public String getLxr() 
    {
        return lxr;
    }
    public void setLxdh(String lxdh) 
    {
        this.lxdh = lxdh;
    }

    public String getLxdh() 
    {
        return lxdh;
    }
    public void setBxcs(Long bxcs) 
    {
        this.bxcs = bxcs;
    }

    public Long getBxcs() 
    {
        return bxcs;
    }
    public void setWxcs(Long wxcs) 
    {
        this.wxcs = wxcs;
    }

    public Long getWxcs() 
    {
        return wxcs;
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
            .append("dwmc", getDwmc())
            .append("sbnc", getSbnc())
            .append("sblx", getSblx())
            .append("sbxh", getSbxh())
            .append("xlh", getXlh())
            .append("rjmc", getRjmc())
            .append("jhm", getJhm())
            .append("shsj", getShsj())
            .append("mj", getMj())
            .append("cgsj", getCgsj())
            .append("gbsj", getGbsj())
            .append("dz", getDz())
            .append("bc", getBc())
            .append("lxr", getLxr())
            .append("lxdh", getLxdh())
            .append("bxcs", getBxcs())
            .append("wxcs", getWxcs())
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
