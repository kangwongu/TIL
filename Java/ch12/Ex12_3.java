import java.util.ArrayList;
import java.util.Iterator;

interface Eatable {}

// 과일
// 조상 클래스
class Fruit implements Eatable { public String toString() { return "Fruit"; }}
// 자손클래스
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}

class Toy { public String toString() { return "Toy"; } }

// 물건을 담는 박스
class Box<T> {
	// 속성
	ArrayList<T> list = new ArrayList<>();
	
	// 기능
	void addItem(T t) { list.add(t); }
	T getItem(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}

// 지네릭 클래스의 타입을 제한
class FruitBox<T extends Fruit & Eatable> extends Box<T> {}


public class Ex12_3 {
	public static void main(String[] args) {
		// 과일박스 지네릭 클래스 생성, Toy타입은 대입될 수 없음
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();
//		FruitBox<Toy> toyBox = new FruitBox<>();	// toy는 Fruit클래스, Eatable인터페이스와 관련x
		
		fruitBox.addItem(new Fruit());
		fruitBox.addItem(new Apple());
		fruitBox.addItem(new Grape());
//		fruitBox.addItem(new Toy());
		
		appleBox.addItem(new Apple());
//		appleBox.addItem(new Grape());	// apple과 grape는 관계 x

		System.out.println(fruitBox);
		System.out.println(appleBox);
	}	
}


