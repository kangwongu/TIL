
import java.util.ArrayList;
import java.util.Collections;

public class Ex11_1 {

	public static void main(String[] args) {
		// 크기가 10인 ArrayLilst를 생성한다
		ArrayList<String> list1 = new ArrayList<>(10);
		
		// ArrayList에 요소를 담는다
		list1.add("박지성");
		list1.add("손흥민");
		list1.add("화이트");
		list1.add("오바메양");
		
		// ArrayList 요소의 일부를 떼어 또 다른 ArrayList를 만든다
		// subList활용
		ArrayList<String> list2 = new ArrayList<>(list1.subList(1, 3));
		print(list1, list2);
		
		// 두 개의 리스트를 정렬한다 sort
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1,list2);
		
		// list1의 요소가 list2에 전부 포함되어있는지 확인
		System.out.println(list1.containsAll(list2));
		
		// list2에 요소를 더 추가
		list2.add("뮐러");
		list2.add("로이스");
		list2.set(1, "레반도프스키");
		print(list1, list2);
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지 삭제
		System.out.println(list1.retainAll(list2));
		print(list1, list2);
		
		// list2의 모든 요소를 삭제
		for(int i=list2.size()-1; i>=0; i--) {
			list2.remove(i);
		}
		print(list1, list2);

	}
	
	// ArrayList 2개의 인스턴스를 매개변수로 받는 메소드
	// 리스트를 출력
	public static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
	}
}
