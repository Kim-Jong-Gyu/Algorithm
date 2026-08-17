package one;

import java.util.Scanner;
import java.util.Stack;

public class GoodWord {

    static void main() {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String[] arr = new String[n + 1];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            Stack<Character> stk = new Stack<>();

            for (char c : arr[i].toCharArray()) {
                if (!stk.isEmpty() && stk.peek() == c) {
                    stk.pop();
                } else {
                    stk.push(c);
                }
            }
            if (stk.isEmpty()) {
                answer++;
            }
        }
        System.out.println(answer);
    }

}
