import java.util.*;

class Solution {    
    public int solution(String s) {
        int answer = 0;
        String convertS = s;
        for(int i = 0; i < s.length(); i++){
            if(check(convertS))
                answer++;
            convertS = convert(convertS);
        }
        return answer;
    }
    
    public String convert(String s){
        StringBuffer sb = new StringBuffer(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(0));
        return sb.toString();
    }
    
    
    public boolean check(String s){
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(stk.empty())
                stk.push(s.charAt(i));
            else if(s.charAt(i) == ']' && stk.peek() == '[')
                stk.pop();
            else if(s.charAt(i) == '}' && stk.peek() == '{')
                stk.pop();
            else if(s.charAt(i) == ')' && stk.peek() == '(')
                stk.pop();
            else
                stk.push(s.charAt(i));
        }
        return stk.empty();
    }
}