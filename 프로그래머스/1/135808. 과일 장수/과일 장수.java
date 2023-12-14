import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Integer[] arr = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(arr,Collections.reverseOrder());
        List<Integer> li = new ArrayList<>();
        for (int j : arr) {
            li.add(j);
            if (li.size() == m) {
                answer += li.get(m - 1) * m;
                li.clear();
            }
        }
        return answer;
    }
}