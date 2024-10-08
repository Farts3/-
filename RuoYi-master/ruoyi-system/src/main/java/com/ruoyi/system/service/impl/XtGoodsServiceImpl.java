package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XtGoodsMapper;
import com.ruoyi.system.domain.XtGoods;
import com.ruoyi.system.service.IXtGoodsService;
import com.ruoyi.common.core.text.Convert;

/**
 * 耗材类型Service业务层处理
 * 
 * @author hqq
 * @date 2024-09-06
 */
@Service
public class XtGoodsServiceImpl implements IXtGoodsService 
{
    @Autowired
    private XtGoodsMapper xtGoodsMapper;

    /**
     * 查询耗材类型
     * 
     * @param sid 耗材类型主键
     * @return 耗材类型
     */
    @Override
    public XtGoods selectXtGoodsBySid(Long sid)
    {
        return xtGoodsMapper.selectXtGoodsBySid(sid);
    }

    /**
     * 查询耗材类型列表
     * 
     * @param xtGoods 耗材类型
     * @return 耗材类型
     */
    @Override
    public List<XtGoods> selectXtGoodsList(XtGoods xtGoods)
    {
        return xtGoodsMapper.selectXtGoodsList(xtGoods);
    }

    /**
     * 新增耗材类型
     * 
     * @param xtGoods 耗材类型
     * @return 结果
     */
    @Override
    public int insertXtGoods(XtGoods xtGoods)
    {
        return xtGoodsMapper.insertXtGoods(xtGoods);
    }

    /**
     * 修改耗材类型
     * 
     * @param xtGoods 耗材类型
     * @return 结果
     */
    @Override
    public int updateXtGoods(XtGoods xtGoods)
    {
        return xtGoodsMapper.updateXtGoods(xtGoods);
    }

    /**
     * 批量删除耗材类型
     * 
     * @param sids 需要删除的耗材类型主键
     * @return 结果
     */
    @Override
    public int deleteXtGoodsBySids(String sids)
    {
        return xtGoodsMapper.deleteXtGoodsBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除耗材类型信息
     * 
     * @param sid 耗材类型主键
     * @return 结果
     */
    @Override
    public int deleteXtGoodsBySid(Long sid)
    {
        return xtGoodsMapper.deleteXtGoodsBySid(sid);
    }
}
