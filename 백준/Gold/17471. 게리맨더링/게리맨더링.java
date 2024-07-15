import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// Connected Component

// 1. 모든 경우의 수를 확인 -> 2개로 색칠한다
// 2. 두개로 나눠진 것 중에서 최소값 구한다

class Main {

    static ArrayList<Integer>[] city;
    static int[] numOfCity;
    static int[] visited;
    static int[] comp;

    static int n;
    static int ret = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfCity = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            numOfCity[i] = Integer.parseInt(st.nextToken());
        }
        city = new ArrayList[n + 1];
        visited = new int[n + 1];
        comp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            city[i] = new ArrayList<>();
        }
        // 양방향 간선 : ~ 에서 부터 ~까지라는 말이 없기 때문에
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            for (int j = 0; j < tmp; j++) {
                int edge = Integer.parseInt(st.nextToken());
                city[i].add(edge);
                city[edge].add(i);
            }
        }
        for (int i = 1; i < (1 << n) - 1; i++) {
            Arrays.fill(comp, 0);
            Arrays.fill(visited, 0);
            int idx = -1, idx2 = -1;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    comp[j + 1] = 1;
                    idx = j + 1;
                } else
                    idx2 = j + 1;
            }
            Pair comp1 = dfs(idx, 1);
            Pair comp2 = dfs(idx2, 0);
            if (comp1.y + comp2.y == n) {
                ret = Math.min(ret, Math.abs(comp1.x - comp2.x));
            }
        }
        System.out.println((ret == Integer.MAX_VALUE ? -1 : ret));
    }

    private static Pair dfs(int here, int value) {
        visited[here] = 1;
        Pair ret = new Pair(1, numOfCity[here]);
        for (int there : city[here]) {
            if (comp[there] != value) continue;
            if (visited[there] == 1) continue;
            Pair tmp = dfs(there, value);
            ret.y += tmp.y;
            ret.x += tmp.x;
        }
        return ret;
    }
}

class Pair {
    int y, x;

    public Pair(int y, int x) {
        this.y = y;
        this.x = x;
    }
}