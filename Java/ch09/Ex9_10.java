import java.util.StringJoiner;

public class Ex9_10 {
	public static void main(String[] args) {
		// �⺻�� -> ���ڿ�, valueOf()���
		int iVal = 100;
		String strVal = String.valueOf(iVal);
		System.out.println(strVal);
		
		// �⺻�� -> ���ڿ�, valueOf()���
		double dVal = 200.0;
		String strVal2 = String.valueOf(dVal);
		System.out.println(strVal2);
		
		// �⺻�� -> ���ڿ�, + "" ���
		int iVal3 = 150;
		String strVal5 = iVal3 + "";
		System.out.println(strVal5);
		
		// ���ڿ� -> �⺻��, parseXXX()���
		String strVal3 = "150";
		int iVal2 = Integer.parseInt(strVal3);
		System.out.println(iVal2);
		
		// ���ڿ� -> �⺻��, valueOf()���
		String strVal4 = "250.0";
		double dVal2 = Double.valueOf(strVal4);
		System.out.println(dVal2);
		
		
		
	}

}

