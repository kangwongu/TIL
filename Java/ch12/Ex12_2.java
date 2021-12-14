import java.util.ArrayList;
import java.util.Iterator;


class Student {
	// �Ӽ�
	String name;
	int ban;
	int no;
	
	// ������
	Student(String name, int ban, int no) {
		this.name = name;
		this.ban = ban;
		this.no = no;
	}
}

// Iterator�� ���׸��� ����

public class Ex12_2 {
	public static void main(String[] args) {
		// Student�� ���Ե� ArrayList ����
		ArrayList<Student> list = new ArrayList<>();
		
		// ��� �߰�
		list.add(new Student("������",1,1));
		list.add(new Student("���ֿ�",1,2));
		list.add(new Student("�����",2,1));
		
		// Student���� Iterator���
		Iterator<Student> it = list.iterator();
		// �̸� ���
		while(it.hasNext()) {
//			Student s = (Student)it.next();	// ���׸��� ������� ���� ��
			Student s = it.next();
			System.out.println(s.name);
		}
		
	}
}