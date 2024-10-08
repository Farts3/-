package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.SbCzjlMapper;
import com.ruoyi.system.domain.SbCzjl;
import com.ruoyi.system.service.ISbCzjlService;
import com.ruoyi.common.core.text.Convert;

/**
 * 操作记录Service业务层处理
 * 
 * @author y
 * @date 2022-12-13
 */
@Service
public class SbCzjlServiceImpl implements ISbCzjlService 
{
    @Autowired
    private SbCzjlMapper sbCzjlMapper;

    /**
     * 查询操作记录
     * 
     * @param sid 操作记录主键
     * @return 操作记录
     */
    @Override
    public SbCzjl selectSbCzjlBySid(String sid)
    {
        return sbCzjlMapper.selectSbCzjlBySid(sid);
    }

    /**
     * 查询操作记录列表
     * 
     * @param sbCzjl 操作记录
     * @return 操作记录
     */
    @Override
    public List<SbCzjl> selectSbCzjlList(SbCzjl sbCzjl)
    {
        return sbCzjlMapper.selectSbCzjlList(sbCzjl);
    }

    /**
     * 新增操作记录
     * 
     * @param sbCzjl 操作记录
     * @return 结果
     */
    @Override
    public int insertSbCzjl(SbCzjl sbCzjl)
    {
        return sbCzjlMapper.insertSbCzjl(sbCzjl);
    }

    /**
     * 修改操作记录
     * 
     * @param sbCzjl 操作记录
     * @return 结果
     */
    @Override
    public int updateSbCzjl(SbCzjl sbCzjl)
    {
        return sbCzjlMapper.updateSbCzjl(sbCzjl);
    }

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的操作记录主键
     * @return 结果
     */
    @Override
    public int deleteSbCzjlBySids(String sids)
    {
        return sbCzjlMapper.deleteSbCzjlBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除操作记录信息
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    @Override
    public int deleteSbCzjlBySid(String sid)
    {
        return sbCzjlMapper.deleteSbCzjlBySid(sid);
    }
}
