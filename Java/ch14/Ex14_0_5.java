import java.util.Optional;

public class Ex14_0_5 {
	public static void main(String[] args) {
		// Optional<T> 사용
		
//		int[] arr = null;
		int[] arr = new int[0];
		
		// 배열 arr가 null이면 NullPointException 
		System.out.println("arr.length="+arr.length);
	
		// Optional객체 생성
//		Optional<String> opt = null;	// 오류x, 하지만 바람직하지 않음
		Optional<String> opt = Optional.empty();	
		System.out.println("opt="+opt);
		
		// Optional객체 값 가져오기
		// null값을 갖고 있을 수 있음 -> 잘 안씀
//		System.out.println("opt="+opt.get()); // 에러
		
		String str = "";
		
		// null값을 갖고 있을 수 있기 때문에 예외처리해야함, 번거로움!
//		try {
//			str = opt.get();
//		} catch (Exception e) {
//			str = ""; // 예외가 발생하면 빈문자열("")로 초기화
//		}
		
//		str = opt.orElse("EMPTY"); // Optional에 저장된 값이 null이면 반환
//		str = opt.orElseGet(() -> new String());
		str = opt.orElseGet(String::new);
		
		System.out.println("str="+str);
	}
}
