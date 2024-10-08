package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.SbJbxx;

/**
 * 基本信息Mapper接口
 * 
 * @author y
 * @date 2022-12-13
 */
public interface SbJbxxMapper 
{
    /**
     * 查询基本信息
     * 
     * @param sid 基本信息主键
     * @return 基本信息
     */
    public SbJbxx selectSbJbxxBySid(String sid);

    /**
     * 查询基本信息列表
     * 
     * @param sbJbxx 基本信息
     * @return 基本信息集合
     */
    public List<SbJbxx> selectSbJbxxList(SbJbxx sbJbxx);

    /**
     * 新增基本信息
     * 
     * @param sbJbxx 基本信息
     * @return 结果
     */
    public int insertSbJbxx(SbJbxx sbJbxx);

    /**
     * 修改基本信息
     * 
     * @param sbJbxx 基本信息
     * @return 结果
     */
    public int updateSbJbxx(SbJbxx sbJbxx);

    /**
     * 删除基本信息
     * 
     * @param sid 基本信息主键
     * @return 结果
     */
    public int deleteSbJbxxBySid(String sid);

    /**
     * 批量删除基本信息
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSbJbxxBySids(String[] sids);
}
