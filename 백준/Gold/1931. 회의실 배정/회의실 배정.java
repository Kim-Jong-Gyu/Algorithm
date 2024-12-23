import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Main {

	static class Pair{
		int start;
		int end;

		public Pair(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pair> li = new ArrayList<>();
		int ret = 1;
		for(int i = 0; i < n; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			li.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		li.sort(new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				if (o1.end == o2.end)
					return o1.start - o2.start;
				return o1.end - o2.end;
			}
		});
		int start = li.get(0).start;
		int end = li.get(0).end;

		for(int i = 1; i < n; i++){
			if(li.get(i).start < end)
				continue;
			start = li.get(i).start;
			end = li.get(i).end;
			ret++;

		}
		System.out.println(ret);
	}
}