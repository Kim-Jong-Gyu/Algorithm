import java.util.*;

class Solution {
    public String solution(String s) {
        List<String> li = Arrays.asList(s.split(""));
        int j = 0;
        for(int i = 0; i < li.size(); i++){
            if(li.get(i).equals(" ")){
                j = i + 1;
            }
            else{
                if((i - j) % 2 == 0)
                    li.set(i, li.get(i).toUpperCase());
                else 
                    li.set(i, li.get(i).toLowerCase());
            }
        }
        return String.join("", li);
    }
}