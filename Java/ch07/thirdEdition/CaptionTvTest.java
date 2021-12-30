package thirdEdition;

// 조상클래스
class Tv {
	// 속성
	boolean power;
	int channel;
	
	// 기능
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
}

// 자손클래스
class CaptionTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
	
}


public class CaptionTvTest {
	public static void main(String[] args) {
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 11;
		ctv.channelUp();
		ctv.displayCaption("안녕");
		ctv.caption=true;
		ctv.displayCaption("신발");
	
	}

}
