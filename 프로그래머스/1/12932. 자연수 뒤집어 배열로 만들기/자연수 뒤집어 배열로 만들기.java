class Solution {
    public int[] solution(long n) {
        String nString = String.valueOf(n);
        String reverse = new StringBuilder(nString).reverse().toString();
        char[] charArray = reverse.toCharArray();
        int[] answer = new int[charArray.length];

        for (int i=0; i<charArray.length; i++) {
            answer[i] = charArray[i] - '0';
        }
        
        return answer;
    }
}