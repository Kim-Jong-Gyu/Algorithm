class Solution {
    
    int[] dh = {0, 1, -1, 0};
    int[] dw = {1, 0, 0, -1};

    
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int size = board.length;
        int count = 0;
        for(int i = 0; i < 4; i++){
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if(h_check < 0 || w_check < 0 || h_check >= size || w_check >= size)
                continue;
            if(board[h_check][w_check].equals(board[h][w]))
                count++;
        }
        return count;
    }
}