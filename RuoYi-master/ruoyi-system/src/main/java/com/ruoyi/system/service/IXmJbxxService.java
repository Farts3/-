package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XmJbxx;

/**
 * 基本信息Service接口
 * 
 * @author y
 * @date 2022-12-13
 */
public interface IXmJbxxService 
{
    /**
     * 查询基本信息
     * 
     * @param sid 基本信息主键
     * @return 基本信息
     */
    public XmJbxx selectXmJbxxBySid(String sid);

    /**
     * 查询基本信息列表
     * 
     * @param xmJbxx 基本信息
     * @return 基本信息集合
     */
    public List<XmJbxx> selectXmJbxxList(XmJbxx xmJbxx);

    /**
     * 新增基本信息
     * 
     * @param xmJbxx 基本信息
     * @return 结果
     */
    public int insertXmJbxx(XmJbxx xmJbxx);

    /**
     * 修改基本信息
     * 
     * @param xmJbxx 基本信息
     * @return 结果
     */
    public int updateXmJbxx(XmJbxx xmJbxx);

    /**
     * 批量删除基本信息
     * 
     * @param sids 需要删除的基本信息主键集合
     * @return 结果
     */
    public int deleteXmJbxxBySids(String sids);

    /**
     * 删除基本信息信息
     * 
     * @param sid 基本信息主键
     * @return 结果
     */
    public int deleteXmJbxxBySid(String sid);
}
