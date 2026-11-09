package two;

import java.util.Scanner;

public class ProfessorHyunwoo {

    static void main() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(sc.nextLine());
            int zeros = 0;
            while(input >= 5) {
                input /= 5;
                zeros += input;
            }

            sb.append(zeros).append('\n');
        }
        System.out.print(sb);
    }
}
