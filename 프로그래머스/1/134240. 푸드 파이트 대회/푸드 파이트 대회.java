import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length; i++){
            for(int j = 0; j < food[i] / 2; j++){
                answer+= String.valueOf(i);
            }
        }
        StringBuffer stringBuffer = new StringBuffer(answer);
        String reverseAnswer = stringBuffer.reverse().toString();
        answer += "0" + reverseAnswer;
        return answer;
    }
}