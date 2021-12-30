package thirdEdition;

// 조상 클래스
class Unit2 {
	int currentHP;
	int x;
	int y;
}

// 조상 인터페이스
interface Fightable extends Movable, Attackable {}

interface Movable { void move(int x, int y); }
interface Attackable { void attack(Unit u); }

// 클래스와 인터페이스의 상속/구현을 받는 클래스
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
			System.out.println("유닛");
		}
		if(f instanceof Fightable) {
			System.out.println("파이터블");
		}
		if(f instanceof Movable) {
			System.out.println("무버블");
		}
		if(f instanceof Attackable) {
			System.out.println("어태커블");
		}
		if(f instanceof Object) {
			System.out.println("오브젝트");
		}
	}

}
