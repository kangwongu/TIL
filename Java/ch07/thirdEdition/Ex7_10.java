package thirdEdition;

// 추상 클래스, 공통부분 추출
abstract class Unit {
	// 속성
	int x,y;
	
	// 기능
	abstract void move(int x, int y);	// 추상메소드
	void stop() {}
}

// 추상클래스를 상속받을 클래스, 추상메소드 상속받아야 함
class Marine extends Unit {
	// 추상메소드의 몸통을 구현해야 함
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
		// 하나의 배열로 여러객체 담기 가능 (다형성)
		Unit[] list = {new Marine(), new Tank(), new DropShip()};
		
		for(int i=0; i<list.length; i++) {
			list[i].move(100, 200);
		}
	}

}
