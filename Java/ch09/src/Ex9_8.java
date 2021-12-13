import java.util.Arrays;
import java.util.StringJoiner;

public class Ex9_8 {
	public static void main(String[] args) {
		
		String str1 = "Kang Won Gu";
		// ���ڿ��� ����������� ������ ���ڿ� �迭�� ����
		String[] arr = str1.split(" ");
		for(String str : arr)
			System.out.println(str);
		
		String str2 = "�����,�λ��,�뱸��,������,ȭ����,������";
		String[] arr2 = str2.split(",");
		System.out.println(Arrays.toString(arr2));
		for(String str : arr2)
			System.out.print(str+"\t");
	
		// ���ڿ��迭 -> ���ڿ�
		String str = String.join("-", arr2);
		System.out.println(str);
		
		// StringJoiner�̿��� ���ڿ� ����
		StringJoiner sj = new StringJoiner("/", "[", "]");
		for(String s : arr)
			sj.add(s);
		System.out.println(sj);
		
		
		String str3 = str1.substring(5);
		System.out.println("\n"+str3);
		
		String str4 = str1.substring(9);			// str1�� 9��°�ڸ����� ������ �߶�
		System.out.println(str4);
		
		String str5 = str2.substring(4, 15);		// str2�� 4��°���� 14��°�ڸ����� �߶�
		System.out.println(str5);
		
		System.out.println(str1.indexOf("Gu"));		// "Gu"�� Ž��
		System.out.println(str1.indexOf('W'));	
		System.out.println(str1.indexOf('n'));		// 'n'�� ó������ Ž��
		
		System.out.println(str1.indexOf('n', 5));	// 'n'�� 5��°�ڸ� ���ĺ��� Ž��
		
	}
}

