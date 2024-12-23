import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		String b = br.readLine();
		int[] bb = new int[b.length()];
		int total = 0;
		for (int i = b.length() - 1; i >= 0; i--) {
			bb[i] = b.charAt(i) - '0';
		}
		for (int i = b.length() - 1; i >= 0; i--) {
			System.out.println(a * bb[i]);
			total += (int)(a * bb[i] * Math.pow(10, b.length() - 1 - i));
		}
		System.out.println(total);
	}
}