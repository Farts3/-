package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XmCzxx;

/**
 * 操作记录Mapper接口
 * 
 * @author ruoyi
 * @date 2022-12-13
 */
public interface XmCzxxMapper 
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
     * 删除操作记录
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    public int deleteXmCzxxBySid(String sid);

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXmCzxxBySids(String[] sids);
}
