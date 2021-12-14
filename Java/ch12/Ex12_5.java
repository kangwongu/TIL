import java.util.ArrayList;
import java.util.Iterator;

// 열거형 생성
enum Direction { EAST, SOUTH, WEST, NORTH }

public class Ex12_5 {
	public static void main(String[] args) {
		// 열거형의 값 얻어오기
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
		
		// 열거형 값들을 열거형 배열로 변환
		Direction[] dArr = Direction.values();
		
		for(Direction d : dArr) {
			// 상수 이름과, 순서를 반환
			System.out.printf("%s=%d\n", d.name(), d.ordinal());
		}
		
	}
}
