import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, l, r, sum;
    static int[][] mp;

    static boolean[][] visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static ArrayList<Pair> list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        mp = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                mp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        list = new ArrayList<Pair>();
        int cnt = 0;
        while(true){
            boolean flag = false;
            resetVisited();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        list.clear();
                        visited[i][j] = true;
                        list.add(new Pair(i,j));
                        sum = mp[i][j];
                        dfs(i,j);
                        if(list.size() == 1)
                            continue;
                        for(Pair el : list){
                            mp[el.getY()][el.getX()] = sum / list.size();
                            flag = true;
                        }
                    }
                }
            }
            if(!flag) break;
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(int y, int x) {
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n)
                continue;
            if(visited[ny][nx])
                continue;
            if(Math.abs(mp[ny][nx] - mp[y][x]) >= l && Math.abs(mp[ny][nx] - mp[y][x]) <= r){
                visited[ny][nx] = true;
                list.add(new Pair(ny,nx));
                sum+= mp[ny][nx];
                dfs(ny,nx);
            }
        }
    }

    private static void resetVisited(){
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }
    }
}

class Pair {
    int y, x;
    public Pair(int y, int x) {
        this.y =y;
        this.x =x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}