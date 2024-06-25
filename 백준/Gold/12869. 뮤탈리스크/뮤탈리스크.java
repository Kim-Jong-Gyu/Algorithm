import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    public static class Triple {
        int a, b, c;

        Triple(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }

        public int getC() {
            return c;
        }
    }

    static int[][] attack = {
            {9, 3, 1},
            {9, 1, 3},
            {3, 9, 1},
            {3, 1, 9},
            {1, 9, 3},
            {1, 3, 9}
    };

    static int[][][] visited;

    static int[] scv;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        scv = new int[3];
        visited = new int[64][64][64];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Triple> q = new LinkedList<>();
        q.offer(new Triple(scv[0], scv[1], scv[2]));
        visited[scv[0]][scv[1]][scv[2]] = 1;
        while (!q.isEmpty()){
            Triple el = q.poll();
            int a = el.getA();
            int b = el.getB();
            int c = el.getC();
            if(visited[0][0][0] > 0)
                break;
            for(int i = 0; i < attack.length; i++){
                int na = Math.max(0, a - attack[i][0]);
                int nb = Math.max(0, b - attack[i][1]);
                int nc = Math.max(0, c - attack[i][2]);
                if(visited[na][nb][nc] > 0)
                    continue;
                q.offer(new Triple(na, nb, nc));
                visited[na][nb][nc] = visited[a][b][c] + 1;
            }
        }
        System.out.println(visited[0][0][0] - 1);
    }

}