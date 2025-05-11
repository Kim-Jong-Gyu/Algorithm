import java.io.*;
import java.util.StringTokenizer;


public class Main {

    static int h;
    static int m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (m < 45) {
            if(h == 0){
                h = 23;
            }
            else {
                h -= 1;
            }
            m += 15;
        }
        else {
            m -= 45;
        }
        System.out.println(h + " " + m);
    }
}