import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    static boolean[] visited = new boolean[30];
    static char[][] mp;

    static int[] dy = {-1, 0, 1, 0};

    static int[] dx = {0, 1, 0, -1};

    static int r, c;

    static int ret = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        mp = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                mp[i][j] = s.charAt(j);
            }
        }
        visited[(int) mp[0][0] - 'A'] = true;
        go(0, 0, 1);
        System.out.println(ret);
    }

    private static void go(int y, int x, int cnt) {
        ret = Math.max(ret, cnt);
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= r || nx >= c)
                continue;
            int next = (int) (mp[ny][nx] - 'A');
            if (!visited[next]) {
                visited[next] = true;
                go(ny, nx, cnt + 1);
                visited[next] = false;
            }
        }
    }
}