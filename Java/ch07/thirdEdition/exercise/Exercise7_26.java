package thirdEdition.exercise;

import java.util.Arrays;

class Outer2 {				// 외부 클래스
	static class Inner {	// 내부 클래스 ( 스태틱 클래스 )
		int iv = 200;
	}
}

public class Exercise7_26 {
	public static void main(String[] args) {
		Outer2.Inner inner = new Outer2.Inner();	// 1. 외부 클래스의 내부 클래스(스태틱 클래스)바로 생성
		System.out.println(inner.iv);
	}
}
