package baekjoon;


public class Ex4673 {
	// 각 자리수를 더하는 메소드
	public static int d(int n) {
		int dn = n;
		// 각 자리수를 더함
		while(n!=0) {
			dn += n%10;	// 첫째자리수 +
			n/=10;
		}
		// 셀프넘버를 반환
		return dn;
	}
	
	public static void main(String[] args) {
		// 셀프넘버를 체크하기 위한 배열
		boolean[] isSelfNumber = new boolean[10001];
		
		for(int i=1; i<isSelfNumber.length; i++) {
			int dn = d(i);	// 셀프넘버를 반환
			
			// 셀프넘버를 true로 체크
			if(dn <= 10000)
				isSelfNumber[dn] = true;
		}
		
		// 셀프넘버가 아닌 수를 출력
		for(int i=1; i<isSelfNumber.length; i++) {
			if(!isSelfNumber[i])
				System.out.println(i);
		}
		
	}
}
