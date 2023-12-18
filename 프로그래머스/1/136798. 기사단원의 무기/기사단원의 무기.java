class Solution {
    public int countDivisor(int input){
        int ret = 0;
        if(input == 1)
            return 1;
        if(input == 2)
            return 2;
        int i = 0;
        for(i = 1; i * i <= input; i++){
            if(input % i == 0)
               ret++;
        }
        ret *= 2;
        if((i - 1) * (i - 1) == input)
            ret--;
        return ret;
    }


    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int num = countDivisor(i);
            if(num > limit){
                num = power;
            }
            answer+= num;
        }
        return answer;
    }
}