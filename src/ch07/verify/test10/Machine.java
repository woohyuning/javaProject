package ch07.verify.test10;

// 07-10-01
public abstract class Machine {

	public int b = 10;
	protected int d = 20;
	int a = 30;
	private int c = 40;

	public void f1() {}
	protected void f2() {}
	void f3() {}
	private void f4() {}
	
	public Machine(int a) {
		
	}
	
	public void powerOn() {}
	
	public void powerOff() {}
	
	public abstract void work();
	
}