package com.WebController;

import com.Domain.Image;
import com.Service.ImgService;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FilesController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("/upload.do")
    public String FileUpload(@RequestParam("photo") CommonsMultipartFile file,
                           HttpServletRequest httpServletRequest){

        //文件不为空
        if(!file.isEmpty()){

            //文件名全称，包含后缀名
            String originalFilename = file.getOriginalFilename();
            //获取.的index
            int doindex = originalFilename.indexOf(".")+1;
            //截取后缀名
            String filelastname = originalFilename.substring(doindex);
            //判断是否是图片类型
            if(!("jpg".equals(filelastname))&&!("png".equals(filelastname))){
                System.out.println("非图片不接受");
//                return;
            }
            String newfilename = System.currentTimeMillis()+"."+filelastname;
            String path = httpServletRequest.getContextPath();
            String path1 = httpServletRequest.getServletPath();
            String path2 = httpServletRequest.getSession().getServletContext().getContextPath();
            String path3 = httpServletRequest.getSession().getServletContext().getRealPath("/upload/"+newfilename);
            System.out.println("上传文件的路径httpServletRequest.getContextPath();！"+path);
            System.out.println("上传文件的路径1！httpServletRequest.getServletPath()"+path1);
            System.out.println("上传文件的路径2！httpServletRequest.getSession().getServletContext().getContextPath()"+path2);
            System.out.println("httpServletRequest.getSession().getServletContext().getRealPath"+path3);
            File file1 = new File(path3);
            try {
                FileUtils.copyInputStreamToFile(file.getInputStream(),file1);
                Image image = new Image();
                int startindex = newfilename.indexOf("0");
                int endindex = newfilename.indexOf(".");
                image.setId(newfilename.substring(startindex,endindex));
                image.setImgname(newfilename);
                image.setImgurl(path3);
                imgService.saveImg(image);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("上传文件！"+originalFilename);

        }

        System.out.println("上传文件！空文件");
//        return "redirect:/user/toajax.do";
        return "redirect:findAllImg.do";

    }

    @RequestMapping("/findAllImg.do")
    public ModelAndView findAllImg(){
        ModelAndView mv = new ModelAndView();
        List<Image> imglist = imgService.findAll();
        mv.addObject("listImg",imglist);
        mv.setViewName("testAjaxandJson");
        Date date = new Date();
        mv.addObject("date",date);
        mv.addObject("price",11.98524);
        return mv;

    }

    @RequestMapping("/downloadImg.do")
    public ResponseEntity<byte[]> downloadImg(@RequestParam("id") String id) throws IOException{
        String targetImgPath = imgService.findById(id).getImgurl();
        File file = new File(targetImgPath);
        String Oldfilename = imgService.findById(id).getImgname();
        String newfilename = Oldfilename.replaceAll("\\.","下载文件.");
        HttpHeaders httpHeaders = new HttpHeaders();
//        String filename = imgService.findById(id).getImgname()+"下载文件哈哈哈";
        //将文件命名转码，从UTF-8转码为iso-8859-1，实现中文不乱码
        String filename = new String(newfilename.getBytes("UTF-8"),"iso-8859-1");
        //如果不设置这个，那么下载文件的文件名和下载的文件格式都会有问题
        httpHeaders.setContentDispositionFormData("attachment",filename);
        //指定请求为二进制数据流
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        返回一个实体对象，即可完成功能
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),httpHeaders,HttpStatus.CREATED);
    }
}
