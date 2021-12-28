import java.util.Scanner;

public class Exercise5_6 {

	public static void main(String[] args) {

		String[] words = {"television", "computer", "mouse", "phone"};
		
		Scanner scanner = new Scanner(System.in);
		
		for(int i=0; i<words.length; i++) {
			char[] question = words[i].toCharArray();
			
			
			// question배열 요소를 랜덤으로 섞기
			for(int j=0; j<question.length; j++) {
				int s = (int)(Math.random()*question.length);
				
				char tmp = question[j];
				question[j] = question[s];
				question[s] = tmp;
			}
			System.out.printf("Q%d. %s의 정답을 입력하세요>", i+1, new String(question));
			
			String answer = scanner.nextLine();
			
			if(words[i].equals(answer.trim())) {
				System.out.println("정답입니다");
			} else {
				System.out.println("틀렸어요");
			}
				
		}
	}

}
