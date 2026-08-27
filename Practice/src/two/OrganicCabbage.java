package two;

import java.util.Scanner;
import java.util.StringTokenizer;

public class OrganicCabbage {


    static boolean[][] visited;
    static int[][] mat;

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static int tc, n, m, k;


    static void main() {

        Scanner sc = new Scanner(System.in);

        tc = Integer.parseInt(sc.nextLine());

        // Result
        int[] ret = new int[tc];

        // Test case
        for (int i = 0; i < tc; i++) {

            StringTokenizer st = new StringTokenizer(sc.nextLine());

            // 필요 개수
            int cnt = 0;

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            mat = new int[n + 3][m + 3];

            visited = new boolean[n + 3][m + 3];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(sc.nextLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                mat[y][x] = 1;
            }

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (mat[j][l] == 1 && !visited[j][l]) {
                        cnt++;
                        dfs(j, l);
                    }
                }
            }
            ret[i] = cnt;
        }
        for (int result : ret) {
            System.out.println(result);
        }

    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
                continue;
            }
            if (visited[ny][nx] || mat[ny][nx] == 0) {
                continue;
            }
            dfs(ny, nx);
        }
    }
}
