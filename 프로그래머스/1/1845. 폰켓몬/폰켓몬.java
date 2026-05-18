import java.util.*;

class Solution {
  
    public int solution(int[] nums) {
        int answer = 0;
        
        int k = nums.length / 2;
        
        // 1. 중복 제거 
        Set<Integer> s = new HashSet<>();
        for(int el: nums) {
            s.add(el);
        }
        
        // 2. k를 뽑는게 최대 경우 
        if(s.size() >= k) {
            answer = k;
        }
        // 3. 아닌 경우
        else {
            answer = s.size();
        }
        
        return answer;
    }
}