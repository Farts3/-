package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.system.domain.XtConsumable;
import com.ruoyi.system.domain.YwPdjl;
import com.ruoyi.system.domain.YwWxjl;
import com.ruoyi.system.service.IXtConsumableService;
import com.ruoyi.system.service.IYwWxjlService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.YwYsjlb;
import com.ruoyi.system.service.IYwYsjlbService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 验收记录Controller
 * 
 * @author hqq
 * @date 2023-02-07
 */
@Controller
@RequestMapping("/system/ysjlbxx")
public class YwYsjlbController extends BaseController
{
    private String prefix = "system/ysjlbxx";

    @Autowired
    private IYwYsjlbService ywYsjlbService;

    @GetMapping()
    public String ysjlbxx()
    {
        return prefix + "/ysjlbxx";
    }

    /**
     * 查询验收记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwYsjlb ywYsjlb)
    {
        startPage();
        List<YwYsjlb> list = ywYsjlbService.selectYwYsjlbList(ywYsjlb);
        return getDataTable(list);
    }

    /**
     * 导出验收记录列表
     */
    @Log(title = "验收记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwYsjlb ywYsjlb)
    {
        List<YwYsjlb> list = ywYsjlbService.selectYwYsjlbList(ywYsjlb);
        ExcelUtil<YwYsjlb> util = new ExcelUtil<YwYsjlb>(YwYsjlb.class);
        return util.exportExcel(list, "验收记录数据");
    }

    /**
     * 新增验收记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }



    @Autowired
    private IYwWxjlService ywWxjlService;
    @Autowired
    private IXtConsumableService xtConsumableService;
    /**
     * 新增保存验收记录
     */
    @Log(title = "验收记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwYsjlb ywYsjlb)
    {
        //填表前先删除前面的记录
        ywYsjlbService.deleteys(ywYsjlb.getWxid());
        ywYsjlb.setSid(UUID.randomUUID().toString().replace("-",""));
        ywYsjlb.setTbr(getUserId()+"");
        ywYsjlb.setTbsj(new Date());
        //如果我的维修单  退回切耗材完整则自动入库
        YwWxjl wx=ywWxjlService.selectYwWxjlBySid(ywYsjlb.getWxid());
        //得到本次修理的耗材名称及耗材数量
        XtConsumable xtConsumable=xtConsumableService.selectXtConsumableBySid(Long.parseLong(wx.getYu4()));
        if(ywYsjlb.getYu1().equals("是")&&ywYsjlb.getYu2().equals("是")){
            xtConsumable.setcNum(xtConsumable.getcNum()+Long.parseLong(wx.getYu5()));
            xtConsumableService.updateXtConsumable(xtConsumable);
        }
        //不退回的不用管
        //退回 不完整 则进入废料库
        if(ywYsjlb.getYu1().equals("是")&&ywYsjlb.getYu2().equals("否")){
            wx.setYu6("1");
            ywWxjlService.updateYwWxjl(wx);
        }
        return toAjax(ywYsjlbService.insertYwYsjlb(ywYsjlb));
    }

    /**
     * 新增保存验收记录
     */
    @PostMapping("/yszf/{sid}")
    @ResponseBody
    public void yszf(@PathVariable("sid") String sid)
    {
        YwYsjlb ywYsjlb=ywYsjlbService.selectYwYsjlbByyszfSid(sid);
        //如果我的维修单  退回切耗材完整则自动入库
        YwWxjl wx=ywWxjlService.selectYwWxjlBySid(sid);
        //得到本次修理的耗材名称及耗材数量
        XtConsumable xtConsumable=xtConsumableService.selectXtConsumableBySid(Long.parseLong(wx.getYu4()));
        if(ywYsjlb.getYu1().equals("是")&&ywYsjlb.getYu2().equals("是")){
            xtConsumable.setcNum(xtConsumable.getcNum()-Long.parseLong(wx.getYu5()));
            xtConsumableService.updateXtConsumable(xtConsumable);
        }
        //不退回的不用管
        //退回 不完整 则进入废料库
        if(ywYsjlb.getYu1().equals("是")&&ywYsjlb.getYu2().equals("否")){
            wx.setYu6("0");
            ywWxjlService.updateYwWxjl(wx);
        }
        ywYsjlbService.deleteys(ywYsjlb.getWxid());
    }



    /**
     * 修改验收记录
     */
    @GetMapping("/ysdchakan/{sid}")
    public String ysdchakan(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwYsjlb ywYsjlb=ywYsjlbService.selectYwYsjlbByyszfSid(sid);
        mmap.put("ywYsjlb", ywYsjlb);
        return prefix + "/edit";
    }

    /**
     * 修改验收记录
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwYsjlb ywYsjlb = ywYsjlbService.selectYwYsjlbBySid(sid);
        mmap.put("ywYsjlb", ywYsjlb);
        return prefix + "/edit";
    }

    /**
     * 修改保存验收记录
     */
    @Log(title = "验收记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwYsjlb ywYsjlb)
    {
        return toAjax(ywYsjlbService.updateYwYsjlb(ywYsjlb));
    }

    /**
     * 删除验收记录
     */
    @Log(title = "验收记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywYsjlbService.deleteYwYsjlbBySids(ids));
    }

    //验收结果
    @GetMapping("/jgys/{sid}")
    public String jgys(@PathVariable("sid") String sid, ModelMap mmap)
    {

        YwYsjlb ywYsjlb =new YwYsjlb();
        ywYsjlb.setWxid(sid);
        mmap.put("ywYsjlb", ywYsjlb);
        return prefix + "/jgys";
    }

}
