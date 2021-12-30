package thirdEdition;

// Tv2 클래스
class Tv2 {
	// 속성
	String color;
	int channel;
	boolean power;
	
	// 기능
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest2 {
	public static void main(String[] args) {
		// 객체 생성
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
		// 객체 사용
		t1.channel = 15;
		t1.channelDown();
		System.out.println(t1.channel);
		System.out.println(t2.channel);
		
		// t2에 t1 참조변수의 값을 저장(주소)
		t2 = t1;
		
		System.out.println(t1.channel);
		System.out.println(t2.channel);
	}

}
