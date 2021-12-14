import java.util.Arrays;
import java.util.StringJoiner;

public class Ex9_8 {
	public static void main(String[] args) {
		
		String str1 = "Kang Won Gu";
		// 문자열을 공백기준으로 나눠서 문자열 배열에 저장
		String[] arr = str1.split(" ");
		for(String str : arr)
			System.out.println(str);
		
		String str2 = "서울시,부산시,대구시,수원시,화성시,성남시";
		String[] arr2 = str2.split(",");
		System.out.println(Arrays.toString(arr2));
		for(String str : arr2)
			System.out.print(str+"\t");
	
		// 문자열배열 -> 문자열
		String str = String.join("-", arr2);
		System.out.println(str);
		
		// StringJoiner이용해 문자열 결합
		StringJoiner sj = new StringJoiner("/", "[", "]");
		for(String s : arr)
			sj.add(s);
		System.out.println(sj);
		
		
		String str3 = str1.substring(5);
		System.out.println("\n"+str3);
		
		String str4 = str1.substring(9);			// str1의 9번째자리부터 끝까지 잘라냄
		System.out.println(str4);
		
		String str5 = str2.substring(4, 15);		// str2의 4번째부터 14번째자리까지 잘라냄
		System.out.println(str5);
		
		System.out.println(str1.indexOf("Gu"));		// "Gu"를 탐색
		System.out.println(str1.indexOf('W'));	
		System.out.println(str1.indexOf('n'));		// 'n'을 처음부터 탐색
		
		System.out.println(str1.indexOf('n', 5));	// 'n'을 5번째자리 이후부터 탐색
		
	}
}

