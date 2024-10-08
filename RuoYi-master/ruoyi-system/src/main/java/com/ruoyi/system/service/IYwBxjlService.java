package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.YwBxjl;

/**
 * 报修单Service接口
 * 
 * @author hqq
 * @date 2023-02-06
 */
public interface IYwBxjlService 
{
    /**
     * 查询报修单
     * 
     * @param sid 报修单主键
     * @return 报修单
     */
    public YwBxjl selectYwBxjlBySid(String sid);

    /**
     * 查询报修单列表
     * 
     * @param ywBxjl 报修单
     * @return 报修单集合
     */
    public List<YwBxjl> selectYwBxjlList(YwBxjl ywBxjl);


    /**
     * 查询报修单列表
     *
     * @param ywBxjl 报修单
     * @return 报修单集合
     */
    public List<YwBxjl> selectWDList(YwBxjl ywBxjl);
    /**
     * 新增报修单
     * 
     * @param ywBxjl 报修单
     * @return 结果
     */
    public int insertYwBxjl(YwBxjl ywBxjl);

    /**
     * 修改报修单
     * 
     * @param ywBxjl 报修单
     * @return 结果
     */
    public int updateYwBxjl(YwBxjl ywBxjl);

    /**
     * 批量删除报修单
     * 
     * @param sids 需要删除的报修单主键集合
     * @return 结果
     */
    public int deleteYwBxjlBySids(String sids);

    /**
     * 删除报修单信息
     * 
     * @param sid 报修单主键
     * @return 结果
     */
    public int deleteYwBxjlBySid(String sid);

}
