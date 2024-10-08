package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XtGoods;

/**
 * 耗材类型Mapper接口
 * 
 * @author hqq
 * @date 2024-09-06
 */
public interface XtGoodsMapper 
{
    /**
     * 查询耗材类型
     * 
     * @param sid 耗材类型主键
     * @return 耗材类型
     */
    public XtGoods selectXtGoodsBySid(Long sid);

    /**
     * 查询耗材类型列表
     * 
     * @param xtGoods 耗材类型
     * @return 耗材类型集合
     */
    public List<XtGoods> selectXtGoodsList(XtGoods xtGoods);

    /**
     * 新增耗材类型
     * 
     * @param xtGoods 耗材类型
     * @return 结果
     */
    public int insertXtGoods(XtGoods xtGoods);

    /**
     * 修改耗材类型
     * 
     * @param xtGoods 耗材类型
     * @return 结果
     */
    public int updateXtGoods(XtGoods xtGoods);

    /**
     * 删除耗材类型
     * 
     * @param sid 耗材类型主键
     * @return 结果
     */
    public int deleteXtGoodsBySid(Long sid);

    /**
     * 批量删除耗材类型
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXtGoodsBySids(String[] sids);
}
