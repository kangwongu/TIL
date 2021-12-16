import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
	public static void main(String[] args) {
		// �Լ��� �������̽� ����
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1;
		Consumer<Integer> c = i -> System.out.print(i+",");
		Predicate<Integer> p = i -> i%2!=0;
		Function<Integer, Integer> f = i -> i*10;
		
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> newList = getRandomList(s, list);
		System.out.println(newList);
		printNotEvenNums(p, c, newList);
		
		transList(f, list, newList);
		System.out.println(list);
		System.out.println(newList);
		
	}
	
	// <T>Ÿ���� ����Ʈ�� ��ȯ�ϴ� �޼ҵ�
	static <T> ArrayList<T> getRandomList(Supplier<T> s, ArrayList<T> list) {
		// 1. �Ű����� list�������� newList ����
		ArrayList<T> newList = new ArrayList<>(list.size());
		// 2. newList�� ������ ����ֱ�
		
		for(int i=0; i<10; i++) {
			newList.add(s.get());
		}
		
		return newList;
	}
	
	// newList���� 2�� ����� �ƴ� ��ҵ鸸 ���
	static <T> void printNotEvenNums(Predicate<T> p, Consumer<T> c, ArrayList<T> list) {
		// ����Ʈ�� ũ�⸸ŭ ���
		for(T i : list) {
			// 2�� ����� �ƴ� ��ҵ鸸 ���
			if(p.test(i)) {
				c.accept(i);
			}
		}
	}
	
	// newList�� ��ҵ��� list�� �ű�
	static <T> void transList(Function<T, T> f, ArrayList<T> list ,ArrayList<T> newList) {
		// newList -> list
		for(T i : newList) {
			list.add(f.apply(i));
		}
	}
	
}
