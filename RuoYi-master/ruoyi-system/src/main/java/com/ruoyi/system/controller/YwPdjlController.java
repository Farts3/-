package com.ruoyi.system.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.core.domain.Ztree;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.YwBxjl;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IYwBxjlService;
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
import com.ruoyi.system.domain.YwPdjl;
import com.ruoyi.system.service.IYwPdjlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 派单记录Controller
 * 
 * @author hqq
 * @date 2023-02-07
 */
@Controller
@RequestMapping("/system/pdjlxx")
public class YwPdjlController extends BaseController
{
    private String prefix = "system/pdjlxx";

    @Autowired
    private IYwPdjlService ywPdjlService;

    @GetMapping()
    public String pdjlxx()
    {
        return prefix + "/pdjlxx";
    }

    /**
     * 查询派单记录列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwPdjl ywPdjl)
    {
        startPage();
        List<YwPdjl> list = ywPdjlService.selectYwPdjlList(ywPdjl);
        return getDataTable(list);
    }



    /**
     * 导出派单记录列表
     */
    //@RequiresPermissions("system:pdjlxx:export")
    @Log(title = "派单记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwPdjl ywPdjl)
    {
        List<YwPdjl> list = ywPdjlService.selectYwPdjlList(ywPdjl);
        ExcelUtil<YwPdjl> util = new ExcelUtil<YwPdjl>(YwPdjl.class);
        return util.exportExcel(list, "派单记录数据");
    }

    /**
     * 新增派单记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        YwPdjl ywPdjl = new YwPdjl();
        mmap.put("ywPdjl", ywPdjl);
        ywPdjl.setTbsj(new Date());
        return prefix + "/add";
    }


    @Autowired
    private ISysUserService ISysUserService;
    /**
     * 新增保存派单记录
     */
    @Log(title = "派单记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwPdjl ywPdjl)
    {
        ywPdjl.setTbr(getUserId()+"");
        ywPdjl.setSid(UUID.randomUUID().toString().replace("-",""));
        ywPdjl.setTbsj(new Date());
        ywPdjl.setLxdh(ISysUserService.selectUserById(Long.valueOf(ywPdjl.getYu1())).getPhonenumber());

        return toAjax(ywPdjlService.insertYwPdjl(ywPdjl));
    }

    /**
     * 修改派单记录
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwPdjl ywPdjl = ywPdjlService.selectYwPdjlBySid(sid);
        mmap.put("ywPdjl", ywPdjl);
        return prefix + "/edit";
    }

    /**
     * 修改保存派单记录
     */
    @Log(title = "派单记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwPdjl ywPdjl)
    {
        return toAjax(ywPdjlService.updateYwPdjl(ywPdjl));
    }

    /**
     * 删除派单记录
     */
    @Log(title = "派单记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywPdjlService.deleteYwPdjlBySids(ids));
    }

    @Autowired
    private IYwBxjlService ywBxjlService;

    @GetMapping("/pfry/{sid}")
    public String pfry(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwPdjl ywPdjl =new YwPdjl();
        ywPdjl.setBxjlid(sid);
        ywPdjl.setPqsj(new Date());
        mmap.put("ywPdjl", ywPdjl);
        return prefix + "/pfry";
    }

    @GetMapping("/add/{bxjlid}")
    public String add(@PathVariable("bxjlid") String bxjlid, ModelMap mmap)
    {
        System.out.println(bxjlid);
        YwPdjl ywPdjl =new YwPdjl();
        ywPdjl.setPqsj(new Date());
        mmap.put("ywPdjl", ywPdjl);
        mmap.put("bxjlid", bxjlid);
        return prefix + "/add";
    }

    /**
     * 选择单位管理树
     */
    @GetMapping(value = { "/selectRYbTree/{sid}", "/selectRYbTree/" })
    public String selectRYbTree(@PathVariable(value = "sid", required = false) String sid, ModelMap mmap)
    {
        //,1,2,3]

        return prefix + "/tree";
    }



}
