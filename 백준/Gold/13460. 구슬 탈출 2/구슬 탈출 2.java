import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int n, m, startRy, startRx, startBy, startBx;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};

	static char[][] mp;
	static boolean[][][][] visited;

	static class Node {
		int redY;
		int redX;

		int blueY;

		int blueX;

		int cnt;
		Node(int redY, int redX, int blueY, int blueX, int cnt) {
			this.redY = redY;
			this.redX = redX;
			this.blueY = blueY;
			this.blueX = blueX;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		mp = new char[n][m];
		visited = new boolean[n][m][n][m];

		// Input Logic
		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 0; j < m; j++) {
				if (s.charAt(j) == 'R') {
					startRy = i;
					startRx = j;
				}
				if (s.charAt(j) == 'B') {
					startBy = i;
					startBx = j;
				}
				mp[i][j] = s.charAt(j);
			}
		}

		// BFS
		System.out.println(bfs(new Node(startRy, startRx, startBy, startBx, 0)));;
	}

	static private int bfs(Node start){
		Queue<Node> q = new LinkedList<>();
		q.offer(start);
		visited[startRy][startRx][startBy][startBx] = true;

		while (!q.isEmpty()) {
			Node now = q.poll();

			if(now.cnt >= 10){
				return -1;
			}

			for (int i = 0; i < 4; i++) {
				// start 값
				int nowRy = now.redY;
				int nowRx = now.redX;
				int nowBy = now.blueY;
				int nowBx = now.blueX;

				boolean redFlag = false;
				boolean blueFlag = false;

				// red
				while (true){
					int nextRy = nowRy + dy[i];
					int nextRx = nowRx + dx[i];

					if(mp[nextRy][nextRx] == '#')
						break;
					if(mp[nextRy][nextRx] == 'O'){
						redFlag = true;
						break;
					}
					nowRy = nextRy;
					nowRx = nextRx;
				}

				// blue
				while (true) {
					int nextBy = nowBy + dy[i];
					int nextBx = nowBx + dx[i];

					if (mp[nextBy][nextBx] == '#')
						break;
					if (mp[nextBy][nextBx] == 'O') {
						blueFlag = true;
						break;
					}
					nowBy = nextBy;
					nowBx = nextBx;
				}

				// 구멍에 들어갔는지 확인
				if(blueFlag)
					continue;
				else if (redFlag) {
					// 정답 출력
					return now.cnt + 1;
				}

				// while 문 이후에 같은 위치일 수도 있기 때문에 따로 처리 .
				if(nowRy == nowBy && nowRx == nowBx){
					// 위 쪽으로 움직인 경우
					if(i == 0){
						if(now.redY < now.blueY)
							nowBy++;
						else
							nowRy++;
					}
					// 오른쪽
					else if(i == 1){
						if(now.redX < now.blueX)
							nowRx--;
						else
							nowBx--;
					}
					// 아래 쪽
					else if(i == 2){
						if(now.redY < now.blueY)
							nowRy--;
						else
							nowBy--;
					}
					// 왼쪽
					else{
						if(now.redX < now.blueX)
							nowBx++;
						else
							nowRx++;
					}
				}
				if(!visited[nowRy][nowRx][nowBy][nowBx]){
					visited[nowRy][nowRx][nowBy][nowBx] = true;
					q.offer(new Node(nowRy, nowRx, nowBy, nowBx, now.cnt + 1));
				}
			}
		}
		return -1;
	}
}