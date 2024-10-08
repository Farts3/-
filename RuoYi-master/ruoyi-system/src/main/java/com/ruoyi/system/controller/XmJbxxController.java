package com.ruoyi.system.controller;

import java.util.List;
import java.util.UUID;

import com.ruoyi.system.service.IXmCzxxService;
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
import com.ruoyi.system.domain.XmJbxx;
import com.ruoyi.system.service.IXmJbxxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 基本信息Controller
 * 
 * @author y
 * @date 2022-12-13
 */
@Controller
@RequestMapping("/system/xmjbxxa")
public class XmJbxxController extends BaseController
{
    private String prefix = "system/xmjbxxa";

    @Autowired
    private IXmJbxxService xmJbxxService;
    @Autowired
    private IXmCzxxService IXmCzxxService;

    @RequiresPermissions("system:xmjbxxa:view")
    @GetMapping()
    public String xmjbxxa()
    {
        return prefix + "/xmjbxxa";
    }

    /**
     * 查询基本信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(XmJbxx xmJbxx)
    {
        if(!getSysUser().getRoles().get(0).getRoleName().contains("管理员")) {
            xmJbxx.setUserid(getUserId());
        }
        startPage();
        List<XmJbxx> list = xmJbxxService.selectXmJbxxList(xmJbxx);
        return getDataTable(list);
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/czjl/{dictId}")
    public String detail(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("XmJbxx", xmJbxxService.selectXmJbxxBySid(dictId));
        return prefix+"/data";
    }

    /**
     * 导出基本信息列表
     */
    @Log(title = "基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XmJbxx xmJbxx)
    {
        List<XmJbxx> list = xmJbxxService.selectXmJbxxList(xmJbxx);
        ExcelUtil<XmJbxx> util = new ExcelUtil<XmJbxx>(XmJbxx.class);
        return util.exportExcel(list, "基本信息数据");
    }

    /**
     * 新增基本信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存基本信息
     */
    @Log(title = "基本信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XmJbxx xmJbxx)
    {
        xmJbxx.setSid(UUID.randomUUID().toString().replace("-",""));
        xmJbxx.setUserid(getUserId());
        return toAjax(xmJbxxService.insertXmJbxx(xmJbxx));
    }

    /**
     * 修改基本信息
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        XmJbxx xmJbxx = xmJbxxService.selectXmJbxxBySid(sid);
        mmap.put("xmJbxx", xmJbxx);
        return prefix + "/edit";
    }

    /**
     * 修改保存基本信息
     */
    @Log(title = "基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XmJbxx xmJbxx)
    {
        return toAjax(xmJbxxService.updateXmJbxx(xmJbxx));
    }

    /**
     * 删除基本信息
     */
    @Log(title = "基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(xmJbxxService.deleteXmJbxxBySids(ids));
    }
}
