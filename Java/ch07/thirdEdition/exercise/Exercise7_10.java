package thirdEdition.exercise;
//
//class MyTv2 {
//	// ¼Ó¼º
//	private boolean isPowerOn;
//	private int channel;
//	private int volume;
//	
//	final int MAX_VOLUME = 100;
//	final int MIN_VOLUME = 0;
//	final int MAX_CHANNEL = 200;
//	final int MIN_CHANNEL = 1;
//	
//	public boolean isPowerOn() {
//		return isPowerOn;
//	}
//	public void setPowerOn(boolean isPowerOn) {
//		this.isPowerOn = isPowerOn;
//	}
//	public int getChannel() {
//		return channel;
//	}
//	public void setChannel(int channel) {
//		this.channel = channel;
//	}
//	public int getVolume() {
//		return volume;
//	}
//	public void setVolume(int volume) {
//		this.volume = volume;
//	}
//	
//	
//	
//}

public class Exercise7_10 {
	public static void main(String[] args) {
		MyTv2 t = new MyTv2();
		t.setChannel(100);
		t.setVolume(50);
		System.out.println(t.getChannel());
		System.out.println(t.getVolume());
		
		
	}
}
