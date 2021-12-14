import java.util.ArrayList;

/*
 * 조상 클래스, 자손 클래스
 * 1. 조상클래스만 담는 지네릭타입의 ArrayList 생성
 * 2. list에 자손클래스 객체를 담음 (가능)
 * 3. 출력
 * 
*/

// 조상 클래스
class Product {}
// 자손 클래스
class Tv extends Product {}
class Computer extends Product {}

public class Ex12_1 {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<>();
		
		list.add(new Tv());
		list.add(new Computer());
		
		System.out.println(list);
	}
}
