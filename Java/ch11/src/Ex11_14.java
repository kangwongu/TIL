import java.util.Set;
import java.util.TreeSet;

public class Ex11_14 {
	public static void main(String[] args) {
		// subset()�޼ҵ�� TreeSet�� �־ ������������ TreeSet�̾�� ��
//		Set set = new TreeSet();
		TreeSet set = new TreeSet();
		
		// �����˻��� ����� ������
		String from = "b";
		String to = "e";
		
		set.add("abc");			set.add("alien");		set.add("bat");
		set.add("car");			set.add("Car");			set.add("disc");
		set.add("dance");		set.add("dZZZZ");		set.add("dzzzz");
		set.add("elephant");	set.add("elevator");	set.add("fan");
		set.add("flower");		
		
		System.out.println(set);
		System.out.println("range search : from " + from + " to " + to);
		
		// b ~ d���� (c�� �����ϴ� ���ڱ���)
		System.out.println("result1 : " + set.subSet(from, to));
		
		// b ~ e���� (e�� �����ϴ� ���ڱ���)
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
		
	}
}
