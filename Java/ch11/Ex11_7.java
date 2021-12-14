import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class Ex11_7 {
	public static void main(String[] args) {
		// String 배열 생성
		String[] list = {"힌민관", "김태술", "강원구", "전지수", "유하영", "서경석"};
		
		// 배열을 정렬
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
		
		// 대소문자 구분안하고 정렬
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println(Arrays.toString(list));
		
		// 새로 정의한 기준으로 정렬
		Arrays.sort(list, new Descending());
		System.out.println(Arrays.toString(list));
	}
}

// 정렬 기준, Comparator구현해야 한다
class Descending implements Comparator {
	// 기본정렬기준을 역순으로 만들어 반환 (역순)
	// instanceof로 타입검사 후, 형변환
	@Override
	public int compare(Object o1, Object o2) {
		// instanceof로 타입체크 후, 형변환
		if(o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable)o1;
			Comparable c2 = (Comparable)o2;
			// 역순
			return c1.compareTo(c2) * -1;
		}
		return -1;
	}
	
}
		
