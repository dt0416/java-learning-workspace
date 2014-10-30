package ln.struts.actionform;

import org.apache.struts.action.ActionForm;

/**
 * ActionForm需繼承ActionForm
 * 
 * @author Ian Chen
 */
public class LoginActionForm extends ActionForm {
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
}
