package thirdedition.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise5_8 {
	public static void main(String[] args) {
		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
		int[] counter = new int[4];
		
		// answer�� ��� �����͸� �а� �� ������ ������ ��� ������ŭ �� ���
		
		// 1. answer�� ��� ��ҵ��� ���ڸ� ����
		for(int i=0; i<answer.length; i++) {
			// 2. �迭�� �� ��Ҹ� ��ȸ�ϸ鼭 ���ǹ����� üũ�� ���ڸ� ����, (����� counter�� ���)
			switch(answer[i]) {
			case 1:
				counter[0]++;
				break;
			case 2:
				counter[1]++;
				break;
			case 3:
				counter[2]++;
				break;
			case 4:
				counter[3]++;
			}
		}		
		// �����
		for(int i=0; i<counter.length; i++) {
			System.out.print(counter[i]);
			for(int j=0; j<counter[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
