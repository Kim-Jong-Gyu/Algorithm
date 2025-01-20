import java.io.*;
import java.util.*;

class Main {

	static ArrayList<ArrayList<Integer>> tree;
	static int n;

	static boolean[] visited;
	static int[] parents;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		parents = new int[n + 1];
		tree = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		dfs(1);
		for (int i = 2; i <= n; i++) {
			System.out.println(parents[i]);
		}
	}

	private static void dfs(int now){
		visited[now] = true;
		for(int adj : tree.get(now)){
			if(visited[adj])
				continue;
			parents[adj] = now;
			dfs(adj);
		}
		return;
	}
}