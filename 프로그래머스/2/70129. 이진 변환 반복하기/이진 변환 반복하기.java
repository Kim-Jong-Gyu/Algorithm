import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int cntZero = 0;
        int cntCon = 0;
        while(s.length() != 1){
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0')
                    cntZero++;
                else {
                    sb.append(s.charAt(i));
                }
            }
            cntCon++;
            s = Integer.toBinaryString(sb.toString().length());
        }
        answer[0] = cntCon;
        answer[1] = cntZero;
        return answer;
    }
}