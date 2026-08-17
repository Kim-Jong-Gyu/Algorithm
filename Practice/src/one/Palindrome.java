package one;

import java.util.Scanner;

public class Palindrome {

    static void main() {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int size = s.length();
        System.out.println(simulation(size, s));
    }

    static int simulation(int size, String s) {

        // 짝수
        if (size % 2 == 0) {
            int mid = size / 2;
            for (int i = 0; i < mid; i++) {
                if (s.charAt(i) != s.charAt(size - i - 1)) {
                    return 0;
                }
            }
        }
        // 홀수
        else {
            int mid = (size / 2) + 1;
            for (int i = 0; i < mid; i++) {
                if (s.charAt(i) != s.charAt(size - i - 1)) {
                    return 0;
                }
            }
        }
        return 1;
    }

}
