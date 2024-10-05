import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        // Conveyer
        Queue<Integer> q = new LinkedList<>();
        
        // Sub Conveyer
        Stack<Integer> stk = new Stack<>();
        
        for(int i = 0; i < order.length; i++){
            q.offer(i + 1);
        }
        int idx = 0;
        
        while(true){
            if(!q.isEmpty()){
                if(order[idx] == q.peek()){
                    q.poll();
                    answer++;
                    idx++;
                    continue;
                }
                if(!stk.isEmpty()){
                    if(order[idx] == stk.peek()){
                        stk.pop();
                        answer++;
                        idx++;
                        continue;
                    }
                }
                stk.push(q.poll());
            }
            else{
                if(!stk.isEmpty()){
                    if(order[idx] == stk.peek()){
                        stk.pop();
                        answer++;
                        idx++;
                    }
                    else
                        break;
                }
                else 
                    break;
            }
        }
        return answer;
    }
}