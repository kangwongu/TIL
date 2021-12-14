import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

class Student{
	// �Ӽ�
	String name;
	int ban;
	int no;
	int kor, eng, math;
	
	// ������
	Student(String name, int ban, int no, int kor, int eng, int math) {
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	int getTotal() {
		return kor + eng + math;
	}
	
	float getAverage() {
		return (int)((getTotal()/3f)*10+0.5)/10f;
	}
	
	public String toString() {
		return name+","+ban+","+no+","+kor+","+eng+","+math+","+getTotal()+","+getAverage();
	}

}

// ���ı���
// ��, ��ȣ�� �������� �������� ����
class BanNoAscending implements Comparator {
	// instanceof�� �̿���  Ÿ��üũ ��, ����ȯ�ϰ� ��
	// Student�� ����ȯ, ban��
	@Override
	public int compare(Object o1, Object o2) {
		if(o1 instanceof Student && o2 instanceof Student) {
			// o1, o2�� Student�� ����ȯ
			Student s1 = (Student)o1;
			Student s2 = (Student)o2;
			
			// ���, ��������
			int result = s1.ban - s2.ban;
			// ���� ������ ��ȣ�� ��
			if(result==0) {
				return s1.no - s2.no;
			}
			return result;
		}
		return -1;

	}
}


public class Exercise11_4 {
	public static void main(String[] args) {
		// ArrayList ����
		ArrayList list = new ArrayList();
		
		// list�� ��� �߰�
		list.add(new Student("ȫ�浿",1,3,100,100,100));
		list.add(new Student("���ü�",1,1,90,70,80));
		list.add(new Student("���ڹ�",1,2,80,80,90));
		list.add(new Student("���ڹ�",2,1,70,90,70));
		list.add(new Student("���ڹ�",2,2,60,100,80));
		
		// sort
		Collections.sort(list, new BanNoAscending());
		
		// ���, IteratorȰ��
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
