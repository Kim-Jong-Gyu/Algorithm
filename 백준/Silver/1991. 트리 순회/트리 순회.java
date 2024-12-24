import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int[][] li;
	static int n;
	static StringBuilder ret = new StringBuilder();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		// initialize input value;
		li = new int[n][2];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int root = st.nextToken().charAt(0) - 'A';
			// left
			li[root][0] = st.nextToken().charAt(0) - 'A';
			// right
			li[root][1] = st.nextToken().charAt(0) - 'A';
		}
		preorder(0);
		ret.append(System.lineSeparator());
		inorder(0);
		ret.append(System.lineSeparator());
		postorder(0);
		System.out.println(ret.toString());
	}

	public static void preorder(int node){
		if(node < 0)
			return;
		ret.append((char)(node + 'A'));
		preorder(li[node][0]);
		preorder(li[node][1]);
	}

	public static void inorder(int node){
		if(node < 0)
			return;
		inorder(li[node][0]);
		ret.append((char)(node + 'A'));
		inorder(li[node][1]);
	}

	public static void postorder(int node){
		if(node < 0)
			return;
		postorder(li[node][0]);
		postorder(li[node][1]);
		ret.append((char)(node + 'A'));
	}
}