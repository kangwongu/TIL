package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex18258 {

	private static Queue<Integer> queue = new LinkedList<>();
	private static StringBuffer sb = new StringBuffer();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 1. ��� �� �Է�
		int N = Integer.parseInt(br.readLine());
		
		// 2. ��� �� ��ŭ �ݺ�
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	// ���� �������� ���ڿ� �и�
			String str = st.nextToken();
//			System.out.println(str);
			
			// �и��� ��ū�� �� ������ �ִٸ� push�� ����, push 15 -> push / 15
			if(st.hasMoreTokens()) {
				push(Integer.parseInt(st.nextToken()));
			} else if(str.equals("pop")) {
				sb.append(pop()).append("\n");
			} else if(str.equals("size")) {
				sb.append(size()).append("\n");
			} else if(str.equals("empty")) {
				sb.append(empty()).append("\n");
			} else if(str.equals("front")) {
				sb.append(front()).append("\n");
			} else if(str.equals("back")) {
				sb.append(back()).append("\n");
			}
			
			
		}
	}

	// push
	public static void push(int i) {
		queue.add(i);
	}
	
	// pop
	public static int pop() {
		if(queue.isEmpty()) {
			return -1;
		}
		
		return queue.remove();
		
	}
	public static int size() {
		if(queue.isEmpty()) 
			return 0;
		
		return queue.size();
	}
	public static int empty() {
		if(queue.isEmpty()) 
			return 1;
		
		return 0;
	}
	public static int front() {
		if(queue.isEmpty()) 
			return -1;
		
		return queue.poll();
	}
	public static int back() {
		if(queue.isEmpty()) 
			return -1;
		
		return queue.poll()-(queue.size()-1);
	}
	
	// size
		
	// empty
		
	// front
		
	// back
		
		
	
}
