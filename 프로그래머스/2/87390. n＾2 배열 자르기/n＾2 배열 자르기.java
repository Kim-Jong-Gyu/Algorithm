import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> arr = new ArrayList<>();
        Long cnt = 0L;
        for(Long i = left; i <= right; i++){
            int row = (int) (i / n);
            int col = (int) (i % n);
            arr.add(Math.max(row, col) + 1);
        }
        return arr.stream().mapToInt(Integer::intValue).toArray();
    }
}