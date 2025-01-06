import java.io.*;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stk = new Stack<>();
		int ret = 0;
		for (int i = 0; i < n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(!stk.isEmpty() && tmp == 0)
				stk.pop();
			else
				stk.add(tmp);
		}
		for(int adj : stk)
			ret += adj;
		System.out.println(ret);
	}
}