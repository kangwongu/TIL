
class Data_1 { int value; }

class Data_2 {
	int value;
	
	// 기본생성자를 명시적으로 추가
	Data_2() {}
	
	Data_2(int x) {
		value = x;
	}
}


public class Ex6_11 {
	public static void main(String[] args) {
		Data_1 d1 = new Data_1();
		Data_2 d2 = new Data_2();
	}
}

