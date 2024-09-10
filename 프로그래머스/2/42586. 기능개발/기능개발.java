import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int idx = 0;
        while(idx < progresses.length){
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            if(progresses[idx] < 100)
                continue;
            int count = 0;
            while(progresses[idx] >= 100){
                count++;
                idx++;
                if(idx == progresses.length)
                    break;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}