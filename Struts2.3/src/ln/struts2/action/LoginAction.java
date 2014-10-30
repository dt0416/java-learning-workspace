package ln.struts2.action;

import com.opensymphony.xwork2.Action;

/**
 * Action需實作com.opensymphony.xwork2.Action
 * 並Override execute method
 * 
 * @author Ian Chen
 */
public class LoginAction implements Action {
    private String userName;
    private String passWord;
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String execute() throws Exception {
        // 判斷密碼為123導至welcome
        if ("123".equals(passWord)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }
}
