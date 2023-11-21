
class Solution {
    public boolean divisor(int num){
        int check = (int)Math.sqrt(num);
        if(check * check == num)
            return false;
        return true;
    }
    
    public int solution(int left, int right) {
        int answer = 0;
        for(int i = left; i <= right; i++){
            answer += (divisor(i)) ? i : i * -1;
        }
        
        return answer;
    }
}