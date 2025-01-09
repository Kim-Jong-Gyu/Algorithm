import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.StringTokenizer;

class Main {

	static int t, k;

	// N극은 0, S극 1
	static ArrayList<ArrayList<Integer>> wheel;

	// 톱니 번호, 시계방향 반시계 방향
	static int[][] command;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		wheel = new ArrayList<>();
		for (int i = 0; i < t; i++) {
			wheel.add(new ArrayList<>());
			String input = br.readLine();
			for (int j = 0; j < 8; j++) {
				wheel.get(i).add(input.charAt(j) - '0');
			}
		}
		k = Integer.parseInt(br.readLine());
		command = new int[k][2];
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			command[i][0] = Integer.parseInt(st.nextToken()) - 1;
			// 시계 방향은 1 반시계 방향은 0 으로 변경
			command[i][1] = Integer.parseInt(st.nextToken()) == -1 ? 0 : 1;
		}

		for (int i = 0; i < k; i++) {
			simulation(command[i][0], command[i][1]);
		}
		System.out.println(count());
	}

	// dir : 1 시계 방향, dir : -1 은 반시계방향
	// num 이 주어질 때, 그 전과 자기 자신 포함 끝까지 확인해야한다.
	private static void simulation(int pos, int dir) {
		int left = findLeft(pos);
		int right = findRight(pos);
		int cnt = dir;
		for (int i = pos; i >= left; i--) {
			rotate(i, cnt % 2);
			cnt++;
		}
		// 초기화
		cnt = dir + 1;
		for (int i = pos + 1; i <= right; i++) {
			rotate(i, cnt % 2);
			cnt++;
		}
	}

	// 같을 때까지 즉, 왼쪽에는 얼마나 돌려야하는지 확인
	private static int findLeft(int pos){
		for (int i = pos; i >= 1; i--) {
			if (Objects.equals(wheel.get(i).get(6), wheel.get(i - 1).get(2))) {
				return i;
			}
		}
		return 0;
	}

	// 이것은 위와 같이 오른쪽을 얼마나 돌려야하는지 확인
	private static int findRight(int pos) {
		for (int i = pos; i < t - 1; i++) {
			if (Objects.equals(wheel.get(i).get(2), wheel.get(i + 1).get(6))) {
				return i;
			}
		}
		return t - 1;
	}

	private static void rotate(int num, int dir){
		if(dir == 1)
			Collections.rotate(wheel.get(num), 1);
		if(dir == 0)
			Collections.rotate(wheel.get(num), -1);
	}

	private static int count(){
		int ret = 0;
		for (int i = 0; i < t; i++) {
			ret += wheel.get(i).get(0);
		}
		return ret;
	}
}