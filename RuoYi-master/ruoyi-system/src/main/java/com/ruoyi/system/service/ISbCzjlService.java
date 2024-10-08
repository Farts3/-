package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.SbCzjl;

/**
 * 操作记录Service接口
 * 
 * @author y
 * @date 2022-12-13
 */
public interface ISbCzjlService 
{
    /**
     * 查询操作记录
     * 
     * @param sid 操作记录主键
     * @return 操作记录
     */
    public SbCzjl selectSbCzjlBySid(String sid);

    /**
     * 查询操作记录列表
     * 
     * @param sbCzjl 操作记录
     * @return 操作记录集合
     */
    public List<SbCzjl> selectSbCzjlList(SbCzjl sbCzjl);

    /**
     * 新增操作记录
     * 
     * @param sbCzjl 操作记录
     * @return 结果
     */
    public int insertSbCzjl(SbCzjl sbCzjl);

    /**
     * 修改操作记录
     * 
     * @param sbCzjl 操作记录
     * @return 结果
     */
    public int updateSbCzjl(SbCzjl sbCzjl);

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的操作记录主键集合
     * @return 结果
     */
    public int deleteSbCzjlBySids(String sids);

    /**
     * 删除操作记录信息
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    public int deleteSbCzjlBySid(String sid);
}
