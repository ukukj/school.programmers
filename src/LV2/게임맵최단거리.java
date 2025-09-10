package LV2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 게임맵최단거리 {
    int n,m;
    int[][] maps;
    // 동, 서, 남, 북
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    List<Integer> list = new ArrayList<>();
    int[][] visited;
    int best = Integer.MAX_VALUE;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        this.maps = maps;
        if (maps[0][0] == 0 || maps[n - 1][m - 1] == 0) return -1;  // 시작 or 도착이 벽이면 방문 불가능
        visited = new int[n][m];
        visited[0][0] = 1;  // 첫 위치 방문표시
        dfs(0,0, 1);

        Collections.sort(list);
        if (list.isEmpty()) return -1;
        return list.get(0);
    }

    private void dfs(int x, int y, int cnt) {
        if (cnt >= best) return;    // 이미 최선보다 길면 return
        if (x == n-1 && y == m-1) {
            list.add(cnt);
            best = Math.min(cnt, best);
            return;
        }

        // 동서남북 4번 가능
        for (int i=0; i<4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];
            // index 벗어났는지 & 미방문인지 & 열려있는지
            if (n > nx && nx>= 0 && m > ny && ny >= 0 && maps[nx][ny] == 1 && visited[nx][ny] == 0) {
                // 방문표시 해주고
                visited[nx][ny] = 1;
                // 재귀호출 (이동은 1번 더 한 상태에서)
                dfs(nx, ny, cnt+1);
                // 백트래킹 (되돌리기) (dfs 재귀 호출 될때 거기 안갔던걸로 다시 매꾸기)
                visited[nx][ny] = 0;
            }
        }
    }
}
