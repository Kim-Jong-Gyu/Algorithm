class Solution {
    
    int[] memo;
    
    public int solution(int n) {
        memo = new int[n + 1];
        return fibo(n);
    }
    
    public int fibo(int n){
        if(n <= 1)
            return n;
        else if(memo[n] != 0)
            return memo[n];
        else
            return memo[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}