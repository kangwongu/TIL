package thirdEdition;

// ���� Ŭ����
class Unit2 {
	int currentHP;
	int x;
	int y;
}

// ���� �������̽�
interface Fightable extends Movable, Attackable {}

interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }

// Ŭ������ �������̽��� ���/������ �޴� Ŭ����
class Fighter extends Unit2 implements Fightable {

	@Override
	public void move(int x, int y) {
		
	}

	@Override
	public void attack(Unit u) {
		
	}
	
}


public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		
		if(f instanceof Unit2) {
			System.out.println("����");
		}
		if(f instanceof Fightable) {
			System.out.println("�����ͺ�");
		}
		if(f instanceof Movable) {
			System.out.println("������");
		}
		if(f instanceof Attackable) {
			System.out.println("����Ŀ��");
		}
		if(f instanceof Object) {
			System.out.println("������Ʈ");
		}
	}

}
