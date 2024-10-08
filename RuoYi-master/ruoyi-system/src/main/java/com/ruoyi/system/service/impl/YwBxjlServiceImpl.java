package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwBxjlMapper;
import com.ruoyi.system.domain.YwBxjl;
import com.ruoyi.system.service.IYwBxjlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报修单Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Service
public class YwBxjlServiceImpl implements IYwBxjlService 
{
    @Autowired
    private YwBxjlMapper ywBxjlMapper;

    /**
     * 查询报修单
     * 
     * @param sid 报修单主键
     * @return 报修单
     */
    @Override
    public YwBxjl selectYwBxjlBySid(String sid)
    {
        return ywBxjlMapper.selectYwBxjlBySid(sid);
    }

    /**
     * 查询报修单列表
     * 
     * @param ywBxjl 报修单
     * @return 报修单
     */
    @Override
    public List<YwBxjl> selectYwBxjlList(YwBxjl ywBxjl)
    {
        return ywBxjlMapper.selectYwBxjlList(ywBxjl);
    }

    /**
     * 查询报修单列表
     *
     * @param ywBxjl 报修单
     * @return 报修单
     */
    @Override
    public List<YwBxjl> selectWDList(YwBxjl ywBxjl)
    {
        return ywBxjlMapper.selectWDList(ywBxjl);
    }

    /**
     * 新增报修单
     * 
     * @param ywBxjl 报修单
     * @return 结果
     */
    @Override
    public int insertYwBxjl(YwBxjl ywBxjl)
    {
        return ywBxjlMapper.insertYwBxjl(ywBxjl);
    }

    /**
     * 修改报修单
     * 
     * @param ywBxjl 报修单
     * @return 结果
     */
    @Override
    public int updateYwBxjl(YwBxjl ywBxjl)
    {
        return ywBxjlMapper.updateYwBxjl(ywBxjl);
    }

    /**
     * 批量删除报修单
     * 
     * @param sids 需要删除的报修单主键
     * @return 结果
     */
    @Override
    public int deleteYwBxjlBySids(String sids)
    {
        return ywBxjlMapper.deleteYwBxjlBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除报修单信息
     * 
     * @param sid 报修单主键
     * @return 结果
     */
    @Override
    public int deleteYwBxjlBySid(String sid)
    {
        return ywBxjlMapper.deleteYwBxjlBySid(sid);
    }
}
