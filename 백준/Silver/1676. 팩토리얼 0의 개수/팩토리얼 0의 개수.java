import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt5 = 0;

		for (int i = 1; i <= n; i++) {
			int store5 = i;
			int tmpCnt5 = 0;

			while (store5 % 5 == 0) {
				tmpCnt5++;
				store5 /= 5;
			}
			cnt5 += tmpCnt5;
		}

		System.out.println(cnt5);
	}
}