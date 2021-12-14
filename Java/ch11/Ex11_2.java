import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex11_2 {

	public static void main(String[] args) {
		// ���ð� ť ����, (ť�� LinkedList��)
		Stack stack = new Stack();
		Queue queue = new LinkedList();
		
		// ���ÿ� ��� ���
		stack.push(0);
		stack.push(1);
		stack.push(2);
		
		// ť�� ��� ���
		queue.offer(0);
		queue.offer(1);
		queue.offer(2);
		
		// ���ÿ� �ִ� ���� ������
		// while�� Ȱ��, stack - empty, queue - isEmpty
		System.out.println("- stack -");
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
		// ť�� �ִ� ���� ������
		System.out.println("- queue -");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}

}
