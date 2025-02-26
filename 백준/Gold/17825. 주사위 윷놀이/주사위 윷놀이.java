import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {


	static ArrayList<ArrayList<Integer>> mp;

	static int[] input;
	static int[] user;

	static int[] score = new int[104];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		input = new int[10];
		for (int i = 0; i < 10; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		init();
		user = new int[4];
		System.out.println(simulation(0));
	}

	private static int simulation(int here) {
		if(here == 10)
			return 0;
		int ret = 0;
		for(int i = 0; i < 4; i++){
			int tmpIdx = user[i];
			int moveIdx = move(tmpIdx, input[here]);
			if(isPresented(moveIdx, i))
				continue;
			user[i] = moveIdx;
			ret = Math.max(ret, simulation(here + 1) + score[moveIdx]);
			user[i] = tmpIdx;
		}
		return ret;
	}

	private static boolean isPresented(int nowIdx, int turnUser){
		if(nowIdx == 100)
			return false;
		for(int i = 0; i < 4; i++){
			if(i == turnUser)
				continue;
			if(user[i] == nowIdx)
				return true;
		}
		return false;
	}


	private static int move(int here, int cnt){
		if(here == 100)
			return 100;
		if(mp.get(here).size() >= 2){
			here = mp.get(here).get(1);
			cnt -= 1;
		}
		if(cnt > 0){
			Queue<Integer> q = new LinkedList<>();
			q.offer(here);
			int there = 0;
			while(!q.isEmpty()){
				int x = q.poll();
				there = mp.get(x).get(0);
				q.offer(there);
				if(there == 100)
					break;
				cnt -= 1;
				if(cnt == 0)
					break;
			}
			return there;
		}
		return here;
	}


	private static void init() {
		mp = new ArrayList<>();
		for(int i = 0; i < 32; i++){
			mp.add(new ArrayList<>());
		}
		for(int i = 0; i <= 19; i++){
			mp.get(i).add(i + 1);
		}
		mp.get(5).add(21);
		mp.get(21).add(22);
		mp.get(22).add(23);
		mp.get(23).add(24);

		mp.get(15).add(29);
		mp.get(29).add(30);
		mp.get(30).add(31);
		mp.get(31).add(24);

		mp.get(10).add(27);
		mp.get(27).add(28);
		mp.get(28).add(24);

		mp.get(24).add(25);
		mp.get(25).add(26);
		mp.get(26).add(20);

		mp.get(20).add(100);

		score[1] = 2;
		score[2] = 4;
		score[3] = 6;
		score[4] = 8;
		score[5] = 10;
		score[6] = 12;
		score[7] = 14;
		score[8] = 16;
		score[9] = 18;
		score[10] = 20;
		score[11] = 22;
		score[12] = 24;
		score[13] = 26;
		score[14] = 28;
		score[15] = 30;
		score[16] = 32;
		score[17] = 34;
		score[18] = 36;
		score[19] = 38;
		score[20] = 40;
		score[21] = 13;
		score[22] = 16;
		score[23] = 19;
		score[24] = 25;
		score[27] = 22;
		score[28] = 24;
		score[25] = 30;
		score[26] = 35;
		score[29] = 28;
		score[30] = 27;
		score[31] = 26;
	}
}