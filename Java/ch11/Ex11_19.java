import static java.util.Collections.addAll;
import static java.util.Collections.binarySearch;
import static java.util.Collections.copy;
import static java.util.Collections.disjoint;
import static java.util.Collections.enumeration;
import static java.util.Collections.fill;
import static java.util.Collections.nCopies;
import static java.util.Collections.replaceAll;
import static java.util.Collections.reverseOrder;
import static java.util.Collections.rotate;
import static java.util.Collections.shuffle;
import static java.util.Collections.sort;
import static java.util.Collections.swap;

import java.util.ArrayList;
import java.util.List;

public class Ex11_19 {
	public static void main(String[] args) {
		List list = new ArrayList();
		System.out.println(list);
		
		addAll(list, 1,2,3,4,5);
		System.out.println(list);
		
		rotate(list,3);
		System.out.println(list);
		
		swap(list,0,3);
		System.out.println(list);
		
		shuffle(list);
		System.out.println(list);
		
		sort(list, reverseOrder());
		System.out.println(list);
		
		sort(list);
		System.out.println(list);
		
		int idx = binarySearch(list,3);
		System.out.println("index of 3 = " + idx);
		
		fill(list,9);
		System.out.println("list="+list);
		
		List newList = nCopies(list.size(), 3);
		System.out.println("newList="+newList);
		
		System.out.println(disjoint(list,newList));;
		copy(list, newList);
		System.out.println(newList);
		System.out.println(list);
		
		replaceAll(list, 3, 7);
		System.out.println(list);
		
		//Enumeration e = enumeration(list);
		//ArrayList list2 = list(e);
		//System.out.println(list2);
		
	}


}

	