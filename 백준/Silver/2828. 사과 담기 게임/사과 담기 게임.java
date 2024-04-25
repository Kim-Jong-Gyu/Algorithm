import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    static int n, m, j;

    static Queue<Integer> q = new LinkedList<>();

    static ArrayList<Integer> arr = new ArrayList<>();

    private static void sub() {
        for(int i = 0; i < arr.size(); i++){
            arr.set(i, arr.get(i) -1);
        }
    }

    private static void add() {
        for(int i = 0; i < arr.size(); i++){
            arr.set(i, arr.get(i) + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        j = Integer.parseInt(br.readLine());
        int ret = 0;
        int cnt = 0;
        for (int i = 0; i < j; i++) {
            int loc = Integer.parseInt(br.readLine());
            q.add(loc);
        }

        for (int i = 1; i <= m; i++) {
            arr.add(i);
        }

        while(!q.isEmpty()) {
            int pos = q.peek();
            if(arr.contains(pos)){
                q.poll();
                ret += cnt;
                cnt = 0;
            }
            else {
                if(pos < arr.get(0)){
                    sub();
                    cnt++;
                }
                if(pos > arr.get(arr.size() - 1)) {
                    add();
                    cnt++;
                }
            }
        }

        System.out.println(ret);
    }
}