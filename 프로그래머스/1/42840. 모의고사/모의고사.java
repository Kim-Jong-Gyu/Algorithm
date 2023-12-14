import java.util.*;

class Solution {
    // 5
    int[] arr1 = {1, 2, 3, 4, 5};
    // 8
    int[] arr2 = {2, 1, 2, 3, 2, 4, 2, 5};
    // 10
    int[] arr3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    public int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] sol = new int[3];
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == arr1[i % arr1.length])
                sol[0] += 1;
            if(answers[i] == arr2[i % arr2.length])
                sol[1] += 1;
            if(answers[i] == arr3[i % arr3.length])
                sol[2] += 1;
        }
        int max = Arrays.stream(sol).max().getAsInt();
        for(int i = 0; i < sol.length; i++){
            if(max == sol[i]){
                answer.add(i + 1);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}