package two;

import java.util.Scanner;
import java.util.StringTokenizer;

public class SafeArea {

    static int[][] mat;

    static boolean[][] visited;

    static int[] dy = {-1, 0, 1, 0};

    static int[] dx = {0, 1, 0, -1};

    static int n;

    static void main() {

        Scanner sc = new Scanner(System.in);

        int max = Integer.MIN_VALUE;

        int ret = 1;

        n = Integer.parseInt(sc.nextLine());
        mat = new int[n + 4][n + 4];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            for(int j = 0; j < n; j++){
                mat[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, mat[i][j]);
            }
        }

        // 최대값 까지
        for(int i = 1; i <= max; i++){
            visited = new boolean[n + 4][n + 4];
            int cnt = 0;
            for(int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    if(!visited[j][k] && mat[j][k] > i) {
                        dfs(j, k, i);
                        cnt++;
                    }
                }
            }
            ret = Math.max(ret, cnt);
        }

        System.out.println(ret);
    }

    static void dfs(int y, int x, int depth) {
        visited[y][x] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            if(visited[ny][nx])
                continue;
            if(mat[ny][nx] <= depth)
                continue;
            dfs(ny, nx, depth);
        }
    }

}
