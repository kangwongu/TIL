import java.util.EmptyStackException;
import java.util.Stack;

public class Ex11_3 {
	public static void main(String[] args) {
		// '('�� ������ ���ÿ� �ְ�, ')'�� ������ ���ÿ� �� '('�� pop()
		// ���α׷��� �����µ� ������ ���������� ����, ����־�� ����
		
		// ������ '('�� ���� ���� ����
		Stack stack = new Stack();
		
		// ����
		String expression = "3*((5*3)-(2*4))";
		System.out.println(expression);
		
		// ������ ��� String������ �ѱ��ھ� �˻�
		for(int i=0; i<expression.length(); i++) {
			char ch = expression.charAt(i);
			
			// '('�̸� ���ÿ� ����
			if(ch=='(') {
				stack.push(ch);
			// ')'�̸� ���ÿ��� ����
			} else if(ch==')') {
				stack.pop();
			}
		}
		
		// ������ ����ִٸ�, ��ȣ ��ġ
		if(stack.empty()) {
			System.out.println("��ȣ�� ��ġ�մϴ�.");
		// ������ ������� �ʴٸ�, ��ȣ ��ġx
		} else {
			System.out.println("��ȣ�� ��ġ���� �ʽ��ϴ�.");
		}
		
		
				
			
				
				
		
			
		
			
	}
}
