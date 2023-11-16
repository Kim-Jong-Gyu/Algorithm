class Solution {
    public int solution(int num) {
        long input = (long) num;
        for(long i = 0; i < 500; i++){
            if(input == 1)
                return (int)i;
            else{
                if(input % 2 == 0)
                    input /= 2;
                else{
                    input *= 3;
                    input++;
                }
            }
        }
        return -1;
    }
}