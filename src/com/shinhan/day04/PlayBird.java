package com.shinhan.day04;

//<4-3>
public class PlayBird {
	public static void main(String[] args) {
		Duck d = new Duck("꽥꽥이", 2, 15);
		d.fly();
		d.sing();
		d.display();
		
		Sparrow s = new Sparrow("짹짹", 2, 10);
		s.fly();
		s.sing();
		s.display();
		
		System.out.println(d);
		System.out.println(d.toString());
		
	}
}
