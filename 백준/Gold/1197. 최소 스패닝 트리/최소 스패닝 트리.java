import java.io.*;
import java.util.*;

class Main {

	static class Node{
		int v1;

		int v2;

		int w;

		public Node(int v1, int v2, int w){
			this.v1 = v1;
			this.v2 = v2;
			this.w = w;

		}
	}

	static int[] root;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		long ret = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>() {
			@Override
			public int compare(Node o1, Node o2) {
				return o1.w - o2.w;
			}
		});

		for(int i = 0; i < e; i++){
			st = new StringTokenizer(br.readLine());
			pq.offer(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		// Union - Find를 위한 배열
		root = new int[v + 1];

		for(int i = 1; i <= v; i++){
			root[i] = i;
		}

		int cnt = 0;
		// Kruskal 알고리즘
		while(!pq.isEmpty()){
			if(cnt == v-1)
				break;
			Node now = pq.poll();
			if(find(now.v1) == find(now.v2))
				continue;
			union(now.v1 , now.v2);
			cnt++;
			ret += now.w;
		}

		System.out.println(ret);
	}
	public static void union(int x, int y){
		x = find(x);
		y = find(y);
		if(x < y)
			root[y] = x;
		else
			root[x] = y;
	}

	private static int find(int v) {
		if(root[v] == v)
			return v;
		else
			return root[v] = find(root[v]);
	}
}