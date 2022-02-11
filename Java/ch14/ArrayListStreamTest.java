import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListStreamTest {

	public static void main(String[] args) {
		
		List<String> sList = new ArrayList<>();
		
		sList.add("saka");
		sList.add("rowe");
		sList.add("xhaka");
		
		Stream<String> stream = sList.stream();
		stream.forEach(s -> System.out.println(s));
		
		sList.stream().sorted().forEach(s -> System.out.print(s + "\t"));
		System.out.println();
		
		sList.stream().map(s->s.length()).forEach(s->System.out.print(s+"\t"));
		System.out.println();
		
		sList.stream().filter(s->s.length() <= 4).forEach(s->System.out.print(s+"\t"));
	}
}
