package one;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Jumong {

    static void main() {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int m = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == m) {
                    result += 1;
                }
            }
        }

        System.out.println(result);

    }

}
