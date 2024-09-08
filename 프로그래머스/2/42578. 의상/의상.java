import java.util.*;

class Solution {
    

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            mp.put(clothes[i][1], mp.getOrDefault(clothes[i][1], 0) + 1);
        }
        for(String key : mp.keySet()){
            answer *= (mp.get(key) + 1);
        }
        
        answer -= 1;
        
        return answer;
    }
}