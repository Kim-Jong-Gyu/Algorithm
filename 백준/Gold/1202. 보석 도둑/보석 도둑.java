import java.io.*;
import java.util.*;

class Main {
	static int n, k;

	public static void main(String[] args) throws IOException {
		// 1. Input 과정
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int[][] inputJewel = new int[n][2];
		int[] bag = new int[k];
		long ret = 0;

		Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			// weight
			inputJewel[i][0] = Integer.parseInt(st.nextToken());
			// price
			inputJewel[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < k; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		// 2. 정렬
		// 보석은 무게 기준 오름차순
		Arrays.sort(inputJewel, new Comparator<>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		// 가장 무게도 오름차순
		Arrays.sort(bag);

		// 3. 가방 범위 내에 해당하는 모든 보석들을 넣는다.
		// 4. PriorityQueue를 사용해서 가격이 가장 높은순으로 한다.
		// 5. 다 넣은 후 가장 큰 값을 뺀다.
		int j = 0;
		for(int i = 0; i < k; i++){
			while(j < n && inputJewel[j][0] <= bag[i]){
				pq.offer(inputJewel[j][1]);
				j++;
			}
			if(!pq.isEmpty()){
				ret += pq.poll();
			}
		}
		System.out.println(ret);
	}
}