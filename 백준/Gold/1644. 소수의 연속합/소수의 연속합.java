import java.io.*;
import java.util.ArrayList;

class Main {

	static ArrayList<Integer> arr;
	static boolean[] che;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		che = new boolean[n + 1];
		arr = era(n);

		int start = 0;
		int end = 0;
		int ret = 0;
		int sum = 0;

		while (true) {
			if(sum >= n){
				sum -= arr.get(start++);
			}
			else if(end == arr.size()){
				break;
			}
			else {
				sum += arr.get(end++);
			}
			if(sum == n) {
				ret += 1;
			}
		}

		System.out.println(ret);
	}

	// 숫자 내에 있는 소수 모음을 구한다.
	private static ArrayList<Integer> era(int max) {
		arr = new ArrayList<>();
		for (int i = 2; i <= max; i++) {
			if (che[i])
				continue;
			for (int j = 2 * i; j <= max; j += i) {
				che[j] = true;
			}
		}
		for (int i = 2; i <= max; i++) {
			if (!che[i]) {
				arr.add(i);
			}
		}
		return arr;
	}
}