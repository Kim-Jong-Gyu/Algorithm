import java.util.*;
import java.io.*;


class Main{

	static char[][] mp1;

	static char[][] mp2;


	static int n;

	static int[] dy = {-1, 0, 1, 0};

	static int[] dx = {0, 1, 0, -1};

	static boolean[][] visited1;

	static boolean[][] visited2;
	static int ret1;

	static int ret2;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		mp1 = new char[n][n];
		mp2 = new char[n][n];

		visited1 = new boolean[n][n];
		visited2 = new boolean[n][n];

		for(int i = 0; i < n; i++){
			String str = br.readLine();
			for(int j = 0; j < n; j++){
				mp1[i][j] = str.charAt(j);
				if(mp1[i][j] == 'G')
					mp2[i][j] = 'R';
				else
					mp2[i][j] = mp1[i][j];
			}
		}

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(!visited1[i][j]){
					dfs(i, j, mp1, visited1);
					ret1 += 1;
				}
				if(!visited2[i][j]){
					dfs(i, j, mp2, visited2);
					ret2 += 1;
				}
			}
		}
		System.out.println(ret1 + " " + ret2);
	}

	// 빨간색과 초록색은 같은걸로 생각
	private static void dfs(int y, int x, char[][] mp, boolean[][] visited){
		visited[y][x] = true;
		for(int i = 0; i < 4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(ny < 0 || nx < 0 || ny >= n || nx >= n)
				continue;
			if(visited[ny][nx])
				continue;
			if(mp[ny][nx] != mp[y][x])
				continue;
			dfs(ny, nx, mp, visited);
		}
	}

}