import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> answer = new ArrayList<>();
        int win = 0;
        int ran = 0;
        int total = win_nums.length;
        for(Integer num : lottos){
            if(Arrays.stream(win_nums).anyMatch(num::equals))
                win++;
            else if(num == 0)
                ran++;
        }
        if (total - (win + ran) + 1 >= 6) {
            answer.add(6);
        } else {
            answer.add(total - (win + ran) + 1);
        }
        if (total - win + 1 >= 6) {
            answer.add(6);
        } else {
            answer.add(total - win + 1);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}