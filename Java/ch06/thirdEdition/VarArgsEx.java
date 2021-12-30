package thirdEdition;

public class VarArgsEx {
	public static void main(String[] args) {

		String[] strArr = {"100","200","300"};
		
		System.out.println(concatenate(",", strArr));
	}
	
	// 가변인자를 매개변수로 받는 메소드
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		return result;
	}
	
	// 오버로딩
	static String concatenate(String... args) {
		return concatenate("", args);
	}

}
