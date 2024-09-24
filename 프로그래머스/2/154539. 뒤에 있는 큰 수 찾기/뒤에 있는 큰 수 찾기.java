import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        int[] answer = new int[numbers.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        
        for(int i = 1; i < numbers.length; i++){
            
            while(!stk.isEmpty() && numbers[stk.peek()] < numbers[i]){
                answer[stk.pop()] = numbers[i];
            }
            
            stk.push(i);
        }
        
        while(!stk.isEmpty()){
            answer[stk.pop()] = -1;
        }
        return answer;
    }
}