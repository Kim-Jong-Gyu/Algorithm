import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int r, c;

    static int maxN = 1500;
    static int[][] visitedWater;

    static int[][] visitedSwan;
    static char[][] mp;

    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static Queue<Pair> waterQ = new LinkedList<>();
    static Queue<Pair> swanQ = new LinkedList<>();

    static int swanY, swanX, day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        visitedWater = new int[r][c];
        visitedSwan = new int[r][c];
        mp = new char[r][c];


        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                mp[i][j] = s.charAt(j);
                if (mp[i][j] == 'L') {
                    swanY = i;
                    swanX = j;
                }
                if (mp[i][j] == 'L' || mp[i][j] == '.') {
                    visitedWater[i][j] = 1;
                    waterQ.offer(new Pair(i, j));
                }
            }
        }
        visitedSwan[swanY][swanX] = 1;
        swanQ.offer(new Pair(swanY, swanX));
        while (true) {
            if (moveSwan())
                break;
            waterMelting();
            day++;
        }
        System.out.println(day);
    }

    private static void waterMelting() {
        Queue<Pair> tmpWater = new LinkedList<>();
        while (!waterQ.isEmpty()) {
            Pair here = waterQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = here.y + dy[i];
                int nx = here.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visitedWater[ny][nx] > 0) {
                    continue;
                }
                if (mp[ny][nx] == 'X') {
                    mp[ny][nx] = '.';
                    visitedWater[ny][nx] = 1;
                    tmpWater.offer(new Pair(ny, nx));
                }
            }
        }
        waterQ = tmpWater;
    }

    private static boolean moveSwan() {
        Queue<Pair> tmpSwan = new LinkedList<>();
        while (!swanQ.isEmpty()) {
            Pair here = swanQ.poll();
            for (int i = 0; i < 4; i++) {
                int ny = here.y + dy[i];
                int nx = here.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= r || nx >= c || visitedSwan[ny][nx] > 0) {
                    continue;
                }
                visitedSwan[ny][nx] = 1;
                if(mp[ny][nx] == '.')
                    swanQ.offer(new Pair(ny,nx));
                else if(mp[ny][nx] == 'X')
                    tmpSwan.offer(new Pair(ny,nx));
                else if (mp[ny][nx] == 'L') return true;
            }
        }
        swanQ = tmpSwan;
        return false;
    }
}


class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}