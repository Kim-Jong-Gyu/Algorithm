import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuffer answer = new StringBuffer("");
        String[] split = s.split(" ");
        int[] intArr = new int[split.length];
        for(int i = 0; i < split.length; i++){
            intArr[i] = Integer.parseInt(split[i]);
        }
        Arrays.sort(intArr);
        answer.append(intArr[0]);
        answer.append(" ");
        answer.append(intArr[intArr.length - 1]);
        return answer.toString();
    }
}