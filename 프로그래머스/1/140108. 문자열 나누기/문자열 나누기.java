class Solution {
    public int solution(String s) {
        int answer = 0;
        char x = s.charAt(0);
        int countX = 1;
        int countA = 0;
        for(int i = 1; i < s.length(); i++){
            if(countX == countA){
                answer++;
                x = s.charAt(i);
                countX = 1;
                countA = 0;
            }
            else {
                if(s.charAt(i) == x)
                    countX++;
                if(s.charAt(i) != x)
                    countA++;
            }
        }
        
        if(countX == countA || countX != 0 || countA != 0){
            answer++;
        }
        return answer;
    }
}