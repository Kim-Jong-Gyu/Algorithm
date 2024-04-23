import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static class Pair {
        int y, x;

        Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] mp = new int[n][m];
        int[][] visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                mp[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<Pair> q = new LinkedList<>();
        // bfs
        visited[0][0] = 1;
        q.add(new Pair(0, 0));
        while (!q.isEmpty()) {
            Pair front = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = front.getY() + dy[i];
                int nx = front.getX() + dx[i];
                if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if(visited[ny][nx] != 0 || mp[ny][nx] == 0)
                    continue;
                visited[ny][nx] = visited[front.getY()][front.getX()] + 1;
                q.offer(new Pair(ny, nx));
            }
        }
        System.out.println(visited[n - 1][m - 1]);;
    }
}