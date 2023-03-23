package com.shinhan.day09;

// 23.03.06 3교시 1-2
// 14장-5 스레드 상태 page.602
// 23.03.06 5교시 1-5
// 14.6 스레드 동기화 page.612
// 23.03.06 6교시 1-4
// 14.6 스레드 동기화 page.615
// 23.03.06 6교시 2-2
// 14.7 스레드 안전 종료 page.618
//23.03.06 6교시 3-2
//14.7 데몬 스레드 page.624
public class ThreadTest4 {
	public static void main(String[] args) throws InterruptedException {
//		f1();
//		f2();
//		f3();
//		f4();
//		f5();
//		f6();
//		f7();
//		f8();
//		f9();
//		f10();
		f11();
	}

//	23.03.06 6교시 3-2
//	14.8 데몬 스레드 page.624
	private static void f11() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); // main thread 종료 시 데몬이 종료
		t1.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("main end");
	}

//	23.03.06 6교시 2-6
//	14.7 스레드 안전 종료 page.622
	private static void f10() {
		SafeThread t1 = new SafeThread();
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}

//	23.03.06 6교시 2-4
//	14.7 스레드 안전 종료 page.621
	private static void f9() {
		SafeThread t1 = new SafeThread();
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.interrupt();
	}

//	23.03.06 6교시 2-2
//	14.7 스레드 안전 종료 page.618
	private static void f8() {
		SafeThread t1 = new SafeThread();
		t1.start();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t1.setStop(true);
//		t1.stop(); 사용하지 않는 것이 좋다
	}

//	23.03.06 6교시 1-4
//	14.6 스레드 동기화 page.615
	private static void f7() {
		WorkObject obj = new WorkObject();
		ThreadA t1 = new ThreadA(obj);
		ThreadB t2 = new ThreadB(obj);

		t1.start();
		t2.start();
	}

//	23.03.06 5교시 2-1
//	14.6 스레드 동기화 page.614
	private static void f6() {
		BathRoom bathroom = new BathRoom();

		BathThread t1 = new BathThread(bathroom, "김씨");
		BathThread t2 = new BathThread(bathroom, "박씨");
		BathThread t3 = new BathThread(bathroom, "정씨");
		BathThread t4 = new BathThread(bathroom, "최씨");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

//	23.03.06 5교시 1-5
//	14.6 스레드 동기화 page.612
	private static void f5() {
		ShareArea share = new ShareArea(new Account("12345", "성춘향", 1000), new Account("78896", "이몽룡", 2000));
		TransferThread t1 = new TransferThread(share);
		PrintThread t2 = new PrintThread(share);

		t1.start();
		t2.start();
	}

//	23.03.06 4교시 1-4
//	14.6 스레드 동기화 page.612
//	동기화
	private static void f4() {
		User1Thread t1 = new User1Thread();
		User2Thread t2 = new User2Thread();
//		Calculator는 2개의 thread가 공유하는 공유영역
		Calculator cal = new Calculator();
		t1.setCalculator(cal);
		t2.setCalculator(cal);

		t1.start();
		t2.start();
	}

//	23.03.06 3교시 2-3
//	14.6 스레드 동기화 page.609
//	동기화(공유영역을 하나의 쓰레드가 사용중 일때 다른쓰레드가 접근금지)
	private static void f3() {
		BathRoom bathroom = new BathRoom();

		BathThread t1 = new BathThread(bathroom, "김씨");
		BathThread t2 = new BathThread(bathroom, "박씨");
		BathThread t3 = new BathThread(bathroom, "정씨");
		BathThread t4 = new BathThread(bathroom, "최씨");

		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

//	23.03.06 3교시 1-4
//	join test
	private static void f2() {
		SumThread t1 = new SumThread(1, 50);
		SumThread t2 = new SumThread(51, 100);
		t1.start();
		t2.start();
		try {
//			Thread.sleep(3000);
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("t1.getSum() : " + t1.getSum());
		System.out.println("t2.getSum() : " + t2.getSum());
		System.out.println("t1.getSum() + t2.getSum() : " + (t1.getSum() + t2.getSum()));
		System.out.println("main end.......");
	}

//	23.03.06 3교시 1-2
//	yield test
	private static void f1() throws InterruptedException {
		WorkThread t1 = new WorkThread("[ 쓰레드A ]");
		WorkThread t2 = new WorkThread("[ 쓰레드B ]");

		t1.start();
		t2.start();
//		5초간 일시정지
		Thread.sleep(5000);
//		t1의 work를 false... t1스레드가 다른스레드에 양보한다
		t1.work = false;
//		10초 후
		Thread.sleep(10000);
//		t1의 work를 true
		t1.work = true;
	}
}
