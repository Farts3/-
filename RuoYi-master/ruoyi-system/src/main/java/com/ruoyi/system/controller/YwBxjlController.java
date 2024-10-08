package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.system.domain.XtDwxxb;
import com.ruoyi.system.domain.YwPdjl;
import com.ruoyi.system.domain.YwSbxx;
import com.ruoyi.system.service.IXtDwxxbService;
import com.ruoyi.system.service.IYwSbxxService;
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
import com.ruoyi.system.domain.YwBxjl;
import com.ruoyi.system.service.IYwBxjlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.xml.crypto.Data;

/**
 * 报修单Controller
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Controller
@RequestMapping("/system/bxdxx")
public class YwBxjlController extends BaseController
{
    private String prefix = "system/bxdxx";

    @Autowired
    private IYwBxjlService ywBxjlService;

    @GetMapping()
    public String bxdxx()
    {
        return prefix + "/bxdxx";
    }

    /**
     * 查询报修单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwBxjl ywBxjl)
    {
        startPage();
        List<YwBxjl> list = ywBxjlService.selectYwBxjlList(ywBxjl);
        return getDataTable(list);
    }

    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list1(YwBxjl ywBxjl)
    {
        ywBxjl.setYu5(getSysUser().getUserName());
        ywBxjl.setYu16(getUserId()+"");
        startPage();
        List<YwBxjl> list = ywBxjlService.selectWDList(ywBxjl);
        return getDataTable(list);
    }



    /**
     * 导出报修单列表
     */
    @Log(title = "报修单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwBxjl ywBxjl)
    {
        List<YwBxjl> list = ywBxjlService.selectYwBxjlList(ywBxjl);
        ExcelUtil<YwBxjl> util = new ExcelUtil<YwBxjl>(YwBxjl.class);
        return util.exportExcel(list, "报修单数据");
    }

    /**
     * 新增报修单
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    /**
     * 查询字典详细
     */
    @GetMapping("/xljl/{dictId}")
    public String xljl(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("sid", dictId);
        return prefix+"/xljl";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/xljlzj/{dictId}")
    public String xljlzj(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("sid", dictId);
        return prefix+"/xljlzj";
    }

    /**
     * 新增保存报修单
     */
    @Log(title = "报修单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwBxjl ywBxjl)
    {
        return toAjax(ywBxjlService.insertYwBxjl(ywBxjl));
    }



    @Log(title = "报修单", businessType = BusinessType.INSERT)
    @PostMapping("/addSaves")
    @ResponseBody
    public AjaxResult addSaves(YwBxjl ywBxjl)
    {
        ywBxjl.setSid(UUID.randomUUID().toString().replace("-",""));
        ywBxjl.setYu3(new Date());
        return toAjax(ywBxjlService.insertYwBxjl(ywBxjl));
    }

    /**
     * 修改报修单
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwBxjl ywBxjl = ywBxjlService.selectYwBxjlBySid(sid);
        mmap.put("ywBxjl", ywBxjl);
        return prefix + "/edit";
    }

    @Autowired
    private IXtDwxxbService xtDwxxbService;

    @GetMapping("/bxy/{sid}")
    public String bxy(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        XtDwxxb uy = xtDwxxbService.selectXtDwxxbBySid(sid);
        YwBxjl ywBxjl=new YwBxjl();
        ywBxjl.setBxDw(uy.getDwmc());
        ywBxjl.setYu1("单位报修");
        ywBxjl.setYu2(uy.getSid()+"");
        mmap.put("ywBxjl", ywBxjl);
        return prefix + "/bxy";
    }
    @GetMapping("/bxy1/{sid}")
    public String bxy1(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        XtDwxxb uy = xtDwxxbService.selectXtDwxxbBySid(sid);
        YwBxjl ywBxjl=new YwBxjl();
        ywBxjl.setBxDw(uy.getDwmc());
        ywBxjl.setYu1("单位报修");
        ywBxjl.setYu2(uy.getSid()+"");
        mmap.put("ywBxjl", ywBxjl);
        return prefix + "/bxy1";
    }

    @Autowired
    private IYwSbxxService ywSbxxService;

    @GetMapping("/bxsb/{sid}")
    public String bxsb(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwSbxx uy = ywSbxxService.selectYwSbxxBySid(sid);
        YwBxjl ywBxjl=new YwBxjl();
        ywBxjl.setBxDw(uy.getDwmc());
        ywBxjl.setYu1("设备报修");
        ywBxjl.setYu2(uy.getSid());
        mmap.put("ywBxjl", ywBxjl);
        return prefix + "/bxsb";
    }

    @GetMapping("/bxsb1/{sid}")
    public String bxsb1(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwSbxx uy = ywSbxxService.selectYwSbxxBySid(sid);
        YwBxjl ywBxjl=new YwBxjl();
        ywBxjl.setBxDw(uy.getDwmc());
        ywBxjl.setYu1("设备报修");
        ywBxjl.setYu2(uy.getSid());
        mmap.put("ywBxjl", ywBxjl);
        return prefix + "/bxsb1";
    }



    /**
     * 修改保存报修单
     */
    @Log(title = "报修单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwBxjl ywBxjl)
    {
        return toAjax(ywBxjlService.updateYwBxjl(ywBxjl));
    }

    /**
     * 删除报修单
     */
    @Log(title = "报修单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywBxjlService.deleteYwBxjlBySids(ids));
    }

    @GetMapping("/pdjl/{sid}")
    public String pdjl(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwPdjl ywPdjl =new YwPdjl();
        ywPdjl.setBxjlid(sid);
        mmap.put("ywPdjl", ywPdjl);
        return prefix + "/pdjl";
    }

}
