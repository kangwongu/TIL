import java.util.Set;
import java.util.TreeSet;

public class Ex11_14 {
	public static void main(String[] args) {
		// subset()메소드는 TreeSet에 있어서 참조변수형이 TreeSet이어야 함
//		Set set = new TreeSet();
		TreeSet set = new TreeSet();
		
		// 범위검색에 사용할 변수들
		String from = "b";
		String to = "e";
		
		set.add("abc");			set.add("alien");		set.add("bat");
		set.add("car");			set.add("Car");			set.add("disc");
		set.add("dance");		set.add("dZZZZ");		set.add("dzzzz");
		set.add("elephant");	set.add("elevator");	set.add("fan");
		set.add("flower");		
		
		System.out.println(set);
		System.out.println("range search : from " + from + " to " + to);
		
		// b ~ d까지 (c로 시작하는 글자까지)
		System.out.println("result1 : " + set.subSet(from, to));
		
		// b ~ e까지 (e로 시작하는 글자까지)
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));
		
	}
}
