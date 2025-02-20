import java.io.*;
import java.util.*;

class Main {
	static class Shark {
		int y;

		int x;

		int v;

		int dir;

		int size;

		boolean isDeath;

		public Shark(int y, int x, int v, int dir, int size) {
			this.y = y;
			this.x = x;
			this.v = v;
			this.dir = dir;
			this.size = size;
			this.isDeath = false;
		}
	}

	static int r, c, m, ret;

	static Shark[] shark;

	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	static int[][] sea;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// y
		r = Integer.parseInt(st.nextToken());
		// x
		c = Integer.parseInt(st.nextToken());
		// 상어 개수
		m = Integer.parseInt(st.nextToken());

		// 바다의 정보를 담는다. -> 샤크가 있는 곳인지 없는 곳인지 그리고 숫자는 해당 위치의 샤크의 번호를 의미한다.
		sea = new int[r][c];
		shark = new Shark[m + 1];

		// 상어를 1부터 번호를 매긴다.
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) - 1;
			int x = Integer.parseInt(st.nextToken()) - 1;
			int v = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken()) - 1;
			int size = Integer.parseInt(st.nextToken());
			if(dir <= 1){
				v = v % (2 * (r - 1));
			}
			else{
				v = v % (2 * (c - 1));
			}
			// shark에 대한 정보를 담는다.
			shark[i] = new Shark(y, x, v, dir, size);
			sea[y][x] = i;
		}
		catchFish();
		System.out.println(ret);
	}

	private static void catchFish() {
		for(int i = 0; i < c; i++){
			// 1. catch
			for(int j = 0; j < r; j++){
				if(sea[j][i] > 0){
					ret += shark[sea[j][i]].size;
					shark[sea[j][i]].isDeath = true;
					sea[j][i] = 0;
					break;
				}
			}
			// 2. shark move
			// shark가 서로 먹히는 것을 관리하기 위해 임시 바다 생성
			int[][] tmpSea = new int[r][c];

			for(int j = 1; j <= m; j++){
				if(shark[j].isDeath)
					continue;

				int y = shark[j].y;
				int x = shark[j].x;
				int v = shark[j].v;
				int dir = shark[j].dir;

				int ny, nx;

				while(true){
					ny = y + v * dy[dir];
					nx = x + v * dx[dir];
					if(ny >= 0 && ny < r && nx >= 0 && nx < c)
						break;
					if(dir <= 1){
						if(ny < 0){
							v -= y;
							y = 0;
						}
						else {
							v -= r - 1 - y;
							y = r - 1;
						}
					}
					else {
						if(nx < 0){
							v -= x;
							x = 0;
						}
						else {
							v -= c - 1 - x;
							x = c - 1;
						}
					}
					dir ^= 1;
				}
				// 이동 후 누군가 있다.
				if(tmpSea[ny][nx] > 0){
					if(shark[tmpSea[ny][nx]].size >= shark[j].size){
						shark[j].isDeath = true;
					}
					else{
						shark[tmpSea[ny][nx]].isDeath = true;
						tmpSea[ny][nx] = j;
						shark[j].y = ny;
						shark[j].x = nx;
						shark[j].dir = dir;
					}
				}
				else{
					tmpSea[ny][nx] = j;
					shark[j].y = ny;
					shark[j].x = nx;
					shark[j].dir = dir;
				}
			}
			sea = tmpSea;
		}
	}
}