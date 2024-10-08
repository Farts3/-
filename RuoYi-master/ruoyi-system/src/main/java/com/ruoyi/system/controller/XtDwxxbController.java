package com.ruoyi.system.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.util.ConvertToMultipartFile;
import com.ruoyi.system.util.QRCodeUtil;
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
import com.ruoyi.system.domain.XtDwxxb;
import com.ruoyi.system.service.IXtDwxxbService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.core.domain.Ztree;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

/**
 * 单位管理Controller
 * 
 * @author hqq
 * @date 2023-02-06
 */
@Controller
@RequestMapping("/system/dwxxb")
public class XtDwxxbController extends BaseController
{
    private String prefix = "system/dwxxb";

    @Autowired
    private IXtDwxxbService xtDwxxbService;

    //@RequiresPermissions("system:dwxxb:view")
    @GetMapping()
    public String dwxxb()
    {
        return prefix + "/dwxxb";
    }



    /**
     * 查询单位管理树列表
     */
    @PostMapping("/list")
    @ResponseBody
    public List<XtDwxxb> list(XtDwxxb xtDwxxb)
    {
        List<XtDwxxb> list = xtDwxxbService.selectXtDwxxbList(xtDwxxb);
        return list;
    }

    /**
     * 导出单位管理列表
     */
    @Log(title = "单位管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(XtDwxxb xtDwxxb)
    {
        List<XtDwxxb> list = xtDwxxbService.selectXtDwxxbList(xtDwxxb);
        ExcelUtil<XtDwxxb> util = new ExcelUtil<XtDwxxb>(XtDwxxb.class);
        return util.exportExcel(list, "单位管理数据");
    }

    /**
     * 新增单位管理
     */
    @GetMapping(value = { "/add/{sid}", "/add/" })
    public String add(@PathVariable(value = "sid", required = false) Long sid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sid))
        {
            mmap.put("xtDwxxb", xtDwxxbService.selectXtDwxxbBySid(sid));
        }
        return prefix + "/add";
    }

    /**
     * 新增保存单位管理
     */
    @Log(title = "单位管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(XtDwxxb xtDwxxb)
    {
        xtDwxxb.setTbr(getUserId()+"");
        xtDwxxb.setTbsj(new Date());
        return toAjax(xtDwxxbService.insertXtDwxxb(xtDwxxb));
    }

    /**
     * 修改单位管理
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") Long sid, ModelMap mmap)
    {
        XtDwxxb xtDwxxb = xtDwxxbService.selectXtDwxxbBySid(sid);
        mmap.put("xtDwxxb", xtDwxxb);
        return prefix + "/edit";
    }

    /**
     * 修改保存单位管理
     */
    @Log(title = "单位管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(XtDwxxb xtDwxxb)
    {
        return toAjax(xtDwxxbService.updateXtDwxxb(xtDwxxb));
    }

    /**
     * 删除
     */
    @Log(title = "单位管理", businessType = BusinessType.DELETE)
    @GetMapping("/remove/{sid}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("sid") Long sid)
    {
        return toAjax(xtDwxxbService.deleteXtDwxxbBySid(sid));
    }

    /**
     * 选择单位管理树
     */
    @GetMapping(value = { "/selectDwxxbTree/{sid}", "/selectDwxxbTree/" })
    public String selectDwxxbTree(@PathVariable(value = "sid", required = false) Long sid, ModelMap mmap)
    {
        if (StringUtils.isNotNull(sid))
        {
            mmap.put("xtDwxxb", xtDwxxbService.selectXtDwxxbBySid(sid));
        }
        return prefix + "/tree";
    }

    /**
     * 加载单位管理树列表
     */
    @GetMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = xtDwxxbService.selectXtDwxxbTree();
        return ztrees;
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/dwewm/{dictId}")
    public String ewm(@PathVariable("dictId") String dictId, ModelMap mmap) throws Exception
    {
        System.out.println(dictId);
        String url=createQRImage("http://60.205.131.5:8081//system/bxdxx/bxy/"+dictId);
      //  String url=createQRImage("http://192.168.0.19:8081/system/bxdxx/bxy/"+dictId);
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
        System.out.println(url);
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
    /**
     * 登录前调试
     */
    @GetMapping("/denglu/{sid}")
    public String denglu(@PathVariable("sid") String sid, ModelMap mmap)
    {
        //查询基本信息
        mmap.put("yuid",sid);
        return prefix+"/denglu";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/bxjl/{dictId}")
    public String bxjl(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        XtDwxxb xtDwxxb = xtDwxxbService.selectXtDwxxbBySid(dictId);
        mmap.put("xtDwxxb", xtDwxxb);
        return prefix+"/bxjl";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/xljl/{dictId}")
    public String xljl(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        XtDwxxb xtDwxxb = xtDwxxbService.selectXtDwxxbBySid(dictId);
        mmap.put("xtDwxxb", xtDwxxb);
        return prefix+"/xljl";
    }

    /**
     * 加载人员管理树列表
     */
    @GetMapping("/tree2Data")
    @ResponseBody
    public List<Ztree> tree2Data()
    {
        List<Ztree> ztrees = xtDwxxbService.selectRYbTree();
        return ztrees;
    }
      //大屏数据
    @GetMapping("index")
    public String index(ModelMap mmap)
    {
        //查询出所有工程部的人员及其电话
       List<XtDwxxb> userlist= xtDwxxbService.selectUser();
       /*//全年故障件数
        XtDwxxb xtDwxxb = xtDwxxbService.bxcs();*/
      // System.out.println(userlist);
        mmap.put("userlist", userlist);
       // mmap.put("xtDwxxb", xtDwxxb);
        return prefix + "/index";
    }



}
