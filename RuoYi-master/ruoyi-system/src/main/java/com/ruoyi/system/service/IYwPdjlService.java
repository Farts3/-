package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.system.domain.YwPdjl;

/**
 * 派单记录Service接口
 * 
 * @author hqq
 * @date 2023-02-07
 */
public interface IYwPdjlService 
{
    /**
     * 查询派单记录
     * 
     * @param sid 派单记录主键
     * @return 派单记录
     */
    public YwPdjl selectYwPdjlBySid(String sid);

    /**
     * 查询派单记录列表
     * 
     * @param ywPdjl 派单记录
     * @return 派单记录集合
     */
    public List<YwPdjl> selectYwPdjlList(YwPdjl ywPdjl);


    /**
     * 新增派单记录
     * 
     * @param ywPdjl 派单记录
     * @return 结果
     */
    public int insertYwPdjl(YwPdjl ywPdjl);

    /**
     * 修改派单记录
     * 
     * @param ywPdjl 派单记录
     * @return 结果
     */
    public int updateYwPdjl(YwPdjl ywPdjl);

    /**
     * 批量删除派单记录
     * 
     * @param sids 需要删除的派单记录主键集合
     * @return 结果
     */
    public int deleteYwPdjlBySids(String sids);

    /**
     * 删除派单记录信息
     * 
     * @param sid 派单记录主键
     * @return 结果
     */
    public int deleteYwPdjlBySid(String sid);


}
