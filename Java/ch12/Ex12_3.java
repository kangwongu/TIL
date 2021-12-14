import java.util.ArrayList;
import java.util.Iterator;

interface Eatable {}

// ����
// ���� Ŭ����
class Fruit implements Eatable { public String toString() { return "Fruit"; }}
// �ڼ�Ŭ����
class Apple extends Fruit { public String toString() { return "Apple"; }}
class Grape extends Fruit { public String toString() { return "Grape"; }}

class Toy { public String toString() { return "Toy"; } }

// ������ ��� �ڽ�
class Box<T> {
	// �Ӽ�
	ArrayList<T> list = new ArrayList<>();
	
	// ���
	void addItem(T t) { list.add(t); }
	T getItem(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
}

// ���׸� Ŭ������ Ÿ���� ����
class FruitBox<T extends Fruit & Eatable> extends Box<T> {}


public class Ex12_3 {
	public static void main(String[] args) {
		// ���Ϲڽ� ���׸� Ŭ���� ����, ToyŸ���� ���Ե� �� ����
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Grape> grapeBox = new FruitBox<>();
//		FruitBox<Toy> toyBox = new FruitBox<>();	// toy�� FruitŬ����, Eatable�������̽��� ����x
		
		fruitBox.addItem(new Fruit());
		fruitBox.addItem(new Apple());
		fruitBox.addItem(new Grape());
//		fruitBox.addItem(new Toy());
		
		appleBox.addItem(new Apple());
//		appleBox.addItem(new Grape());	// apple�� grape�� ���� x

		System.out.println(fruitBox);
		System.out.println(appleBox);
	}	
}


