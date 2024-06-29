import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

}

class Main {

    static int maxN = 300;
    static int[][] visited = new int[maxN + 4][maxN + 4];
    static char[][] mp = new char[maxN + 4][maxN + 4];
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m, x1, y1, x2, y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        y1 = Integer.parseInt(st.nextToken()) - 1;
        x1 = Integer.parseInt(st.nextToken()) - 1;
        y2 = Integer.parseInt(st.nextToken()) - 1;
        x2 = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                mp[i][j] = s.charAt(j);
            }
        }

        Queue<Pair> q = new LinkedList<>();
        visited[y1][x1] = 1;
        q.offer(new Pair(y1, x1));
        int time = 0;
        while (mp[y2][x2] != '0') {
            time++;
            Queue<Pair> tmp = new LinkedList<>();
            while (!q.isEmpty()) {
                Pair here = q.poll();
                for (int j = 0; j < 4; j++) {
                    int ny = here.y + dy[j];
                    int nx = here.x + dx[j];
                    if (ny < 0 || nx < 0 || ny >= n || nx >= m || visited[ny][nx] > 0)
                        continue;
                    visited[ny][nx] = time;
                    if (mp[ny][nx] != '0') {
                        mp[ny][nx] = '0';
                        tmp.offer(new Pair(ny, nx));
                    } else
                        q.offer(new Pair(ny, nx));
                }
            }
            q = tmp;
        }
        System.out.println(visited[y2][x2]);
    }
}

