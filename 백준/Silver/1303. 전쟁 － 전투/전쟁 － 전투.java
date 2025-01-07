import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n, m;
	static char[][] mp;
	static boolean[][] visited;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static class Pair{
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 가로
		n = Integer.parseInt(st.nextToken());
		// 세로
		m = Integer.parseInt(st.nextToken());
		mp = new char[m][n];
		visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			for (int j = 0; j < n; j++) {
				mp[i][j] = s.charAt(j);
			}
		}



		int[] ret = new int[2];
		//DFS
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visited[i][j]){
					int tmp = bfs(i, j , mp[i][j]);
					if(mp[i][j] == 'W'){
						ret[0] += (int)Math.pow(tmp, 2);
					}
					if(mp[i][j] == 'B'){
						ret[1] += (int)Math.pow(tmp, 2);
					}
				}
			}
		}
		System.out.println(ret[0] + " " + ret[1]);

	}

	private static int bfs(int y, int x, char col) {
		Queue<Pair> q = new LinkedList<>();
		int ret = 1;
		q.offer(new Pair(y, x));
		visited[y][x] = true;
		while(!q.isEmpty()){
			Pair now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= m || nx >= n) {
					continue;
				}
				if(visited[ny][nx] || mp[ny][nx] != col) {
					continue;
				}
				visited[ny][nx] = true;
				q.offer(new Pair(ny, nx));
				ret++;
			}
		}
		return ret;
	}
}