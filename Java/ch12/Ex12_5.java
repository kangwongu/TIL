import java.util.ArrayList;
import java.util.Iterator;

// ������ ����
enum Direction { EAST, SOUTH, WEST, NORTH }

public class Ex12_5 {
	public static void main(String[] args) {
		// �������� �� ������
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.valueOf("WEST");
		Direction d3 = Enum.valueOf(Direction.class, "EAST");
		
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
		
		System.out.println(d1==d2);
		System.out.println(d2==d3);
		System.out.println(d3==d1);
		
		System.out.println(d1.compareTo(d2));
		System.out.println(d1.compareTo(d3));
		
		// ������ ������ ������ �迭�� ��ȯ
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) {
			// ��� �̸���, ������ ��ȯ
			System.out.printf("%s=%d\n", d.name(), d.ordinal());
		}
		
	}
}
