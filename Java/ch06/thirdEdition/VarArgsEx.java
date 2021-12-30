package thirdEdition;

public class VarArgsEx {
	public static void main(String[] args) {

		String[] strArr = {"100","200","300"};
		
		System.out.println(concatenate(",", strArr));
	}
	
	// �������ڸ� �Ű������� �޴� �޼ҵ�
	static String concatenate(String delim, String... args) {
		String result = "";
		
		for(String str : args) {
			result += str + delim;
		}
		return result;
	}
	
	// �����ε�
	static String concatenate(String... args) {
		return concatenate("", args);
	}

}
