import java.util.*;
class Solution {
    List<Integer> li = new ArrayList<>();
    
    public int findSlice(int[] arr, int stIdx, int endIdx, int idx){
        int[] sliceArr = Arrays.stream(arr, stIdx, endIdx).toArray();
        Arrays.sort(sliceArr);
        return sliceArr[idx];
    }
    
    public int[] solution(int[] array, int[][] commands) {
        for (int[] command : commands) {
            li.add(findSlice(array, command[0] - 1, command[1], command[2] - 1));
        }
        return li.stream().mapToInt(Integer :: intValue).toArray();
    }
}