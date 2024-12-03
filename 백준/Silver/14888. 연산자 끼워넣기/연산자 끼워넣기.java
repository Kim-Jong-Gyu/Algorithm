import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	static char[] operator = {'+', '-', '*', '/'};

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
		ArrayList<Character> opList = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				opList.add(operator[i]);
			}
		}
		// 1. dfs
		boolean[] visited = new boolean[n - 1];
		Stack<Character> stk = new Stack<>();
		dfs(visited, opList, 0, stk);
		System.out.println(maxRet);
		System.out.println(minRet);
	}

	// 1. DFS
	static private void dfs(boolean[] visited, ArrayList<Character> opList, int depth, Stack<Character> stk){
		if (depth == opList.size()) {
			int result = solve(stk);
			maxRet = Math.max(result, maxRet);
			minRet = Math.min(result, minRet);
			return;
		}

		for (int i = 0; i < opList.size(); i++) {
			if(visited[i])
				continue;
			visited[i] = true;
			stk.push(opList.get(i));
			dfs(visited, opList, depth + 1, stk);
			visited[i] = false;
			stk.pop();
		}
	}

	private static int solve(Stack<Character> stk) {
		int iter = 1;
		int ret = numArray[0];
		for(Character ch : stk){
			ret = calculate(ch, ret, numArray[iter]);
			iter++;
		}
		return ret;
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