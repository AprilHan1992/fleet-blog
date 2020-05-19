package com.fleet.common.util.file;

import com.fleet.common.util.UUIDUtil;
import com.fleet.common.util.file.entity.BigFile;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Method;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 文件工具类
 */
public class FileUtil {

    private final static Logger logger = LoggerFactory.getLogger(FileUtil.class);

    /**
     * 文件上传
     */
    public static void upload(byte[] file, String path, String fileName) throws Exception {
        File fileDir = new File(path);
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(path + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 文件上传
     */
    public static void upload(InputStream in, String path, String fileName) throws Exception {
        File fileDir = new File(path);
        if (!fileDir.exists() && !fileDir.isDirectory()) {
            fileDir.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(path + fileName);
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        in.close();
        out.flush();
        out.close();
    }

    /**
     * 文件下载
     */
    public static void download(String path, String fileName, HttpServletResponse response) throws Exception {
        InputStream in = new FileInputStream(path + fileName);

        response.reset();
        response.setContentType("bin");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }

    /**
     * 批量文件打包下载
     *
     * @throws Exception
     * @bigFile files    文件
     * @bigFile path     缓存Zip包存放位置
     * @bigFile fileName 文件名
     * @bigFile response
     */
    public static void download(File[] files, String path, String fileName, HttpServletResponse response) throws Exception {
        String zipFileName = UUIDUtil.getUUID() + ".zip";
        File zipfile = new File(path + zipFileName);
        if (!zipfile.exists()) {
            zipfile.createNewFile();
        }

        FileOutputStream out = new FileOutputStream(zipfile);
        ZipOutputStream zipOutputStream = new ZipOutputStream(out);
        zipFile(files, zipOutputStream);
        zipOutputStream.finish();
        zipOutputStream.close();
        out.flush();
        out.close();
        downloadZip(zipfile, fileName, response);
    }

    /**
     * 图片在线查看
     */
    public static void image(String path, String fileName, HttpServletResponse response) throws Exception {
        InputStream in = new FileInputStream(path + fileName);

        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }

    public static String rename(String fileName) {
        return UUIDUtil.getUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 全部文件打包
     */
    private static void zipFile(File[] files, ZipOutputStream zipOutputStream) {
        if (files != null) {
            for (File file : files) {
                zipFile(file, zipOutputStream);
            }
        }
    }

    /**
     * 对文件打包
     */
    private static void zipFile(File file, ZipOutputStream zipOutputStream) {
        try {
            if (file.exists()) {
                if (file.isFile()) {
                    FileInputStream in = new FileInputStream(file);
                    ZipEntry entry = new ZipEntry(file.getName());
                    zipOutputStream.putNextEntry(entry);

                    // 向压缩文件中输出数据
                    byte[] b = new byte[1024];
                    int len;
                    while ((len = in.read(b)) > 0) {
                        zipOutputStream.write(b, 0, len);
                    }
                    zipOutputStream.closeEntry();
                    // 关闭创建的流对象
                    in.close();
                } else {
                    try {
                        File[] files = file.listFiles();
                        if (files != null) {
                            for (File value : files) {
                                zipFile(value, zipOutputStream);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 下载Zip文件
     */
    private static void downloadZip(File file, String fileName, HttpServletResponse response) throws Exception {
        FileInputStream in = new FileInputStream(file);

        response.reset();
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes(), "ISO-8859-1"));
        OutputStream out = response.getOutputStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = in.read(b)) > 0) {
            out.write(b, 0, len);
        }
        out.flush();
        out.close();
        in.close();
    }

    /**
     * 在MappedByteBuffer释放后再对它进行读操作的话就会引发jvm crash，在并发情况下很容易发生
     * 正在释放时另一个线程正开始读取，于是crash就发生了。所以为了系统稳定性释放前一般需要检 查是否还有线程在读或写
     */
    public static void mappedByteBuffer(final MappedByteBuffer mappedByteBuffer) {
        try {
            if (mappedByteBuffer == null) {
                return;
            }

            mappedByteBuffer.force();
            AccessController.doPrivileged((PrivilegedAction<Object>) () -> {
                try {
                    Method cleanerMethod = mappedByteBuffer.getClass().getMethod("cleaner");
                    cleanerMethod.setAccessible(true);
                    Object cleaner = cleanerMethod.invoke(mappedByteBuffer);
                    Method cleanMethod = cleaner.getClass().getMethod("clean");
                    cleanMethod.setAccessible(true);
                    cleanMethod.invoke(cleaner);
                } catch (Exception e) {
                    logger.error("clean MappedByteBuffer error!!!", e);
                }
                logger.info("clean MappedByteBuffer completed!!!");
                return null;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void uploadFileByRandomAccessFile(BigFile bigFile) throws IOException {
        String filePath = bigFile.getFilePath() + bigFile.getMd5();
        String fileName = bigFile.getName();
        String tempName = fileName + "_tmp";

        File fileDir = new File(filePath);
        File tempFile = new File(filePath, tempName);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        RandomAccessFile raf = new RandomAccessFile(tempFile, "rw");
        long offset = bigFile.getChunk() * bigFile.getChunkSize();
        //定位到该分片的偏移量
        raf.seek(offset);
        //写入该分片数据
        raf.write(bigFile.getFile().getBytes());
        // 释放
        raf.close();

        boolean isComplete = checkState(bigFile);
        if (isComplete) {
            renameTo(tempFile, fileName);
        }
    }

    /**
     * 分块上传
     * 第一步：获取 RandomAccessFile ，随机访问文件类的对象
     * 第二步：调用 RandomAccessFile 的 getChannel()方法，打开文件通道 FileChannel
     * 第三步：获取当前是第几个分块，计算文件的最后偏移量
     * 第四步：获取当前文件分块的字节数组，用于获取文件字节长度
     * 第五步：使用文件通道 FileChannel 类的 map() 方法创建直接字节缓冲器 MappedByteBuffer
     * 第六步：将分块的字节数组放入到当前位置的缓冲区内 mappedByteBuffer.put(byte[] b);
     * 第七步：释放缓冲区
     * 第八步：检查文件是否全部完成上传
     */
    public static void uploadFileByMappedByteBuffer(BigFile bigFile) throws IOException {
        String filePath = bigFile.getFilePath() + bigFile.getMd5();
        String fileName = bigFile.getName();
        String tempName = fileName + "_tmp";

        File fileDir = new File(filePath);
        File tempFile = new File(filePath, tempName);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }

        //第一步
        RandomAccessFile raf = new RandomAccessFile(tempFile, "rw");
        //第二步
        FileChannel fc = raf.getChannel();
        //第三步
        long offset = bigFile.getChunk() * bigFile.getChunkSize();
        //第四步
        byte[] bytes = bigFile.getFile().getBytes();
        //第五步
        MappedByteBuffer mappedByteBuffer = fc.map(FileChannel.MapMode.READ_WRITE, offset, bytes.length);
        //第六步
        mappedByteBuffer.put(bytes);
        //第七步
        FileUtil.mappedByteBuffer(mappedByteBuffer);
        fc.close();
        raf.close();
        //第八步
        boolean isComplete = checkState(bigFile);
        if (isComplete) {
            renameTo(tempFile, fileName);
        }
    }

    /**
     * 检查文件上传进度
     */
    public static boolean checkState(BigFile bigFile) throws IOException {
        File confFile = new File(bigFile.getFilePath() + bigFile.getMd5(), "state");
        RandomAccessFile raf = new RandomAccessFile(confFile, "rw");
        //设置文件长度
        raf.setLength(bigFile.getChunks());
        //设置起始偏移量
        raf.seek(bigFile.getChunk());
        //将指定的一个字节写入文件中 127
        raf.write(Byte.MAX_VALUE);
        byte[] completeStateList = FileUtils.readFileToByteArray(confFile);
        byte isComplete = Byte.MAX_VALUE;
        //这一段逻辑有点复杂，看的时候思考了好久，创建conf文件文件长度为总分片数，每上传一个分块即向conf文件中写入一个127，那么没上传的位置就是默认的0,已上传的就是Byte.MAX_VALUE 127
        for (int i = 0; i < completeStateList.length && isComplete == Byte.MAX_VALUE; i++) {
            // 按位与运算，将&两边的数转为二进制进行比较，有一个为0结果为0，全为1结果为1  eg.3&5  即 0000 0011 & 0000 0101 = 0000 0001   因此，3&5的值得1。
            isComplete = (byte) (isComplete & completeStateList[i]);
            System.out.println("check part " + i + " complete?:" + completeStateList[i]);
        }
        raf.close();
        if (isComplete == Byte.MAX_VALUE) {
            return true;
        }
        return false;
    }

    /**
     * 文件重命名
     *
     * @bigFile file    将要修改名字的文件
     * @bigFile newName 新的名字
     */
    private static boolean renameTo(File file, String newName) {
        // 检查要重命名的文件是否存在，是否是文件
        if (!file.exists() || file.isDirectory()) {
            logger.info("File does not exist: " + file.getName());
            return false;
        }
        String p = file.getParent();
        File newFile = new File(p + File.separatorChar + newName);
        // 修改文件名
        return file.renameTo(newFile);
    }

}
