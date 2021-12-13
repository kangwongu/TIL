import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex11_2 {

	public static void main(String[] args) {
		// 스택과 큐 생성, (큐는 LinkedList로)
		Stack stack = new Stack();
		Queue queue = new LinkedList();
		
		// 스택에 요소 담기
		stack.push(0);
		stack.push(1);
		stack.push(2);
		
		// 큐에 요소 담기
		queue.offer(0);
		queue.offer(1);
		queue.offer(2);
		
		// 스택에 있는 값들 꺼내기
		// while문 활용, stack - empty, queue - isEmpty
		System.out.println("- stack -");
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		// 큐에 있는 값들 꺼내기
		System.out.println("- queue -");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
