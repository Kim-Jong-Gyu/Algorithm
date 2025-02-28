import java.io.*;
import java.util.*;

class Main {

	static int m, n, h;
	static int[][][] box;
	static int[][][] visited;

	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};

	static class Tuple {
		int z;
		int y;
		int x;

		public Tuple(int z, int y, int x) {
			this.z = z;
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		box = new int[h][n][m];
		visited = new int[h][n][m];

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < m; k++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (box[i][j][k] == 1 && visited[i][j][k] == 0) {
						bfs(i, j, k);
					}
				}
			}
		}
		int result = solve();
		System.out.println((result <= 0) ? result : result - 1);
	}

	private static int solve() {
		int ret = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < m; k++) {
					if (visited[i][j][k] == 0 && box[i][j][k] != -1) {
						return -1;
					}
					ret = Math.max(visited[i][j][k], ret);
				}
			}
		}
		return ret;
	}

	private static void bfs(int z, int y, int x) {
		visited[z][y][x] = 1;
		Queue<Tuple> q = new LinkedList<>();
		q.offer(new Tuple(z, y, x));
		while (!q.isEmpty()) {
			Tuple now = q.poll();
			for (int i = 0; i < 6; i++) {
				int nz = now.z + dz[i];
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m)
					continue;
				if (box[nz][ny][nx] != 0)
					continue;
				if (visited[nz][ny][nx] != 0 && visited[nz][ny][nx] <= visited[now.z][now.y][now.x] + 1) {
					continue;
				}
				q.offer(new Tuple(nz, ny, nx));
				visited[nz][ny][nx] = visited[now.z][now.y][now.x] + 1;
			}
		}
	}
}