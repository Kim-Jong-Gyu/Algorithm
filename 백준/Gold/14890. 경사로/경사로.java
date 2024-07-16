import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    static int n, l, ret;

    static int[][] a;

    // 대칭
    static int[][] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        b = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                b[j][i] = a[i][j];
            }
        }
        solve(a);
        solve(b);
        System.out.println(ret);
    }

    private static void solve(int[][] a) {
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int j = 0;
            for (j = 0; j < n - 1; j++) {
                if (a[i][j] == a[i][j + 1])
                    cnt++;
                else if (a[i][j + 1] == a[i][j] + 1 && cnt >= l)
                    cnt = 1;
                else if (a[i][j + 1] == a[i][j] - 1 && cnt >= 0)
                    cnt = -l + 1;
                else
                    break;
            }
            if(j == n - 1 && cnt >= 0) ret++;
        }
    }
}