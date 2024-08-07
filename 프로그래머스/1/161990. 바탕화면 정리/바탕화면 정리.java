class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j) == '#'){
                    minY = Math.min(i, minY);
                    minX = Math.min(j, minX);
                    maxY = Math.max(i, maxY);
                    maxX = Math.max(j, maxX);
                }
            }
        }
        answer[0] = minY;
        answer[1] = minX;
        answer[2] = maxY + 1;
        answer[3] = maxX + 1;
        return answer;
    }
}