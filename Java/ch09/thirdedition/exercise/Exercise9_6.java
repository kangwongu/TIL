package thirdedition.exercise;

public class Exercise9_6 {
	public static String fileZero(String src, int length) {
		if(src==null || src.length()==length) {
			return src;
		} 
		
		if(length<=0) {
			return "";
		}
		
		if(src.length()>length) {
			return src.substring(0, length);
		}
		
		// length만큼의 char배열을 만든다
		char[] charArr = new char[length];
		
		// 배열을 '0'값으로 초기화
		for(int i=0; i<charArr.length; i++) {
			charArr[i] = '0';
		}
		
		// src를 char배열로 변환, char배열에 복사
		char[] srcArr = src.toCharArray();
		System.arraycopy(srcArr, 0, charArr, length-srcArr.length, srcArr.length);
		return new String(charArr);
	}
	
	
	public static void main(String[] args) {
		String src = "12345";
		System.out.println(fileZero(src,10));
		System.out.println(fileZero(src,-1));
		System.out.println(fileZero(src,3));
	}
}