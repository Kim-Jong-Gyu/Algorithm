import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][] mp = new int[54][54];
    static int[][] visited = new int[54][54];

    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int n, m, k;

    private static void dfs(int y, int x){
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(visited[ny][nx] == 1 || mp[ny][nx] == 0)
                continue;
            dfs(ny,nx);
        }
    }

    private static void reset(){
        for(int i = 0; i < n; i++){
            Arrays.fill(mp[i], 0);
            Arrays.fill(visited[i], 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 밭의 개수
        int t = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr  = new ArrayList<>();
        for(int i = 0; i < t; i++) {
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int locY = Integer.parseInt(st.nextToken());
                int locX = Integer.parseInt(st.nextToken());
                mp[locY][locX] = 1;
            }
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (mp[j][l] == 1 && visited[j][l] == 0) {
                        dfs(j, l);
                        count++;
                    }
                }
            }
            reset();
            arr.add(count);
        }

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}