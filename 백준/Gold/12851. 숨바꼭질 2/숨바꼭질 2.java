import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, k;

    static int max = 200000;

    static int[] visited = new int[max + 4];
    static long[] cnt = new long[max + 4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            System.out.println(1);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;
        cnt[n] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (0 <= next && next <= max) {
                    if (visited[next] == 0) {
                        q.offer(next);
                        visited[next] = visited[now] + 1;
                        cnt[next] += cnt[now];
                    } else if (visited[next] == visited[now] + 1) {
                        cnt[next] += cnt[now];
                    }
                }
            }
        }
        System.out.println(visited[k] - 1);
        System.out.println(cnt[k]);
    }
}