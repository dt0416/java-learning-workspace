package ln.spring.c01start.c03applicationcontext;

public class Student {
	private String name;
	
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
