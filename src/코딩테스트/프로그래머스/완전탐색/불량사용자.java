package 코딩테스트.프로그래머스.완전탐색;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량사용자 {
    private void count(int index, Set<String> banned, String[][] bans, Set<Set<String>> banSet){
        if(index == bans.length){
            banSet.add(new HashSet<>(banned));
            return;
        }

        for(String id : bans[index]){
            if(banned.contains(id)) continue;
            banned.add(id);
            count(index + 1, banned, bans, banSet);
            banned.remove(id);
        }
    }

    public int solution(String[] user_id, String[] banned_id){
        String[][] bans = Arrays.stream(banned_id)
                .map(banned -> banned.replace('*', '.'))
                .map(banned -> Arrays.stream(user_id)
                        .filter(id -> id.matches(banned))
                        .toArray(String[]::new))
                .toArray(String[][]::new);

        Set<Set<String>> banSet = new HashSet<>();
        count(0, new HashSet<>(), bans, banSet);

        return banSet.size();
    }

    public static void main(String[] args) {
        불량사용자 a = new 불량사용자();
        a.solution(new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[]{"fr*d*", "abc1**"});
    }
}
