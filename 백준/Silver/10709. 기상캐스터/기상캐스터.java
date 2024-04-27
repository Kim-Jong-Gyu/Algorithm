import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static char[][] mp;
    static int[][] ret;

    static int h, w;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());
        mp = new char[h][w];
        ret = new int[h][w];
        //Return Value -1 로 초기 세팅
        for (int i = 0; i < h; i++) {
            Arrays.fill(ret[i], -1);
        }

        // input value
        String s;
        for (int i = 0; i < h; i++) {
            s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                mp[i][j] = s.charAt(j);
                if (s.charAt(j) == 'c') {
                    ret[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (mp[i][j] == 'c') {
                    go(i, j);
                }
            }
        }
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print(ret[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void go(int y, int x) {
        int nx = x + 1;
        if (nx >= w)
            return;
        if (mp[y][nx] == 'c')
            return;
        ret[y][nx] = ret[y][x] + 1;
        go(y, nx);
    }
}