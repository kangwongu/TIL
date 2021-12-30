package thirdEdition.exercise;

// 조상클래스
class Robot {}

// 자손클래스
class DanceRobot extends Robot {
	void dance() {
		System.out.println("춤을 춰");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("싱어롱~~");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("스케치치칫");
	}
}

public class Exercise7_18 {
	// 매개변수로 Robot형을 받는다 -> Robot, Robot의 자손들만 매개변수 ok
	public static void action(Robot r) {
		// 유효성 검사
		if(r==null)
			return;
		
		// instanceof로 타입체크
		// 형변환해서 알맞는 인스턴스의 메소드 실행
		if(r instanceof DanceRobot) {
			DanceRobot t = (DanceRobot)r;
			t.dance();
		} else if(r instanceof SingRobot) {
			SingRobot s = (SingRobot)r;
			s.sing();
		} else if (r instanceof DrawRobot) {
			DrawRobot d = (DrawRobot)r;
			d.draw();
		} else {
			return;
		}
		
	}
	
	public static void main(String[] args) {
		// 하나의 배열로 여러 객체 다루기
		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
	
		for(int i=0; i<arr.length; i++) 
			action(arr[i]);
	}
}
