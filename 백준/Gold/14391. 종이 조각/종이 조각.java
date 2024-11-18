import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[][] mp;

	static int n, m;

	static int ret = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		mp = new int[n][m];

		for(int i = 0; i < n; i++){
			String tmp = br.readLine();
			for(int j = 0; j < m; j++){
				mp[i][j] = tmp.charAt(j) - '0';
			}
		}

		// 모든 경우의 수를 따질 때 -> 비트마스킹
		for(int s = 0; s < (1 << n * m); s++){
			int sum = getSum(s);
			ret = Math.max(ret, sum);
		}
		System.out.println(ret);
	}

	private static int getSum(int s) {
		int ret = 0;
		// row 덧셈
		for(int i = 0; i < n; i++){
			int cur = 0;
			for(int j = 0; j < m; j++){
				// 2차원을 1차원으로 만들어서 현재 위치를 나타내는 변수
				int k = i * m + j;
				if(((1 << k) & s) == 0){
					cur = cur * 10 + mp[i][j];
				}
				else {
					ret += cur;
					cur = 0;
				}
			}
			// 0000 일경우
			ret += cur;
		}
		// col 덧셈
		for(int j = 0; j < m; j++){
			int cur = 0;
			for(int i = 0; i < n; i++) {
				int k = i * m + j;
				if((s & (1 << k)) != 0){
					cur = cur * 10 + mp[i][j];
				}
				else {
					ret += cur;
					cur = 0;
				}
			}
			ret += cur;
		}
		return ret;
	}
}