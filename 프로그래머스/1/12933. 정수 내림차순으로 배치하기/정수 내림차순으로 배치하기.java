import java.util.*;
class Solution {
    public long solution(long n) {
        long answer = 0;
        List<Long> li = new ArrayList<Long>();
        while(n > 0){
            li.add(n % 10);
            n /= 10;
        }
        Collections.sort(li, Collections.reverseOrder());
        for(int i = 0; i < li.size(); i++){
            if(li.get(i) == 0)
                continue;
            else
                answer += li.get(i) * (long)Math.pow(10, li.size() - 1 -i); 
    }
    return answer;
    }
}