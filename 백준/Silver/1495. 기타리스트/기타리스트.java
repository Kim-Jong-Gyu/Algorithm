import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n, s, m;

	static int[] v;
	static boolean[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = new int[n + 1];
		dp = new boolean[n + 1][m + 1];

		// input
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
		}

		// start
		dp[0][s] = true;

		// 2차원 배열을 활용해서 범위 내 볼륨들을 다 체크한다. 
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				if(dp[i - 1][j]){
					int v1 = j + v[i];
					int v2 = j - v[i];
					if(v1 <= m)
						dp[i][v1] = true;
					if(v2 >= 0)
						dp[i][v2] = true;
				}
			}
		}
		// 마지막 n에서 다 false면 조절할수 없는거, 있으면 순차적으로 도니까 마지막꺼를 출력하게 한다. 
		int ret = -1;
		for(int j = 0; j <= m; j++){
			if(dp[n][j])
				ret = j;
		}
		System.out.println(ret);
	}
}