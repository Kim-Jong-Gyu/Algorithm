import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][] mp;
    static int[][] visited;

    static int[] dy = {-1, 0 ,1, 0};
    static int[] dx = {0, 1, 0, -1};

    static ArrayList<Pair> wallList;
    static ArrayList<Pair> virusList;

    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        wallList = new ArrayList<>();
        virusList = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        mp = new int[n + 5][m + 5];
        visited = new int[n + 5][m + 5];
        int ret = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                mp[i][j] = Integer.parseInt(st.nextToken());
                if(mp[i][j] == 0){
                    wallList.add(new Pair(i,j));
                }
                if(mp[i][j] == 2){
                    virusList.add(new Pair(i,j));
                }
            }
        }
        for(int i = 0; i < wallList.size(); i++){
            for(int j = i + 1; j < wallList.size(); j++){
                for(int k = j + 1; k < wallList.size(); k++){
                    Pair wall1 = wallList.get(i);
                    Pair wall2 = wallList.get(j);
                    Pair wall3 = wallList.get(k);
                    mp[wall1.getY()][wall1.getX()] = 1;
                    mp[wall2.getY()][wall2.getX()] = 1;
                    mp[wall3.getY()][wall3.getX()] = 1;
                    ret = Math.max(ret, solve());
                    mp[wall1.getY()][wall1.getX()] = 0;
                    mp[wall2.getY()][wall2.getX()] = 0;
                    mp[wall3.getY()][wall3.getX()] = 0;
                }
            }
        }
        System.out.println(ret);
    }

    private static int solve(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                visited[i][j] = 0;
            }
        }
        for(Pair p : virusList){
            dfs(p.getY(), p.getX());
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(mp[i][j] == 0 && visited[i][j] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    private static void dfs(int y,int x){
        visited[y][x] = 1;
        for(int i = 0; i< 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if(visited[ny][nx] == 1 || mp[ny][nx] == 1){
                continue;
            }
            dfs(ny,nx);
        }
    }
}

class Pair{
    int y,x;

    public Pair(int y, int x){
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

}