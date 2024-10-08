package com.ruoyi.system.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 耗材列表对象 xt_consumable
 * 
 * @author hqq
 * @date 2024-09-06
 */
public class XtConsumable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** sid */
    private Long sid;

    /** 耗材名称 */
    @Excel(name = "耗材名称")
    private String cName;

    /** 耗材型号 */
    @Excel(name = "耗材型号")
    private String cXh;

    /** 耗材颜色 */
    @Excel(name = "耗材颜色")
    private String cCor;

    /** 耗材价格 */
    @Excel(name = "耗材价格")
    private BigDecimal cMoney;

    /** 数量 */
    @Excel(name = "数量")
    private Long cNum;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal cSmoney;

    /** 预留1 */
    private String yu1;

    /** 预留2 */
    private String yu2;

    /** 预留3 */
    private String yu3;

    /** 预留4 */
    private String yu4;

    /** 预留5 */
    private String yu5;

    /** 预留6 */
    private String yu6;

    /** 预留7 */
    private String yu7;

    public void setSid(Long sid) 
    {
        this.sid = sid;
    }

    public Long getSid() 
    {
        return sid;
    }
    public void setcName(String cName) 
    {
        this.cName = cName;
    }

    public String getcName() 
    {
        return cName;
    }
    public void setcXh(String cXh) 
    {
        this.cXh = cXh;
    }

    public String getcXh() 
    {
        return cXh;
    }
    public void setcCor(String cCor) 
    {
        this.cCor = cCor;
    }

    public String getcCor() 
    {
        return cCor;
    }
    public void setcMoney(BigDecimal cMoney) 
    {
        this.cMoney = cMoney;
    }

    public BigDecimal getcMoney() 
    {
        return cMoney;
    }
    public void setcNum(Long cNum) 
    {
        this.cNum = cNum;
    }

    public Long getcNum() 
    {
        return cNum;
    }
    public void setcSmoney(BigDecimal cSmoney) 
    {
        this.cSmoney = cSmoney;
    }

    public BigDecimal getcSmoney() 
    {
        return cSmoney;
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
            .append("cName", getcName())
            .append("cXh", getcXh())
            .append("cCor", getcCor())
            .append("cMoney", getcMoney())
            .append("cNum", getcNum())
            .append("cSmoney", getcSmoney())
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
