package thirdEdition.exercise;

// 조상 클래스
// 추상 클래스로 만들어서 공통 부분을 추출
abstract class Unit {
	// 공통 부분
	int x, y;
	abstract void move(int x, int y);
	void stop() {
		
	}
}

// 자손 클래스
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}

class Marine extends Unit {

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}

class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}


public class Exercise7_17 {
	public static void main(String[] args) {
	}
}
