package com.shinhan.day05;

// 23.02.27 2교시 2-4
public class CarTest {
	void go(Tire tire) {
		tire.roll();
		if(tire instanceof KumhoTire) {
			KumhoTire kum = (KumhoTire) tire;
			System.out.println(kum.intro);
		} else if(tire instanceof HankokTire han) {
			System.out.println(han.info);
		}
	}
}
