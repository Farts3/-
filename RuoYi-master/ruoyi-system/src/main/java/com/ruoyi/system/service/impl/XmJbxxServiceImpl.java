package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmJbxxMapper;
import com.ruoyi.system.domain.XmJbxx;
import com.ruoyi.system.service.IXmJbxxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 基本信息Service业务层处理
 * 
 * @author y
 * @date 2022-12-13
 */
@Service
public class XmJbxxServiceImpl implements IXmJbxxService 
{
    @Autowired
    private XmJbxxMapper xmJbxxMapper;

    /**
     * 查询基本信息
     * 
     * @param sid 基本信息主键
     * @return 基本信息
     */
    @Override
    public XmJbxx selectXmJbxxBySid(String sid)
    {
        return xmJbxxMapper.selectXmJbxxBySid(sid);
    }

    /**
     * 查询基本信息列表
     * 
     * @param xmJbxx 基本信息
     * @return 基本信息
     */
    @Override
    public List<XmJbxx> selectXmJbxxList(XmJbxx xmJbxx)
    {
        return xmJbxxMapper.selectXmJbxxList(xmJbxx);
    }

    /**
     * 新增基本信息
     * 
     * @param xmJbxx 基本信息
     * @return 结果
     */
    @Override
    public int insertXmJbxx(XmJbxx xmJbxx)
    {
        return xmJbxxMapper.insertXmJbxx(xmJbxx);
    }

    /**
     * 修改基本信息
     * 
     * @param xmJbxx 基本信息
     * @return 结果
     */
    @Override
    public int updateXmJbxx(XmJbxx xmJbxx)
    {
        return xmJbxxMapper.updateXmJbxx(xmJbxx);
    }

    /**
     * 批量删除基本信息
     * 
     * @param sids 需要删除的基本信息主键
     * @return 结果
     */
    @Override
    public int deleteXmJbxxBySids(String sids)
    {
        return xmJbxxMapper.deleteXmJbxxBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除基本信息信息
     * 
     * @param sid 基本信息主键
     * @return 结果
     */
    @Override
    public int deleteXmJbxxBySid(String sid)
    {
        return xmJbxxMapper.deleteXmJbxxBySid(sid);
    }
}
