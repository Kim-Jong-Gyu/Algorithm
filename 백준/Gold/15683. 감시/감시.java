import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static int n, m;

	static int ret = Integer.MAX_VALUE;

	static int[][] office;

	static ArrayList<Pair> cctvArr;

	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		office = new int[n][m];
		cctvArr = new ArrayList<>();
		// 1. 입력
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				office[i][j] = Integer.parseInt(st.nextToken());
				if (office[i][j] != 0 && office[i][j] != 6) {
					cctvArr.add(new Pair(i, j));
				}
			}
		}

		dfs(0);
		System.out.println(ret);
	}

	// 계산
	private static void dfs(int here) {
		if (here == cctvArr.size()) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (office[i][j] == 0)
						cnt++;
				}
			}
			ret = Math.min(ret, cnt);
			return;
		}
		for (int i = 0; i < 4; i++) {
			ArrayList<Pair> change = watching(here, i);
			dfs(here + 1);
			for(Pair p : change){
				office[p.y][p.x] = 0;
			}
		}
	}

	private static ArrayList<Pair> watching(int here, int dir) {
		ArrayList<Pair> change = new ArrayList<>();
		int y = cctvArr.get(here).y;
		int x = cctvArr.get(here).x;
		if (office[y][x] == 1) {
			while (true) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny >= 0 && nx >= 0 && nx < m && ny < n && office[ny][nx] != 6) {
					if (office[ny][nx] == 0) {
						office[ny][nx] = 8;
						change.add(new Pair(ny, nx));
					}
					y = ny;
					x = nx;
				} else {
					break;
				}
			}
		} else if (office[y][x] == 2) {
			for (int i = 0; i <= 2; i += 2) {
				int tmpY = y;
				int tmpX = x;
				while (true) {
					int ny = tmpY + dy[(dir + i) % 4];
					int nx = tmpX + dx[(dir + i) % 4];
					if (ny >= 0 && nx >= 0 && nx < m && ny < n && office[ny][nx] != 6) {
						if (office[ny][nx] == 0) {
							office[ny][nx] = 8;
							change.add(new Pair(ny, nx));
						}
						tmpY = ny;
						tmpX = nx;
					} else {
						break;
					}
				}
			}
		} else if (office[y][x] == 3) {
			for (int i = 0; i < 2; i++) {
				int tmpY = y;
				int tmpX = x;
				while (true) {
					int ny = tmpY + dy[(dir + i) % 4];
					int nx = tmpX + dx[(dir + i) % 4];
					if (ny >= 0 && nx >= 0 && nx < m && ny < n && office[ny][nx] != 6) {
						if (office[ny][nx] == 0) {
							office[ny][nx] = 8;
							change.add(new Pair(ny, nx));
						}
						tmpY = ny;
						tmpX = nx;
					} else {
						break;
					}
				}
			}
		} else if (office[y][x] == 4) {
			for (int i = 0; i < 3; i++) {
				int tmpY = y;
				int tmpX = x;
				while (true) {
					int ny = tmpY + dy[(dir + i) % 4];
					int nx = tmpX + dx[(dir + i) % 4];
					if (ny >= 0 && nx >= 0 && nx < m && ny < n && office[ny][nx] != 6) {
						if (office[ny][nx] == 0) {
							office[ny][nx] = 8;
							change.add(new Pair(ny, nx));
						}
						tmpY = ny;
						tmpX = nx;
					} else {
						break;
					}
				}
			}
		} else if (office[y][x] == 5) {
			for (int i = 0; i < 4; i++) {
				int tmpY = y;
				int tmpX = x;
				while (true) {
					int ny = tmpY + dy[(dir + i) % 4];
					int nx = tmpX + dx[(dir + i) % 4];
					if (ny >= 0 && nx >= 0 && nx < m && ny < n && office[ny][nx] != 6) {
						if (office[ny][nx] == 0) {
							office[ny][nx] = 8;
							change.add(new Pair(ny, nx));
						}
						tmpY = ny;
						tmpX = nx;
					} else {
						break;
					}
				}
			}
		}
		return change;
	}
}