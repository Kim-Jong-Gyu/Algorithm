import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int t, n, m;
	static StringBuilder sb;

	static ArrayList<Integer>[] mp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		// output
		sb = new StringBuilder();

		// edge
		StringTokenizer st;
		// 체크용
		int cnt;

		// 검별해야하는 개수만큼
		for(int i = 0; i < t; i++){

			n = Integer.parseInt(br.readLine());
			m = Integer.parseInt(br.readLine());
			mp = new ArrayList[n + 1];
			cnt = 0;
			visited = new boolean[n + 1];

			// initialized
			for(int j = 1; j <= n; j++){
				mp[j] = new ArrayList<>();
			}

			for(int j = 0; j < m; j++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				mp[a].add(b);
				mp[b].add(a);
			}
			for(int j = 1; j <= n; j++){
				if(!visited[j]){
					dfs(j, visited, mp);
					cnt++;
				}
			}
			if(cnt == 1 && m == n - 1)
				sb.append("tree").append("\n");
			else
				sb.append("graph").append("\n");
		}

		System.out.println(sb);
	}

	private static void dfs(int here, boolean[] visited, ArrayList<Integer>[] mp) {
		visited[here] = true;
		for(int there : mp[here]){
			if(!visited[there])
				dfs(there, visited, mp);
		}
		return;
	}
}