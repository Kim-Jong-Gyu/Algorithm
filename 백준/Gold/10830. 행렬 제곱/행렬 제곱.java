import java.io.*;
import java.util.StringTokenizer;

class Main {

	static int n;

	static long b;

	static long[][] mat;

	static int mod = 1000;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		mat = new long[n][n];

		// 입력값 받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				mat[i][j] = Long.parseLong(st.nextToken()) % mod;
			}
		}

		// 제곱
		long[][] ret = square(mat, b);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(ret[i][j] + " ");
			}
			System.out.println();
		}
	}

	// 재귀를 이용
	private static long[][] square(long[][] mat, long b){
		if(b == 1){
			return mat;
		}
		long[][] half = square(mat, b/2);
		long[][] result = multiply(half, half);

		if(b % 2 != 0){
			result = multiply(result, mat);
		}

		return result;
	}

	private static long[][] multiply(long[][] half1, long[][] half2) {
		long[][] ret = new long[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				long sum = 0;
				for (int k = 0; k < n; k++) {
					sum += half1[i][k] * half2[k][j];
					sum %= mod;
				}
				ret[i][j] = sum;
			}
		}
		return ret;
	}
}