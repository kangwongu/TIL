package thirdEdition.exercise;

// ����Ŭ����
class Robot {}

// �ڼ�Ŭ����
class DanceRobot extends Robot {
	void dance() {
		System.out.println("���� ��");
	}
}

class SingRobot extends Robot {
	void sing() {
		System.out.println("�̾��~~");
	}
}

class DrawRobot extends Robot {
	void draw() {
		System.out.println("����ġġĩ");
	}
}

public class Exercise7_18 {
	// �Ű������� Robot���� �޴´� -> Robot, Robot�� �ڼյ鸸 �Ű����� ok
	public static void action(Robot r) {
		// ��ȿ�� �˻�
		if(r==null)
			return;
		
		// instanceof�� Ÿ��üũ
		// ����ȯ�ؼ� �˸´� �ν��Ͻ��� �޼ҵ� ����
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
		// �ϳ��� �迭�� ���� ��ü �ٷ��
		Robot[] arr = {new DanceRobot(), new SingRobot(), new DrawRobot()};
	
		for(int i=0; i<arr.length; i++) 
			action(arr[i]);
	}
}
