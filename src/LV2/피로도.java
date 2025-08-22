package LV2;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class 피로도 {
    private int max = 0;
    public int solution(int k, int[][] dungeons) {;
        boolean[] visited = new boolean[dungeons.length];
        _dfs(k, dungeons, visited, 0);
        return max;
    }

    private void _dfs(int curr, int[][] dungeons, boolean[] visited, int cleared) {
        max = Math.max(max, cleared);

        for (int i=0; i<dungeons.length; i++) {
            int need = dungeons[i][0];
            int cost = dungeons[i][1];
            if (!visited[i] && curr >= need) {
                visited[i] = true;
                _dfs(curr - cost, dungeons, visited, cleared + 1);
                visited[i]= false;
            }
        }
    }
}
