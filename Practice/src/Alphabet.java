import java.util.*;

public class Alphabet {

    static void main() {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            map.put((char) (i + 'a'), 0);
        }

        for(int i = 0; i < str.length(); i++) {
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
        }
        map.forEach((k, v) -> System.out.print(v + " "));
    }

}
