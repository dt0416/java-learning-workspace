package ln.spring.c02bean.c01beanscope;

public class Teacher {
	private String name;
	
	// Constructor
	public Teacher() {
		System.out.println("Teacher Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(String.format("Teacher Hello!! My Name is %s", name));
	}
}
