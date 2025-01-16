import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {

	static int n, k, ret;

	static ArrayList<Integer> category;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		category = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			category.add(Integer.parseInt(br.readLine()));
		}

		Collections.reverse(category);

		for (int i = 0; i < n; i++) {
			int now = category.get(i);
			if (now > k)
				continue;
			int tmp = 1;
			while(tmp * now <= k){
				tmp++;
			}
			tmp -= 1;
			k -= tmp * now;
			ret += tmp;
		}
		System.out.println(ret);
	}
}