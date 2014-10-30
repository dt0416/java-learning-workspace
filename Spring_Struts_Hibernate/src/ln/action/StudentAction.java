package ln.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ln.actionform.StudentActionForm;
import ln.service.StudentService;
import ln.spring.hibernate.pojo.Student;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class StudentAction extends DispatchAction {
    private StudentService studentServiceInter;
    
    public void setStudentServiceInter(StudentService studentServiceInter) {
        this.studentServiceInter = studentServiceInter;
    }

    public ActionForward showStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List students = studentServiceInter.queryStudent();
        request.setAttribute("students", students);
        return mapping.findForward("success");
    }
    
    public ActionForward addStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentActionForm studentForm = (StudentActionForm) form;
        Student student = new Student();
        student.setName(studentForm.getName());
        student.setEmail(studentForm.getEmail());
        student.setAge(studentForm.getAge());
        
        studentServiceInter.addStudent(student);
        // 取得所有學生
        List students = studentServiceInter.queryStudent();
        request.setAttribute("students", students);
        return mapping.findForward("success");
    }
    
    public ActionForward delStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        studentServiceInter.delStudent(id);
        // 取得所有學生
        List students = studentServiceInter.queryStudent();
        request.setAttribute("students", students);
        return mapping.findForward("success");
    }
    
    public ActionForward goUpdStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String id = request.getParameter("id");
        Student student = studentServiceInter.queryById(id);
        request.setAttribute("student", student);
        return mapping.findForward("update");
    }
    
    public ActionForward updStudent(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        StudentActionForm studentForm = (StudentActionForm) form;
        Student student = new Student(Integer.parseInt(studentForm.getId()));
        student.setName(studentForm.getName());
        student.setEmail(studentForm.getEmail());
        student.setAge(studentForm.getAge());
        
        studentServiceInter.updateStudent(student);
        // 取得所有學生
        List students = studentServiceInter.queryStudent();
        request.setAttribute("students", students);
        return mapping.findForward("success");
    }
}
