import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static char[][] mp;

    static int[][] visited;
    static int n, m, ret;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mp = new char[n][m];
        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                mp[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mp[i][j] == 'L') {
                    visited[i][j] = 1;
                    bfs(i, j);
                }
                ret = Math.max(check(), ret);
                resetVisited();
            }
        }
        System.out.println(ret - 1);
    }

    private static void resetVisited() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
    }

    private static int check() {
        int chk = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chk = Math.max(chk, visited[i][j]);
            }
        }
        return chk;
    }

    private static void bfs(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(y, x));
        while (!q.isEmpty()) {
            Pair p = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = p.getY() + dy[i];
                int nx = p.getX() + dx[i];
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (visited[ny][nx] != 0 || mp[ny][nx] != 'L')
                    continue;
                q.offer(new Pair(ny, nx));
                visited[ny][nx] = visited[p.getY()][p.getX()] + 1;
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