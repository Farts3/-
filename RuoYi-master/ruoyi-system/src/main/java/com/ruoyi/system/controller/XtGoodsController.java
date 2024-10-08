package com.ruoyi.system.controller;

import java.util.List;
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
import com.ruoyi.system.domain.XtGoods;
import com.ruoyi.system.service.IXtGoodsService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 耗材类型Controller
 * 
 * @author hqq
 * @date 2024-09-06
 */
@Controller
@RequestMapping("/system/goods")
public class XtGoodsController extends BaseController
{
    private String prefix = "system/goods";

    @Autowired
    private IXtGoodsService xtGoodsService;

    @RequiresPermissions("system:goods:view")
    @GetMapping()
    public String goods()
    {
        return prefix + "/goods";
    }

    /**
     * 查询耗材类型列表
     */
    @RequiresPermissions("system:goods:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XtGoods xtGoods)
    {
        startPage();
        List<XtGoods> list = xtGoodsService.selectXtGoodsList(xtGoods);
        return getDataTable(list);
    }

    /**
     * 导出耗材类型列表
     */
    @RequiresPermissions("system:goods:export")
    @Log(title = "耗材类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtGoods xtGoods)
    {
        List<XtGoods> list = xtGoodsService.selectXtGoodsList(xtGoods);
        ExcelUtil<XtGoods> util = new ExcelUtil<XtGoods>(XtGoods.class);
        return util.exportExcel(list, "耗材类型数据");
    }

    /**
     * 新增耗材类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存耗材类型
     */
    @RequiresPermissions("system:goods:add")
    @Log(title = "耗材类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtGoods xtGoods)
    {
        return toAjax(xtGoodsService.insertXtGoods(xtGoods));
    }

    /**
     * 修改耗材类型
     */
    @RequiresPermissions("system:goods:edit")
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        XtGoods xtGoods = xtGoodsService.selectXtGoodsBySid(sid);
        mmap.put("xtGoods", xtGoods);
        return prefix + "/edit";
    }

    /**
     * 修改保存耗材类型
     */
    @RequiresPermissions("system:goods:edit")
    @Log(title = "耗材类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtGoods xtGoods)
    {
        return toAjax(xtGoodsService.updateXtGoods(xtGoods));
    }

    /**
     * 删除耗材类型
     */
    @RequiresPermissions("system:goods:remove")
    @Log(title = "耗材类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xtGoodsService.deleteXtGoodsBySids(ids));
    }
}
