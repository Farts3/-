package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SbJbxxMapper;
import com.ruoyi.system.domain.SbJbxx;
import com.ruoyi.system.service.ISbJbxxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 基本信息Service业务层处理
 * 
 * @author y
 * @date 2022-12-13
 */
@Service
public class SbJbxxServiceImpl implements ISbJbxxService 
{
    @Autowired
    private SbJbxxMapper sbJbxxMapper;

    /**
     * 查询基本信息
     * 
     * @param sid 基本信息主键
     * @return 基本信息
     */
    @Override
    public SbJbxx selectSbJbxxBySid(String sid)
    {
        return sbJbxxMapper.selectSbJbxxBySid(sid);
    }

    /**
     * 查询基本信息列表
     * 
     * @param sbJbxx 基本信息
     * @return 基本信息
     */
    @Override
    public List<SbJbxx> selectSbJbxxList(SbJbxx sbJbxx)
    {
        return sbJbxxMapper.selectSbJbxxList(sbJbxx);
    }

    /**
     * 新增基本信息
     * 
     * @param sbJbxx 基本信息
     * @return 结果
     */
    @Override
    public int insertSbJbxx(SbJbxx sbJbxx)
    {
        return sbJbxxMapper.insertSbJbxx(sbJbxx);
    }

    /**
     * 修改基本信息
     * 
     * @param sbJbxx 基本信息
     * @return 结果
     */
    @Override
    public int updateSbJbxx(SbJbxx sbJbxx)
    {
        return sbJbxxMapper.updateSbJbxx(sbJbxx);
    }

    /**
     * 批量删除基本信息
     * 
     * @param sids 需要删除的基本信息主键
     * @return 结果
     */
    @Override
    public int deleteSbJbxxBySids(String sids)
    {
        return sbJbxxMapper.deleteSbJbxxBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除基本信息信息
     * 
     * @param sid 基本信息主键
     * @return 结果
     */
    @Override
    public int deleteSbJbxxBySid(String sid)
    {
        return sbJbxxMapper.deleteSbJbxxBySid(sid);
    }
}
