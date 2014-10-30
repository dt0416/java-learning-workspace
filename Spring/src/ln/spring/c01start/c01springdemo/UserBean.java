package ln.spring.c01start.c01springdemo;

public class UserBean {
	private String name;

	// Constructor
	public UserBean() {
		System.out.println("UserBean Constructor");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(String.format("UserBean Hello!! My Name is %s", name));
	}
}
