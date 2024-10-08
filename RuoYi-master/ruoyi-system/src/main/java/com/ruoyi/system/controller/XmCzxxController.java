package com.ruoyi.system.controller;

import java.util.List;
import java.util.UUID;

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
import com.ruoyi.system.domain.XmCzxx;
import com.ruoyi.system.service.IXmCzxxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作记录Controller
 * 
 * @author ruoyi
 * @date 2022-12-13
 */
@Controller
@RequestMapping("/system/xmczxx")
public class XmCzxxController extends BaseController
{
    private String prefix = "system/xmczxx";

    @Autowired
    private IXmCzxxService xmCzxxService;

    @GetMapping()
    public String xmczxx()
    {
        return prefix + "/xmczxx";
    }

    /**
     * 查询操作记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XmCzxx xmCzxx)
    {
        startPage();
        List<XmCzxx> list = xmCzxxService.selectXmCzxxList(xmCzxx);
        return getDataTable(list);
    }



    /**
     * 查询操作记录列表
     */
    @PostMapping("/listid")
    @ResponseBody
    public TableDataInfo listid(XmCzxx xmCzxx)
    {
        startPage();
        List<XmCzxx> list = xmCzxxService.selectXmCzxxList(xmCzxx);
        return getDataTable(list);
    }



    /**
     * 导出操作记录列表
     */
    @Log(title = "操作记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XmCzxx xmCzxx)
    {
        List<XmCzxx> list = xmCzxxService.selectXmCzxxList(xmCzxx);
        ExcelUtil<XmCzxx> util = new ExcelUtil<XmCzxx>(XmCzxx.class);
        return util.exportExcel(list, "操作记录数据");
    }

    /**
     * 新增操作记录
     */
    @GetMapping("/add")
    public String add()
    {

        return prefix + "/add";
    }

    /**
     * 新增字典类型
     */
    @GetMapping("/add/{xmid}")
    public String add(@PathVariable("xmid") String xmid, ModelMap mmap)
    {
        mmap.put("xmid", xmid);
        return prefix + "/add";
    }

    /**
     * 新增保存操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XmCzxx xmCzxx)
    {
        xmCzxx.setSid(UUID.randomUUID().toString().replace("-",""));
        xmCzxx.setUserid(getUserId());
        return toAjax(xmCzxxService.insertXmCzxx(xmCzxx));
    }

    /**
     * 修改操作记录
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        XmCzxx xmCzxx = xmCzxxService.selectXmCzxxBySid(sid);
        mmap.put("xmCzxx", xmCzxx);
        return prefix + "/edit";
    }

    /**
     * 修改保存操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XmCzxx xmCzxx)
    {
        return toAjax(xmCzxxService.updateXmCzxx(xmCzxx));
    }

    /**
     * 删除操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xmCzxxService.deleteXmCzxxBySids(ids));
    }
}
