package com.gb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 在GAE專案也可使用Servlet
 * 此為一般的Servlet範例，也必需在web.xml裡做設定
 * 瀏覽http://127.0.0.1:8888/hello即可看到結果
 * 中文會有亂碼問題，待有需要再處理
 * 
 * @author Ian Chen
 *
 */
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.getWriter().println("HELLO測試");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
