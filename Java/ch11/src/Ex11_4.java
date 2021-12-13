import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;



public class Ex11_4 {
	// ��ɾ ���� ť ����
	static Queue queue = new LinkedList();
	static final int MAX_SIZE = 5;	// �ִ� ��ɾ� ����
	
	public static void main(String[] args) {
		
		while(true) {
			// ����� �Է�
			Scanner scanner = new Scanner(System.in);
			System.out.print("��ɾ �Է��ϼ��� >>");
			String input = scanner.nextLine();
			
			if(input.equals("")) continue;
			
			if(input.equalsIgnoreCase("help")) {
				System.out.println("help - ����");
				System.out.println("Q / q - �ý��� ����");
				System.out.println("history - �װ� �Է��� ��ɾ �ִ� "+MAX_SIZE+"�� ������");
			} else if(input.equalsIgnoreCase("Q")) {
				System.out.println("�ý��� ����");
				System.exit(0);
			} else if(input.equalsIgnoreCase("history")) {
				
				save(input);
				
				LinkedList list = (LinkedList)queue;
				Iterator it = list.iterator();
	
				// �ֱٿ� �Է��� ��ɾ� ��� (�ִ� 5��)
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
		
		// ť�� 5���̻� �������� ó�������� ����
		if(queue.size() > MAX_SIZE) {
			queue.remove();
		}
	}
	
	
}
