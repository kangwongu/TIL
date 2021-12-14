import java.util.ArrayList;
import java.util.Iterator;

public class Ex11_5 {
	public static void main(String[] args) {
		// Iterator를 사용해서 컬렉션 요소들을 출력하기
		
		// 1. ArrayList 생성
		ArrayList<String> list = new ArrayList<>();
		
		// 2. list에 요소 추가
		list.add("오바메양");
		list.add("스미스 로우");
		list.add("마갈량이스");
		list.add("마르티넬리");
		
		// 3. Iterator를 사용해 요소 출력하기
		Iterator it = list.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
	}
	
}
