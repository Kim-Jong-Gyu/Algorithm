import java.util.ArrayList;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add((long)x * i);
        }
        return arr.stream().mapToLong(i -> i).toArray();
    }
}