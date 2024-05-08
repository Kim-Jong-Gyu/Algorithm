import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
    static ArrayList<Integer>[] nodeList;
    static int n, root, deleteN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeList = new ArrayList[54];
        for(int i = 0; i < 54; i++){
            nodeList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(parent == -1)
                root = i;
            else {
                nodeList[parent].add(i);
            }
        }
        deleteN = Integer.parseInt(br.readLine());
        if(deleteN == root)
            System.out.println(0);
        else {
            System.out.println(dfs(root));
        }
    }

    private static int dfs(int start) {
        int ret = 0;
        int child = 0;
        for(int adj : nodeList[start]){
            if(adj == deleteN) continue;
            ret += dfs(adj);
            child++;
        }
        if(child == 0)
            return 1;
        return ret;
    }
}