package ln.spring.c02bean.c05beanautowire;

public class Student {
    private String name;
    private Teacher teacher;
    
    /**
     * 此方法提供給autowire="constructor"時使用
     * 當沒有此方法會有Exception
     * @param tea
     */
    public Student(Teacher tea) {
        System.out.println("Student(Teacher)");
        this.teacher = tea;
    }

    public Student() {
        System.out.println("Student()");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
      System.out.println("setTeacher()");
      this.teacher = teacher;
    }
}
