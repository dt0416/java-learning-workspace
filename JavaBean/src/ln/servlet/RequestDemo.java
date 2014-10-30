package ln.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <pre> Servlet implementation class RequestDemo. </pre>
 *
 * @author Ian Chen
 */
public class RequestDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestDemo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  String[] name = request.getParameterValues("name"); // 同名多個input
      System.out.println("=====getParameterValues=====");
	  for (String string : name) {
	      System.out.println(string);
      }

	  System.out.println("=====getParameter====="); // 只有1個input
	  String age = request.getParameter("age");
      System.out.println("age:" + age);
      
      System.out.println("=====getParameterNames====="); // 列出所有parameter
      Enumeration<String> aaa = request.getParameterNames();
      while (aaa.hasMoreElements()) {
        String o = aaa.nextElement();
        System.out.println(o);
      }
	}

}
