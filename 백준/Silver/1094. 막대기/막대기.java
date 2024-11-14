import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		int ret = 1;

		while (x != 1) {
			if((x & 1) != 0)
				ret++;
			x /= 2;
		}

		System.out.println(ret);
	}
}