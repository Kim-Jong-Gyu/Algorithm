import java.util.*;

class Solution {
    public int[] solution(long n) {
        String input = Long.toString(n);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = input.length() - 1; i >= 0; i--){
            arr.add(input.charAt(i) - '0');
        }
        return arr.stream().mapToInt(i->i).toArray();
    }
}