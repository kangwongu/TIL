package thirdedition.exercise;

public class Exercise4_4 {
	
	public static void main(String[] args) {
		int gob = 1;	// ������ ���ϱ� ���� ��
		int sum = 0;
		int num = 0;
		
		for(int i=1; true; i++, gob=-gob) {
			// 1, -2, 3, -4 ...
			num = i * gob;
			System.out.println(num);
			sum+=num;	
			
			// ������ 100�̻��̸� ����
			if(sum>=100)
				break;
		}
		System.out.println(num);
		System.out.println(sum);
		
	}

}
