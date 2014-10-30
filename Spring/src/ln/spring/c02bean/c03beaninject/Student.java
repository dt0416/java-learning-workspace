package ln.spring.c02bean.c03beaninject;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Student {
	private String name;
	private String[] friends;
	private Teacher[] teachers;
	private List<Teacher> listTeachers;
	private Set<Teacher> setTeachers;
	private Map<String, Teacher> mapTeacher;
	private Teacher myInnerTeacher;
	private Properties pp;
	private String nullObj;
	
	public String getNullObj() {
		return nullObj;
	}

	public void setNullObj(String nullObj) {
		this.nullObj = nullObj;
	}

	public Properties getPp() {
		return pp;
	}

	public void setPp(Properties pp) {
		this.pp = pp;
	}

	public Teacher getMyInnerTeacher() {
		return myInnerTeacher;
	}

	public void setMyInnerTeacher(Teacher myInnerTeacher) {
		this.myInnerTeacher = myInnerTeacher;
	}

	public Map<String, Teacher> getMapTeacher() {
		return mapTeacher;
	}

	public void setMapTeacher(Map<String, Teacher> mapTeacher) {
		this.mapTeacher = mapTeacher;
	}

	public List<Teacher> getListTeachers() {
		return listTeachers;
	}

	public void setListTeachers(List<Teacher> listTeachers) {
		this.listTeachers = listTeachers;
	}

	public Set<Teacher> getSetTeachers() {
		return setTeachers;
	}

	public void setSetTeachers(Set<Teacher> setTeachers) {
		this.setTeachers = setTeachers;
	}

	public Teacher[] getTeachers() {
		return teachers;
	}

	public void setTeachers(Teacher[] teachers) {
		this.teachers = teachers;
	}

	public String[] getFriends() {
		return friends;
	}

	public void setFriends(String[] friend) {
		this.friends = friend;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
