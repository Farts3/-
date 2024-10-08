package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.YwYsjlb;

/**
 * 验收记录Mapper接口
 * 
 * @author hqq
 * @date 2023-02-07
 */
public interface YwYsjlbMapper 
{
    /**
     * 查询验收记录
     * 
     * @param sid 验收记录主键
     * @return 验收记录
     */
    public YwYsjlb selectYwYsjlbBySid(String sid);

    /**
     * 查询验收记录列表
     * 
     * @param ywYsjlb 验收记录
     * @return 验收记录集合
     */
    public List<YwYsjlb> selectYwYsjlbList(YwYsjlb ywYsjlb);

    /**
     * 新增验收记录
     * 
     * @param ywYsjlb 验收记录
     * @return 结果
     */
    public int insertYwYsjlb(YwYsjlb ywYsjlb);

    /**
     * 修改验收记录
     * 
     * @param ywYsjlb 验收记录
     * @return 结果
     */
    public int updateYwYsjlb(YwYsjlb ywYsjlb);

    /**
     * 删除验收记录
     * 
     * @param sid 验收记录主键
     * @return 结果
     */
    public int deleteYwYsjlbBySid(String sid);

    public int deleteys(String sid);

    /**
     * 批量删除验收记录
     * 
     * @param sids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteYwYsjlbBySids(String[] sids);

    public  YwYsjlb selectYwYsjlbByyszfSid(String sid);
}
