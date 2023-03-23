package com.shinhan.day06;

//23.02.28 1교시 복습-5
public class LabelTest {
	public static void main(String[] args) {
		Label la1 = new Label("이름입력", 20, 5, "black", "large");
		Resizable la2 = new Label("이름입력", 20, 5, "black", "large");
		Colorable la3 = new Label("이름입력", 20, 5, "black", "large");
		Changeale la4 = new Label("이름입력", 20, 5, "black", "large");
		
		work(la1);
//		work(la2);
//		work(la3);
		work(la4);
	}
//	자동형변환 : 부모타입_객체참조변수 = 자식객체
	private static void work(Changeale aa) {
		// TODO Auto-generated method stub
		if(aa instanceof Label label) {
			label.setBackground(null);
			label.setFont(null);
			label.setForeground(null);
			label.size(0, 0);
		}
	}
}
