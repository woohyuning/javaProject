package exam;

class Prob3 {
	public static void main(String args[]) {
		PhoneCharge skt = new PhoneCharge("김현우", 100, 50, 1);
		PhoneCharge ktf = new PhoneCharge("신희만", 200, 100, 2);
		PhoneCharge lgt = new PhoneCharge("조유성", 150, 500, 10);
		skt.printCharge();
		ktf.printCharge();
		lgt.printCharge();
	}
}

class PhoneCharge {
	private String user; // 사용자이름
	private int call; // 통화시간
	private int sms; // 문자전송건수
	private int data; // 데이터통신량
	private int total; // 요금

	public PhoneCharge(String user, int call, int sms, int data) {
		super();
		this.user = user;
		this.call = call;
		this.sms = sms;
		this.data = data;
	}

	public int calsCharge() {
		int callFee = 10; // 통화요금
		int smsFee = 20; // 문자요금
		int dataFee = 1000; // 데이터통신요금

		if (call >= 200) {
			total += (call * callFee) * 2;
		} else {
			total += call * callFee;
		}
		if (sms >= 300) {
			total += (sms * smsFee) * 4;
		} else {
			total += (sms * smsFee);
		}
		if (data >= 7) {
			total += (data * dataFee) * 2;
		} else {
			total += (data *  dataFee);
		}

		return total;
	}
	
	public void printCharge() {
		calsCharge();
		System.out.println(user + " 사용자는 이번달에 사용하신 전화요금이 " + total + " 원입니다.");
	}
}
