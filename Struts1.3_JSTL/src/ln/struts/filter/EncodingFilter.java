package ln.struts.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 編碼過濾器
 * 需implements Filter
 * 
 * @author Ian Chen
 *
 */
public class EncodingFilter implements Filter {
	private String encoding = "";

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		
		// 設定編碼
//		arg0.setCharacterEncoding("utf-8"); // 寫死在程式
		arg0.setCharacterEncoding(this.encoding); // 讀取web.xml裡的設定
		
		// 讓filter繼續往下走
		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = arg0.getInitParameter("encoding");

	}

}
