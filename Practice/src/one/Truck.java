package one;

import java.util.Scanner;

/**
 * 트럭 주차
 *
 */
public class Truck {

    static int min = 999;
    static int max  = -1;

    static void main() {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] arr = new int[101];

        for (int i = 0; i < 3; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            for (int j = start; j < end; j++) {
                arr[j] += 1;
            }
            min = Math.min(min, start);
            max = Math.max(max, end);
        }

        int sum = 0;
        for (int i = min; i <= max; i++) {
            if(arr[i] == 1) {
                sum += a;
            }
            else if(arr[i] == 2) {
                sum += arr[i] * b;
            }
            else {
                sum += arr[i] * c;
            }
        }

        System.out.print(sum);
    }

}
