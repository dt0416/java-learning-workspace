package com.gb.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gb.Member;
import com.gb.PMF;

public class RegServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		String nickname = req.getParameter("nickname");
		String email = req.getParameter("email");
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Member member = new Member(userid, password, nickname, email);
        pm.makePersistent(member);
        pm.close();
        PrintWriter out = resp.getWriter();
        out.println("會員註冊成功");
	}
	
}
