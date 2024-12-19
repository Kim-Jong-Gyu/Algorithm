import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

	static class Suggestion{
		int pay;
		int day;

		public Suggestion(int pay, int day){
			this.pay = pay;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int result = 0;

		PriorityQueue<Suggestion> ret = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Suggestion o1, Suggestion o2) {
				return o1.pay - o2.pay;
			}
		});

		PriorityQueue<Suggestion> pq = new PriorityQueue<>(new Comparator<>() {

			@Override
			public int compare(Suggestion o1, Suggestion o2) {
				if(o1.day == o2.day)
					return o1.pay - o2.pay;
				return o1.day - o2.day;
			}
		});


		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			pq.offer(new Suggestion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		while(!pq.isEmpty()){
			// 비교 대상
			Suggestion tmp = pq.poll();
			if(ret.size() >= tmp.day){
				if(!ret.isEmpty() && ret.peek().pay < tmp.pay){
					ret.poll();
					ret.add(tmp);
				}
			}
			else{
				ret.add(tmp);
			}
		}

		while(!ret.isEmpty()){
			Suggestion tmp = ret.poll();
			result += tmp.pay;
		}
		System.out.println(result);
	}
}