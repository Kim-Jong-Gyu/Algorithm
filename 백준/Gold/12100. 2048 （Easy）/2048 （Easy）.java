import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static class Board{

		int[][] mp = new int[24][24];

		public Board(int n){
			this.mp = new int[n][n];
		}

		public Board(Board board){
			this.mp = new int[board.mp.length][board.mp[0].length];
			this.copyArr(board.mp);
		}

		// 반 시계 방향 90도 회전
		public void rotate90(){
			int[][] tmp = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					tmp[i][j] = mp[n - j - 1][i];
				}
			}
			copyArr(tmp);
		}

		// 움직였을때 함수
		public void move(){
			int[][] tmp = new int[n][n];
			for(int i = 0; i < n; i++){
				int now = -1;
				// 음수 Index로 인해서 체크
				boolean flag = false;

				for (int j = 0; j < n; j++) {
					if(mp[i][j] == 0)
						continue;
					if(flag && tmp[i][now] == mp[i][j]){
						tmp[i][now] *= 2;
						flag = false;
					}
					else {
						tmp[i][++now] = mp[i][j];
						flag = true;
					}
				}
			}
			copyArr(tmp);
		}

		private void copyArr(int[][] arr) {
			for (int i = 0; i < n; i++) {
				System.arraycopy(arr[i], 0, this.mp[i], 0, n);
			}
		}

		public void count(){
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					ret = Math.max(mp[i][j], ret);
				}
			}
		}
	}

	static int n, ret;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Board board = new Board(n);
		// 초기 세팅
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				board.mp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		solve(board, 0);
		System.out.println(ret);
	}

	private static void solve(Board board, int cnt) {
		if(cnt == 5){
			board.count();
			return;
		}
		for(int i = 0; i < 4; i++){
			Board b = new Board(board);
			b.move();
			solve(b, cnt + 1);
			board.rotate90();
		}
	}
}