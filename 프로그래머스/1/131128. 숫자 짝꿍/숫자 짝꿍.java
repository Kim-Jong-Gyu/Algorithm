import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        for(int i = 0; i< X.length(); i++)
            arrX[X.charAt(i) - '0']++;
        for(int i = 0; i< Y.length(); i++)
            arrY[Y.charAt(i) - '0']++;
        for(int i = arrX.length - 1; i >= 0; i--){
            while(arrX[i] >= 1 && arrY[i] >= 1){
                arrX[i]--;
                arrY[i]--;
                answer.append(i);
            }
        }
        if(answer.toString().equals(""))
            return "-1";
        else if(answer.toString().startsWith("0")){
            return "0";
        }else {
            return answer.toString();
        }
    }
}