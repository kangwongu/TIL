import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex11_17 {
	public static void main(String[] args) {
		// HashMap�� �л� �̸���, ���� ����, Iterator�̿��� �̸� : ���� ���
		// HashMap ����
		HashMap hm = new HashMap();
		
		// HashMap�� �̸�, ���� ����
		hm.put("������", 100);
		hm.put("�����", 88);
		hm.put("������", 85);
		hm.put("�޽�", 100);
		hm.put("����", 95);
		hm.put("���ٸ޾�", 80);
		
		// Iterator�� �̿��ϱ� ���ؼ� Map -> Set
		Set set = hm.entrySet();
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			// Set���¸� Map�� Entry���·� �ɰ��� Ű, ���� ����
			Map.Entry me = (Entry)it.next();
			System.out.println("�̸� : "+me.getKey()+", ���� : "+me.getValue());
			
		}
		
		// Ű�� �̾Ƽ� �̸� ���
		set = hm.keySet();
		System.out.println("�̸� : "+set);
		
		// ���� �̾Ƽ� ����, ���, �ְ�����, �������� ���
		// �� ����
		Collection values = hm.values();
		
		// iterator Ȱ��
		it = values.iterator();
		int total = 0;	// ����
		double average = 0.0;
		while(it.hasNext()) {
			total += (int)it.next();
		}
		
		average = (double)total/set.size();
		
		System.out.println("����:"+total);
		System.out.println("���:"+Math.round(average*10)/10.0);
		System.out.println("�ְ�����:"+Collections.max(values));
		System.out.println("��������:"+Collections.min(values));
	}
}
