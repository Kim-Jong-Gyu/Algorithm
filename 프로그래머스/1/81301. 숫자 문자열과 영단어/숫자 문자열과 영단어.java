import java.util.*;

class Solution {
    Map<String, String> mp = new HashMap<String,String>();
    
    public void init(){
        mp.put("zero", "0");
        mp.put("one", "1");
        mp.put("two", "2");
        mp.put("three", "3");
        mp.put("four", "4");
        mp.put("five", "5");
        mp.put("six", "6");
        mp.put("seven", "7");
        mp.put("eight", "8");
        mp.put("nine", "9");
    }
    
    public int solution(String s) {
        init();
        for(String key : mp.keySet()){
            s = s.replaceAll(key, mp.get(key));
        }
        return Integer.parseInt(s);
    }
}