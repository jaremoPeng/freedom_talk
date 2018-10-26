package com.jaremo.freedom_talk.utils.mail;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class MailUtil {

    public static Session createSession(String mailType,String fromAddress,String password){
        //创建Properties 类用于记录邮箱的一些属性
        final Properties props = new Properties();
        // 指定验证为true
        props.setProperty("mail.smtp.auth", "true");

        //此处填写SMTP服务器
        mailType = mailType.toLowerCase();
        if(mailType.equals("qq")){ // 判定发件人是用QQ邮箱
            props.put("mail.smtp.host", "smtp.qq.com");
            // 指定smtp端口号
            props.put("mail.smtp.port", "587");

        }else{
            props.put("mail.smtp.host", "smtp.163.com");
        }

        //此处填写你的账号
        props.put("mail.user", fromAddress);
        //此处的密码就是前面说的16位STMP口令
        props.put("mail.password", password);
        //构建授权信息，用于进行SMTP进行身份验证
        Authenticator authenticator = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                // 用户名、密码
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };

        //使用环境属性和授权信息，创建邮件会话
        Session mailSession = Session.getInstance(props, authenticator);
        return  mailSession;
    }

    /**
     *  发送邮件
     * @param session
     * @param mail
     */
    public static void send(Session session,final Mail mail) throws MessagingException,IOException {
        //创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 获取到所有的收件人
        ArrayList<String> toAddressList = mail.getToAddressList();
        if(toAddressList.size()!=0){
            for (String toAddress:toAddressList) {
                // 设置发件人
                message.setFrom(new InternetAddress(mail.getFromAddress()));
                // 设置收件人
                message.addRecipients(Message.RecipientType.TO, toAddress);
                // 设置主题
                message.setSubject(mail.getSubject());
                // 获取所有的附件
                ArrayList<Attach> attaches = mail.getAttaches();
                if(attaches.size()!=0){ // 判断是否有附件
                    // 创建部件集对象
                    MimeMultipart parts = new MimeMultipart();
                    // 创建一个部件
                    MimeBodyPart part = new MimeBodyPart();
                    // 设置邮件文本内容
                    part.setContent(mail.getContent(), "text/html;charset=utf-8");
                    // 把部件添加到部件集中
                    parts.addBodyPart(part);
                    for (Attach attach : attaches) {
                        MimeBodyPart attachPart = new MimeBodyPart();// 创建一个部件
                        attachPart.attachFile(attach.getFile());// 设置附件文件
                        attachPart.setFileName(MimeUtility.encodeText(attach.getFileName()));// 设置附件文件名
                        String cid = attach.getCid();
                        if(cid != null) {
                            attachPart.setContentID(cid);
                        }
                        parts.addBodyPart(attachPart);
                        message.setContent(parts);// 给邮件设置内容
                    }
                    Transport.send(message);// 发邮件
                }else {
                    //设置邮件的内容体
                    message.setContent(mail.getContent() , "text/html;charset=UTF-8");
                    Transport.send(message);
                }
            }
        }
    }
}
