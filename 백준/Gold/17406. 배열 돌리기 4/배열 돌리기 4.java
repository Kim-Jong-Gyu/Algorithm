import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	static int n, m, k;
	static int[][] mp;

	static Command[] commandArr;

	static boolean[] visited;

	static int[][] simulateMap;

	static int ret = Integer.MAX_VALUE;
	static class Command{
		int r;
		int c;
		int s;

		public Command(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		mp = new int[n][m];
		commandArr = new Command[k];
		visited = new boolean[k];

		// Initial Setting
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			commandArr[i] = new Command(r, c, s);
		}
		dfs(0, new Stack<Integer>());
		System.out.println(ret);
	}

	public static void dfs(int depth, Stack<Integer> stk){
		if(depth == k){
			// 경우의 수에 맞게 회전이 필요
			simulation(stk);
			return;
		}
		for (int i = 0; i < k; i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			stk.add(i);
			dfs(depth + 1, stk);
			stk.pop();
			visited[i] = false;
		}
	}
	public static void simulation(Stack<Integer> stk){
		simulateMap = arrayCopy(mp);
		for(int now : stk){
			Command command = commandArr[now];
			int startRow =  command.r - command.s - 1;
			int endRow = command.r + command.s - 1;
			int startCol = command.c - command.s - 1;
			int endCol = command.c + command.s - 1;
			rotate(startRow, endRow, startCol, endCol);
		}
		countMax();
	}

	public static void rotate(int startRow, int endRow, int startCol, int endCol){
		int[][] tmp = arrayCopy(simulateMap);
		if(startRow == endRow){
			simulateMap[startRow][startCol] = tmp[startRow][startCol];
			return;
		}
		// 첫 번째 ->
		for (int j = endCol; j > startCol; j--) {
			simulateMap[startRow][j] = tmp[startRow][j - 1];
		}
		// 맨 끝에서 아래로 ->
		for (int i = endRow; i > startRow; i--) {
			simulateMap[i][endCol] = tmp[i - 1][endCol];
		}
		for (int j = startCol; j < endCol; j++) {
			simulateMap[endRow][j] = tmp[endRow][j + 1];
		}
		for (int i = startRow; i < endRow; i++) {
			simulateMap[i][startCol] = tmp[i + 1][startCol];
		}
		rotate(startRow + 1, endRow - 1, startCol + 1, endCol - 1);
	}

	private static void countMax() {
		for (int i = 0; i < n; i++) {
			int rowSum = 0;
			for (int j = 0; j < m; j++) {
				rowSum += simulateMap[i][j];
			}
			ret = Math.min(ret, rowSum);
		}
	}

	private static int[][] arrayCopy(int[][] arr){
		int[][] ret = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ret[i][j] = arr[i][j];
			}
		}
		return ret;
	}
}