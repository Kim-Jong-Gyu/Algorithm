import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    // 중위순회(inorder)를 레벨화하는 문제

    static ArrayList<Integer>[] adj;
    static int k;

    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        int end = (int)Math.pow(2, k) - 1;
        adj = new ArrayList[k];
        for(int i = 0; i < k; i++){
            adj[i] = new ArrayList<>();
        }
        a = new int[end];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < end; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        go(0, end - 1, 0);
        for(int i = 0; i < k; i++){
            for(int j : adj[i]){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void go(int start, int end, int level) {
        if(start > end)
            return;
        if(start == end){
            adj[level].add(a[start]);
            return;
        }
        int mid = (start + end) / 2;
        adj[level].add(a[mid]);
        go(start, mid - 1, level + 1);
        go(mid + 1, end, level + 1);
    }
}