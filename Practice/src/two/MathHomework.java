package two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MathHomework {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<String> li = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String in = sc.nextLine();

            for (int j = 0; j < in.length(); j++) {
                char ch = in.charAt(j);

                if (isNumber(ch)) {
                    sb.append(ch);
                } else {
                    addNumber(li, sb);
                }
            }

            addNumber(li, sb);
        }

        li.sort((a, b) -> {
            if (a.length() != b.length()) {
                return Integer.compare(a.length(), b.length());
            }
            return a.compareTo(b);
        });

        for (String num : li) {
            System.out.println(num);
        }

        sc.close();
    }

    static void addNumber(List<String> li, StringBuilder sb) {
        if (sb.isEmpty()) {
            return;
        }

        int start = 0;

        // 모두 0이면 마지막 0 하나는 남김
        while (start < sb.length() - 1 && sb.charAt(start) == '0') {
            start++;
        }

        li.add(sb.substring(start));
        sb.setLength(0);
    }

    static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }

}