import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	static class Cow{
		int arrive;
		int taken;

		public Cow(int arrive, int taken){
			this.arrive = arrive;
			this.taken = taken;
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ret = 0;

		// 새로운 자료구조 사용 -> Comperator로 정렬이 가능
		PriorityQueue<Cow> s = new PriorityQueue<>(new Comparator<Cow>() {
			@Override
			public int compare(Cow o1, Cow o2) {
				if(o1.arrive == o2.arrive)
					return o1.taken - o2.taken;
				return o1.arrive - o2.arrive;
			}
		});

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			s.add(new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		while (!s.isEmpty()){
			Cow now = s.poll();
			if(now.arrive > ret)
				ret = now.arrive + now.taken;
			else
				ret += now.taken;
		}
		System.out.println(ret);
	}
}