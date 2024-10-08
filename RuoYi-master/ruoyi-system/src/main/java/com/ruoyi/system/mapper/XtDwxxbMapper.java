package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.XtDwxxb;

/**
 * 单位管理Mapper接口
 * 
 * @author hqq
 * @date 2023-02-06
 */
public interface XtDwxxbMapper 
{
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
     * 删除单位管理
     * 
     * @param sid 单位管理主键
     * @return 结果
     */
    public int deleteXtDwxxbBySid(Long sid);

    /**
     * 批量删除单位管理
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteXtDwxxbBySids(String[] sids);

    public List<XtDwxxb> selectRYbTree();

    public  List<XtDwxxb> selectUser();

    public XtDwxxb finddwxx(Long sid);
}
