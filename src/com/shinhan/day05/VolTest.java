package com.shinhan.day05;

//23.02.27 7교시 8-1
//8장 LAP1
class VolTest {
	public static void main(String args[]){
		 Volume[] v = new Volume[3];
		 v[0] = new Speaker();
		 v[1] = new Radio();
		 v[2] = new TV();
		 for(int i = 0; i < v.length; i++){
			 for(int j = 1; j <= 3; j++){
		       		v[i].volumeUp(200);
		      }
			 for(int j = 1; j <= 3; j++){
			  	v[i].volumeDown(300);
			 }
		 }
	}
}
