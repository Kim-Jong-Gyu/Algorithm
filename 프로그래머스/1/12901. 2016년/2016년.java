import java.util.*;
class Solution {
public String solution(int a, int b) {
        String answer = "";
        Calendar cal = Calendar.getInstance();
        cal.set(2016, a - 1, b);
        return switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case 1 -> "SUN";
            case 2 -> "MON";
            case 3 -> "TUE";
            case 4 -> "WED";
            case 5 -> "THU";
            case 6 -> "FRI";
            case 7 -> "SAT";
            default -> answer;
        };
    }
}