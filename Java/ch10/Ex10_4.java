import java.util.Calendar;

public class Ex10_4 {
	public static void main(String[] args) {
		Calendar date = Calendar.getInstance();
		date.set(2019, 0, 7);
		
		System.out.println(toString(date));
		System.out.println("= 1�� �� =");
		date.add(Calendar.DATE, 25);	// �ٸ� �ʵ忡 ������ ��ħ
		System.out.println(toString(date));
		
		System.out.println("= 2�� �� =");
		date.add(Calendar.MONTH, -2);
		System.out.println(toString(date));
		
		System.out.println("= 31�� �� =");
		date.roll(Calendar.DATE, 31);	// �ٸ� �ʵ忡 ������ ��ġ�� ����
		System.out.println(toString(date));
	
		System.out.println("= 31�� �� =");
		date.add(Calendar.DATE, 31);
		System.out.println(toString(date));
	}
	

	// ��¥ ���
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR)+"�� "+(date.get(Calendar.MONTH)+1)
				+"�� "+date.get(Calendar.DATE)+"�� ";
	}
}

