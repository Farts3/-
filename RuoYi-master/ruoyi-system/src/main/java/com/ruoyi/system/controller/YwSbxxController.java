package com.ruoyi.system.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.domain.CxSelect;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.domain.*;
import com.ruoyi.system.service.IXtConsumableService;
import com.ruoyi.system.service.IXtGoodsService;
import com.ruoyi.system.service.IYwWxjlService;
import com.ruoyi.system.util.ConvertToMultipartFile;
import com.ruoyi.system.util.QRCodeUtil;
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
import com.ruoyi.system.service.IYwSbxxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

/**
 * 设备管理Controller
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Controller
@RequestMapping("/system/jcsbxxt")
public class YwSbxxController extends BaseController
{
    private String prefix = "system/jcsbxxt";

    @Autowired
    private IYwSbxxService ywSbxxService;

    //@RequiresPermissions("system:jcsbxxt:view")
    @GetMapping()
    public String jcsbxxt()
    {
        return prefix + "/jcsbxxt";
    }

    /**
     * 查询设备管理列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(YwSbxx ywSbxx)
    {
        startPage();
        List<YwSbxx> list = ywSbxxService.selectYwSbxxList(ywSbxx);
        return getDataTable(list);
    }

    /**
     * 导出设备管理列表
     */
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(YwSbxx ywSbxx)
    {
        List<YwSbxx> list = ywSbxxService.selectYwSbxxList(ywSbxx);
        ExcelUtil<YwSbxx> util = new ExcelUtil<YwSbxx>(YwSbxx.class);
        return util.exportExcel(list, "设备管理数据");
    }

    /**
     * 新增设备管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }


    /**
     * 新增设备管理
     */
    @GetMapping("/add/{sid}")
    public String add(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwSbxx ywSbxx = new YwSbxx();
        ywSbxx.setDwmc(sid);
        mmap.put("ywSbxx", ywSbxx);
        return prefix + "/add";
    }

    /**
     * 新增保存设备管理
     */
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(YwSbxx ywSbxx)
    {
        ywSbxx.setSid(UUID.randomUUID().toString().replace("-",""));
        ywSbxx.setTbr(getUserId()+"");
        ywSbxx.setTbsj(new Date());
        return toAjax(ywSbxxService.insertYwSbxx(ywSbxx));
    }

    /**
     * 修改设备管理
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        YwSbxx ywSbxx = ywSbxxService.selectYwSbxxBySid(sid);
        mmap.put("ywSbxx", ywSbxx);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备管理
     */
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(YwSbxx ywSbxx)
    {
        return toAjax(ywSbxxService.updateYwSbxx(ywSbxx));
    }

    /**
     * 删除设备管理
     */
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ywSbxxService.deleteYwSbxxBySids(ids));
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/dwewm/{dictId}")
    public String ewm(@PathVariable("dictId") String dictId, ModelMap mmap) throws Exception
    {
        // String url=createQRImage("http://192.168.0.19:8081/system/jcsbxxt/xq/"+dictId);
        String url=createQRImage("http://60.205.131.5:8081/system/jcsbxxt/xq/"+dictId);
        //查询基本信息
        mmap.put("url",url);
        return prefix+"/dwewm";
    }

    /**
     * 活动创建签到二维码
     * @return  二维码上传之后返回的Url
     */
    private String createQRImage(String url)
    {
        QRCodeUtil i=new QRCodeUtil();
        BufferedImage bufferedImage = i.createImage("UTF-8", url, 200, 200);
        //  BufferedImage bufferedImage = i.createImage("UTF-8", url, 300, 200);
        //上传服务器
        return uploadServer(bufferedImage);
    }

    /**
     * 二维码上传服务器  且返回路径
     * @param bufferedImage
     * @return
     */
    private String uploadServer(BufferedImage bufferedImage)
    {
        //将BufferedImage 转换为 MultipartFile 进行文件上传
        try
        {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage,"jpg",out);
            byte[] imageByte = out.toByteArray();
            MultipartFile file = new ConvertToMultipartFile(imageByte, IdUtils.simpleUUID(),IdUtils.fastSimpleUUID(), MimeTypeUtils.IMAGE_JPG,imageByte.length);
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            //file.getContentType() image/jpg
            String fileName = FileUploadUtils.upload(filePath, file);
            return fileName;
        }
        catch (IOException e)
        {
            throw  new ServiceException("二维码创建失败,请联系管理员");
        }
    }


    @Autowired
    private IYwWxjlService ywWxjlService;

    @Autowired
    private IXtGoodsService xtGoodsService;
    @Autowired
    private IXtConsumableService xtConsumableService;
    /**
     * 查询字典详细
     */
    @GetMapping("/xq/{dictId}")
    public String xq(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        //查询基本信息
        // 设备基本信息
        mmap.put("ywSbxx", ywSbxxService.selectYwSbxxBySid(dictId));
        YwSbxx uy = ywSbxxService.selectYwSbxxBySid(dictId);
        //重置报修基本信息
       /* YwBxjl ywBxjl=new YwBxjl();
        ywBxjl.setBxDw(uy.getDwmc());
        ywBxjl.setYu1("设备报修");
        ywBxjl.setYu2(uy.getSid());
        mmap.put("ywBxjl", ywBxjl);*/
        YwWxjl ywWxjl=new YwWxjl();
        ywWxjl.setYu1(uy.getSid());
        mmap.put("ywWxjl", ywWxjl);
        //根据设备ID查询出所有的维修记录
        List<YwWxjl> list = ywWxjlService.selectYwWxjlList(ywWxjl);
        mmap.put("wxlist", list);
        //返回对应的耗材类型信息
        XtGoods xtGoods=new XtGoods();
        //将耗材类型已字典的方式给前台
        mmap.put("hclx", xtGoodsService.selectXtGoodsList(xtGoods));

        //将类型及对应名称返回到前台
        //获取类型
        List<XtGoods> golist = xtGoodsService.selectXtGoodsList(xtGoods);
        mmap.put("golist", golist);

        return prefix+"/xq";
    }

    /**
     * 登录前调试
     */
    @GetMapping("/denglu/{sid}")
    public String denglu(@PathVariable("sid") String sid, ModelMap mmap)
    {
        //查询基本信息
        mmap.put("sid",sid);
        return prefix+"/denglu";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/bxjl/{dictId}")
    public String bxjl(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("ywSbxx", ywSbxxService.selectYwSbxxBySid(dictId));
        return prefix+"/bxjl";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/xljl/{dictId}")
    public String xljl(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        YwSbxx ywSbxx=new YwSbxx();
        ywSbxx.setYu3(dictId);
        ywSbxx.setYu4(getUserId()+"");
        mmap.put("ywSbxx",ywSbxx);
        return prefix+"/xljl";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/hcjl/{dictId}")
    public String hcjl(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        YwSbxx ywSbxx=new YwSbxx();
        ywSbxx.setYu3(dictId);
        ywSbxx.setYu4(getUserId()+"");
        mmap.put("ywSbxx",ywSbxx);
        return prefix+"/hcjl";
    }
}
