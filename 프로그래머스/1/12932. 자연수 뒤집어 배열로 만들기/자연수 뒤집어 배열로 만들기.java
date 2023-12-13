class Solution {
    public int[] solution(long n) {
        String nString = String.valueOf(n);
        String reverse = new StringBuilder(nString).reverse().toString();
        String[] split = reverse.split("");
        int[] answer = new int[split.length];

        for (int i=0; i<split.length; i++) {
            answer[i] = Integer.parseInt(split[i]);
        }
        
        return answer;
    }
}