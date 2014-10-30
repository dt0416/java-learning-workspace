package com.mail;

import java.io.IOException;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 接收到Mail自動化作業
 * 需覆寫「doPost」方法
 * @author Ian Chen
 *
 */
public class MailServiceServlet extends HttpServlet {
    public static final Logger log = Logger.getLogger(MailServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            MailRelate.receiveMail(req.getInputStream());
        } catch (MessagingException ex) {
            ex.printStackTrace();
            log.warning(ex.toString());
        }
    }
}
