
// Tv클래스
class Tv {
	// 속성
	// 파워, 채널
	boolean power;
	int channel;
	// 기능
	// 파워온오프, 채널_1, 채널-1
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }

}

// Tv클래스의 상속을 받는 SmartTv클래스
class SmartTv extends Tv {
	// 속성
	// + 자막on/off
	boolean caption;
	// 기능
	// + 자막on이면 자막보여주기
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
}

public class Ex7_1 {
	public static void main(String[] args) {
		// Tv클래스 상속받은 SmartTv클래스 인스턴스 생성
		SmartTv stv = new SmartTv();
		// Tv클래스의 멤버 사용가능
		stv.channel = 224;
		stv.channelUp();
		System.out.println(stv.channel);
		// SmartTv클래스의 자막기능
		stv.displayCaption("Hi");
		stv.caption = true;
		stv.displayCaption("Hi");
		
	}

}
