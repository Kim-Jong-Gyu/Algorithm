import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String ret = input.replaceAll("pi|ka|chu", "");
		if(ret.isEmpty())
			System.out.println("YES");
		else
			System.out.println("NO");
	}
}