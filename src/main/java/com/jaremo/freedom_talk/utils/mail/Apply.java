package com.jaremo.freedom_talk.utils.mail;

import javax.mail.MessagingException;
import javax.mail.Session;
import java.io.IOException;
import java.util.ArrayList;

public class Apply {

    public static void sendEmail(String form, ArrayList<String> toList, String password, String mailType, String subject, String content) throws IOException, MessagingException {
        Session session = MailUtil.createSession(mailType, form, password);
        Mail mail = new Mail(form,toList,mailType,subject,content);
        MailUtil.send(session,mail);
    }

    public static void sendAttachEmail(String form, ArrayList<String> toList, String password, String mailType, String subject, String content,ArrayList<Attach> attaches) throws IOException, MessagingException {
        Session session = MailUtil.createSession(mailType, form, password);
        Mail mail = new Mail(form,toList,mailType,subject,content,attaches);
        MailUtil.send(session,mail);
    }
}
