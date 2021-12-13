import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Exercise11_6 {
	public static void main(String[] args) {
		// 중복x, 순서 x
		Set set = new HashSet();
		int[][] board = new int[5][5];
		
		for(int i=0; set.size()<25; i++) {
			set.add((int)(Math.random()*30)+1+"");
		}
		
		// list를 이용해 shuffle()사용 -> 효과적으로 섞기 가능
		List list = new LinkedList(set);
		Collections.shuffle(list);
		Iterator it = list.iterator();
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = Integer.parseInt((String)it.next());
				System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]);
			}
			System.out.println();
		}
	}
}
