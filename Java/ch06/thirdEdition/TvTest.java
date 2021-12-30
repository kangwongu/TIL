package thirdEdition;

// Tv 클래스
class Tv {
	// 속성
	String color;
	int channel;
	boolean power;
	
	// 기능
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest {
	public static void main(String[] args) {
		// 객체 생성
		Tv t = new Tv();
		
		// 객체 사용
		t.channel = 15;
		t.channelDown();
		System.out.println(t.channel);
	}

}
