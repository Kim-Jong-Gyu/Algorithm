import java.util.*;
class Solution {
    
    List<Integer> li = new ArrayList<Integer>();
    
    public int solve(List<Integer> li, int score, int k){
        int ret = 0;
        li.add(score);
        li.sort(Collections.reverseOrder());
        if(li.size() < k){
            ret = li.get(li.size() - 1);
        }
        else {
            ret = li.get(k - 1);
        }
        return ret;
    }

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        for(int i = 0; i < score.length; i++){
            answer[i] = solve(li, score[i],k);
        }
        return answer;
    }
}