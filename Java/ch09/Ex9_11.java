import java.util.StringJoiner;

public class Ex9_11 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		
		System.out.println(sb == sb2);
		System.out.println(sb.equals(sb2));
		
		String s = sb.toString();
		String s2 = new String(sb2);
		
		System.out.println(s.equals(s2));
		
		StringBuffer sb3 = new StringBuffer();
		sb3.append("강원구");
		sb3.append("강종구");
		
		String str = sb3.toString();	// StringBuffer -> String
		System.out.println(str);
		
	}

}

