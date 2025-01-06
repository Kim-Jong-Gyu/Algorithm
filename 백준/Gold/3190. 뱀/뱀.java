import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

	static int n, k, l, time;

	static int[][] mp;

	static boolean[][] visited;

	static int dir = 1;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static class Command{

		int duration;
		// D, L
		int direction;

		public Command(int duration, int direction) {
			this.duration = duration;
			this.direction = direction;
		}
	}

	static class Pair{
		int y;
		int x;

		public Pair(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	// 오른쪽은 반시계 방향으로 맵의 위츠를 바꾼다.
	// 왼쪽은 시계 방향으로 맵의 위치를 바꾼다.


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		mp = new int[n][n];
		visited = new boolean[n][n];

		StringTokenizer st;
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int row = Integer.parseInt(st.nextToken());
			int col = Integer.parseInt(st.nextToken());
			mp[--row][--col] = 1;
		}
		l = Integer.parseInt(br.readLine());
		ArrayList<Command> li = new ArrayList<>();
		for (int i = 0; i < l; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String c = st.nextToken();
			if(c.equals("D")){
				// 오른쪽
				li.add(new Command(t, 1));
			}
			else {
				// 왼쪽
				li.add(new Command(t, 3));
			}
		}

		Deque<Pair> dq = new ArrayDeque<>();
		dq.addLast(new Pair(0, 0));

		// 명령어 List를 위한 포인터
		int idx = 0;
		while(!dq.isEmpty()){
			time++;
			Pair now = dq.getFirst();
			int ny = now.y + dy[dir];
			int nx = now.x + dx[dir];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx])
				break;
			if(mp[ny][nx] != 1){
				visited[dq.getLast().y][dq.getLast().x] = false;
				dq.pollLast();
			}
			else{
				mp[ny][nx] = 0;
			}
			visited[ny][nx] = true;
			dq.addFirst(new Pair(ny, nx));
			if(idx < li.size() && time == li.get(idx).duration){
				dir = (dir + li.get(idx).direction) % 4;
				idx++;
			}
		}
		System.out.println(time);
	}
}