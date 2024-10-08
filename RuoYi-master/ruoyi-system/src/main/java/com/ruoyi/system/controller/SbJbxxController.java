package com.ruoyi.system.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.ServletUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.MimeTypeUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.system.domain.SbCzjl;
import com.ruoyi.system.service.ISbCzjlService;
import com.ruoyi.system.util.ConvertToMultipartFile;
import com.ruoyi.system.util.QRCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
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
import com.ruoyi.system.domain.SbJbxx;
import com.ruoyi.system.service.ISbJbxxService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 基本信息Controller
 * 
 * @author y
 * @date 2022-12-13
 */
@Controller
@RequestMapping("/system/sbjbxx")
public class SbJbxxController extends BaseController
{
    private String prefix = "system/sbjbxx";

    @Autowired
    private ISbJbxxService sbJbxxService;
    @Autowired
    private ISbCzjlService ISbCzjlService;

    @GetMapping()
    public String sbjbxx()
    {
        return prefix + "/sbjbxx";
    }

    /**
     * 查询基本信息列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SbJbxx sbJbxx)
    {

        if(!getSysUser().getRoles().get(0).getRoleName().contains("管理员")) {
            sbJbxx.setUserid(getUserId());
        }
        startPage();
        List<SbJbxx> list = sbJbxxService.selectSbJbxxList(sbJbxx);
        return getDataTable(list);
    }

    /**
     * 导出基本信息列表
     */
    @Log(title = "基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SbJbxx sbJbxx)
    {
        List<SbJbxx> list = sbJbxxService.selectSbJbxxList(sbJbxx);
        ExcelUtil<SbJbxx> util = new ExcelUtil<SbJbxx>(SbJbxx.class);
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
    public AjaxResult addSave(SbJbxx sbJbxx)
    {
        sbJbxx.setSid(UUID.randomUUID().toString().replace("-",""));
        sbJbxx.setUserid(getUserId());
        return toAjax(sbJbxxService.insertSbJbxx(sbJbxx));
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/czjl/{dictId}")
    public String detail(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("sbJbxx", sbJbxxService.selectSbJbxxBySid(dictId));
        return prefix+"/data";
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/czjls/{dictId}")
    public String czjls(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        mmap.put("sbJbxx", sbJbxxService.selectSbJbxxBySid(dictId));

        return prefix+"/datas";


    }


    /**
     * 查询字典详细
     */
    @GetMapping("/xq/{dictId}")
    public String xq(@PathVariable("dictId") String dictId, ModelMap mmap)
    {
        //查询基本信息
        mmap.put("sbJbxx", sbJbxxService.selectSbJbxxBySid(dictId));
        //查询列表信息
        SbCzjl SbCzjl=new SbCzjl();
        SbCzjl.setSbid(dictId);
        mmap.put("sbJbxxList", ISbCzjlService.selectSbCzjlList(SbCzjl));
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



    @PostMapping("/login")
    @ResponseBody
    public void login(String username, String password,String sid)
    {
        System.out.println(username);

    }



    /**
     * 查询字典详细
     */
    @GetMapping("/ewm/{dictId}")
    public String ewm(@PathVariable("dictId") String dictId, ModelMap mmap) throws Exception
    {
            System.out.println(dictId);
           String url=createQRImage("http://hbhqq.gnway.cc/system/sbjbxx/xq/"+dictId);
            System.out.println(dictId+"数据");
            //查询基本信息
            mmap.put("url",url);
            return prefix+"/ewm";
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
     * 修改基本信息
     */
    @GetMapping("/edit/{sid}")
    public String edit(@PathVariable("sid") String sid, ModelMap mmap)
    {
        SbJbxx sbJbxx = sbJbxxService.selectSbJbxxBySid(sid);
        mmap.put("sbJbxx", sbJbxx);
        return prefix + "/edit";
    }

    /**
     * 修改保存基本信息
     */
    @Log(title = "基本信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SbJbxx sbJbxx)
    {
        return toAjax(sbJbxxService.updateSbJbxx(sbJbxx));
    }

    /**
     * 删除基本信息
     */
    @Log(title = "基本信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sbJbxxService.deleteSbJbxxBySids(ids));
    }
}
