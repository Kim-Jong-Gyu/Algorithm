class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int prev = 0;
        while(n >= a){
            prev = n;
            n = (n / a) * b;
            answer += n;
            if(prev % a != 0){
                n += prev % a;
            }
        }
        return answer;
    }
}