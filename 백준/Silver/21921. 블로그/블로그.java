import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n, x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int[] input = new int[n + 1];
		int[] psum = new int[n + 1];
		int ret = 0;
		int cnt = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			psum[i] = psum[i - 1] + input[i];
		}

		for (int i = x; i <= n; i++) {
			ret = Math.max(ret, psum[i] - psum[i - x]);
		}

		if(ret != 0){
			for(int i = x; i <= n; i++){
				if(ret == psum[i] - psum[i - x])
					cnt++;
			}
			System.out.println(ret);
			System.out.println(cnt);
		}
		else {
			System.out.println("SAD");
		}

	}
}