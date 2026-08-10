import java.util.Scanner;
import java.util.StringTokenizer;

public class Sequence {

    static void main() {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(sc.nextLine());

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }

        // 처음 K개의 합
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += temp[i];
        }

        int max = sum;

        // 한 칸씩 이동
        for (int i = k; i < n; i++) {
            sum += temp[i];
            sum -= temp[i - k];

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}