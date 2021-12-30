// 추상클래스
abstract class Unit {
	// 공통되는 부분들을 추출
	// 속성
	int x, y;
	
	// 기능
	abstract void move(int x, int y);	// 상속받는 클래스들은 무조건 구현해야 함
	void stop() { }
}

// 추상클래스 상속
class Marine extends Unit {
	@Override
	void move(int x, int y) {
		System.out.println("Marine[x="+x+",y="+y+"]");
	}
	void stimPack() {}
}

// 추상클래스 상속
class Tank extends Unit {
	@Override
	void move(int x, int y) {
		System.out.println("Tank[x="+x+",y="+y+"]");
	}
	void changeMode() {}
}

// 추상클래스 상속
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
