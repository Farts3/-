package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 耗材类型对象 xt_goods
 * 
 * @author hqq
 * @date 2024-09-06
 */
public class XtGoods extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** sid */
    private Long sid;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String goodsName;

    /** 编码 */
    @Excel(name = "编码")
    private String goodsBm;

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
    public void setGoodsName(String goodsName) 
    {
        this.goodsName = goodsName;
    }

    public String getGoodsName() 
    {
        return goodsName;
    }
    public void setGoodsBm(String goodsBm) 
    {
        this.goodsBm = goodsBm;
    }

    public String getGoodsBm() 
    {
        return goodsBm;
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
            .append("goodsName", getGoodsName())
            .append("goodsBm", getGoodsBm())
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
