import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {

	static String str;

	static class Pair{
		int leftK;
		int rightK;

		public Pair(int leftK, int rightK) {
			this.leftK = leftK;
			this.rightK = rightK;
		}

	}

	static int totalK, ret;


	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		totalK = str.replaceAll("R", "").length();

		// R 기준 왼쪽 K개수
		ArrayList<Pair> cntK = new ArrayList<>();

		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'K'){
				cnt++;
			}
			else{
				cntK.add(new Pair(cnt, totalK - cnt));
			}
		}
		int left = 0;
		int right = cntK.size() - 1;
		while (left <= right) {
			ret = Math.max(ret, (right - left + 1) + 2 * (Math.min((cntK.get(left).leftK), cntK.get(right).rightK)));
			if (cntK.get(left).leftK < cntK.get(right).rightK)
				left++;
			else
				right--;
		}
		System.out.println(ret);
	}
}