import java.util.ArrayList;
import java.util.Iterator;

public class Ex11_5 {
	public static void main(String[] args) {
		// Iterator�� ����ؼ� �÷��� ��ҵ��� ����ϱ�
		
		// 1. ArrayList ����
		ArrayList<String> list = new ArrayList<>();
		
		// 2. list�� ��� �߰�
		list.add("���ٸ޾�");
		list.add("���̽� �ο�");
		list.add("�������̽�");
		list.add("����Ƽ�ڸ�");
		
		// 3. Iterator�� ����� ��� ����ϱ�
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
	}
	
}
