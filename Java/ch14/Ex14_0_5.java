import java.util.Optional;

public class Ex14_0_5 {
	public static void main(String[] args) {
		// Optional<T> ���
		
//		int[] arr = null;
		int[] arr = new int[0];
		
		// �迭 arr�� null�̸� NullPointException 
		System.out.println("arr.length="+arr.length);
	
		// Optional��ü ����
//		Optional<String> opt = null;	// ����x, ������ �ٶ������� ����
		Optional<String> opt = Optional.empty();	
		System.out.println("opt="+opt);
		
		// Optional��ü �� ��������
		// null���� ���� ���� �� ���� -> �� �Ⱦ�
//		System.out.println("opt="+opt.get()); // ����
		
		String str = "";
		
		// null���� ���� ���� �� �ֱ� ������ ����ó���ؾ���, ���ŷο�!
//		try {
//			str = opt.get();
//		} catch (Exception e) {
//			str = ""; // ���ܰ� �߻��ϸ� ���ڿ�("")�� �ʱ�ȭ
//		}
		
//		str = opt.orElse("EMPTY"); // Optional�� ����� ���� null�̸� ��ȯ
//		str = opt.orElseGet(() -> new String());
		str = opt.orElseGet(String::new);
		
		System.out.println("str="+str);
	}
}
