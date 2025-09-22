package LV2;

import java.util.*;

public class 방문길이 {
    public int solution(String dirs) {
        int cnt = 0;
        Map<Character, int[]> move = new HashMap<>();
        move.put('U', new int[]{0, 1});
        move.put('D', new int[]{0, -1});
        move.put('R', new int[]{1,0});
        move.put('L', new int[]{-1,0});

        int x = 0;
        int y = 0;
        Set<List<Integer>> set = new HashSet<>();
        for (char dir : dirs.toCharArray()) {
            int dx = x + move.get(dir)[0];
            int dy = y + move.get(dir)[1];

            if (dx<=5 && dx>=-5 && dy<=5 && dy>=-5) {
                if (!set.contains(Arrays.asList(x,y,dx,dy))) {
                    set.add(Arrays.asList(x,y,dx,dy));
                    set.add(Arrays.asList(dx,dy,x,y));
                    cnt ++;
                }
                x = dx;
                y = dy;
            }
        }
        return cnt;
    }
}
