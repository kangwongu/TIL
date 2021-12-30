
public class Ex6_1 {
	public static void main(String[] args) {
		// Tv형 참조변수 선언
		Tv t;
		// 참조변수  t에 Tv인스턴스의 주소값 대입
		t = new Tv();
		
		// 참조변수(리모콘) t로 Tv인스턴스 사용
		t.channel=11;
		t.channelUp();
		System.out.println(t.channel);
	}
}

class Tv {
	// 속성 (변수)
	String color;
	boolean power;
	int channel;
	
	// 기능 (메소드)
	void power() { power = !power;}
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}
