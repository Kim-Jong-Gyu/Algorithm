import java.util.*;

class Solution {
    
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int el : scoville) {
            pq.offer(el);
        }
        
        while(!pq.isEmpty()) {
            int first = pq.poll();
            if(first >= K){
                break;
            }
            else {
                if(pq.isEmpty()){
                    answer = -1;
                    break;
                }
                else {
                    answer += 1;
                    int second = pq.poll();
                    pq.offer(first + second * 2);
                }
            }
        }
        
        return answer;
    }
    
}