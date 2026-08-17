import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class One {

    static void main() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;

        while ((str = br.readLine()) != null) {
            int n = Integer.parseInt(str);

            int remainder = 1 % n;
            int count = 1;

            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n;
                count++;
            }

            System.out.println(count);
        }
    }
}
