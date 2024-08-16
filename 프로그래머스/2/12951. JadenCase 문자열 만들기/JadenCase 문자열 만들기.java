import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char[] charArr = s.toCharArray();
        boolean flag = true;
        for(int i = 0; i < charArr.length; i++){
            if(charArr[i] == ' '){
                flag = true;
                continue;
            }
            if(Character.isDigit(charArr[i])){
                flag = false;
                continue;
            }
            if(Character.isLowerCase(charArr[i]) && flag){
                charArr[i] = Character.toUpperCase(charArr[i]);
                flag = false;
                continue;
            }
            charArr[i] = Character.toLowerCase(charArr[i]);    
        }
        return String.valueOf(charArr);
    }
}