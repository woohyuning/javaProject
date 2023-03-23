package ch07.verify.test07;

//07-07-01
public class Parent {
	public String nation;
	
	public Parent() {
		// TODO Auto-generated constructor stub
		this("대한민국");
		System.out.println("Parent() call");
	}

	public Parent(String nation) {
		// TODO Auto-generated constructor stub
		this.nation = nation;
		System.out.println("Parent(String nation) call");
	}
}
