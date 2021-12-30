package thirdEdition;

// Tv2 클래스
class Tv4 {
	// 속성
	String color;
	int channel;
	boolean power;
	
	// 기능
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest4 {
	public static void main(String[] args) {
		// 객체 배열 생성, 길이 3
		Tv4[] tvArr = new Tv4[5];
		
		// 객체 배열 초기화 (채널)
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i] = new Tv4();
			tvArr[i].channel = i+20;
		}
		
		// 객체 배열 채널 출력
		for(int i=0; i<tvArr.length; i++) {
			System.out.println("tvArr["+i+"].channel = "+tvArr[i].channel);
		}
	}

}
