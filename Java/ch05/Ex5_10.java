import java.util.Arrays;
import java.util.Scanner;

public class Ex5_10 {

	public static void main(String[] args) {
		
		// 단어, 뜻이 저장된 2차원배열을 생성
		String[][] words = {
				{"Computer", "컴퓨터"},
				{"Desk", "책상"},
				{"Chair", "의자"},
				{"Pensil", "연필"},
				{"Cloth", "옷"}
		};
		System.out.println(Arrays.deepToString(words));
		
		Scanner scanner = new Scanner(System.in);
		
		// 배열의 길이만큼 반복(실행)
		for(int i=0; i<words.length; i++) {
			System.out.printf("Q%d. %s의 뜻은?>>", i+1, words[i][0]);
			
			// 단어의 뜻을 맞춰야 함, 뜻 입력받음
			String input = scanner.nextLine().trim();
			// 뜻과 입력값이 같으면 정답 틀리면 땡
			// 문자열 비교는 무조건  equals()!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			if(input.equals(words[i][1]))
				System.out.println("정답입니다.");
			else {
				System.out.println("땡!");
			}
		}
		
		
			
	}

}
