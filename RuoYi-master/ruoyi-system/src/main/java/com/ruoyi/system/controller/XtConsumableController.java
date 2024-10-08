package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;

import com.ruoyi.system.domain.XtGoods;
import com.ruoyi.system.service.IXtGoodsService;
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
import com.ruoyi.system.domain.XtConsumable;
import com.ruoyi.system.service.IXtConsumableService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 耗材列表Controller
 * 
 * @author hqq
 * @date 2024-09-06
 */
@Controller
@RequestMapping("/system/consumable")
public class XtConsumableController extends BaseController
{
    private String prefix = "system/consumable";

    @Autowired
    private IXtConsumableService xtConsumableService;

    @RequiresPermissions("system:consumable:view")
    @GetMapping()
    public String consumable()
    {
        return prefix + "/consumable";
    }

    /**
     * 查询耗材列表列表
     */
    @RequiresPermissions("system:consumable:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtConsumable xtConsumable)
    {
        startPage();
        List<XtConsumable> list = xtConsumableService.selectXtConsumableList(xtConsumable);
        return getDataTable(list);
    }

    /**
     * 导出耗材列表列表
     */
    @RequiresPermissions("system:consumable:export")
    @Log(title = "耗材列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtConsumable xtConsumable)
    {
        List<XtConsumable> list = xtConsumableService.selectXtConsumableList(xtConsumable);
        ExcelUtil<XtConsumable> util = new ExcelUtil<XtConsumable>(XtConsumable.class);
        return util.exportExcel(list, "耗材列表数据");
    }


    @Autowired
    private IXtGoodsService xtGoodsService;
    /**
     * 新增耗材列表
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        XtGoods xtGoods=new XtGoods();
        //将耗材类型已字典的方式给前台
        mmap.put("hclx", xtGoodsService.selectXtGoodsList(xtGoods));
        return prefix + "/add";
    }

    /**
     * 新增保存耗材列表
     */
    @RequiresPermissions("system:consumable:add")
    @Log(title = "耗材列表", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtConsumable xtConsumable)
    {
        return toAjax(xtConsumableService.insertXtConsumable(xtConsumable));
    }

    /**
     * 修改耗材列表
     */
    @RequiresPermissions("system:consumable:edit")
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        XtConsumable xtConsumable = xtConsumableService.selectXtConsumableBySid(sid);
        XtGoods xtGoods=new XtGoods();
        //将耗材类型已字典的方式给前台
        mmap.put("hclx", xtGoodsService.selectXtGoodsList(xtGoods));
        mmap.put("xtConsumable", xtConsumable);
        return prefix + "/edit";
    }

    /**
     * 修改保存耗材列表
     */
    @RequiresPermissions("system:consumable:edit")
    @Log(title = "耗材列表", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtConsumable xtConsumable)
    {
        return toAjax(xtConsumableService.updateXtConsumable(xtConsumable));
    }

    /**
     * 删除耗材列表
     */
    @RequiresPermissions("system:consumable:remove")
    @Log(title = "耗材列表", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtConsumableService.deleteXtConsumableBySids(ids));
    }
}
