import java.io.*;

class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		long ret = 0;
		for(long i = 1; i <= n; i++){
			ret += calSize(i);
		}
		System.out.println(ret);
	}

	private static int calSize(long n){
		int ret = 0;
		while(n > 0){
			n /= 10;
			ret++;
		}
		return ret;
	}
}