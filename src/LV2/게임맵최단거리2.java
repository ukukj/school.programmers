package LV2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리2 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[] dx = {0,0,1,-1};  // 동서남북
        int[] dy = {1,-1,0,0};  // 동서남북
        int[][] cntArr = new int[n][m];
        cntArr[0][0] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        int[][] visited = new int[n][m];
        visited[0][0] = 1;

        // 갈곳있을때까지 계속
        while (!queue.isEmpty()) {
            int[] goTo = queue.poll();
            int now_x = goTo[0];
            int now_y = goTo[1];
            if (now_x == n-1 && now_y == m-1) break;

            for (int i=0; i<4; i++) {
                int x = now_x+dx[i];
                int y = now_y+dy[i];

                // 갈수있으면
                if (x >= 0 && y >= 0 && x<n && y <m && maps[x][y] == 1 && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    cntArr[x][y] = cntArr[now_x][now_y] + 1;
                    queue.add(new int[]{x,y});
                }
            }
        }

        if (cntArr[n-1][m-1] == 0) return -1;
        return cntArr[n-1][m-1];
    }

}
