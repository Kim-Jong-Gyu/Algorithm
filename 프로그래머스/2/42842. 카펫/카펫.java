import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        List<Pair> caseList = searchCase(yellow);
        for(Pair pair : caseList){
            if(pair.y * 2 + pair.x * 2 - 4 == brown){
                answer[0] = pair.x;
                answer[1] = pair.y;
            }
        }
        return answer;
    }
    
    public List<Pair> searchCase(int n){
        List<Pair> ret = new ArrayList<>();
        for(int i = 1; i * i <= n; i++){
            if(n % i == 0)
                ret.add(new Pair((n / i) + 2, i + 2));
        }
        return ret;
    }
    
    static class Pair {
        //length
        int y;
        //width
        int x;
        
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}