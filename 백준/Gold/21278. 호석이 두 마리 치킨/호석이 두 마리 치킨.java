import java.io.*;
import java.util.*;

class Main {

	static ArrayList<Integer>[] tree;
	static int n, m;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		tree = new ArrayList[n + 1];
		int[] result = new int[3];
		result[2] = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			tree[from].add(to);
			tree[to].add(from);
		}

		// 두가리를 선택하는 경우의 수
		for(int i = 1; i <= n; i++){
			for(int j = i + 1; j <= n; j++){
				int tmp = caseDistance(i, j);
				if(result[2] > tmp){
					result[2] = tmp;
					result[0] = i;
					result[1] = j;
				}
				else if(result[2] == tmp){
					if(result[0] > i){
						result[0] = i;
						result[1] = j;
					}
					else if(result[0] == i){
						if(result[1] > j){
							result[1] = j;
						}
					}
				}
			}
		}
		System.out.println(result[0] + " " + result[1] + " " + result[2]);
	}

	private static int caseDistance(int choice1, int choice2) {
		int ret = 0;
		// choice1, choice2 각 지점 별 거리 배열
		int[] distance1 = bfs(choice1);
		int[] distance2 = bfs(choice2);
		for(int i = 1; i <= n; i++){
			ret += Math.min(distance1[i] - 1, distance2[i] - 1);
		}
		return ret * 2;
	}

	private static int[] bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] visited = new int[n + 1];
		q.offer(start);
		visited[start] = 1;
		while(!q.isEmpty()){
			int now = q.poll();
			for (int next : tree[now]) {
				if(visited[next] != 0)
					continue;
				visited[next] = visited[now] + 1;
				q.offer(next);
			}
		}
		return visited;
	}
}