package recursiveCall;

public class ExRecursiveCall {

	public int factorialFunc(int n) {
        if(n > 1) {
            return n * factorialFunc(n-1);
        } else {
            return 1;
        }
    }
	
	public int factorialFunc2(int n) {
        if(n <= 1) {
            return 1;
        }
        return n * factorialFunc(n-1);
    }
	
	public static void main(String[] args) {
		ExRecursiveCall factorial = new ExRecursiveCall();
		System.out.println(factorial.factorialFunc(5));
		System.out.println(factorial.factorialFunc2(5));		
	}

}
