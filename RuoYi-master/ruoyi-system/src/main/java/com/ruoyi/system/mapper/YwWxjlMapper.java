package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.YwWxjl;

/**
 * 维修单Mapper接口
 * 
 * @author hqq
 * @date 2023-02-06
 */
public interface YwWxjlMapper 
{
    /**
     * 查询维修单
     * 
     * @param sid 维修单主键
     * @return 维修单
     */
    public YwWxjl selectYwWxjlBySid(String sid);

    /**
     * 查询维修单列表
     * 
     * @param ywWxjl 维修单
     * @return 维修单集合
     */
    public List<YwWxjl> selectYwWxjlList(YwWxjl ywWxjl);

    /**
     * 查询维修单列表
     *
     * @param ywWxjl 维修单
     * @return 维修单集合
     */
    public List<YwWxjl> selectYwWxjlListhc(YwWxjl ywWxjl);

    /**
     * 新增维修单
     * 
     * @param ywWxjl 维修单
     * @return 结果
     */
    public int insertYwWxjl(YwWxjl ywWxjl);

    /**
     * 修改维修单
     * 
     * @param ywWxjl 维修单
     * @return 结果
     */
    public int updateYwWxjl(YwWxjl ywWxjl);

    /**
     * 删除维修单
     * 
     * @param sid 维修单主键
     * @return 结果
     */
    public int deleteYwWxjlBySid(String sid);

    /**
     * 批量删除维修单
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYwWxjlBySids(String[] sids);

    /**
     * 查询维修单列表
     *
     * @param ywWxjl 维修单
     * @return 维修单集合
     */
    public List<YwWxjl> selectYwWxjlListshhc(YwWxjl ywWxjl);

    public List<YwWxjl> selectYwWxjlListfl(YwWxjl ywWxjl);
}
