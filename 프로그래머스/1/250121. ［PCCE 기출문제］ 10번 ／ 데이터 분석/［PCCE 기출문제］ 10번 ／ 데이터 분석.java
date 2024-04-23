import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = new int[500][4];
        int count = 0;
        String[] extArr = {"code", "date", "maximum", "remain"};
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < 4; j++){
                if(ext.equals(extArr[j])){
                    if(data[i][j] < val_ext){
                        answer[count] = data[i];
                        count++;
                    }
                }
            }
        }
        int sortBy = 0;
        for(int i = 0; i < 4; i++){
            if(sort_by.equals(extArr[i])){
                sortBy = i;
            }
        }
        int[][] ret = Arrays.copyOfRange(answer, 0, count);
        Arrays.sort(ret, (o1, o2) -> {
            for(int i = 0; i < 4; i++){
                if(sort_by.equals(extArr[i])){
                    return o1[i] - o2[i];
                }
            }
            return 0;
        });
        return ret;
    }
}