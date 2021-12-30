package thirdEdition.exercise;

import java.util.Arrays;

// 조상클래스
class Product {
	// 속성
	int price;
	
	// 생성자
	Product(int price) { this.price = price; }
}

// 자손클래스
class Tv extends Product {
	Tv() { super(100); }
}

class Computer extends Product {
	Computer() { super(200); }
}

class Audio extends Product {
	Audio() { super(50); }
}


class Buyer {
	// 속성
	int money = 1000;
	// 하나의 배열로 여러객체를 다룬다
	Product[] list = new Product[3];	// 다형성 장점
	int i=0;
	
	
	// 기능
	// 물품을 구매한다
	// 매개변수 다형성 -> 다형성 장점, Product, Product자손만이 매개변수로 ok
	void buy(Product p) {
		// 구매자가 가진돈이 물건값보다 적다면 실패
		if(money < p.price) {
			System.out.println("잔액이 부족해 구입 불가");
			return;
		}
		
		money -= p.price;	// 가진돈에서 물건값 차감
		add(p);				// 장바구니에 담는다, 객체지향적 코드
	}
	
	// 장바구니에 담는 메소드
	void add(Product p) {
		// 유효성 검사
		if(i>=list.length) {
			// 기존 장바구니 2배 용량의 새로운 장바구니 생성 
			Product[] newList = new Product[list.length*2];
			// 새로운 장바구니에 기존 장바구니 복사
//			System.arraycopy(list, 0, newList, 0, list.length);
			newList = Arrays.copyOf(list, newList.length);
			// 기존 장바구니로 바꾸기
			list = newList;
		}
		// 장바구니에 담는다
		list[i++] = p;
		
	}
	
	// 장바구니 담긴 목록, 총 구매비용, 남은 소지금 출력
	void summary() {
		int sum=0;	// 총구매비용
		for(int i=0; i<list.length; i++) {
			sum += list[i].price;
		}
		System.out.println(Arrays.toString(list));
		System.out.println(sum);
		System.out.println(money);
	}
}

public class Exercise7_19 {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}
}
