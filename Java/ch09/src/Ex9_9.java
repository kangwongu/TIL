import java.util.Arrays;
import java.util.StringJoiner;

public class Ex9_9 {
	public static void main(String[] args) {
		// 기호가 포함된 문자열
		String animals = "dog,cat,bear";
		
		// split메소드 이용해 String배열로 분할
		// 문자열 -> 문자열 배열
		String[] arr = animals.split(",");
		System.out.println(Arrays.toString(arr));
		
		// join메소드 이용해 배열을 문자열로 결합
		// 문자열 배열 -> 문자열
		String str = String.join("-", arr);
		System.out.println(str);
		
		// StringJoiner클래스 사용해 문자열 결합
		// 문자열 배열 -> 문자열
		StringJoiner sj = new StringJoiner(",","[","]");
		for(String s : arr) {
			sj.add(s);
		}
		
		System.out.println(sj);
		
		
		String str1 = "박지성,손흥민,기성용,이청용,박주영,강원구";
		
		String[] arr1 = str1.split(",");
		System.out.println(Arrays.toString(arr1));
		
		String str2 = String.join("-", arr1);
		System.out.println(str2);
		
		StringJoiner sj2 = new StringJoiner("/","[","]");
		for(String s : arr1)
			sj2.add(s);
		System.out.println(sj2);
		
		String str3 = str1.substring(4,15);
		System.out.println(str3);
		
		System.out.println(str1.indexOf("강원구"));
		System.out.println(str1.indexOf('강'));
		System.out.println(str1.indexOf('용', 13));
	}
}

