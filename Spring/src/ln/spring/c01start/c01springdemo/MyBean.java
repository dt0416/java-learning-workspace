package ln.spring.c01start.c01springdemo;

public class MyBean {
	private String name;
	private UserBean ub;

	// Constructor
	public MyBean() {
		System.out.println("MyBean Constructor");
	}

	public UserBean getUb() {
		return ub;
	}

	public void setUb(UserBean ub) {
		this.ub = ub;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void sayHello() {
		System.out.println(String.format("MyBean Hello!! My Name is %s", name));
		ub.sayHello();
	}
}
