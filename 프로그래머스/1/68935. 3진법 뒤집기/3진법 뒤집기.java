import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        List<Integer> li = new ArrayList<>();
        while(n > 0){
            li.add(n % 3);
            n /= 3;
        }
        for(int i = 0; i < li.size(); i++){
            answer += (int)Math.pow(3, li.size() - i - 1) * li.get(i);
        }
        return answer;
    }
}