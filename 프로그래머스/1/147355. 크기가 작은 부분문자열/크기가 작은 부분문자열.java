import java.util.*;
class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        long longP = Long.parseLong(p);
        for(int i = 0; i < t.length() - (len - 1); i++){
            String str = t.substring(i, i + len);
            if(Long.parseLong(str) <= longP)
                answer++;
        }
        return answer;
    }
}