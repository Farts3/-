package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwYsjlbMapper;
import com.ruoyi.system.domain.YwYsjlb;
import com.ruoyi.system.service.IYwYsjlbService;
import com.ruoyi.common.core.text.Convert;

/**
 * 验收记录Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-07
 */
@Service
public class YwYsjlbServiceImpl implements IYwYsjlbService 
{
    @Autowired
    private YwYsjlbMapper ywYsjlbMapper;

    /**
     * 查询验收记录
     * 
     * @param sid 验收记录主键
     * @return 验收记录
     */
    @Override
    public YwYsjlb selectYwYsjlbBySid(String sid)
    {
        return ywYsjlbMapper.selectYwYsjlbBySid(sid);
    }

    /**
     * 查询验收记录
     *
     * @param sid 验收记录主键
     * @return 验收记录
     */
    @Override
    public YwYsjlb selectYwYsjlbByyszfSid(String sid)
    {
        return ywYsjlbMapper.selectYwYsjlbByyszfSid(sid);
    }

    /**
     * 查询验收记录列表
     * 
     * @param ywYsjlb 验收记录
     * @return 验收记录
     */
    @Override
    public List<YwYsjlb> selectYwYsjlbList(YwYsjlb ywYsjlb)
    {
        return ywYsjlbMapper.selectYwYsjlbList(ywYsjlb);
    }

    /**
     * 新增验收记录
     * 
     * @param ywYsjlb 验收记录
     * @return 结果
     */
    @Override
    public int insertYwYsjlb(YwYsjlb ywYsjlb)
    {
        return ywYsjlbMapper.insertYwYsjlb(ywYsjlb);
    }

    /**
     * 修改验收记录
     * 
     * @param ywYsjlb 验收记录
     * @return 结果
     */
    @Override
    public int updateYwYsjlb(YwYsjlb ywYsjlb)
    {
        return ywYsjlbMapper.updateYwYsjlb(ywYsjlb);
    }

    /**
     * 批量删除验收记录
     * 
     * @param sids 需要删除的验收记录主键
     * @return 结果
     */
    @Override
    public int deleteYwYsjlbBySids(String sids)
    {
        return ywYsjlbMapper.deleteYwYsjlbBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除验收记录信息
     * 
     * @param sid 验收记录主键
     * @return 结果
     */
    @Override
    public int deleteYwYsjlbBySid(String sid)
    {
        return ywYsjlbMapper.deleteYwYsjlbBySid(sid);
    }

    @Override
    public int deleteys(String sid)
    {
        return ywYsjlbMapper.deleteys(sid);
    }
}
