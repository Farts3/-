package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwPdjlMapper;
import com.ruoyi.system.domain.YwPdjl;
import com.ruoyi.system.service.IYwPdjlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 派单记录Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-07
 */
@Service
public class YwPdjlServiceImpl implements IYwPdjlService 
{
    @Autowired
    private YwPdjlMapper ywPdjlMapper;

    /**
     * 查询派单记录
     * 
     * @param sid 派单记录主键
     * @return 派单记录
     */
    @Override
    public YwPdjl selectYwPdjlBySid(String sid)
    {
        return ywPdjlMapper.selectYwPdjlBySid(sid);
    }

    /**
     * 查询派单记录列表
     * 
     * @param ywPdjl 派单记录
     * @return 派单记录
     */
    @Override
    public List<YwPdjl> selectYwPdjlList(YwPdjl ywPdjl)
    {
        return ywPdjlMapper.selectYwPdjlList(ywPdjl);
    }

    /**
     * 新增派单记录
     * 
     * @param ywPdjl 派单记录
     * @return 结果
     */
    @Override
    public int insertYwPdjl(YwPdjl ywPdjl)
    {
        return ywPdjlMapper.insertYwPdjl(ywPdjl);
    }

    /**
     * 修改派单记录
     * 
     * @param ywPdjl 派单记录
     * @return 结果
     */
    @Override
    public int updateYwPdjl(YwPdjl ywPdjl)
    {
        return ywPdjlMapper.updateYwPdjl(ywPdjl);
    }

    /**
     * 批量删除派单记录
     * 
     * @param sids 需要删除的派单记录主键
     * @return 结果
     */
    @Override
    public int deleteYwPdjlBySids(String sids)
    {
        return ywPdjlMapper.deleteYwPdjlBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除派单记录信息
     * 
     * @param sid 派单记录主键
     * @return 结果
     */
    @Override
    public int deleteYwPdjlBySid(String sid)
    {
        return ywPdjlMapper.deleteYwPdjlBySid(sid);
    }


}
