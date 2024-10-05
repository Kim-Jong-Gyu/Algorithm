import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n, k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		// w : 0, V : 1
		int[] v = new int[n + 1];
		int[] w = new int[n + 1];
		int[][] dp = new int[n + 1][k + 1];


		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= k; j++){

				if(w[i] > j){
					dp[i][j] = dp[i - 1][j];
				}

				else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}