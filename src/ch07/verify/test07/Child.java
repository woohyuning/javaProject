package ch07.verify.test07;

//07-07-02
public class Child extends Parent {
	public String name;
	
	public Child() {
		// TODO Auto-generated constructor stub
		this("홍길동");
		System.out.println("Child() call");
	}

	public Child(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		System.out.println("Child(String name) call");
	}	
}
