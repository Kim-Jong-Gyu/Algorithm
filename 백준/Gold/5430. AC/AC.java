import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

class Main {

	static int t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();


		for(int i = 0; i < t; i++){

			Deque<Integer> dq = new ArrayDeque<>();
			String command = br.readLine();
			int n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			int x = 0;

			for (int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == '[' || input.charAt(j) == ']')
					continue;
				if(input.charAt(j) >= '0' && input.charAt(j) <= '9')
					x = x * 10 + input.charAt(j) -'0';
				else{
					if(x > 0)
						dq.addLast(x);
					x = 0;
				}
			}
			if(x > 0)
				dq.addLast(x);

			// R 체크
			boolean error = false;
			boolean reverse = false;

			for (int j = 0; j < command.length(); j++) {
				if(command.charAt(j) == 'R')
					reverse = !reverse;
				else{
					if(dq.isEmpty()){
						error = true;
						break;
					}
					if(reverse)
						dq.pollLast();
					else
						dq.pollFirst();
				}
			}

			if(error)
				sb.append("error").append("\n");
			else {
				if(dq.size() == 0){
					sb.append("[]").append("\n");
				}
				else {
					sb.append("[");
					Iterator it;
					if(reverse){
						it = dq.descendingIterator();
					}
					else {
						it = dq.iterator();
					}
					while (it.hasNext()) {
						sb.append(it.next()).append(",");
					}
					sb.delete(sb.length() - 1, sb.length());
					sb.append("]").append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}