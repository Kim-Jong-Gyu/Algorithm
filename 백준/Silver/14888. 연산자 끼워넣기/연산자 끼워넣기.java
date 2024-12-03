import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[] numArray;

	static int n;
	static int maxRet = Integer.MIN_VALUE;
	static int minRet = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		numArray = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		int plus = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int multiply = Integer.parseInt(st.nextToken());
		int divide = Integer.parseInt(st.nextToken());

		dfs(1, numArray[0], plus, minus, multiply, divide);

		System.out.println(maxRet);
		System.out.println(minRet);
	}

	// 1. DFS
	static private void dfs(int idx, int current_result, int plus, int minus, int multiply, int divide){
		if (idx == n) {
			maxRet = Math.max(maxRet, current_result);
			minRet = Math.min(minRet, current_result);
		}
		if(plus > 0)
			dfs(idx + 1, calculate('+', current_result, numArray[idx]), plus - 1, minus, multiply, divide);
		if(minus > 0)
			dfs(idx + 1, calculate('-', current_result, numArray[idx]), plus, minus - 1, multiply, divide);
		if(multiply > 0)
			dfs(idx + 1, calculate('*', current_result, numArray[idx]), plus, minus, multiply -1, divide);
		if(divide > 0)
			dfs(idx + 1, calculate('/', current_result, numArray[idx]), plus, minus, multiply, divide - 1);
	}

	private static int calculate(Character op, int num1, int num2) {
		if(op == '+') {
			return num1 + num2;
		}
		else if(op == '-') {
			return num1 - num2;
		}
		else if(op == '*') {
			return num1 * num2;
		}
		else{
			int ret = Math.abs(num1) / num2;
			if(num1 < 0)
				return -ret;
			else
				return ret;
		}
	}
}