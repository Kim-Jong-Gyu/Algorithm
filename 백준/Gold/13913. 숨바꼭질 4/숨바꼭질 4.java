import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int n, k;

    static int max = 100001;
    static int[] visited = new int[max + 4];

    static int[] prev = new int[max + 4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        ArrayList<Integer> ret = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            if(now == k){
                break;
            }
            for(int next : new int[]{now + 1, now - 1, now * 2}){
                if(0 <= next  && next <= max){
                    if(visited[next] == 0){
                        q.offer(next);
                        prev[next] = now;
                        visited[next] = visited[now] + 1;
                    }
                }
            }
        }
        for(int i = k; i != n; i = prev[i]){
            ret.add(i);
        }
        Collections.reverse(ret);
        System.out.println(visited[k] - 1);
        System.out.print(n + " ");
        for(int i = 0; i < ret.size(); i++){
            System.out.print(ret.get(i) + " ");
        }
    }
}