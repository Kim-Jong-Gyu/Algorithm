import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 경우의 수가 2개
 * 첫 번째는 동생이랑 수빈이가 나란히 움직이면서 만나는 경우
 * 두 번째는 동생이 먼저 도착해서 수빈이가 도착하는 경우 -> 예를 들면 3초에 동생이 10에 있을 때 수빈이는 1초 때에 +1 , -1을 연달아 함으로써 만날 수 있다.
 * Flood Fill 알고리즘을 사용해야 한다. -> 한 turn을 단위로 계산을 하고 싶기 때문에 사용한다.
 **/

class Main {

    static int n, k;

    static int max = 500000;

    // 홀, 짝을 구분해야한다.
    static int[][] visited = new int[2][max + 4];

    static boolean ok;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        visited[0][n] = 1;
        q.offer(n);
        int time = 1;
        while (!q.isEmpty()) {
            k += time;
            if (k > max)
                break;
            if (visited[time % 2][k] > 0) {
                ok = true;
                break;
            }
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int here = q.poll();
                for (int next : new int[]{here + 1, here - 1, here * 2}) {
                    if (next < 0 || next > max || visited[time % 2][next] > 0)
                        continue;
                    visited[time % 2][next] = visited[(time + 1) % 2][here] + 1;
                    if(next == k){
                        ok = true;
                        break;
                    }
                    q.offer(next);
                }
                if(ok) break;
            }
            if(ok) break;
            time++;
        }
        if(ok)
            System.out.println(time);
        else
            System.out.println(-1);
    }
}