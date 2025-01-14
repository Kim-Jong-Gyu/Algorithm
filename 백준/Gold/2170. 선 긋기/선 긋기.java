import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	static class Pair {
		long s;

		long e;

		public Pair(long s, long e) {
			this.s = s;
			this.e = e;
		}
	}

	static int n;
	static long ret;

	static long s = -1000000001;
	static long e = -1000000001;

	static PriorityQueue<Pair> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.s - o2.s < 0)
					return -1;
				else if (o1.s - o2.s == 0)
					return 0;
				else
					return 1;
			}
		});
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			pq.offer(new Pair(s, e));
		}

		while (!pq.isEmpty()) {
			Pair now = pq.poll();
			if (now.s > e) {
				ret += Math.abs(e - s);
				s = now.s;
			}
			e = Math.max(e, now.e);
		}
		ret += Math.abs(e - s);
		System.out.println(ret);
	}
}