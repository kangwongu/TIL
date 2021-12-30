package thirdEdition;

// 조상 클래스, 공통부분을 작성
class Product {
	// 속성
	int price;
	int bonusPoint;
	
	// 생성자
	Product(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
}

// 자손 클래스
class Tv3 extends Product {
	Tv3() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}

// 사용하는 클래스
class Buyer {
	// 속성
	int money = 1000;
	int bonusPoint;
	
	// 기능
	void buy(Product p) {	// 매개변수 다형성
		// 유효성 검사 필수!
		if(money<p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p+"를 구매했습니다.");
	}

	void showInfo() {
		System.out.println("남은 돈은 "+money+"입니다.");
		System.out.println("누적 포인트는 "+bonusPoint+"입니다.");
	}
	
	
}


public class PolyArgumentTest {
	public static void main(String[] args) {
		Buyer buyer = new Buyer();
		
		// 구매자가 Tv, Computer를 구매
		buyer.buy(new Tv3());
		buyer.buy(new Computer());
		
		// 구매자 정보 출력
		buyer.showInfo();
	}

}
