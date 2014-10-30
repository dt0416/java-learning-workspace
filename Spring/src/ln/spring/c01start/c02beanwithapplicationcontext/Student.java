package ln.spring.c01start.c02beanwithapplicationcontext;

public class Student {
	private String name;
	
	// Constructor
	public Student() {
		System.out.println("Student Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(String.format("Student Hello!! My Name is %s", name));
	}
}
