public class Exercise9_3 {
	public static int count(String src, String target) {
		int count = 0;
		int pos = 0;
		
		while(true) {
			// Å½»ö ½ÃÀÛ
			pos = src.indexOf(target, pos);
			
			// Å½»ö ¼º°ø
			if(pos == -1) {
				break;
			} 
			
			count++;
			pos += target.length();
			
		}
		return count;
		
	}
	
	public static void main(String[] args) {
		System.out.println(count("12345AB12AB345AB", "AB"));
	}
}
