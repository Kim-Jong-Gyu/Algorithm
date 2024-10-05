import java.util.*;

class Solution {
    
    int[] ret = new int[2];
    
    public int[] solution(int[][] arr) {
        quadTree(0, 0, arr.length, arr);
        return ret;
    }
    
    public boolean check(int startY, int startX, int size, int[][] arr){
        for(int i = startY; i < startY + size; i++){
            for(int j = startX; j < startX + size; j++){
                if(arr[startY][startX] != arr[i][j])
                    return false;
            }
        }
        return true;
    }
    
    public void quadTree(int startY, int startX, int size, int[][] arr){
        if(check(startY, startX, size, arr)){
            if(arr[startY][startX] == 0)
                ret[0] += 1;
            else
                ret[1] += 1;
            return;
        }
        else{
            // UpLeft
            quadTree(startY, startX, size/2, arr);
            // UpRight
            quadTree(startY, startX + size/2, size/2, arr);
            // DownLeft
            quadTree(startY + size/2, startX, size/2, arr);
            // DownRight
            quadTree(startY + size/2, startX + size/2, size/2, arr);
        }
    }
}