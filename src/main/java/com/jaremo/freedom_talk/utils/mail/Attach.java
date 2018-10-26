package com.jaremo.freedom_talk.utils.mail;

import java.io.File;

/**
 * 附件
 */
public class Attach {

    private String cid;
    private File file; // 文件
    private String fileName; // 文件名

    public Attach() {
    }

    public Attach(File file, String fileName) {

        this.file = file;
        this.fileName = fileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }
}
