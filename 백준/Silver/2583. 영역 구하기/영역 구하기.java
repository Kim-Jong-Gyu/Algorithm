import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[][] visited;
    static int[][] mp;

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m, k, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        mp = new int[n][m];
        visited = new int[n][m];
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            for(int j = startY; j < endY; j++){
                for(int k = startX; k < endX; k++) {
                    mp[j][k] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(mp[i][j] == 0 && visited[i][j] == 0){
                    dfs(i,j);
                    arr.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(arr);
        System.out.println(arr.size());
        for(int i = 0; i< arr.size(); i++){
            System.out.print(arr.get(i) + " ");
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = 1;
        count++;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(visited[ny][nx] != 0 || mp[ny][nx] != 0)
                continue;
            dfs(ny, nx);
        }
    }
}