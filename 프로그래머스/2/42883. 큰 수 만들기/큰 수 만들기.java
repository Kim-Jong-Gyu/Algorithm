import java.util.*;

class Solution {
    
    boolean[] visited;
    String ret = "";
    
    public String solution(String number, int k) {
        String answer = "";
        char[] arr = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        
        int len = number.length() - k;
        
        int start = 0;
        for(int i = 0; i < len; i++){
            char max = '0';
            for(int j = start; j <= i + k; j++){
                if(arr[j] > max){
                    max = arr[j];
                    start = j + 1;
                }
            }
            sb.append(max);
        }
        
        return sb.toString();
    }
}