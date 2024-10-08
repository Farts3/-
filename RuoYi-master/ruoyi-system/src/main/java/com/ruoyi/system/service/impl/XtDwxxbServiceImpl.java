package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.XtDwxxbMapper;
import com.ruoyi.system.domain.XtDwxxb;
import com.ruoyi.system.service.IXtDwxxbService;
import com.ruoyi.common.core.text.Convert;

/**
 * 单位管理Service业务层处理
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Service
public class XtDwxxbServiceImpl implements IXtDwxxbService 
{
    @Autowired
    private XtDwxxbMapper xtDwxxbMapper;

    /**
     * 查询单位管理
     * 
     * @param sid 单位管理主键
     * @return 单位管理
     */
    @Override
    public XtDwxxb selectXtDwxxbBySid(Long sid)
    {
        return xtDwxxbMapper.selectXtDwxxbBySid(sid);
    }

    /**
     * 查询单位管理列表
     * 
     * @param xtDwxxb 单位管理
     * @return 单位管理
     */
    @Override
    public List<XtDwxxb> selectXtDwxxbList(XtDwxxb xtDwxxb)
    {
        return xtDwxxbMapper.selectXtDwxxbList(xtDwxxb);
    }

    /**
     * 新增单位管理
     * 
     * @param xtDwxxb 单位管理
     * @return 结果
     */
    @Override
    public int insertXtDwxxb(XtDwxxb xtDwxxb)
    {
        return xtDwxxbMapper.insertXtDwxxb(xtDwxxb);
    }

    /**
     * 修改单位管理
     * 
     * @param xtDwxxb 单位管理
     * @return 结果
     */
    @Override
    public int updateXtDwxxb(XtDwxxb xtDwxxb)
    {
        return xtDwxxbMapper.updateXtDwxxb(xtDwxxb);
    }

    /**
     * 批量删除单位管理
     * 
     * @param sids 需要删除的单位管理主键
     * @return 结果
     */
    @Override
    public int deleteXtDwxxbBySids(String sids)
    {
        return xtDwxxbMapper.deleteXtDwxxbBySids(Convert.toStrArray(sids));
    }

    /**
     * 删除单位管理信息
     * 
     * @param sid 单位管理主键
     * @return 结果
     */
    @Override
    public int deleteXtDwxxbBySid(Long sid)
    {
        return xtDwxxbMapper.deleteXtDwxxbBySid(sid);
    }

    /**
     * 查询单位管理树列表
     * 
     * @return 所有单位管理信息
     */
    @Override
    public List<Ztree> selectXtDwxxbTree()
    {
        List<XtDwxxb> xtDwxxbList = xtDwxxbMapper.selectXtDwxxbList(new XtDwxxb());
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (XtDwxxb xtDwxxb : xtDwxxbList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(xtDwxxb.getSid());
            ztree.setpId(xtDwxxb.getSjdw());
            ztree.setName(xtDwxxb.getDwmc());
            ztree.setTitle(xtDwxxb.getDwmc());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    /**
     * 查询单位管理树列表
     *
     * @return 所有单位管理信息
     */
    @Override
    public List<Ztree> selectRYbTree()
    {
        List<XtDwxxb> xtDwxxbList = xtDwxxbMapper.selectRYbTree();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (XtDwxxb xtDwxxb : xtDwxxbList)
        {
            //sid, dwmc, sjdw
            Ztree ztree = new Ztree();
            ztree.setId(xtDwxxb.getSid());
            ztree.setpId(xtDwxxb.getSjdw());
            ztree.setName(xtDwxxb.getDwmc());
            ztree.setTitle(xtDwxxb.getDwmc());
            ztrees.add(ztree);
        }
        return ztrees;
    }

    @Override
    public  List<XtDwxxb> selectUser(){
        return xtDwxxbMapper.selectUser();
    }


    /**
     * 查询单位管理
     *
     * @param sid 单位管理主键
     * @return 单位管理
     */
    @Override
    public XtDwxxb finddwxx(Long sid)
    {
        return xtDwxxbMapper.finddwxx(sid);
    }
}
