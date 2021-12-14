import java.util.Arrays;
import java.util.StringJoiner;

public class Ex9_9 {
	public static void main(String[] args) {
		// ��ȣ�� ���Ե� ���ڿ�
		String animals = "dog,cat,bear";
		
		// split�޼ҵ� �̿��� String�迭�� ����
		// ���ڿ� -> ���ڿ� �迭
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		// join�޼ҵ� �̿��� �迭�� ���ڿ��� ����
		// ���ڿ� �迭 -> ���ڿ�
		String str = String.join("-", arr);
		System.out.println(str);
		
		// StringJoinerŬ���� ����� ���ڿ� ����
		// ���ڿ� �迭 -> ���ڿ�
		StringJoiner sj = new StringJoiner(",","[","]");
		for(String s : arr) {
			sj.add(s);
		}
		
		System.out.println(sj);
		
		
		String str1 = "������,�����,�⼺��,��û��,���ֿ�,������";
		
		String[] arr1 = str1.split(",");
		System.out.println(Arrays.toString(arr1));
		
		String str2 = String.join("-", arr1);
		System.out.println(str2);
		
		StringJoiner sj2 = new StringJoiner("/","[","]");
		for(String s : arr1)
			sj2.add(s);
		System.out.println(sj2);
		
		String str3 = str1.substring(4,15);
		System.out.println(str3);
		
		System.out.println(str1.indexOf("������"));
		System.out.println(str1.indexOf('��'));
		System.out.println(str1.indexOf('��', 13));
	}
}

