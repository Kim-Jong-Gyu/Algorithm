import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n;
	static int[][] input;

	static int[] dp;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		input = new int[n + 1][2];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 걸린 시간
			input[i][0] = Integer.parseInt(st.nextToken());
			// 금액
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		// 요일
		for (int i = 1; i <= n; i++) {
			dp[i] = dp[i - 1];
			for (int j = 1; j <= n; j++) {
				if(input[j][0] + j == i + 1) {
					dp[i] = Math.max(dp[i], input[j][1] + dp[j - 1]);
				}
			}
		}
		System.out.println(dp[n]);
	}
}