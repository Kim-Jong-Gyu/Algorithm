package one;

import java.util.Scanner;

public class MakePalindrome {

    static void main() {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] count = new int[26];

        // 알파벳 개수 세기
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }

        int oddCount = 0;
        char mid = 0;

        // 홀수 개수인 알파벳 확인
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                oddCount++;
                mid = (char) ('A' + i);
            }
        }

        // 홀수 개수인 알파벳이 2개 이상이면 불가능
        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return;
        }

        StringBuilder left = new StringBuilder();

        // 왼쪽 절반 만들기
        // A부터 시작하니까 자동으로 사전순 최소
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < count[i] / 2; j++) {
                left.append((char) ('A' + i));
            }
        }

        // 오른쪽은 왼쪽의 반대
        String right = new StringBuilder(left).reverse().toString();

        StringBuilder answer = new StringBuilder();

        answer.append(left);

        if (oddCount == 1) {
            answer.append(mid);
        }

        answer.append(right);

        System.out.println(answer);
    }
}