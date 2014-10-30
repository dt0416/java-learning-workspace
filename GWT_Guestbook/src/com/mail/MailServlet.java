package com.mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 寄送郵件
 * @author Ian Chen
 *
 */
public class MailServlet extends HttpServlet {

    public static final Logger log = Logger.getLogger(MailServlet.class.getName());
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();
            // 不可使用沒認證的信箱當寄件者
            MailRelate.sendMail("dt0416@gmail.com", "dt0416@pchome.com.tw", "GAE mail", "郵送郵件成功!!");
            out.print("郵件成功寄出");
        } catch (AddressException e) {
            e.printStackTrace();
            log.warning(e.toString());
        } catch (MessagingException e) {
            e.printStackTrace();
            log.warning(e.toString());
        }
    }
}
