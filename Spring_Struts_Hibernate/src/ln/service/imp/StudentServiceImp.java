package ln.service.imp;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import ln.service.StudentService;
import ln.spring.hibernate.pojo.Student;

@Transactional
public class StudentServiceImp implements StudentService {

    private SessionFactory sessionFactory;
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        // 取得ID最大值
        Query query = session.createQuery("select max(id) from Student");
        int max = (int) query.uniqueResult();
        student.setId(max + 1); // 設定ID
        session.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public void delStudent(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        String del = String.format("delete Student where id = %s", id);
        Query query = session.createQuery(del);
        int result = query.executeUpdate();
    }

    @Override
    public List queryStudent() {
        Session session = this.sessionFactory.getCurrentSession();
        return session.createQuery("from Student").list();
    }

    @Override
    public Student queryById(String id) {
        Session session = this.sessionFactory.getCurrentSession();
        Student student = (Student) session.load(Student.class, new Integer(id));
        return student;
    }
}
