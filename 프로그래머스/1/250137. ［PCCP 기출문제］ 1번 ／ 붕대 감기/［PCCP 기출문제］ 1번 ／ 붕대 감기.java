class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int time = 0;
        int pointer = 0;
        int success = 0;
        while(true) {
            if(time == attacks[pointer][0]){
                answer -= attacks[pointer][1];
                if(answer <= 0){
                    return -1;
                }
                pointer++;
                if(pointer == attacks.length){
                    break;
                }
                success = 0;
            }
            else {                
                success++;
                if(answer < health){
                    answer += bandage[1];
                    if(answer > health){
                        answer = health;
                        continue;
                    }
                    if(success == bandage[0]){
                        answer += bandage[2];
                        if(answer > health){
                            answer = health;
                        }
                        success = 0;
                    }
                }
            }
            time++;
        }
        
        return answer;
    }
}