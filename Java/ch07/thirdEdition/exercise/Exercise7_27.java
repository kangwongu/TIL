package thirdEdition.exercise;

import java.util.Arrays;

class Outer3 {				// �ܺ� Ŭ����
	int value = 10;
	
	class Inner2 {			// ���� Ŭ���� ( ����ƽ Ŭ���� )
		int value = 20;
		void method1() {
			int value = 30;
			System.out.println(value);
			System.out.println(this.value);
			System.out.println(Outer3.this.value);
		}
	}
}

public class Exercise7_27 {
	public static void main(String[] args) {
		Outer3 out = new Outer3();
		Outer3.Inner2 inner = out.new Inner2();
		inner.method1();
	}
}
