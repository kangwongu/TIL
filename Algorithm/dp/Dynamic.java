package dp;

public class Dynamic {

	// 피보나치 수열
	public int dynamicFunc(int n) {
        // Memoization기법, 내부 배열을 생성해 값을 저장해 둠
        Integer[] cache = new Integer[n + 1];
        cache[0] = 0;
        cache[1] = 1;
        for(int index=2; index<n+1; index++) {
            cache[index] = cache[index-1] + cache[index-2];
        }
        return cache[n];
    }
	public static void main(String[] args) {
		Dynamic dynamic = new Dynamic();
		System.out.println(dynamic.dynamicFunc(5));
	}

}
