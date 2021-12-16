import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex14_4 {
	
	public static void main(String[] args) {
		// ArrayList<Integer>����� 0~9�߰�, ��� ��� ���
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		list.forEach(i -> System.out.print(i+","));
		System.out.println();
		
		// list���� 2, 3�� ��� ����
		list.removeIf(i -> i%2==0 || i%3==0);
		System.out.println(list);
		
		// list �� ��ҿ� 10�� ����
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		// map ����
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "�ȳ��ϼ���");
		hm.put("2", "����");
		hm.put("3", "�����Դϴ�.");
		hm.put("4", "�� ��Ź�����");
		
		// map�� ��� ��Ҹ� <k,v>�������� ���
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// Ư�� Ű�� value�� ����
		hm.compute("3", (k,v) -> "ȣ���Դϴ�.");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// Ư�� Ű�� value�� ����
		hm.merge("2", "����", (k,v) -> "����");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		hm.merge("4", "����", (k,v) -> "������");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// ���� ��� Ű�� value�� ����
		hm.replaceAll((k,v) -> "�ȴ�");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
	}
}