package two;

import java.util.Scanner;
import java.util.StringTokenizer;

public class AppleAddGame {

    static int n, m, j;

    static void main() {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());

        // 바구니 사이즈
        m = Integer.parseInt(st.nextToken());

        // 사과 개수
        j = Integer.parseInt(sc.nextLine());

        // 바구니 위치(범위)
        int[] arr = new int[2];

        arr[0] = 1;
        arr[1] = m;

        int sumMove = 0;
        for (int i = 0; i < j; i++) {
            // Apple 위치
            int apple = Integer.parseInt(sc.nextLine());
            int move = 0;
            if (apple <= arr[1] && apple >= arr[0]) {
                continue;
            } else {
                if (apple < arr[0]) {
                    move = arr[0] - apple;
                    sumMove += move;
                    arr[0] -= move;
                    arr[1] -= move;
                } else {
                    move = apple - arr[1];
                    sumMove += move;
                    arr[0] += move;
                    arr[1] += move;
                }
            }
        }
        System.out.println(sumMove);
    }


}
