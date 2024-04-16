import java.util.*;

class Solution {
    
    // 인원수
    int num = 0;
    
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        num = friends.length;
        
        // 주고 받은 내역을 위한 배열 
        int[][] hist = new int[num][num];
        // 주고 받은 선물과 받은 선물을 이중 배열로 나타내기
        for(String gift : gifts){
            String[] exchange = gift.split(" ");
            String receive = exchange[1];
            String send = exchange[0];
            for(int i = 0; i < friends.length; i++){
                for(int j = 0; j < friends.length; j++){
                    if(send.equals(friends[i])){
                        if(receive.equals(friends[j])){
                            hist[i][j]++;
                        }
                    }
                }
            }
        }
        
        // 선물 지수 배열 
        int[] point = new int[num];
        for(int i = 0; i < hist.length; i++){
            for(int j = 0; j < hist[i].length; j++){
                point[i] += hist[i][j];
                point[j] -= hist[i][j];
            }
        }
        
        // 결과 값 구하기 
        int ret = 0;
        for(int i = 0; i < hist.length; i++){
            answer = Math.max(answer, ret);
            ret = 0;
            for(int j = 0; j < hist.length; j++){
                if(hist[i][j] > hist[j][i])
                    ret++;
                if(hist[i][j] == hist[j][i]){
                    if(point[i] > point[j])
                        ret++;
                }
                
            }
        }
        
        return answer;
    }
}