import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Ex11_9 {
	public static void main(String[] args) {
		// Set - 중복 x, 순서 x
				
		// String 배열 생성
		String[] strArr = {"안녕", "안녕", "하세요","룰루","룰루"};
	
		// HashSet생성
		Set set = new HashSet();
		
		// HashSet에 추가
		for(int i=0; i<strArr.length; i++) {
			set.add(strArr[i]);
		}
		
		System.out.println(set);
		
		// Iterator를 이용해 출력하기
		// Iterator획득
		Iterator it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}