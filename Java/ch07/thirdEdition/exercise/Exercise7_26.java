package thirdEdition.exercise;

import java.util.Arrays;

class Outer2 {				// �ܺ� Ŭ����
	static class Inner {	// ���� Ŭ���� ( ����ƽ Ŭ���� )
		int iv = 200;
	}
}

public class Exercise7_26 {
	public static void main(String[] args) {
		Outer2.Inner inner = new Outer2.Inner();	// 1. �ܺ� Ŭ������ ���� Ŭ����(����ƽ Ŭ����)�ٷ� ����
		System.out.println(inner.iv);
	}
}
