import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

//섯다카드 클래스
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
		// instanceof로 타입체크하고 형변환해서 비교
		boolean isValid = false;
		
		if(obj instanceof SutdaCard) {
			// 형변환
			SutdaCard s = (SutdaCard)obj;
			isValid = (num==s.num) && (isKwang==s.isKwang);
		}
		return isValid;
	}

	@Override
	public int hashCode() {
		return Objects.hash(num, isKwang);
	}
	
	
}


public class Exercise11_5 {
	public static void main(String[] args) {
		SutdaCard c1 = new SutdaCard(3, true);
		SutdaCard c2 = new SutdaCard(3, true);
		SutdaCard c3 = new SutdaCard(1, true);
		
		HashSet set = new HashSet();
		set.add(c1);
		set.add(c2);
		set.add(c3);
		
		System.out.println(set);
		
	}

}
