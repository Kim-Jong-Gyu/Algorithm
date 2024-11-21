import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = 0;
		String command;
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			if (command.equals("all"))
				n = (1 << 21) - 1;
			else if (command.equals("empty"))
				n = 0;
			else {
				int num = Integer.parseInt(st.nextToken());
				switch (command) {
					case "add" -> n |= (1 << num);
					case "remove" -> n &= ~ (1 << num);
					case "check" -> sb.append((n & (1 << num)) != 0 ? 1 : 0).append("\n");
					default -> n ^= (1 << num);
				}
			}
		}
		System.out.println(sb);
	}
}