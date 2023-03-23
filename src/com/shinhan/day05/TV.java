package com.shinhan.day05;

// 23.02.27 7교시 8-5
// 8장 LAP1
public class TV implements Volume {
	int volLevel;
	
	@Override
	public void volumeUp(int volLevel) {
		this.volLevel += volLevel;
		System.out.println(getClass().getSimpleName() + " 볼륨 올립니다. " + this.volLevel);

	}
	
	@Override
	public void volumeDown(int volLevel) {
		this.volLevel -= volLevel;
		if(this.volLevel < 0) {
			this.volLevel = 0;
		}
		System.out.println(getClass().getSimpleName() + " 볼륨 내립니다. " + this.volLevel);
	}
}
