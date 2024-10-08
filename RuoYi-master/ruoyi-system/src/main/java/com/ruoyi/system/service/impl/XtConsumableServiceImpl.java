package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XtConsumableMapper;
import com.ruoyi.system.domain.XtConsumable;
import com.ruoyi.system.service.IXtConsumableService;
import com.ruoyi.common.core.text.Convert;

/**
 * 耗材列表Service业务层处理
 * 
 * @author hqq
 * @date 2024-09-06
 */
@Service
public class XtConsumableServiceImpl implements IXtConsumableService 
{
    @Autowired
    private XtConsumableMapper xtConsumableMapper;

    /**
     * 查询耗材列表
     * 
     * @param sid 耗材列表主键
     * @return 耗材列表
     */
    @Override
    public XtConsumable selectXtConsumableBySid(Long sid)
    {
        return xtConsumableMapper.selectXtConsumableBySid(sid);
    }

    /**
     * 查询耗材列表列表
     * 
     * @param xtConsumable 耗材列表
     * @return 耗材列表
     */
    @Override
    public List<XtConsumable> selectXtConsumableList(XtConsumable xtConsumable)
    {
        return xtConsumableMapper.selectXtConsumableList(xtConsumable);
    }

    /**
     * 新增耗材列表
     * 
     * @param xtConsumable 耗材列表
     * @return 结果
     */
    @Override
    public int insertXtConsumable(XtConsumable xtConsumable)
    {
        return xtConsumableMapper.insertXtConsumable(xtConsumable);
    }

    /**
     * 修改耗材列表
     * 
     * @param xtConsumable 耗材列表
     * @return 结果
     */
    @Override
    public int updateXtConsumable(XtConsumable xtConsumable)
    {
        return xtConsumableMapper.updateXtConsumable(xtConsumable);
    }

    /**
     * 批量删除耗材列表
     * 
     * @param sids 需要删除的耗材列表主键
     * @return 结果
     */
    @Override
    public int deleteXtConsumableBySids(String sids)
    {
        return xtConsumableMapper.deleteXtConsumableBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除耗材列表信息
     * 
     * @param sid 耗材列表主键
     * @return 结果
     */
    @Override
    public int deleteXtConsumableBySid(Long sid)
    {
        return xtConsumableMapper.deleteXtConsumableBySid(sid);
    }
}
