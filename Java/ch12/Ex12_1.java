import java.util.ArrayList;

/*
 * ���� Ŭ����, �ڼ� Ŭ����
 * 1. ����Ŭ������ ��� ���׸�Ÿ���� ArrayList ����
 * 2. list�� �ڼ�Ŭ���� ��ü�� ���� (����)
 * 3. ���
 * 
*/

// ���� Ŭ����
class Product {}
// �ڼ� Ŭ����
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
