import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[] arr;
	// 중복되는지 체크
	static boolean[] flag = new boolean[100005];
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		long ret = 0;
		int end = 0;
		int start = 0;

		while(end < n){
			if(!flag[arr[end]]){
				flag[arr[end]] = true;
				end += 1;
			}
			else {
				// 범위 내 부분 집합 개수
				ret += (end -start);
				flag[arr[start]] = false;
				start += 1;
			}
		}
		// 남은 숫자 개수들의 합 -> 연속된 수열의 경우의 수
		ret += ((long)(end - start) * (end -start + 1)) / 2;
		System.out.println(ret);
	}
}