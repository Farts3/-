package com.ruoyi.system.controller;

import java.util.Date;
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
import com.ruoyi.system.domain.SbCzjl;
import com.ruoyi.system.service.ISbCzjlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 操作记录Controller
 * 
 * @author y
 * @date 2022-12-13
 */
@Controller
@RequestMapping("/system/sbczjl")
public class SbCzjlController extends BaseController
{
    private String prefix = "system/sbczjl";

    @Autowired
    private ISbCzjlService sbCzjlService;

    @GetMapping()
    public String sbczjl()
    {
        return prefix + "/sbczjl";
    }

    /**
     * 查询操作记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SbCzjl sbCzjl)
    {
        startPage();
        List<SbCzjl> list = sbCzjlService.selectSbCzjlList(sbCzjl);
        return getDataTable(list);
    }

    /**
     * 导出操作记录列表
     */
    @Log(title = "操作记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SbCzjl sbCzjl)
    {
        List<SbCzjl> list = sbCzjlService.selectSbCzjlList(sbCzjl);
        ExcelUtil<SbCzjl> util = new ExcelUtil<SbCzjl>(SbCzjl.class);
        return util.exportExcel(list, "操作记录数据");
    }

    /**
     * 新增操作记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        mmap.put("tjdate", new Date());
        return prefix + "/add";
    }

    /**
     * 新增保存操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SbCzjl sbCzjl)
    {
        sbCzjl.setUserid(getUserId());
        sbCzjl.setSid(UUID.randomUUID().toString().replace("-",""));
        sbCzjl.setLrsj(new Date());
        return toAjax(sbCzjlService.insertSbCzjl(sbCzjl));
    }



    /**
     * 新增字典类型
     */
    @GetMapping("/add/{sbid}")
    public String add(@PathVariable("sbid") String sbid, ModelMap mmap)
    {
        System.out.println(sbid);
        mmap.put("sbid", sbid);
        mmap.put("tjdate", new Date());
        return prefix + "/add";
    }

    /**
     * 修改操作记录
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        SbCzjl sbCzjl = sbCzjlService.selectSbCzjlBySid(sid);
        mmap.put("sbCzjl", sbCzjl);
        return prefix + "/edit";
    }

    /**
     * 修改保存操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SbCzjl sbCzjl)
    {
        return toAjax(sbCzjlService.updateSbCzjl(sbCzjl));
    }

    /**
     * 删除操作记录
     */
    @Log(title = "操作记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sbCzjlService.deleteSbCzjlBySids(ids));
    }
}
