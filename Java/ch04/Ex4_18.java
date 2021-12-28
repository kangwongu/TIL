import java.util.Scanner;

public class Ex4_18 {

	public static void main(String[] args) {
		
		// 입력위한 툴
		Scanner scanner = new Scanner(System.in);
		
		// 무한루프,
		while(true) {
			// 메뉴
			System.out.println("(1) 추가");
			System.out.println("(2) 조회");
			System.out.println("(3) 삭제");
			System.out.println("(0) 종료");
			
			// 메뉴 입력받음
			System.out.print("메뉴를 선택해주세요(1)~(3) (0)은 종료.>>");
			int menu = scanner.nextInt();
			
			// 유효성검사
			// 메뉴가 0이면 종료
			if(menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
				// 메뉴가 1~3이 아니면 재입력
			} else if (!(1 <= menu && menu <= 3)) {
				System.out.println("올바르지 않은 메뉴입니다. 재입력하세요");
				continue;
			}
			
			System.out.println("선택하신 메뉴는 "+menu+"입니다.");
			
			
		}
	}
}