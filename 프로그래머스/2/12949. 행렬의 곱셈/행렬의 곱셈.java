class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[i].length; j++){
                answer[i][j] = go(arr1, arr2, i, j);
            }
        }
        return answer;
    }
    
    public int go(int[][] arr1, int[][] arr2, int i, int j){
        int ret = 0;
        for(int k = 0; k < arr1[0].length; k++){
           ret += arr1[i][k] * arr2[k][j];
        }
        return ret;
    }    
}