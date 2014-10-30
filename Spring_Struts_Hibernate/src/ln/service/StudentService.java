package ln.service;

import java.util.List;

import ln.spring.hibernate.pojo.Student;

public interface StudentService {
    public void addStudent(Student student);
    public void updateStudent(Student student);
    public void delStudent(String id);
    public List queryStudent();
    public Student queryById(String id);
}
