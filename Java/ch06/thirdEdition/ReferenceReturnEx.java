package thirdEdition;


class Entity { int num; }

public class ReferenceReturnEx {
	public static void main(String[] args) {
		// �ν��Ͻ� ����
		Entity e = new Entity();
		e.num = 100;
		
		// ��ȯŸ���� Entity���̱� ������ Entity��ü�� ���� ���� ����
		Entity newEntity = change(e);
		System.out.println(e.num);
		System.out.println(newEntity.num);
		
	}
	
	// ��ȯŸ���� ������
	// �Ű������� ��ȯ���� �޾� �� �����Ű�� �޼ҵ�
	static Entity change(Entity e) {
		// ��ȯŸ���� �Ű������� ����
		// ���ο� ��ȯŸ�� ������ �Ű������� �Ӽ��� ����
		Entity newE = new Entity();
		newE.num = e.num;
		
		return newE;
	}

}
