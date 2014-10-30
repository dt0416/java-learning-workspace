package com.mail;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 郵件傳送、接收
 * @author Ian Chen
 *
 */
public class MailRelate {
    public static final Logger log = Logger.getLogger(MailServlet.class.getName());
    
    /**
     * 傳送郵件
     * @param fromAddress
     * @param toAddress
     * @param subject
     * @param text
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMail(String fromAddress, String toAddress, String subject, String text) throws AddressException, MessagingException {
        Properties prop = new Properties();
        Session session = Session.getDefaultInstance(prop);
        InternetAddress from = new InternetAddress(fromAddress);
        InternetAddress to = new InternetAddress(toAddress);
        Message message = new MimeMessage(session);
        message.setFrom(from);
        message.setRecipient(Message.RecipientType.TO, to);
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
    }
    
    /**
     * 接收郵件
     * @param in
     * @throws MessagingException
     * @throws IOException
     */
    public static void receiveMail(InputStream in) throws MessagingException, IOException {
        Properties prop = new Properties();
        Session session = Session.getDefaultInstance(prop);
        Message message = new MimeMessage(session, in);
        String subject = message.getSubject();
        String content = getText(message);
        log.info("郵件內容:" + content);
        Address[] addrs = message.getFrom();
        log.info(subject);
        for (Address address : addrs) {
            log.info(address.toString());
        }
    }
    
    /**
     * 依MimeType擷取郵件內容
     * @param part
     * @return
     * @throws MessagingException
     * @throws IOException
     */
    private static String getText(Part part) throws MessagingException, IOException {
        String content = null;
        if (part.isMimeType("text/*")) {
            log.info("CONTENT is text/*");
            content = (String) part.getContent();
        } else if (part.isMimeType("multipart/alternative")) { // 利用遞迴取得每個Part的內容
            log.info("CONTENT is multipart/alternative");
            Multipart mpart = (Multipart) part.getContent();
            for (int index = 0; index < mpart.getCount(); index++) {
                Part p = mpart.getBodyPart(index);
                content = getText(p);
                log.info("mpart " + index + ":" + content);
            }
        }
        return content;
    }
}
