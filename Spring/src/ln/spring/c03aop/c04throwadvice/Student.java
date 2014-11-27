package ln.spring.c03aop.c04throwadvice;

public class Student implements IStudent {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void sayHello() throws Exception {
		System.out.println(String.format("Student Hello!! My Name is %s", name));
		throw new Exception("sayHelloException");
	}

	@Override
	public void sayBye() {
		System.out.println(String.format("Student Bye!! My Name is %s", name));
	}
	
}