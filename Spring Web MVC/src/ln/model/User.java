package ln.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 假設此為自行建立的物件
 * 
 * @author Ian Chen
 */
public class User {
    private String userName;
    private String password;
    private String nickName;
    private String email;
    
    public User() {}
    
    public User(String userName, String password, String nickName, String email) {
        super();
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.email = email;
    }
    @NotEmpty(message="不可為空")
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    @Pattern(regexp="\\D+\\d+", message="需為字元+數字")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Size(min=2, message="不可小於2個字")
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    @Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
