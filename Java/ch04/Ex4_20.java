import java.util.Scanner;

public class Ex4_20 {

	public static void main(String[] args) {
		// 변수
		// 메뉴에 활용될 변수
		int menu;
		int num;	// 연산할 수
		
		Scanner scanner = new Scanner(System.in);
	
		// do-while문에 이름을 붙임
		outer :
		do {
			System.out.println("(1) squre");
			System.out.println("(2) squre root");
			System.out.println("(3) log");
			
			// 메뉴를 입력받음
			System.out.print("메뉴를 선택하세요(1~3). 종료(0)>");
			menu = scanner.nextInt();
			
			// 메뉴가 0이면 종료
			if(menu == 0) {
				System.out.println("프로그램을 종료합니다");
				break;
			// 메뉴가 1~3이 아니면 재입력
			} else if(!(1 <= menu && menu <= 3)) {
				System.out.println("다시 입력하세요(1~3). 종료(0)");
				continue;
			}
			
			System.out.println("선택하신 메뉴는 " + menu + "입니다");
			
			for(;;) {
				System.out.print("계산할 수를 입력하세요(0~99) (0:계산 종료, 99:전체 종료)>");
				// 연산할 수 입력
				num = scanner.nextInt();
				
				// 조건검사, 0이면 종료, 99면 전체종료
				if(num == 0) {
					System.out.println("계산종료");
					break;
				} 
				
				if(num == 99) {
					System.out.println("전체종료");
					break outer;
				}
				
				// 메뉴에 따른 연산 실행
				switch(menu) {
				// 제곱
				case 1:
					System.out.println("result = " + num*num);
					break;
				// 제곱근
				case 2:
					System.out.println("result = " + Math.sqrt(num));
					break;
				// 로그	
				case 3:
					System.out.println("result = " + Math.log(num));
					break;
				}
				
			}
			
			
		}while(true);
		
		
		
		
		
	}
}