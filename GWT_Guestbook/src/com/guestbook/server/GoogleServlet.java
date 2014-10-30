package com.guestbook.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class GoogleServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        if (user == null) {
            String loginUrl  = userService.createLoginURL("/google");
            out.println("尚未登入");
            out.println("<br /><a href=\"" + loginUrl + "\">登入Google帳號</a>");
        } else {
            out.println("已登入Google帳號, Email:" + user.getEmail());
            out.println("<br /><a href=\"" + userService.createLogoutURL("/google") + "\">登出Google帳號</a>");
        }
        out.println("</html></body>");
    }
    
}
