package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XmCzxxMapper;
import com.ruoyi.system.domain.XmCzxx;
import com.ruoyi.system.service.IXmCzxxService;
import com.ruoyi.common.core.text.Convert;

/**
 * 操作记录Service业务层处理
 * 
 * @author hqq
 * @date 2022-12-13
 */
@Service
public class XmCzxxServiceImpl implements IXmCzxxService 
{
    @Autowired
    private XmCzxxMapper xmCzxxMapper;

    /**
     * 查询操作记录
     * 
     * @param sid 操作记录主键
     * @return 操作记录
     */
    @Override
    public XmCzxx selectXmCzxxBySid(String sid)
    {
        return xmCzxxMapper.selectXmCzxxBySid(sid);
    }

    /**
     * 查询操作记录列表
     * 
     * @param xmCzxx 操作记录
     * @return 操作记录
     */
    @Override
    public List<XmCzxx> selectXmCzxxList(XmCzxx xmCzxx)
    {
        return xmCzxxMapper.selectXmCzxxList(xmCzxx);
    }

    /**
     * 新增操作记录
     * 
     * @param xmCzxx 操作记录
     * @return 结果
     */
    @Override
    public int insertXmCzxx(XmCzxx xmCzxx)
    {
        return xmCzxxMapper.insertXmCzxx(xmCzxx);
    }

    /**
     * 修改操作记录
     * 
     * @param xmCzxx 操作记录
     * @return 结果
     */
    @Override
    public int updateXmCzxx(XmCzxx xmCzxx)
    {
        return xmCzxxMapper.updateXmCzxx(xmCzxx);
    }

    /**
     * 批量删除操作记录
     * 
     * @param sids 需要删除的操作记录主键
     * @return 结果
     */
    @Override
    public int deleteXmCzxxBySids(String sids)
    {
        return xmCzxxMapper.deleteXmCzxxBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除操作记录信息
     * 
     * @param sid 操作记录主键
     * @return 结果
     */
    @Override
    public int deleteXmCzxxBySid(String sid)
    {
        return xmCzxxMapper.deleteXmCzxxBySid(sid);
    }
}
