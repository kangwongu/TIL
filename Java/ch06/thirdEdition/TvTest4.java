package thirdEdition;

// Tv2 Ŭ����
class Tv4 {
	// �Ӽ�
	String color;
	int channel;
	boolean power;
	
	// ���
	void power() { power = !power; }
	void channelUp() { ++channel; }
	void channelDown() { --channel; }
	
}


public class TvTest4 {
	public static void main(String[] args) {
		// ��ü �迭 ����, ���� 3
		Tv4[] tvArr = new Tv4[5];
		
		// ��ü �迭 �ʱ�ȭ (ä��)
		for(int i=0; i<tvArr.length; i++) {
			tvArr[i] = new Tv4();
			tvArr[i].channel = i+20;
		}
		
		// ��ü �迭 ä�� ���
		for(int i=0; i<tvArr.length; i++) {
			System.out.println("tvArr["+i+"].channel = "+tvArr[i].channel);
		}
	}

}
