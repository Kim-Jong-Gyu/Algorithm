import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        int sumWeight = 0;

        for(int i = 0; i < bridge_length; i++){
            q.offer(0);
        }

        while(idx < truck_weights.length){
            answer++;
            sumWeight -= q.poll();
            if(sumWeight + truck_weights[idx] <= weight){
                q.offer(truck_weights[idx]);
                sumWeight += truck_weights[idx];
                idx++;
            }
            else
                q.offer(0);
        }
        return answer + bridge_length;
    }
}