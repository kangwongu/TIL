import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
	public static void main(String[] args) {
		// Set - �ߺ� x, ���� x
				
		// String �迭 ����
		String[] strArr = {"�ȳ�", "�ȳ�", "�ϼ���","���","���"};
	
		// HashSet����
		Set set = new HashSet();
		
		// HashSet�� �߰�
		for(int i=0; i<strArr.length; i++) {
			set.add(strArr[i]);
		}
		
		System.out.println(set);
		
		// Iterator�� �̿��� ����ϱ�
		// Iteratorȹ��
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}