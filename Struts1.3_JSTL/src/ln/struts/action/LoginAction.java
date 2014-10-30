package ln.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ln.struts.actionform.LoginActionForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Action需繼承Action
 * 並Override execute method
 * 
 * @author Ian Chen
 */
public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		LoginActionForm loginFormAction = (LoginActionForm) form;
		
		// JSTL Demo 用
		List<String> userList = new ArrayList<String>();
		userList.add("user1");
		userList.add("user2");
		userList.add("user3");
		request.setAttribute("login", "<a href=\"Login.html\">Login</a>");
		request.setAttribute("ifDemo", "mydemo");
		request.setAttribute("userList", userList);
		
		// 判斷密碼為123導至welcome
		if ("123".equals(loginFormAction.getPassWord())) {
			return mapping.findForward("welcome");
		} else {
			return mapping.findForward("error");
		}
	}

}
