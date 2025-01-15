import java.io.*;
import java.util.*;

class Main {

	static int n, l, ret, startBlock, endBlock;

	static ArrayList<int[]> poolList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		poolList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int[] pool = new int[2];
			// start
			pool[0] = Integer.parseInt(st.nextToken());
			// end
			pool[1] = Integer.parseInt(st.nextToken());
			poolList.add(pool);
		}
		poolList.sort(new Comparator<>() {
			@Override
			public int compare(int[] pool1, int[] pool2) {
				return pool1[0] - pool2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			int[] now = poolList.get(i);
			if (startBlock < now[0]) {
				startBlock = now[0];
				endBlock = startBlock + l;
				ret++;
			}
			while (endBlock < now[1]) {
				endBlock = endBlock + l;
				ret++;
			}
			startBlock = endBlock;
		}
		System.out.println(ret);
	}
}