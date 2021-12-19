package com.study.system.controller;

import com.study.system.utils.WebUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {

    // 设置图片保存路径
    @Resource(name = "uploadFileRootPath")
    private String rootPath;

    // 设置图片下载路径的前缀
    @Resource(name = "fileDownLoadPrefix")
    private String picPrefix;

    /*
        图片上传接收的对象为MultipartFile类型
     */
    @RequestMapping("uploadImgForWangEditor.action")
    public Map<String,Object> uploadImgForWangEditor(MultipartFile mf){
        /*
            根据官网格式来进行构建 https://www.wangeditor.com/doc/pages/07-%E4%B8%8A%E4%BC%A0%E5%9B%BE%E7%89%87/01-%E9%85%8D%E7%BD%AE%E6%9C%8D%E5%8A%A1%E7%AB%AF%E6%8E%A5%E5%8F%A3.html
            {
            // errno 即错误代码，0 表示没有错误。
            //       如果有错误，errno != 0，可通过下文中的监听函数 fail 拿到该错误码进行自定义处理
            "errno": 0,
            // data 是一个数组，返回图片Object，Object中包含需要包含url、alt和href三个属性,它们分别代表图片地址、图片文字说明和跳转链接,alt和href属性是可选的，可以不设置或设置为空字符串,需要注意的是url是一定要填的。
            "data": [
                        {
                            url: "图片地址",
                            alt: "图片文字说明",
                            href: "跳转链接"
                        },
                        {
                            url: "图片地址1",
                            alt: "图片文字说明1",
                            href: "跳转链接1"
                        },
                        "……"
                    ]
            }
         */
        Map<String, Object> resMap = new HashMap<>();
        //  errno 即错误代码，0 表示没有错误。
        resMap.put("errno",0);
        String oldName = mf.getOriginalFilename();
        String newName = createNewFileName(oldName);
        // 构造一个文件
        File file = new File(rootPath,newName);
        // 构建一个文件夹，当不存在的时候自动创建
        File dir = new File(rootPath);
        // 把 MultipartFile 对象流写到file里
        try {
            if (!dir.exists()){
                dir.mkdirs();
            }
            // 将数据写入到文件
            mf.transferTo(file);
            // 开始组装需要的url
            ArrayList<String> data = new ArrayList<>();
            data.add(picPrefix+"upload/showImage.action?path="+newName);
            resMap.put("data",data);
            return resMap;      // {"errno":"0","data":["showImage.action?path=newName","","",...]}
        }catch (Exception e){
            e.printStackTrace();
            resMap.put("errno",-1);
        }
        return null;
    }

    // 将图片以流的方式响应出去
    @RequestMapping("showImage.action")
    public void showImage(String path, HttpServletResponse response){
        File file=new File(rootPath,path);
        //判断文件是否存在
        if(file.exists()){
            //设置响应类型 通知浏览器 不要打开
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            //设置响应的文件的名称
            //如果响应的数据的名称是中文，在设置文件的名称时 要先将文件的名称进行编码 再进行传输
            try {
                String name = URLEncoder.encode(path, "UTF-8");
                response.setHeader("Content-Disposition", "attachment; filename="+name);
                //构造文件流
                FileInputStream fos=new FileInputStream(file);
                //得到输出流
                ServletOutputStream sos = response.getOutputStream();
                //从文件流里面读向输出流里面写
                byte[] b=new byte[1024];
                int len=0;
                while ((len=fos.read(b))!=-1){
                    sos.write(b,0,len);
                    sos.flush();
                }
                fos.close();
                sos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            try {
                PrintWriter writer = response.getWriter();
                writer.write("file not found");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private String createNewFileName(String oldName) {
        // 获得文件后缀, 带.
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        return UUID.randomUUID()+suffix;
    }
}
