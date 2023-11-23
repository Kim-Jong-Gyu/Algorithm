import java.util.*;
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        List<List<Integer>> total = new ArrayList<>(); 
        for(int i = 0; i < arr1.length; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < arr1[i].length; j++){
                row.add(arr1[i][j] + arr2[i][j]);
            }
            total.add(row);
        }
        return total.stream().map(item -> item.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
    }
}