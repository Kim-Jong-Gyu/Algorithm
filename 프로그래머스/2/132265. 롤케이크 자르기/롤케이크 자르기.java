import java.util.*;

class Solution {
    
    public int check(int[] arr){
        // 중복 제거  
        int[] distinct_arr = Arrays.stream(arr).distinct().toArray();
        return distinct_arr.length;
    }
    
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> mp1 = new HashMap<>();
        Map<Integer, Integer> mp2 = new HashMap<>();
        
        int point = 0;
        
        mp1.put(topping[point], 1);
        
        for(int i = 1; i < topping.length; i++){
            mp2.put(topping[i], mp2.getOrDefault(topping[i], 0) + 1);
        }
        
        while(point < topping.length - 1){
            if(mp1.size() == mp2.size()){
                answer++;
            }

            point++;
            
            mp1.put(topping[point], mp1.getOrDefault(topping[point], 0) + 1);

            if(mp2.get(topping[point]) > 1){
                mp2.put(topping[point], mp2.get(topping[point]) - 1);
            }
            else {
                mp2.remove(topping[point]);
            }
        }
        
        return answer;
    }
}