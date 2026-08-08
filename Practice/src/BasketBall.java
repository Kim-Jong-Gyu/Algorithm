import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BasketBall {

    static void main() {

        Scanner sc = new Scanner(System.in);

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int n = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            char first = s.charAt(0);
            map.put(first, map.getOrDefault(first, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= 5) {
                sb.append(entry.getKey());
            }
        }

        if (sb.isEmpty()) {
            System.out.println("PREDAJA");
        }
        else System.out.println(sb);
    }

}
