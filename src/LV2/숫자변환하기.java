package LV2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 숫자변환하기 {
    public int solution(int x, int y, int n) {
        if (x == y) return 0;
        boolean[] visited = new boolean[y+1];
        visited[x] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int now = cur[0], cnt = cur[1];
            int[] nexts = new int[]{now+n, now*2, now*3};
            for (int next : nexts) {
                if (next > y || visited[next]) continue;
                if (next == y) return cnt+1;
                visited[next] = true;
                queue.add(new int[]{next, cnt+1});
            }
        }

        return -1;
    }
}
