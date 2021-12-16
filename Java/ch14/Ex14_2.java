import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
	public static void main(String[] args) {
		// 함수형 인터페이스 정의
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
	
	// <T>타입의 리스트를 반환하는 메소드
	static <T> ArrayList<T> getRandomList(Supplier<T> s, ArrayList<T> list) {
		// 1. 매개변수 list사이즈의 newList 생성
		ArrayList<T> newList = new ArrayList<>(list.size());
		// 2. newList에 랜덤값 집어넣기
		
		for(int i=0; i<10; i++) {
			newList.add(s.get());
		}
		
		return newList;
	}
	
	// newList에서 2의 배수가 아닌 요소들만 출력
	static <T> void printNotEvenNums(Predicate<T> p, Consumer<T> c, ArrayList<T> list) {
		// 리스트의 크기만큼 출력
		for(T i : list) {
			// 2의 배수가 아닌 요소들만 출력
			if(p.test(i)) {
				c.accept(i);
			}
		}
	}
	
	// newList의 요소들을 list에 옮김
	static <T> void transList(Function<T, T> f, ArrayList<T> list ,ArrayList<T> newList) {
		// newList -> list
		for(T i : newList) {
			list.add(f.apply(i));
		}
	}
	
}
