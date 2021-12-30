package thirdEdition;

class Unit3 {
	int hitPoint;
	final int MAX_HP;
	Unit3(int hp) {
		MAX_HP = hp;
	}
}

interface Repairable {}

class GroundUnit extends Unit3 {
	GroundUnit(int hp) {
		super(hp);
	}
	
}

class AirUnit extends Unit3 {
	AirUnit(int hp) {
		super(hp);
	}
	
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(40);
		hitPoint = MAX_HP;
	}
	
}

class Tank2 extends GroundUnit implements Repairable {
	Tank2() {
		super(150);
		hitPoint = MAX_HP;
	}
	
}

class DropShip2 extends AirUnit implements Repairable {
	DropShip2() {
		super(125);
		hitPoint = MAX_HP;
	}
	
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	// �Ű������� �������̽� -> �������̽��� ������ Ŭ������ �Ű������� ok
	void repairble(Repairable r) {
		// instanceof�� Ÿ��üũ ��, ����ȯ
		if(r instanceof Unit3) {
			Unit3 u = (Unit3)r;
			while(u.hitPoint!=u.MAX_HP) {
				u.hitPoint++;
			}
			System.out.println(u.toString()+"�� ������ �������ϴ�.");
		}
	}
}


public class RepairableTest {
	public static void main(String[] args) {
		Tank2 tank = new Tank2();
		DropShip2 dropship = new DropShip2();
		Marine2 marine = new Marine2();
		SCV scv = new SCV();
		
		scv.repairble(tank);
		scv.repairble(dropship);
		scv.repairble(scv);
	}
}