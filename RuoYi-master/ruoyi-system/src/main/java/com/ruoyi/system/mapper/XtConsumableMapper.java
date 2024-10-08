package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XtConsumable;

/**
 * 耗材列表Mapper接口
 * 
 * @author hqq
 * @date 2024-09-06
 */
public interface XtConsumableMapper 
{
    /**
     * 查询耗材列表
     * 
     * @param sid 耗材列表主键
     * @return 耗材列表
     */
    public XtConsumable selectXtConsumableBySid(Long sid);

    /**
     * 查询耗材列表列表
     * 
     * @param xtConsumable 耗材列表
     * @return 耗材列表集合
     */
    public List<XtConsumable> selectXtConsumableList(XtConsumable xtConsumable);

    /**
     * 新增耗材列表
     * 
     * @param xtConsumable 耗材列表
     * @return 结果
     */
    public int insertXtConsumable(XtConsumable xtConsumable);

    /**
     * 修改耗材列表
     * 
     * @param xtConsumable 耗材列表
     * @return 结果
     */
    public int updateXtConsumable(XtConsumable xtConsumable);

    /**
     * 删除耗材列表
     * 
     * @param sid 耗材列表主键
     * @return 结果
     */
    public int deleteXtConsumableBySid(Long sid);

    /**
     * 批量删除耗材列表
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXtConsumableBySids(String[] sids);
}
