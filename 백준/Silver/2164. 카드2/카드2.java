import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <= n; i++){
			q.offer(i);
		}

		while (q.size() > 1) {
			q.poll();
			int top = q.poll();
			q.offer(top);
		}
		System.out.println(q.peek());
	}
}