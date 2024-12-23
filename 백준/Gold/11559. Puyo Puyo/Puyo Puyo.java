import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	static char[][] mp = new char[12][6];
	static boolean[][] visited;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static ArrayList<Pair> result;

	static class Pair {
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 12; i++) {
			String input = br.readLine();
			for (int j = 0; j < 6; j++) {
				mp[i][j] = input.charAt(j);
			}
		}
		int cnt = 0;
		Queue<Pair> q = new LinkedList<>();
		while (true) {
			boolean isEnd = true;
			visited = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (mp[i][j] != '.') {
						result = bfs(i, j, mp[i][j]);
						if (result.size() >= 4) {
							isEnd = false;
							for(int k = 0; k < result.size(); k++){
								mp[result.get(k).y][result.get(k).x] = '.';
							}
						}
					}
				}
			}
			if(isEnd)
				break;
			fall();
			cnt += 1;
		}
		System.out.println(cnt);
	}

	private static void fall() {
		// 밑에서부터 탐색
		for(int i = 11; i >= 0; i--){
			for(int j = 0; j < 6; j++){
				if(mp[i][j] == '.'){
					for(int k = i - 1; k >= 0; k--){
						if(mp[k][j] != '.'){
							mp[i][j] = mp[k][j];
							mp[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}

	private static ArrayList<Pair> bfs(int y, int x, char color) {
		Queue<Pair> q = new LinkedList<>();
		ArrayList<Pair> li = new ArrayList<>();
		q.offer(new Pair(y, x));
		li.add(new Pair(y, x));
		visited[y][x] = true;
		while (!q.isEmpty()) {
			Pair now = q.poll();
			for (int i = 0; i < 4; i++) {
				int ny = now.y + dy[i];
				int nx = now.x + dx[i];
				if (ny < 0 || nx < 0 || ny >= 12 || nx >= 6)
					continue;
				if (visited[ny][nx] || mp[ny][nx] != color)
					continue;
				visited[ny][nx] = true;
				q.offer(new Pair(ny, nx));
				li.add(new Pair(ny, nx));
			}
		}
		return li;
	}
}
