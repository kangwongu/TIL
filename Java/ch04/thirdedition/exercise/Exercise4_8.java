package thirdedition.exercise;

public class Exercise4_8 {
	
	public static void main(String[] args) {
		// x�� 0~10
		for(int i=0; i<=10; i++) {
			// y 0~10
			for(int j=0; j<=10; j++) {
				// 2x+4y=10�� �����ϴ� ��쿡�� ���
				if((2*i)+(4*j)==10) {
					System.out.println("x="+i+", y="+j);
				}
			}
		}
	}
}
