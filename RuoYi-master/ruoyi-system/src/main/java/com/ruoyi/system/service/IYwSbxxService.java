package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.YwSbxx;

/**
 * 设备管理Service接口
 * 
 * @author hqq
 * @date 2023-02-06
 */
public interface IYwSbxxService 
{
    /**
     * 查询设备管理
     * 
     * @param sid 设备管理主键
     * @return 设备管理
     */
    public YwSbxx selectYwSbxxBySid(String sid);

    /**
     * 查询设备管理列表
     * 
     * @param ywSbxx 设备管理
     * @return 设备管理集合
     */
    public List<YwSbxx> selectYwSbxxList(YwSbxx ywSbxx);

    /**
     * 新增设备管理
     * 
     * @param ywSbxx 设备管理
     * @return 结果
     */
    public int insertYwSbxx(YwSbxx ywSbxx);

    /**
     * 修改设备管理
     * 
     * @param ywSbxx 设备管理
     * @return 结果
     */
    public int updateYwSbxx(YwSbxx ywSbxx);

    /**
     * 批量删除设备管理
     * 
     * @param sids 需要删除的设备管理主键集合
     * @return 结果
     */
    public int deleteYwSbxxBySids(String sids);

    /**
     * 删除设备管理信息
     * 
     * @param sid 设备管理主键
     * @return 结果
     */
    public int deleteYwSbxxBySid(String sid);
}
