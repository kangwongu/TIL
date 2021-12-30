package thirdEdition;

// 조상 클래스, 공통부분을 작성
class Product2 {
	// 속성
	int price;
	int bonusPoint;
	
	// 생성자
	Product2(int price) {
		this.price = price;
		bonusPoint = price/10;
	}
}

// 자손 클래스
class Tv4 extends Product {
	Tv4() {
		super(100);
	}
	
	@Override
	public String toString() {
		return "Tv";
	}
	
}

class Computer2 extends Product {
	Computer2() {
		super(200);
	}
	
	@Override
	public String toString() {
		return "Computer";
	}
	
}

// 사용하는 클래스
class Buyer2 {
	// 속성
	int money = 1000;
	int bonusPoint;
	// 장바구니, 하나의 배열로 여러종류 객체 다루기
	Product[] list = new Product[10];
	int i = 0;
	
	// 기능
	void buy(Product p) {	// 매개변수 다형성
		// 유효성 검사 필수!
		if(money<p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		list[i++] = p;
		System.out.println(p+"를 구매했습니다.");
	}

	void showInfo() {
		System.out.println("남은 돈은 "+money+"입니다.");
		System.out.println("누적 포인트는 "+bonusPoint+"입니다.");
	}
	
	// 총합을 구하자, 구매한 리스트 출력
	void summary() {
		int sum=0;	// 총합을 저장할 변수
		String itemList="";	// 카트에 담겨있는 물품
		
		// for문으로 리스트 순회
		for(int i=0; i<list.length; i++) {
			// 총합 구하기
			if(list[i]==null) break;
			sum += list[i].price;
			itemList += list[i]+",";
		}
		
		System.out.println("총 금액은 "+sum+"입니댜.");
		System.out.println("구매한 물품은 "+itemList+"입니다.");
	}
	
}


public class PolyArgumentTest2 {
	public static void main(String[] args) {
		Buyer2 buyer = new Buyer2();
		
		// 구매자가 Tv, Computer를 구매
		buyer.buy(new Tv4());
		buyer.buy(new Computer2());
		
		
		buyer.summary();
		// 구매자 정보 출력
		buyer.showInfo();
		
		
	}

}
