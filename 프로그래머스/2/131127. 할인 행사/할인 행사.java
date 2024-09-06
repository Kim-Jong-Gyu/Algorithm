import java.util.*;

class Solution {
    
    public Map<String, Integer> init(String[] want, int[] number){
        Map<String, Integer> mp = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            mp.put(want[i], number[i]);
        }
        return mp;
    }
    
    public boolean check(Map<String, Integer> jung){
        for(String key : jung.keySet()){
            if(jung.get(key) != 0){
                return false;
            }
        }
        return true;
    }
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i = 0 ; i <= discount.length - 10; i++){
            Map<String, Integer> jung = init(want, number);
            for(int j = i; j < i + 10; j++){
                if(jung.get(discount[j]) != null){
                    jung.put(discount[j], jung.get(discount[j]) - 1);
                }
            }
            if(check(jung)){
                answer++;
            }
        }
        return answer;
    }
}