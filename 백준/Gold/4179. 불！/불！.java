import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int r, c, ret;
    static char[][] mp;
    static int[][] visitedFire;

    static int[][] visitedJihoon;

    static Pair jihoon;

    static int INF = 987654321;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        mp = new char[r][c];
        visitedFire = new int[r][c];
        visitedJihoon = new int[r][c];
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                mp[i][j] = s.charAt(j);
                visitedFire[i][j] = INF;
                if (mp[i][j] == 'J') {
                    jihoon = new Pair(i, j);
                }
                else if (mp[i][j] == 'F') {
                    visitedFire[i][j] = 1;
                    q.offer(new Pair(i,j));
                }
            }
        }
        // fire
        while(!q.isEmpty()){
            Pair p = q.poll();
            for(int i = 0; i < 4; i++){
                int ny = p.getY() + dy[i];
                int nx = p.getX() + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c)
                    continue;
                if(mp[ny][nx] == '#' || visitedFire[ny][nx] != INF)
                    continue;
                visitedFire[ny][nx] = visitedFire[p.getY()][p.getX()] + 1;
                q.offer(new Pair(ny, nx));
            }
        }
        //Jihoon
        visitedJihoon[jihoon.getY()][jihoon.getX()] = 1;
        q.offer(jihoon);
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.getX() == c - 1 || p.getY() == r - 1 || p.getX() == 0 || p.getY() == 0){
                ret = visitedJihoon[p.getY()][p.getX()];
                break;
            }
            for(int i = 0; i < 4; i++){
                int ny = p.getY() + dy[i];
                int nx = p.getX() + dx[i];
                if(ny < 0 || nx < 0 || ny >= r || nx >= c)
                    continue;
                if(mp[ny][nx] == '#' || visitedJihoon[ny][nx] != 0)
                    continue;
                if(visitedFire[ny][nx] <= visitedJihoon[p.getY()][p.getX()] + 1)
                    continue;
                visitedJihoon[ny][nx] = visitedJihoon[p.getY()][p.getX()] + 1;
                q.offer(new Pair(ny, nx));
            }
        }
        if(ret != 0)
            System.out.println(ret);
        else
            System.out.println("IMPOSSIBLE");
    }
}

class Pair {

    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}