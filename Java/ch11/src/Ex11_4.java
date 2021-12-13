import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Ex11_4 {
	// 명령어를 담을 큐 생성
	static Queue queue = new LinkedList();
	static final int MAX_SIZE = 5;	// 최대 명령어 개수
	
	public static void main(String[] args) {
		
		while(true) {
			// 사용자 입력
			Scanner scanner = new Scanner(System.in);
			System.out.print("명령어를 입력하세요 >>");
			String input = scanner.nextLine();
			
			if(input.equals("")) continue;
			
			if(input.equalsIgnoreCase("help")) {
				System.out.println("help - 도움말");
				System.out.println("Q / q - 시스템 종료");
				System.out.println("history - 그간 입력한 명령어를 최대 "+MAX_SIZE+"개 보여줌");
			} else if(input.equalsIgnoreCase("Q")) {
				System.out.println("시스템 종료");
				System.exit(0);
			} else if(input.equalsIgnoreCase("history")) {
				
				save(input);
				
				LinkedList list = (LinkedList)queue;
				Iterator it = list.iterator();
	
				// 최근에 입력한 명령어 출력 (최대 5개)
				int i=0;
				while(it.hasNext()) {
					System.out.println(++i+"."+it.next());
				}
				
			} else {
				save(input);
			}
		}
	}
	
	public static void save(String input) {
		if(!queue.equals(""))
			queue.offer(input);
		
		// 큐에 5개이상 들어가있으면 처음데이터 삭제
		if(queue.size() > MAX_SIZE) {
			queue.remove();
		}
	}
	
	
}
