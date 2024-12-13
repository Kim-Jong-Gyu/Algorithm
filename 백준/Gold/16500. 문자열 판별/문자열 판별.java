import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];

		for (int i = 0; i < n; i++) {
			String tmp = br.readLine();
			input[i] = tmp;
		}

		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			for(int j = 0; j < i; j++){
				if (dp[j] && contain(s, j, i, input)) {
					dp[i] = true;
					break;
				}
			}

		}
		System.out.println(dp[s.length()] ? 1 : 0);
	}

	private static boolean contain(String s, int start, int end, String[] input) {
		String sub = s.substring(start, end);
		for (String str : input) {
			if (sub.equals(str)) {
				return true;
			}
		}
		return false;
	}
}