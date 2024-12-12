import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int n, m, x, y, k;
	static int[][] mp;

	static int[] command;

	static class Dice {
		int top;
		int bottom;
		int front;
		int back;
		int left;
		int right;

		public Dice(int top, int bottom, int front, int back, int left, int right) {
			this.top = top;
			this.bottom = bottom;
			this.front = front;
			this.back = back;
			this.left = left;
			this.right = right;
		}

		// 동쪽
		public void rollRight() {
			int tmpRight = this.right;
			int tmpLeft = this.left;
			int tmpBottom = this.bottom;
			int tmpTop = this.top;
			this.top = tmpLeft;
			this.bottom = tmpRight;
			this.right = tmpTop;
			this.left = tmpBottom;
		}

		// 서쪽
		public void rollLeft() {
			int tmpRight = this.right;
			int tmpLeft = this.left;
			int tmpBottom = this.bottom;
			int tmpTop = this.top;
			this.top = tmpRight;
			this.bottom = tmpLeft;
			this.right = tmpBottom;
			this.left = tmpTop;
		}

		// 북쪽
		public void rollUp() {
			int tmpFront = this.front;
			int tmpBack = this.back;
			int tmpBottom = this.bottom;
			int tmpTop = this.top;
			this.top = tmpFront;
			this.bottom = tmpBack;
			this.front = tmpBottom;
			this.back = tmpTop;
		}

		public void rollDown() {
			int tmpFront = this.front;
			int tmpBack = this.back;
			int tmpBottom = this.bottom;
			int tmpTop = this.top;
			this.top = tmpBack;
			this.bottom = tmpFront;
			this.front = tmpTop;
			this.back = tmpBottom;
		}

		public void paste(int value) {
			this.bottom = value;
		}
	}

	static class Location {
		int y;
		int x;

		public Location(int y, int x) {
			this.y = y;
			this.x = x;
		}

		public void moveUp() {
			this.y -= 1;
		}

		public void moveDown() {
			this.y += 1;
		}

		public void moveRight() {
			this.x += 1;
		}

		public void moveLeft() {
			this.x -= 1;
		}
	}

	public static void main(String[] args) throws IOException {
		init();
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		Location loc = new Location(y, x);
		for (int i = 0; i < k; i++) {
			if (!check(loc, command[i]))
				continue;
			switch (command[i]) {
				case 1: {
					dice.rollRight();
					loc.moveRight();
					break;
				}
				case 2: {
					dice.rollLeft();
					loc.moveLeft();
					break;
				}
				case 3: {
					dice.rollUp();
					loc.moveUp();
					break;
				}
				case 4: {
					dice.rollDown();
					loc.moveDown();
					break;
				}
			}
			System.out.println(dice.top);
			if (mp[loc.y][loc.x] == 0) {
				mp[loc.y][loc.x] = dice.bottom;
				continue;
			}
			dice.paste(mp[loc.y][loc.x]);
			mp[loc.y][loc.x] = 0;
		}
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		mp = new int[n][m];
		command = new int[k];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				mp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
	}

	public static boolean check(Location loc, int command) {
		if (command == 1) {
			return loc.x + 1 < m;
		} else if (command == 2) {
			return loc.x - 1 >= 0;
		} else if (command == 3) {
			return loc.y - 1 >= 0;
		} else {
			return loc.y + 1 < n;
		}
	}

}