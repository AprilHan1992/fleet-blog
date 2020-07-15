package com.fleet.consumer.controller.blog.file;

import com.fleet.common.enums.ResultState;
import com.fleet.common.json.R;
import com.fleet.common.util.file.FileUtil;
import com.fleet.common.util.file.entity.BigFile;
import com.fleet.consumer.config.FileConfig;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController("BlogBigFileController")
@RequestMapping(value = "/blog/bigFile")
public class BigFileController {

    private Logger logger = LoggerFactory.getLogger(BigFileController.class);

    @Resource
    FileConfig fileConfig;

    /**
     * 秒传判断，断点判断
     */
    @GetMapping("checkFileMd5")
    public R checkFileMd5(String md5) throws Exception {
        File md5Dir = new File(fileConfig.getBigFilePath() + md5);
        if (!md5Dir.exists()) {
            return R.error();
        }
        // state文件记录文件上传进度
        File confFile = new File(fileConfig.getBigFilePath() + md5 + File.separatorChar + "state");
        byte[] completeList = FileUtils.readFileToByteArray(confFile);
        List<Integer> missChunkList = new ArrayList<>();
        for (int i = 0; i < completeList.length; i++) {
            if (completeList[i] != Byte.MAX_VALUE) {
                missChunkList.add(i);
            }
        }
        if (missChunkList.isEmpty()) {
            return R.ok(ResultState.ERROR);
        }
        return R.ok(ResultState.ERROR, missChunkList);
    }

    /**
     * 上传文件
     */
    @PostMapping("/upload")
    public R upload(BigFile bigFile) {
        try {
            bigFile.setFilePath(fileConfig.getBigFilePath());
            // 方法1
            // storageService.uploadFileByRandomAccessFile(param);
            // 方法2 这个更快点
            FileUtil.uploadFileByMappedByteBuffer(bigFile);
        } catch (Exception e) {
            return R.error();
        }
        return R.ok(ResultState.ERROR);
    }
}
