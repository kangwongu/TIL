import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Ex11_7 {
	public static void main(String[] args) {
		// String �迭 ����
		String[] list = {"���ΰ�", "���¼�", "������", "������", "���Ͽ�", "���漮"};
		
		// �迭�� ����
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		
		// ��ҹ��� ���о��ϰ� ����
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(list));
		
		// ���� ������ �������� ����
		Arrays.sort(list, new Descending());
		System.out.println(Arrays.toString(list));
	}
}

// ���� ����, Comparator�����ؾ� �Ѵ�
class Descending implements Comparator {
	// �⺻���ı����� �������� ����� ��ȯ (����)
	// instanceof�� Ÿ�԰˻� ��, ����ȯ
	@Override
	public int compare(Object o1, Object o2) {
		// instanceof�� Ÿ��üũ ��, ����ȯ
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			// ����
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
	
}
		
