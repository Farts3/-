package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmCzxx;

/**
 * 操作记录Service接口
 * 
 * @author hqq
 * @date 2022-12-13
 */
public interface IXmCzxxService 
{
    /**
     * 查询操作记录
     * 
     * @param sid 操作记录主键
     * @return 操作记录
     */
    public XmCzxx selectXmCzxxBySid(String sid);

    /**
     * 查询操作记录列表
     * 
     * @param xmCzxx 操作记录
     * @return 操作记录集合
     */
    public List<XmCzxx> selectXmCzxxList(XmCzxx xmCzxx);

    /**
     * 新增操作记录
     * 
     * @param xmCzxx 操作记录
     * @return 结果
     */
    public int insertXmCzxx(XmCzxx xmCzxx);

    /**
     * 修改操作记录
     * 
     * @param xmCzxx 操作记录
     * @return 结果
     */
    public int updateXmCzxx(XmCzxx xmCzxx);

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的操作记录主键集合
     * @return 结果
     */
    public int deleteXmCzxxBySids(String sids);

    /**
     * 删除操作记录信息
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    public int deleteXmCzxxBySid(String sid);
}
