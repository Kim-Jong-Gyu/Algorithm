import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[][] mp;

	static boolean[][] visited;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	static int n, m;

	static int ret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mp = new int[n][m];
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < n; i++){
			for (int j = 0; j < m; j++) {
				dfs(0, i, j, mp[i][j]);
				woo(i, j);
			}
		}

		System.out.println(ret);
	}

	// " ㅜ ", " ㅏ ", " ㅗ ", " ㅓ "
	public static void woo(int y, int x){
		if(x + 1 < m && x - 1 >= 0 && y + 1 < n){
			int tmp = mp[y][x] + mp[y][x - 1] + mp[y][x + 1] + mp[y + 1][x];
			ret = Math.max(ret, tmp);
		}
		if(y - 1 >= 0 && x + 1 < m && y + 1 < n){
			int tmp = mp[y][x] + mp[y - 1][x] + mp[y][x + 1] + mp[y + 1][x];
			ret = Math.max(ret, tmp);
		}
		if(y - 1 >= 0 && x - 1 >= 0 && x + 1 < m){
			int tmp = mp[y][x] + mp[y - 1][x] + mp[y][x + 1] + mp[y][x - 1];
			ret = Math.max(ret, tmp);
		}

		if(y - 1 >= 0 && y + 1 < n && x - 1 >= 0){
			int tmp = mp[y][x] + mp[y - 1][x] + mp[y + 1][x] + mp[y][x - 1];
			ret = Math.max(ret, tmp);
		}
	}

	public static void dfs(int depth, int y, int x, int result){
		if(depth == 3){
			ret = Math.max(result, ret);
			return;
		}

		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny < 0 || nx < 0 || ny >= n || nx >= m)
				continue;
			if(visited[ny][nx])
				continue;
			visited[y][x] = true;
			dfs(depth + 1, ny, nx, result + mp[ny][nx]);
			visited[y][x] = false;
		}
	}
}