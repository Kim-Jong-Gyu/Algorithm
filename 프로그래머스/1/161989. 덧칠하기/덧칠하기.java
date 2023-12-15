class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cur = section[0];
        answer++;
        for(int curSection : section){
            if(cur + m > curSection)
                continue;
            cur = curSection;
            answer++;
        }
        return answer;
    }
}