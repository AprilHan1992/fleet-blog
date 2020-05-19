package com.fleet.common.util.file.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

public class BigFile implements Serializable {

    private static final long serialVersionUID = 6169188357155442546L;

    /**
     * 文件保存路径
     */
    private String filePath;

    /**
     * 分片大小（与前端保持一致）
     */
    private Long chunkSize;

    /**
     * 总分片数量
     */
    private int chunks;

    /**
     * 当前为第几分片
     */
    private int chunk;

    /**
     * 分块文件
     */
    private MultipartFile file;

    /**
     * 文件名
     */
    private String name;

    /**
     * MD5
     */
    private String md5;

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Long getChunkSize() {
        return chunkSize;
    }

    public void setChunkSize(Long chunkSize) {
        this.chunkSize = chunkSize;
    }

    public int getChunks() {
        return chunks;
    }

    public void setChunks(int chunks) {
        this.chunks = chunks;
    }

    public int getChunk() {
        return chunk;
    }

    public void setChunk(int chunk) {
        this.chunk = chunk;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }
}
