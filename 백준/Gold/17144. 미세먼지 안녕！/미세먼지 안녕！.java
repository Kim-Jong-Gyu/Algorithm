import java.io.*;
import java.util.StringTokenizer;

class Main {

	static int r, c, t;
	static int[][] mp;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static int[] cleaner = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		mp = new int[r][c];

		// 클리너를 위한 변수
		int tmp = 0;
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < c; j++) {
				mp[i][j] = Integer.parseInt(st.nextToken());
				if (mp[i][j] == -1) {
					cleaner[tmp++] = i;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			mp = diffusion();
			clean();
		}
		System.out.println(count());
	}

	private static int count() {
		int ret = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mp[i][j] == -1)
					continue;
				ret += mp[i][j];
			}
		}
		return ret;
	}

	private static void clean() {
		int up = cleaner[0];
		int down = cleaner[1];
		// 반시계 방향
		// 반대로 생각 !!
		for (int i = up - 1; i > 0; i--) {
			mp[i][0] = mp[i - 1][0];
		}
		for (int i = 0; i < c - 1; i++) {
			mp[0][i] = mp[0][i + 1];
		}
		for (int i = 0; i < up; i++) {
			mp[i][c - 1] = mp[i + 1][c - 1];
		}
		for (int i = c - 1; i > 1; i--) {
			mp[up][i] = mp[up][i - 1];
		}
		mp[up][1] = 0;

		// 시계 방향
		for (int i = down + 1; i < r - 1; i++) {
			mp[i][0] = mp[i + 1][0];
		}

		for (int i = 0; i < c - 1; i++) {
			mp[r - 1][i] = mp[r - 1][i + 1];
		}

		for (int i = r - 1; i > down; i--) {
			mp[i][c - 1] = mp[i - 1][c - 1];
		}

		for (int i = c - 1; i > 0; i--) {
			mp[down][i] = mp[down][i - 1];
		}
		mp[down][1] = 0;
	}

	private static int[][] diffusion() {
		int[][] ret = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mp[i][j] == -1) {
					ret[i][j] = -1;
					continue;
				}
				ret[i][j] += mp[i][j];
				for (int k = 0; k < 4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if (ny < 0 || nx < 0 || ny >= r || nx >= c)
						continue;
					if (mp[ny][nx] == -1)
						continue;

					ret[ny][nx] += (mp[i][j] / 5);
					ret[i][j] -= (mp[i][j] / 5);
				}
			}
		}
		return ret;
	}
}