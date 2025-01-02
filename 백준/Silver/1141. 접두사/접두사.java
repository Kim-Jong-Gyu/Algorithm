import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] li = new String[n];
		for (int i = 0; i < n; i++) {
			li[i] = br.readLine();
		}

		Arrays.sort(li, new Comparator<>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		int cnt = n;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if(li[j].startsWith(li[i])){
					cnt--;
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}