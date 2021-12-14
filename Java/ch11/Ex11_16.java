import java.util.HashMap;
import java.util.Scanner;

public class Ex11_16 {
	public static void main(String[] args) {
		// id, 비번을 HashMap에 저장, 사용자 입력, 맞추면 ㄹ그인, 틀리면 놉
		// HashMap생성
		HashMap hm = new HashMap();
		
		// HashMap에 id, 비번 저장
		hm.put("kwg527", "kjg1202");
		hm.put("kjg1202", "kwg0527");
		hm.put("asdf", "1234");
		
		Scanner scanner = new Scanner(System.in);
		
		// 사용자 입력
		while(true ) {
			System.out.println("id와 password를 입력하세요.");
			// id입력
			System.out.print("id :");
			String id = scanner.nextLine();
			
			// 비번 입력
			System.out.print("password :");
			String password = scanner.nextLine();
			System.out.println();
			
			// id가 일치하지 않으면 재입력
			if(!hm.containsKey(id)) {
				System.out.println("일치하지 않는 id입니다.");
				continue;
			}
			
			// id는 일치, 비번이 일치하지 않으면 재입력
			if(!(hm.get(id)).equals(password)) {
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("로그인 성공!");
				break;
			}
			
			
		}
		
		
	}
}
