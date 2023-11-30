import java.util.*;
class Solution {
    Map<String, Integer> mp = new HashMap<>();
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Arrays.fill(answer, - 1);
        String[] str= s.split("");
        for(int i = 0; i < str.length; i++){
            if(mp.containsKey(str[i])){
                answer[i] = i - mp.get(str[i]);
                mp.replace(str[i], i);
            }
            mp.put(str[i], i);
        }
        return answer;
    }
}