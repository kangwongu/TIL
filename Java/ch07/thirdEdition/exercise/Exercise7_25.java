package thirdEdition.exercise;

import java.util.Arrays;

class Outer {		// 외부 클래스
	class Inner {	// 내부 클래스 (인스턴스 클래스
		int iv = 100;
	}
}

public class Exercise7_25 {
	public static void main(String[] args) {
		Outer out = new Outer();				// 1. 외부 클래스 생성
		Outer.Inner inner = out.new Inner();	// 2. 외부 클래스의 내부 클래스 생성
		System.out.println(inner.iv);
	}
}
