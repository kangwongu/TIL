import java.util.StringJoiner;

public class Ex9_12 {
	public static void main(String[] args) {
		// 기존 16 + 2
		// "01"을 갖는 StringBuffer인스턴스 생성
		StringBuffer sb = new StringBuffer("01");
		sb.append('4').append(56);
		System.out.println(sb);
		
		StringBuffer sb3 = sb.append(78);
		System.out.println(sb3);
		
		System.out.println(sb.deleteCharAt(2));
		System.out.println(sb.delete(4, 6));
		System.out.println(sb.insert(1, "ab"));
		System.out.println(sb.capacity());
		System.out.println(sb.length() );
		
		
		StringBuffer sb2 = new StringBuffer();
		sb2.append("강원구").append("강종구").append("강유선");
		System.out.println(sb2);
		String str = sb2.toString();
		System.out.println(str);
		
		System.out.println(sb2.delete(3, 6));
		System.out.println(sb2.insert(0,"김은영"));
		System.out.println(sb2.capacity());
		System.out.println(sb2.length());
		System.out.println(sb2.reverse());
		String str2 = sb2.substring(3, 6);
		System.out.println(str2);
		StringBuffer sb4 = new StringBuffer(str2);
		System.out.println(sb4.reverse());
		
		
	}

}

