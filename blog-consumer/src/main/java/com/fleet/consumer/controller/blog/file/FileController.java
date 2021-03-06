package com.fleet.consumer.controller.blog.file;

import com.fleet.common.json.R;
import com.fleet.common.util.file.FileUtil;
import com.fleet.consumer.config.FileConfig;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

@RestController("BlogFileController")
@RequestMapping("/blog/file")
public class FileController {

    @Resource
    FileConfig fileConfig;

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public R upload(@RequestParam(value = "file") MultipartFile file) throws Exception {
        if (file == null) {
            return R.error("上传文件为空");
        }

        try {
            String fileName = FileUtil.rename(file.getOriginalFilename());
            FileUtil.upload(file.getBytes(), fileConfig.getFilePath(), fileName);
            return R.ok(fileName);
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 上传图片文件
     */
    @PostMapping("/image/upload")
    public R imageUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file == null) {
            return R.error("上传图片文件为空");
        }

        try {
            String fileName = FileUtil.rename(file.getOriginalFilename());
            FileUtil.upload(file.getBytes(), fileConfig.getImgPath(), fileName);
            String url = "/file/image/view/" + fileName;
            return R.ok(url);
        } catch (Exception e) {
            return R.error();
        }
    }

    /**
     * 查看图片
     */
    @GetMapping("/image/view/{fileName:.+}")
    public void imageView(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        if (fileName == null) {
            return;
        }
        FileUtil.image(fileConfig.getImgPath(), fileName, response);
    }

    /**
     * 下载文件
     */
    @GetMapping("/download/{fileName:.+}")
    public void downLoadFile(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        FileUtil.download(fileConfig.getFilePath(), fileName, response);
    }

    /**
     * 下载图片文件
     */
    @GetMapping("/image/download/{fileName:.+}")
    public void imageDownLoad(@PathVariable("fileName") String fileName, HttpServletResponse response) throws Exception {
        FileUtil.download(fileConfig.getImgPath(), fileName, response);
    }

    /**
     * 批量下载文件
     */
    @RequestMapping("/download")
    public void downLoadFiles(HttpServletResponse response) throws Exception {
        File[] files = new File[3];
        files[0] = new File(fileConfig.getImgPath() + "1.jpg");
        files[1] = new File(fileConfig.getImgPath() + "2.jpg");
        files[2] = new File(fileConfig.getImgPath());
        FileUtil.download(files, fileConfig.getFilePath(), "图片.zip", response);
    }
}
