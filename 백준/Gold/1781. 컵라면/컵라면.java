import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	static class Problem implements Comparable<Problem>{

		int deadLine;
		int cnt;

		public Problem(int deadLine, int cnt){
			this.deadLine = deadLine;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Problem o) {
			return Integer.compare(deadLine, o.deadLine);
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long ret = 0;

		ArrayList<Problem> li = new ArrayList<>();

		PriorityQueue<Integer> result = new PriorityQueue<>();

		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			li.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		Collections.sort(li);


		for(Problem p : li){
			ret += p.cnt;
			result.offer(p.cnt);
			if(result.size() > p.deadLine){
				ret -= result.poll();
			}
		}
		System.out.println(ret);
	}
}