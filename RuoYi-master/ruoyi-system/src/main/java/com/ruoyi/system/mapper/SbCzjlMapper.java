package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SbCzjl;

/**
 * 操作记录Mapper接口
 * 
 * @author y
 * @date 2022-12-13
 */
public interface SbCzjlMapper 
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
     * 删除操作记录
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    public int deleteSbCzjlBySid(String sid);

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSbCzjlBySids(String[] sids);
}
