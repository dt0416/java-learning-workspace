package ln.hibernate.c01hibernatedemo.pojo;
// Generated 2013/12/6 下午 03:03:08 by Hibernate Tools 3.4.0.CR1


import java.util.HashSet;
import java.util.Set;

/**
 * Student generated by hbm2java
 */
public class Student  implements java.io.Serializable {


     private int id;
     private String name;
     private String email;
     private Integer age;
     private Set studentcourses = new HashSet(0);

    public Student() {
    }

	
    public Student(int id) {
        this.id = id;
    }
    public Student(int id, String name, String email, Integer age, Set studentcourses) {
       this.id = id;
       this.name = name;
       this.email = email;
       this.age = age;
       this.studentcourses = studentcourses;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getAge() {
        return this.age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    public Set getStudentcourses() {
        return this.studentcourses;
    }
    
    public void setStudentcourses(Set studentcourses) {
        this.studentcourses = studentcourses;
    }




}


