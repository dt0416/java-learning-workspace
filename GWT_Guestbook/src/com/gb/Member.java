package com.gb;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Member {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	Long id;
	
	@Persistent
	String userid;
	
	@Persistent
	String password;
	
	@Persistent
	String nickname;
	
	@Persistent
	String email;
	
	public Member() { }
	
	public Member(String userid, String password, String nickname, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.nickname = nickname;
		this.email = email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 供JSTL取得時使用
	 */
	public List<Member> getAllMembers() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
	    Query query = pm.newQuery("SELECT FROM " + Member.class.getName());
	    List<Member> allMember = (List<Member>) query.execute();
	    pm.close();
	    return allMember;
	}
}
