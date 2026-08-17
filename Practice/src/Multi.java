import java.util.Scanner;
import java.util.StringTokenizer;

public class Multi {

    static long a;
    static long c;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(b));
    }

    static long pow(long b) {

        if (b == 1) {
            return a % c;
        }

        long half = pow(b / 2);

        long result = (half * half) % c;

        if (b % 2 == 1) {
            result = (result * a) % c;
        }

        return result;
    }
}
