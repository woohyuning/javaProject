package ch07.verify.test12;

public class Example {
	public static void main(String[] args) {
		action(new A());
		action(new B());
		action(new C());
	}

	public static void action(A a) {
		// TODO Auto-generated method stub
		a.method1();
		if(a instanceof C c) {
			c.method2();
		}
	}
}
