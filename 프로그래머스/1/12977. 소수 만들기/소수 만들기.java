class Solution {
    int answer = 0;

    private boolean check(int i, int j, int k) {
        int sum = i + j + k;
        for(int l = 2; l * l <= sum; l++){
            if(sum % l == 0){
                return false;
            }
        }
        return true;
    }

    public int solution(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                for(int k = j + 1; k < nums.length; k++){
                    if(check(nums[i], nums[j], nums[k])){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}