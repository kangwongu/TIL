import java.util.EmptyStackException;
import java.util.Stack;

public class Ex11_3 {
	public static void main(String[] args) {
		// '('을 만나면 스택에 넣고, ')'을 만나면 스택에 들어간 '('을 pop()
		// 프로그램이 끝났는데 스택이 남아있으면 실패, 비어있어야 성공
		
		// 수식의 '('을 담을 스택 생성
		Stack stack = new Stack();
		
		// 수식
		String expression = "3*((5*3)-(2*4))";
		System.out.println(expression);
		
		// 수식이 담긴 String변수를 한글자씩 검사
		for(int i=0; i<expression.length(); i++) {
			char ch = expression.charAt(i);
			
			// '('이면 스택에 삽입
			if(ch=='(') {
				stack.push(ch);
			// ')'이면 스택에서 삭제
			} else if(ch==')') {
				stack.pop();
			}
		}
		
		// 스택이 비어있다면, 괄호 일치
		if(stack.empty()) {
			System.out.println("괄호가 일치합니다.");
		// 스택이 비어있지 않다면, 괄호 일치x
		} else {
			System.out.println("괄호가 일치하지 않습니다.");
		}
		
		
				
			
				
				
		
			
		
			
	}
}
