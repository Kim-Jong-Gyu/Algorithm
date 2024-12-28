import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int[] a;
	static int n;
	static int x;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = new int[n];
		x = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(a);
		// 투 포인터
		int start = 0;
		int end = n - 1;
		int ret = 0;
		while (true) {
			int sum = a[start] + a[end];
			if(sum > x){
				end -= 1;
			}
			else if(start >= end){
				break;
			}
			else {
				start += 1;
			}
			if(sum == x)
				ret+=1;
		}
		System.out.println(ret);
	}
}