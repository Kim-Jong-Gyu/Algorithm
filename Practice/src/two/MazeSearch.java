package two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MazeSearch {

    static int n, m;

    static int[] dy = {-1, 0, 1, 0};

    static int[] dx = {0, 1, 0, -1};

    static int count = Integer.MAX_VALUE;

    static void main() {
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

//        dfs(0, 0, 1, visited, matrix);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1});

        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int y = now[0];
            int x = now[1];
            int depth = now[2];

            if (y == n - 1 && x == m - 1) {
                count = Math.min(count, depth);
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || ny >= n || nx >= m) {
                    continue;
                }
                if (matrix[ny][nx] == 0) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx, depth + 1});
            }
        }

        System.out.println(count);
    }


    static void dfs(int y, int x, int depth, boolean[][] visited, int[][] matrix) {

        if (y == n - 1 && x == m - 1) {
            count = Math.min(count, depth);
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (matrix[ny][nx] == 0) {
                continue;
            }
            if (visited[ny][nx]) {
                continue;
            }
            visited[ny][nx] = true;
            dfs(ny, nx, depth + 1, visited, matrix);
            visited[ny][nx] = false;
        }
    }

}
