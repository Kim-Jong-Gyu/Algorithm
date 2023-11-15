class Solution {
    public int solution(String s) {
        int answer = 0;
        int flag = 1;
        int start = 0;
        if(s.charAt(0) == '-'){
            flag *= -1;
            start = 1;
        }
        if(s.charAt(0) == '+'){
            start = 1;
        }
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                continue;
            }
            answer += (s.charAt(i) - '0') * (int)Math.pow(10, (s.length() - 1 - i));
        }
        return answer * flag;
    }
}