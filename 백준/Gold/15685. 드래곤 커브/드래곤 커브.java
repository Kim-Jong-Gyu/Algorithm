import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

	static int n;

	// 0 : x
	// 1 : y
	// 2 : d (시작방향)
	// 3 : g ( 세대)
	static int[][] input;

	// 방향에 따른 모든 세대별 curve를 구한다.
	static ArrayList<ArrayList<ArrayList<Integer>>> curve;

	static boolean[][] visited = new boolean[102][102];

	static int[] dy = {0, -1, 0, 1};
	static int[] dx = {1, 0, -1, 0};
	static int ret = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new int[n][4];
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
			input[i][2] = Integer.parseInt(st.nextToken());
			input[i][3] = Integer.parseInt(st.nextToken());
		}
		dragonCurve();
		for(int i = 0; i < n; i++){
			draw(input[i][0], input[i][1], input[i][2], input[i][3]);
		}
		for(int i = 0; i <= 100; i++){
			for(int j = 0; j <= 100; j++){
				if(visited[i][j] && visited[i + 1][j] && visited[i + 1][j + 1] && visited[i][j + 1]){
					ret++;
				}
			}
		}
		System.out.println(ret);
	}

	private static void draw(int x, int y, int d, int g){
		visited[y][x] = true;
		for (int i = 0; i <= g; i++) {
			for(int dir : curve.get(d).get(i)){
				x += dx[dir];
				y += dy[dir];
				visited[y][x] = true;
			}
		}
	}

	// 방향에 따른 10세대까지의 방향 전환을 담는 리스트를 구한다.
	private static void dragonCurve(){
		curve = new ArrayList<>();
		for(int i = 0; i < 4; i++){
			curve.add(new ArrayList<>());
			for(int j = 0; j <= 10; j++){
				curve.get(i).add(new ArrayList<>());
			}
		}
		for(int i = 0; i < 4; i++){
			curve.get(i).get(0).add(i);
			curve.get(i).get(1).add((i + 1) % 4);
			// 2세대부터의 방향 전환 -> 이건 패턴을 파악해야한다.
			for(int j = 2; j <= 10; j++){
				int n = curve.get(i).get(j - 1).size();
				for(int k = n - 1; k >= 0; k--){
					curve.get(i).get(j).add((curve.get(i).get(j - 1).get(k) + 1) % 4);
				}
				for(int k = 0; k < n; k++){
					curve.get(i).get(j).add(curve.get(i).get(j - 1).get(k));
				}
			}
		}
	}
}