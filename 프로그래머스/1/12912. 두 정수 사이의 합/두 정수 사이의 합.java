import java.util.*;

class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int flag = 1;
        if(a > b)
            flag *= -1;
        for(int i = 0; i <= Math.abs(a - b); i++){
            answer += (long)a + i * flag;
        }
        return answer;
    }
}