import java.util.*;

class Solution {
    
    public Map<String, Integer> mp = new HashMap<>();
    
    public int convertFromMonthToDays(String month){
        return Integer.parseInt(month) * 28;
    }
    
    public int convertFromYearToDays(String year){
        return Integer.parseInt(year) * 12 * 28;
    }
    
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        String[] h = today.split("\\.");
        
        
        int todayTotal = convertFromYearToDays(h[0]) + convertFromMonthToDays(h[1])
            + Integer.parseInt(h[2]);
        
        for(String term : terms){
            String[] t = term.split(" ");
            mp.put(t[0], convertFromMonthToDays(t[1]));
        }
        
        List<Integer> ret = new ArrayList<>();
        
        for(int i = 0; i < privacies.length; i++){
            String[] s = privacies[i].split("\\.");
            String[] tail = s[s.length - 1].split(" ");
            // s[0], s[1] -> year , month 
            // tail[0], tail[1] -> day , grade
            int total = convertFromYearToDays(s[0]) + convertFromMonthToDays(s[1]) 
                + Integer.parseInt(tail[0]) + mp.get(tail[1]);
            if(total <= todayTotal)
                ret.add(i + 1);
        }
        return ret.stream().mapToInt(Integer::intValue).toArray();
    }
}