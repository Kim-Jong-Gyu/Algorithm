import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

	static int n, m, r;

	static ArrayList<ArrayList<Integer>> li;
	static boolean[] visited;

	static int[] ret;

	static int order = 1;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		li = new ArrayList<>();
		visited = new boolean[n + 1];
		ret = new int[n + 1];
		// 정점의 수만큼 배열을 생성
		for (int i = 0; i <= n; i++) {
			li.add(new ArrayList<>());
		}

		// 간선 입력
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			// 양방향 간선
			li.get(u).add(v);
			li.get(v).add(u);
		}
		// 오름차순 정렬
		for (int i = 0; i <= n; i++) {
			Collections.sort(li.get(i));
		}

		// DFS
		dfs(r);
		for (int i = 1; i <= n; i++) {
			System.out.println(ret[i]);
		}

	}

	private static void dfs(int now) {
		visited[now] = true;
		ret[now] = order++;
		for (int adj : li.get(now)) {
			if(visited[adj])
				continue;
			dfs(adj);
		}
	}
}