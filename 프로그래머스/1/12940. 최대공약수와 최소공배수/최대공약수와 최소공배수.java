import java.util.*;
class Solution {
    private int commonDivisor(int n, int m){
        int ret = 1;
        int i = 1;
        while(n >= i && m >= i){
            if(n % i == 0 && m % i == 0){
               ret = i;
            }
            i++;
        }
        return ret;
    }
    
    
    public int[] solution(int n, int m) {
        int commonD = commonDivisor(n, m);
        n /= commonD;
        m /= commonD;
        int commonM = n * m * commonD;
        int[] answer = {commonD, commonM};
        return answer;
    }
}