import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static int[][] mp = new int[105][105];
    static int[][] visited = new int[105][105];

    static int[][] edge = new int[105][105];
    static int n, m;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int time = 0;
        Queue<Pair> q = new LinkedList<>();
        while (true) {
            reset();
            visited[0][0] = 1;
            q.offer(new Pair(0, 0));
            while (!q.isEmpty()) {
                Pair p = q.poll();
                for (int i = 0; i < 4; i++) {
                    int ny = p.getY() + dy[i];
                    int nx = p.getX() + dx[i];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                        continue;
                    if (mp[ny][nx] == 1 && visited[ny][nx] == 0)
                        edge[ny][nx] = 1;
                    if (mp[ny][nx] == 1 || visited[ny][nx] == 1)
                        continue;
                    visited[ny][nx] = 1;
                    q.offer(new Pair(ny, nx));
                }
            }
            time++;
            if (solve() != 0) {
                System.out.println(time);
                System.out.println(solve());
                break;
            } else {
                deleteEdge();
            }
        }
    }

    private static void deleteEdge() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (edge[i][j] == 1)
                    mp[i][j] = 0;
            }
        }
    }

    private static int solve() {
        int cnt = 0;
        int cmp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mp[i][j] == 1) {
                    cnt++;
                }
                if (mp[i][j] == 1 && edge[i][j] == 1)
                    cmp++;
            }
        }
        if (cnt == cmp) {
            return cmp;
        }
        return 0;
    }

    private static void reset() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
                edge[i][j] = 0;
            }
        }
    }
}

class Pair {

    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
}