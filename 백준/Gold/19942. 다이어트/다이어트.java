import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int mp, mf, ms, mv, n;

    static int ret = 99999999;

    static HashMap<Integer, PriorityQueue<String>> retMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        mp = Integer.parseInt(st.nextToken());
        mf = Integer.parseInt(st.nextToken());
        ms = Integer.parseInt(st.nextToken());
        mv = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][5];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < (1 << n); i++){
            int p = 0, f = 0, s = 0, v = 0, sum = 0;
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if((i & (1 << j)) != 0) {
                    sb.append(j + 1).append(" ");
                    p += a[j][0];
                    f += a[j][1];
                    s += a[j][2];
                    v += a[j][3];
                    sum += a[j][4];
                }
            }
            if(p >= mp && f >= mf && s >= ms && v >= mv){
                if(ret >= sum){
                    ret = sum;
                    if(!retMap.containsKey(ret)){
                        PriorityQueue<String> pq = new PriorityQueue<>();
                        pq.offer(sb.toString());
                        retMap.put(ret , pq);
                    }
                    else {
                        retMap.get(ret).offer(sb.toString());
                    }
                }
            }
        }
        if(ret == 99999999)
            System.out.println(-1);
        else {
            System.out.println(ret);
            System.out.print(retMap.get(ret).poll());
        }
    }
}