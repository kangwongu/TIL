package thirdedition;

public class EqualsTest2 {
	public static void main(String[] args) {
		Person p1 = new Person(8097934750L);
		Person p2 = new Person(8097934750L);
	
		if(p1==p2) 
			System.out.println("����");
		else
			System.out.println("�ٸ���");
	
		if(p1.equals(p2))
			System.out.println("����");
		else
			System.out.println("�ٸ���");
	}

}

class Person {
	long id;
	
	// �������̵�
	public boolean equals(Object obj) {
		// instanceof�� ����ȯ �������� üũ ��, ����ȯ �� ��
		if(obj!=null && obj instanceof Person) {
			return id == ((Person)obj).id;
		} else {
			return false;
		}
	}
	
	Person(long id) {
		this.id = id;
	}
}
