import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int n = 0;
    static int[][] mp;
    static int[][] visited;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    private static void dfs(int y, int x, int height) {
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            if(mp[ny][nx] <= height || visited[ny][nx] != 0)
                continue;
            dfs(ny, nx, height);
        }
    }

    private static void resetVisited() {
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        mp = new int[n][n];
        visited = new int[n][n];
        int answer = 0;
        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, mp[i][j]);
            }
        }

        for(int i = 0; i <= maxHeight; i++){
            int count = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++){
                    if(visited[j][k] == 0 && mp[j][k] > i){
                        dfs(j, k, i);
                        count++;
                    }
                }
            }
            answer = Math.max(count, answer);
            resetVisited();
        }
        System.out.println(answer);
    }

}