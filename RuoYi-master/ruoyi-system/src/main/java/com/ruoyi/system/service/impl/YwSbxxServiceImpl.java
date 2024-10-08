package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.YwSbxxMapper;
import com.ruoyi.system.domain.YwSbxx;
import com.ruoyi.system.service.IYwSbxxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 设备管理Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Service
public class YwSbxxServiceImpl implements IYwSbxxService 
{
    @Autowired
    private YwSbxxMapper ywSbxxMapper;

    /**
     * 查询设备管理
     * 
     * @param sid 设备管理主键
     * @return 设备管理
     */
    @Override
    public YwSbxx selectYwSbxxBySid(String sid)
    {
        return ywSbxxMapper.selectYwSbxxBySid(sid);
    }

    /**
     * 查询设备管理列表
     * 
     * @param ywSbxx 设备管理
     * @return 设备管理
     */
    @Override
    public List<YwSbxx> selectYwSbxxList(YwSbxx ywSbxx)
    {
        return ywSbxxMapper.selectYwSbxxList(ywSbxx);
    }

    /**
     * 新增设备管理
     * 
     * @param ywSbxx 设备管理
     * @return 结果
     */
    @Override
    public int insertYwSbxx(YwSbxx ywSbxx)
    {
        return ywSbxxMapper.insertYwSbxx(ywSbxx);
    }

    /**
     * 修改设备管理
     * 
     * @param ywSbxx 设备管理
     * @return 结果
     */
    @Override
    public int updateYwSbxx(YwSbxx ywSbxx)
    {
        return ywSbxxMapper.updateYwSbxx(ywSbxx);
    }

    /**
     * 批量删除设备管理
     * 
     * @param sids 需要删除的设备管理主键
     * @return 结果
     */
    @Override
    public int deleteYwSbxxBySids(String sids)
    {
        return ywSbxxMapper.deleteYwSbxxBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除设备管理信息
     * 
     * @param sid 设备管理主键
     * @return 结果
     */
    @Override
    public int deleteYwSbxxBySid(String sid)
    {
        return ywSbxxMapper.deleteYwSbxxBySid(sid);
    }
}
