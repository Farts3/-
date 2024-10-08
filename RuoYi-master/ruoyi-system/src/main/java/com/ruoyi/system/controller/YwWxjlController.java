package com.ruoyi.system.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.domain.CxSelect;
import com.ruoyi.system.domain.XtConsumable;
import com.ruoyi.system.domain.XtDwxxb;
import com.ruoyi.system.domain.XtGoods;
import com.ruoyi.system.service.IXtConsumableService;
import com.ruoyi.system.service.IXtDwxxbService;
import com.ruoyi.system.service.IXtGoodsService;
import com.ruoyi.system.util.NumberToAmountInWords;
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
import com.ruoyi.system.domain.YwWxjl;
import com.ruoyi.system.service.IYwWxjlService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

import javax.xml.crypto.Data;

/**
 * 维修单Controller
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Controller
@RequestMapping("/system/wxdgl")
public class YwWxjlController extends BaseController
{
    private String prefix = "system/wxdgl";

    @Autowired
    private IYwWxjlService ywWxjlService;

    //@RequiresPermissions("system:wxdgl:view")
    @GetMapping()
    public String wxdgl()
    {
        return prefix + "/wxdgl";
    }

    @GetMapping("/myXd")
    public String myXd(){
        return prefix + "/myXd";
    }

    @GetMapping("/wxdglzsk")
    public String wxdglzsk()
    {
        return prefix + "/wxdglzsk";
    }

    @GetMapping("/flgl")
    public String flgl(){
        return prefix + "/flgl";
    }

    /**
     * 查询维修单列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwWxjl ywWxjl)
    {
        startPage();
        List<YwWxjl> list = ywWxjlService.selectYwWxjlList(ywWxjl);
        return getDataTable(list);
    }


    @PostMapping("/listhc")
    @ResponseBody
    public TableDataInfo listhc(YwWxjl ywWxjl)
    {
       // ywWxjl.setTbr(getUserId()+"");
        startPage();
        List<YwWxjl> list = ywWxjlService.selectYwWxjlListhc(ywWxjl);
        return getDataTable(list);
    }


    @PostMapping("/list1")
    @ResponseBody
    public TableDataInfo list1(YwWxjl ywWxjl)
    {
        startPage();
        List<YwWxjl> list = ywWxjlService.selectYwWxjlListshhc(ywWxjl);
        return getDataTable(list);
    }

       //查询废料列表
    @PostMapping("/listfl")
    @ResponseBody
    public TableDataInfo listfl(YwWxjl ywWxjl)
    {
        startPage();
        List<YwWxjl> list = ywWxjlService.selectYwWxjlListfl(ywWxjl);
        return getDataTable(list);
    }



    /**
     * 导出维修单列表
     */
    //@RequiresPermissions("system:wxdgl:export")
    @Log(title = "维修单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwWxjl ywWxjl)
    {
        List<YwWxjl> list = ywWxjlService.selectYwWxjlList(ywWxjl);
        ExcelUtil<YwWxjl> util = new ExcelUtil<YwWxjl>(YwWxjl.class);
        return util.exportExcel(list, "维修单数据");
    }


    @Autowired
    private IXtGoodsService xtGoodsService;
    @Autowired
    private IXtConsumableService xtConsumableService;
    /**
     * 新增维修单
     */
    @GetMapping("/add")
    public String add(ModelMap mmap)
    {
        //将类型及对应名称返回到前台
        //获取类型
        XtGoods xtGoods=new XtGoods();
        List<XtGoods> golist = xtGoodsService.selectXtGoodsList(xtGoods);
        mmap.put("golist", golist);
        return prefix + "/add";
    }



    /**
     * 新增保存维修单
     */
    //@RequiresPermissions("system:wxdgl:add")
    @Log(title = "维修单", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwWxjl ywWxjl)
    {
        //ywWxjl.setSid(UUID.randomUUID().toString().replace("-",""));
        //ywWxjl.setTbr(getUserId()+"");
        ywWxjl.setTbsj(new Date());
        if(ywWxjl.getYu2().equals("是")) {
            Long sl = Long.parseLong(ywWxjl.getYu5());
            //对数量进行判断如果填写的数量>库存则提示数据保存失败并说明原因
            XtConsumable XtConsumable = xtConsumableService.selectXtConsumableBySid(Long.parseLong(ywWxjl.getYu4()));
            //通过耗材的id查询
            if (sl > XtConsumable.getcNum()) {
                return AjaxResult.error("耗材库存不足请联系管理员并重新填写！");
            }
            //若数量满足则库存进行操作数量的更改
            XtConsumable.setcNum(XtConsumable.getcNum() - sl);
            //将单价返回给系统列表
            ywWxjl.setYu7(XtConsumable.getcMoney()+"");
            System.out.println("-----------------------------2");
            xtConsumableService.updateXtConsumable(XtConsumable);
        }
        return toAjax(ywWxjlService.insertYwWxjl(ywWxjl));
    }

    /**
     * 新增保存维修单
     */
    //@RequiresPermissions("system:wxdgl:add")
    @Log(title = "维修单", businessType = BusinessType.INSERT)
    @PostMapping("/addSaves")
    @ResponseBody
    public AjaxResult addSaves(YwWxjl ywWxjl)
    {
       // ywWxjl.setSid(UUID.randomUUID().toString().replace("-",""));
        //ywWxjl.setTbr(getUserId()+"");
        ywWxjl.setTbsj(new Date());
        if(ywWxjl.getYu2().equals("是")) {
            Long sl = Long.parseLong(ywWxjl.getYu5());
            //对数量进行判断如果填写的数量>库存则提示数据保存失败并说明原因
            XtConsumable XtConsumable = xtConsumableService.selectXtConsumableBySid(Long.parseLong(ywWxjl.getYu4()));
            //通过耗材的id查询
            if (sl > XtConsumable.getcNum()) {
                return AjaxResult.error("耗材库存不足请联系管理员并重新填写！");
            }
            //若数量满足则库存进行操作数量的更改
            XtConsumable.setcNum(XtConsumable.getcNum() - sl);
            //将单价返回给系统列表
            ywWxjl.setYu7(XtConsumable.getcMoney()+"");
            System.out.println("-----------------------------1");
            xtConsumableService.updateXtConsumable(XtConsumable);
        }
        ywWxjlService.insertYwWxjl(ywWxjl);
        return AjaxResult.success("维修单提交完成");
    }




    /**
     * 修改维修单
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwWxjl ywWxjl = ywWxjlService.selectYwWxjlBySid(sid);
        ywWxjl.setYu4(getUserId()+"");
        mmap.put("ywWxjl", ywWxjl);
        XtGoods xtGoods=new XtGoods();
        List<XtGoods> golist = xtGoodsService.selectXtGoodsList(xtGoods);
        mmap.put("golist", golist);
        return prefix + "/edit";
    }

    /**
     * 修改维修单
     */
    @GetMapping("/chakans/{sid}")
    public String chakans(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwWxjl ywWxjl = ywWxjlService.selectYwWxjlBySid(sid);
        ywWxjl.setYu3(xtGoodsService.selectXtGoodsBySid(Long.parseLong(ywWxjl.getYu3())).getGoodsName());
        ywWxjl.setYu4(xtConsumableService.selectXtConsumableBySid(Long.parseLong(ywWxjl.getYu4())).getcName());
        mmap.put("ywWxjl", ywWxjl);
        return prefix + "/editchakan";
    }



    /**
     * 修改保存维修单
     */
    @Log(title = "维修单", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwWxjl ywWxjl)
    {
        return toAjax(ywWxjlService.updateYwWxjl(ywWxjl));
    }

    /**
     * 删除维修单
     */
    @Log(title = "维修单", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {

        return toAjax(ywWxjlService.deleteYwWxjlBySids(ids));
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/czjls/{dictId}")
    public String czjls(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        YwWxjl ywWxjl=new YwWxjl();
        ywWxjl.setYu3(dictId);
        mmap.put("ywWxjl",ywWxjl);
        return prefix+"/datas";
    }

    /**
     * 新增字典类型
     */
    @GetMapping("/add/{yu1}")
    public String add(@PathVariable("yu1") String yu1, ModelMap mmap)
    {
        mmap.put("yu1", yu1);
        //将类型及对应名称返回到前台
        //获取类型
        XtGoods xtGoods=new XtGoods();
        List<XtGoods> golist = xtGoodsService.selectXtGoodsList(xtGoods);
        mmap.put("golist", golist);
        return prefix + "/add";
    }

    //获取二级数据SelectCons
    @PostMapping("/SelectCons")
    @ResponseBody
    public AjaxResult SelectCons(String yu1)
    {
        System.out.println(yu1);
        XtConsumable xtConsumable=new XtConsumable();
        xtConsumable.setYu1(yu1);
        List<XtConsumable> colist = xtConsumableService.selectXtConsumableList(xtConsumable);
        return AjaxResult.success(colist);
    }


    @GetMapping("/chakan/{sid}")
    public String chakan(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwWxjl ywWxjl = ywWxjlService.selectYwWxjlBySid(sid);
        mmap.put("ywWxjl", ywWxjl);
        return prefix + "/chakan";
    }

    @Autowired
    private IXtDwxxbService xtDwxxbService;

    @GetMapping("/ckd/{sid}")
    public String ckd(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwWxjl ywWxjl = ywWxjlService.selectYwWxjlBySid(sid);
        mmap.put("ywWxjl", ywWxjl);
        //通过维修记录查询出对应的耗材记录  包括 编号  商品名称  型号  价格  金额  小计  总计


        //查询出对应单位信息
        XtDwxxb XtDwxxb= xtDwxxbService.finddwxx(ywWxjl.getSid());
        mmap.put("XtDwxxb", XtDwxxb);
        //类型信息
        XtGoods XtGoods=xtGoodsService.selectXtGoodsBySid(Long.parseLong(ywWxjl.getYu3()));
        XtGoods.setYu6(getSysUser().getUserName());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(new Date());
        XtGoods.setYu7(currentTime);
        mmap.put("XtGoods", XtGoods);
        //耗材信息
        XtConsumable XtConsumable=xtConsumableService.selectXtConsumableBySid(Long.parseLong(ywWxjl.getYu4()));
         //计算出总金额、[[${ywWxjl.yu5}*${XtConsumable.cMoney}]]
         int sl=Integer.parseInt(ywWxjl.getYu5());
         double dj=Double.valueOf(ywWxjl.getYu7());
         double je=sl*dj;
        XtConsumable.setcSmoney(BigDecimal.valueOf(je));
        XtConsumable.setYu7(NumberToAmountInWords.numberToAmountInWords(BigDecimal.valueOf(je)));
        mmap.put("XtConsumable", XtConsumable);
        return prefix + "/ckd";
    }



}
