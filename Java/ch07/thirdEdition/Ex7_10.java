package thirdEdition;

// �߻� Ŭ����, ����κ� ����
abstract class Unit {
	// �Ӽ�
	int x,y;
	
	// ���
	abstract void move(int x, int y);	// �߻�޼ҵ�
	void stop() {}
}

// �߻�Ŭ������ ��ӹ��� Ŭ����, �߻�޼ҵ� ��ӹ޾ƾ� ��
class Marine extends Unit {
	// �߻�޼ҵ��� ������ �����ؾ� ��
	@Override
	void move(int x, int y) {
		System.out.println("Marine[x="+x+",y="+y+"]");
	}
	
	void stimPack() {}
	
}

class Tank extends Unit{

	@Override
	void move(int x, int y) {
		System.out.println("Tank[x="+x+",y="+y+"]");
	}
	void changeMode() {}
	
}

class DropShip extends Unit {

	@Override
	void move(int x, int y) {
		System.out.println("DropShip[x="+x+",y="+y+"]");
	}
	void load() {}
	void unLoad() {}
}


public class Ex7_10 {
	public static void main(String[] args) {
		// �ϳ��� �迭�� ������ü ��� ���� (������)
		Unit[] list = {new Marine(), new Tank(), new DropShip()};
		
		for(int i=0; i<list.length; i++) {
			list[i].move(100, 200);
		}
	}

}
