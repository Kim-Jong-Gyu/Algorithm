import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Main {
	// 원형 자료 구조를 선형 자료 구조로 변경하자 !!
	static int buy, m, n, ret;

	static int[] pizzaA, pizzaB, pSumA, pSumB;

	static Map<Integer, Integer> aCnt;
	static Map<Integer, Integer> bCnt;

	public static void main(String[] args) throws IOException {
		// 1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		buy = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		pizzaA = new int[m];
		pizzaB = new int[n];

		for (int i = 0; i < m; i++) {
			pizzaA[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 0; i < n; i++) {
			pizzaB[i] = Integer.parseInt(br.readLine());
		}

		// 2. 누적합
		pSumA = new int[2 * (m + 1)];
		pSumB = new int[2 * (n + 1)];
		for (int i = 1; i <= m; i++) {
			pSumA[i] = pSumA[i - 1] + pizzaA[i - 1];
		}
		// 원형이랑 끝에서 부터 진행하는것도 계산 해야한다.
		for(int i = m + 1; i <= 2 * m; i++){
			pSumA[i] = pSumA[i - 1] + pizzaA[i - m - 1];
		}
		for(int i = 1; i <= n; i++){
			pSumB[i] = pSumB[i - 1] + pizzaB[i - 1];
		}
		for(int i = n + 1; i <= 2 * n; i++){
			pSumB[i] = pSumB[i - 1] + pizzaB[i - n - 1];
		}

		// 3. 계산
		aCnt = solve(m , pSumA);
		bCnt = solve(n, pSumB);
		ret = aCnt.getOrDefault(buy, 0) + bCnt.getOrDefault(buy, 0);
		for(int i = 1; i < buy; i++){
			ret += (aCnt.getOrDefault(i, 0) * bCnt.getOrDefault(buy - i, 0));
		}
		System.out.println(ret);
	}

	private static Map<Integer, Integer> solve(int n, int[] pSum){
		Map<Integer, Integer>cnt = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			for(int j = i; j <= n + i - 1; j++){
				int sum = pSum[j] - pSum[j - i];
				cnt.put(sum , cnt.getOrDefault(sum, 0) + 1);
				if(i == n)
					break;
			}
		}
		return cnt;
	}
}