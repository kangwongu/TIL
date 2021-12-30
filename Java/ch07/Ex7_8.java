//
//class Product {
//	int price;
//	int bonusPoint;
//	
//	Product(int price) {
//		this.price = price;
//		bonusPoint = (int)(price/10.0);
//	}
//}
//
//class Tv1 extends Product {
//	Tv1() { super(100); }
//	
//	public String toString() { return "Tv"; }
//}
//
//class Computer extends Product {
//	Computer() { super(200); }
//
//	public String toString() { return "Computer"; }
//}
//
//class Buyer {
//	int money = 1000;
//	int bonusPoint = 0;
//	
//	void buy(Product p) {
//		if(money < p.price) {
//			System.out.println("잔액이 부족하여 물건을 살 수 없습니다.");
//			return;
//		}
//		money -= p.price;
//		bonusPoint += p.bonusPoint;
//		System.out.println(p + "을/를 구입하셨습니다.");
//	}
//}
//
//public class Ex7_8 {
//	public static void main(String[] args) {
//		Buyer b = new Buyer();
//		
//		b.buy(new Tv1());
//		b.buy(new Computer());
//		
//		System.out.println("현재 남은 돈은 " + b.money + "만원입니다.");
//		System.out.println("현재 보너스점수는 " + b.bonusPoint + "점입니다.");
//	}	
//
//}

// 조상 클래스
class Product {
	// 속성
	int price;
	int bonusPoint;
	
	// 생성자
	Product() {this(0);}

	Product(int price) {
		this.price = price;
		bonusPoint = (int)(price/10.0);
	}	
}

// 자손 클래스
class Tv1 extends Product {
	Tv1() { super(100); }
	public String toString() { return "Tv"; }
}

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer"; }
}

// 이용하는 클래스
class Buyer {
	// 속성
	int money = 1000;
	int bonusPoint = 0;
	
	// 기능
	// 구매 메소드, 매개변수 다형성
	void buy(Product p) {
		// 유효성검사
		if(money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + "을/를 구입하셨습니다.");
	}
}

class Ex7_8 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		Tv1 tv = new Tv1();
		Computer c = new Computer();
		
		b.buy(tv);
		b.buy(c);
	}
}
