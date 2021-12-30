// �߻�Ŭ����
abstract class Unit {
	// ����Ǵ� �κе��� ����
	// �Ӽ�
	int x, y;
	
	// ���
	abstract void move(int x, int y);	// ��ӹ޴� Ŭ�������� ������ �����ؾ� ��
	void stop() { }
}

// �߻�Ŭ���� ���
class Marine extends Unit {
	@Override
	void move(int x, int y) {
		System.out.println("Marine[x="+x+",y="+y+"]");
	}
	void stimPack() {}
}

// �߻�Ŭ���� ���
class Tank extends Unit {
	@Override
	void move(int x, int y) {
		System.out.println("Tank[x="+x+",y="+y+"]");
	}
	void changeMode() {}
}

// �߻�Ŭ���� ���
class Dropship extends Unit {
	@Override
	void move(int x, int y) {
		System.out.println("Dropship[x="+x+",y="+y+"]");
	}
	
}

public class Ex7_10 {
	public static void main(String[] args) {
		Unit[] group = { new Marine(), new Tank(), new Dropship() };
		
		for(int i=0; i<group.length; i++) {
			group[i].move(100, 200);
		}
	}
}
