package thirdEdition.exercise;

import java.util.Arrays;

class Outer {		// �ܺ� Ŭ����
	class Inner {	// ���� Ŭ���� (�ν��Ͻ� Ŭ����
		int iv = 100;
	}
}

public class Exercise7_25 {
	public static void main(String[] args) {
		Outer out = new Outer();				// 1. �ܺ� Ŭ���� ����
		Outer.Inner inner = out.new Inner();	// 2. �ܺ� Ŭ������ ���� Ŭ���� ����
		System.out.println(inner.iv);
	}
}
