class Solution {
    public boolean primeCheck(String num, int k){
        long n = Long.parseLong(num);
        if(n == 1 || n == 0)
            return false;
        if(n == 2 || n == 3)
            return true;
        for(int i = 2; (long) i * i <= n; i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        int answer = 0;
        // 진수로 변환
        String binary = Integer.toString(n,k);
        String[] arr = binary.split("0");
        for(String num : arr){
            if(num.isEmpty())
                continue;
            if(primeCheck(num, k)){
                answer++;
            }
        }
        return answer;
    }
}