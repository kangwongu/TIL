// 섯다카드 클래스
class SutdaCard {
	// 속성
	int num;
	boolean isKwang;
	
	// 생성자
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	// 기능
	public String toString() {
		// 광이면 K, 아니면 공백
		return num + (isKwang ? "K" : "");
	}

	// num, isKwang을 비교
	@Override
	public boolean equals(Object obj) {
		// instanceof연산자로 타입 검사 후, 비교
		if(obj instanceof SutdaCard) {
			SutdaCard s = (SutdaCard)obj;
			if(num==s.num && isKwang==s.isKwang) 
				return true;
		}
		
		return false;
	
	}
}


public class Exercise9_1 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c1.equals(c2));
	}

}
