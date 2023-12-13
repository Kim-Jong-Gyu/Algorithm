import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int prev1 = -1;
        int prev2 = -1;
        for(String target : goal){
            List<String> list1 = Arrays.asList(cards1);
            List<String> list2 = Arrays.asList(cards2);
            if(list1.contains(target)){
                int next1 = list1.indexOf(target);
                if(prev1 + 1 != next1){
                    return "No";
                }
                prev1 = next1;
            } else {
                int next2 = list2.indexOf(target);  
                if(prev2 + 1 != next2){
                    return "No";
                }
                prev2 = next2;
            }
        }
        return "Yes";
    }
}