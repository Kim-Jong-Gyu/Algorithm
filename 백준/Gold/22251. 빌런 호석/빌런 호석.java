import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n, k, p, x;

	static int[][] numArr = {
		{1, 1, 1, 0, 1, 1, 1}, //0
		{0, 0, 1, 0, 0, 0, 1}, //1
		{0, 1, 1, 1, 1, 1, 0}, //2
		{0, 1, 1, 1, 0, 1, 1}, //3
		{1, 0, 1, 1, 0, 0, 1}, //4
		{1, 1, 0, 1, 0, 1, 1}, //5
		{1, 1, 0, 1, 1, 1, 1}, //6
		{0, 1, 1, 0, 0, 0, 1}, //7
		{1, 1, 1, 1, 1, 1, 1}, //8
		{1, 1, 1, 1, 0, 1, 1} // 9
	}; //9

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		int ret = 0;
		// X를 배열로 변환
		int[] xArr = intToArr(x);

		// 1층 부터 n층까지 확인
		for(int i = 1; i <= n; i++){
			if(i == x)
				continue;
			if(isReversed(xArr, i))
				ret++;
		}
		System.out.println(ret);
	}

	// 다른 거 개수 찾기
	private static boolean isReversed(int[] xArr, int target) {
		int[] targetArr = intToArr(target);
		int diff = 0;
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < 7; j++) {
				if (numArr[xArr[i]][j] != numArr[targetArr[i]][j])
					diff++;
				if(diff > p)
					return false;
			}
		}
		return true;
	}

	private static int[] intToArr(int x){
		int[] ret = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			ret[i] = x % 10;
			x /= 10;
		}
		return ret;
	}
}