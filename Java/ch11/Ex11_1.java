
import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {

	public static void main(String[] args) {
		// ũ�Ⱑ 10�� ArrayLilst�� �����Ѵ�
		ArrayList<String> list1 = new ArrayList<>(10);
		
		// ArrayList�� ��Ҹ� ��´�
		list1.add("������");
		list1.add("�����");
		list1.add("ȭ��Ʈ");
		list1.add("���ٸ޾�");
		
		// ArrayList ����� �Ϻθ� ���� �� �ٸ� ArrayList�� �����
		// subListȰ��
		ArrayList<String> list2 = new ArrayList<>(list1.subList(1, 3));
		print(list1, list2);
		
		// �� ���� ����Ʈ�� �����Ѵ� sort
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1,list2);
		
		// list1�� ��Ұ� list2�� ���� ���ԵǾ��ִ��� Ȯ��
		System.out.println(list1.containsAll(list2));
		
		// list2�� ��Ҹ� �� �߰�
		list2.add("����");
		list2.add("���̽�");
		list2.set(1, "���ݵ�����Ű");
		print(list1, list2);
		
		// list1���� list2�� ��ġ�� �κи� ����� ������ ����
		System.out.println(list1.retainAll(list2));
		print(list1, list2);
		
		// list2�� ��� ��Ҹ� ����
		for(int i=list2.size()-1; i>=0; i--) {
			list2.remove(i);
		}
		print(list1, list2);

	}
	
	// ArrayList 2���� �ν��Ͻ��� �Ű������� �޴� �޼ҵ�
	// ����Ʈ�� ���
	public static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
