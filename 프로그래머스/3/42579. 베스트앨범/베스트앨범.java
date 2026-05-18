import java.util.*;

class Solution {
        
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, Integer> totalPlayByGenre = new HashMap<>();
        
        Map<String, Map<Integer, Integer>> playsWithPkByGenre = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            totalPlayByGenre.put(genres[i], totalPlayByGenre.getOrDefault(genres[i], 0) + plays[i]);

            Map<Integer, Integer> songMap = playsWithPkByGenre.getOrDefault(genres[i], new HashMap<>());
            songMap.put(i, plays[i]);
            playsWithPkByGenre.put(genres[i], songMap);
        }

        // 장르 총 재생 수 기준 내림차순 정렬
        List<Map.Entry<String, Integer>> listByGenre = new ArrayList<>(totalPlayByGenre.entrySet());

        listByGenre.sort((a, b) -> b.getValue() - a.getValue());

        List<Integer> answerList = new ArrayList<>();

        // 장르 순서대로 반복
        for (Map.Entry<String, Integer> genreEntry : listByGenre) {
            String genre = genreEntry.getKey();

            Map<Integer, Integer> songs = playsWithPkByGenre.get(genre);

            List<Map.Entry<Integer, Integer>> songList = new ArrayList<>(songs.entrySet());

            // 재생 수 내림차순, 같으면 고유번호 오름차순
            songList.sort((a, b) -> {
                if (a.getValue().equals(b.getValue())) {
                    return a.getKey() - b.getKey();
                }
                return b.getValue() - a.getValue();
            });

            // 장르별 최대 2곡 추가
            for (int i = 0; i < Math.min(2, songList.size()); i++) {
                answerList.add(songList.get(i).getKey());
            }
        
        }

        int[] answer = new int[answerList.size()];

        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}