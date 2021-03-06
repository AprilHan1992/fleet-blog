package com.fleet.common.util.word;

import com.fleet.common.util.UUIDUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;
import java.util.Locale;
import java.util.Map;

/**
 * Word工具类
 */
public class WordUtil {

    private Configuration config;

    public WordUtil() {
        config = new Configuration(Configuration.VERSION_2_3_29);
        config.setEncoding(Locale.getDefault(), "UTF-8");
        config.setClassicCompatible(true);
    }

    /**
     * 根据word xml模板生成word文档
     */
    public void export(Map<String, Object> map, String tempPath, String tempName, OutputStream out) throws Exception {
        File file = getTempFile(map, tempPath, tempName);

        InputStream in = new FileInputStream(file);
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
     * 生成word文档缓存文件
     *
     * @param map      替换数据
     * @param tempPath 缓存目录
     * @param tempFile resources/template下模板文件
     * @return
     * @throws IOException
     * @throws TemplateException
     */
    public File getTempFile(Map<String, Object> map, String tempPath, String tempFile) throws Exception {
        config.setClassForTemplateLoading(WordUtil.class, "/template");
        Template template = config.getTemplate(tempFile);
        File file = new File(tempPath + UUIDUtil.getUUID() + ".doc");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        template.process(map, writer);
        writer.flush();
        writer.close();
        return file;
    }
}
