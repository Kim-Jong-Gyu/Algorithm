import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

class Main {

	static int n, m, k;

	static char[][] mp;
	static boolean[][] visited;

	static int[] dy = {-1, 0, 1, 0};

	static int[] dx = {0, 1, 0, -1};

	static int cnt;
	static int ret;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		mp = new char[n][m];
		visited = new boolean[n][m];

		for(int i = 0; i < k; i++){
			st = new StringTokenizer(br.readLine());
			mp[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = '#';
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visited[i][j] && mp[i][j] == '#') {
					cnt = 0;
					dfs(i, j);
					ret = Math.max(ret, cnt);
				}
			}
		}
		System.out.println(ret);
	}

	private static void dfs(int y, int x){
		visited[y][x] = true;
		cnt++;
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if(mp[ny][nx] != '#' || visited[ny][nx])
				continue;
			dfs(ny,nx);
		}
	}
}