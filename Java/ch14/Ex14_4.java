import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Ex14_4 {
	
	public static void main(String[] args) {
		// ArrayList<Integer>만들고 0~9추가, 모든 요소 출력
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		list.forEach(i -> System.out.print(i+","));
		System.out.println();
		
		// list에서 2, 3의 배수 제거
		list.removeIf(i -> i%2==0 || i%3==0);
		System.out.println(list);
		
		// list 각 요소에 10을 곱함
		list.replaceAll(i -> i*10);
		System.out.println(list);
		
		// map 생성
		HashMap<String, String> hm = new HashMap<String, String>();
		hm.put("1", "안녕하세요");
		hm.put("2", "저는");
		hm.put("3", "ㅇㅇ입니다.");
		hm.put("4", "잘 부탁드려요");
		
		// map의 모든 요소를 <k,v>형식으로 출력
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// 특정 키의 value값 변경
		hm.compute("3", (k,v) -> "호우입니다.");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// 특정 키의 value값 변경
		hm.merge("2", "저는", (k,v) -> "나는");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		hm.merge("4", "으음", (k,v) -> "잘하자");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
		System.out.println();
		
		// 맵의 모든 키의 value값 변경
		hm.replaceAll((k,v) -> "안뇽");
		hm.forEach((k,v) -> System.out.print("<"+k+","+v+">"));
	}
}