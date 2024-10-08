package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwWxjlMapper;
import com.ruoyi.system.domain.YwWxjl;
import com.ruoyi.system.service.IYwWxjlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 维修单Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Service
public class YwWxjlServiceImpl implements IYwWxjlService 
{
    @Autowired
    private YwWxjlMapper ywWxjlMapper;

    /**
     * 查询维修单
     * 
     * @param sid 维修单主键
     * @return 维修单
     */
    @Override
    public YwWxjl selectYwWxjlBySid(String sid)
    {
        return ywWxjlMapper.selectYwWxjlBySid(sid);
    }

    /**
     * 查询维修单列表
     * 
     * @param ywWxjl 维修单
     * @return 维修单
     */
    @Override
    public List<YwWxjl> selectYwWxjlList(YwWxjl ywWxjl)
    {
        return ywWxjlMapper.selectYwWxjlList(ywWxjl);
    }

    /**
     * 查询维修单(耗材)列表
     *
     * @param ywWxjl 维修单
     * @return 维修单
     */
    @Override
    public List<YwWxjl> selectYwWxjlListhc(YwWxjl ywWxjl)
    {

        return ywWxjlMapper.selectYwWxjlListhc(ywWxjl);
    }

    /**
     * 查询维修单(耗材)列表
     *
     * @param ywWxjl 维修单
     * @return 维修单
     */
    @Override
    public List<YwWxjl> selectYwWxjlListshhc(YwWxjl ywWxjl)
    {

        return ywWxjlMapper.selectYwWxjlListshhc(ywWxjl);
    }

    @Override
    public List<YwWxjl> selectYwWxjlListfl(YwWxjl ywWxjl)
    {

        return ywWxjlMapper.selectYwWxjlListfl(ywWxjl);
    }

    /**
     * 新增维修单
     * 
     * @param ywWxjl 维修单
     * @return 结果
     */
    @Override
    public int insertYwWxjl(YwWxjl ywWxjl)
    {
        return ywWxjlMapper.insertYwWxjl(ywWxjl);
    }

    /**
     * 修改维修单
     * 
     * @param ywWxjl 维修单
     * @return 结果
     */
    @Override
    public int updateYwWxjl(YwWxjl ywWxjl)
    {
        return ywWxjlMapper.updateYwWxjl(ywWxjl);
    }

    /**
     * 批量删除维修单
     * 
     * @param sids 需要删除的维修单主键
     * @return 结果
     */
    @Override
    public int deleteYwWxjlBySids(String sids)
    {
        return ywWxjlMapper.deleteYwWxjlBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除维修单信息
     * 
     * @param sid 维修单主键
     * @return 结果
     */
    @Override
    public int deleteYwWxjlBySid(String sid)
    {
        return ywWxjlMapper.deleteYwWxjlBySid(sid);
    }
}
