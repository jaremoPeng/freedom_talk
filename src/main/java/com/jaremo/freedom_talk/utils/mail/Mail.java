package com.jaremo.freedom_talk.utils.mail;

import java.util.ArrayList;

public class Mail {

    private String fromAddress; // 发件人
    private ArrayList<String> toAddressList; // 收件人可存在多个
    private String mailType; // 163,qq,126...
    private String subject; // 邮件主题
    private String content; // 邮件内容
    private ArrayList<Attach> attaches = new ArrayList<>(); // 附件可存在多个

    public Mail() {
    }

    public Mail(String fromAddress, ArrayList<String> toAddressList, String mailType, String subject, String content) {

        this.fromAddress = fromAddress;
        this.toAddressList = toAddressList;
        this.mailType = mailType;
        this.subject = subject;
        this.content = content;
    }

    public Mail(String fromAddress, ArrayList<String> toAddressList, String mailType, String subject, String content, ArrayList<Attach> attaches) {
        this.fromAddress = fromAddress;
        this.toAddressList = toAddressList;
        this.mailType = mailType;
        this.subject = subject;
        this.content = content;
        this.attaches = attaches;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    /**
     * 发件人
     * @param fromAddress
     */
    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getMailType() {
        return mailType;
    }

    /**
     * 设置发件人的类型
     * @param mailType
     */
    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getSubject() {
        return subject;
    }

    /**
     * 设置邮件标题
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    /**
     * 设置内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<String> getToAddressList() {
        return toAddressList;
    }

    /**
     * 设置收件人
     * @param toAddressList
     */
    public void setToAddressList(ArrayList<String> toAddressList) {
        this.toAddressList = toAddressList;
    }

    public ArrayList<Attach> getAttaches() {
        return attaches;
    }

    /**
     * 添加附件
     * @param attaches
     */
    public void setAttaches(ArrayList<Attach> attaches) {
        this.attaches = attaches;
    }
}
