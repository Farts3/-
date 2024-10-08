package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.XtDwxxb;
import com.ruoyi.common.core.domain.Ztree;

/**
 * 单位管理Service接口
 * 
 * @author hqq
 * @date 2023-02-06
 */
public interface IXtDwxxbService 
{
    public XtDwxxb finddwxx(Long sid) ;

    /**
     * 查询单位管理
     * 
     * @param sid 单位管理主键
     * @return 单位管理
     */
    public XtDwxxb selectXtDwxxbBySid(Long sid);

    /**
     * 查询单位管理列表
     * 
     * @param xtDwxxb 单位管理
     * @return 单位管理集合
     */
    public List<XtDwxxb> selectXtDwxxbList(XtDwxxb xtDwxxb);

    /**
     * 新增单位管理
     * 
     * @param xtDwxxb 单位管理
     * @return 结果
     */
    public int insertXtDwxxb(XtDwxxb xtDwxxb);

    /**
     * 修改单位管理
     * 
     * @param xtDwxxb 单位管理
     * @return 结果
     */
    public int updateXtDwxxb(XtDwxxb xtDwxxb);

    /**
     * 批量删除单位管理
     * 
     * @param sids 需要删除的单位管理主键集合
     * @return 结果
     */
    public int deleteXtDwxxbBySids(String sids);

    /**
     * 删除单位管理信息
     * 
     * @param sid 单位管理主键
     * @return 结果
     */
    public int deleteXtDwxxbBySid(Long sid);

    /**
     * 查询单位管理树列表
     * 
     * @return 所有单位管理信息
     */
    public List<Ztree> selectXtDwxxbTree();

    public List<Ztree> selectRYbTree();

    public  List<XtDwxxb> selectUser();
}
