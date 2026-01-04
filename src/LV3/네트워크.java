package LV3;

public class 네트워크 {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                answer++;   // 새 네트워크 발견
                dfs(i, computers, visited, n);
            }
        }
        return answer;
    }

    private void dfs(int cur, int[][] computers, boolean[] visited, int n) {
        visited[cur] = true;

        for (int i=0; i<n; i++) {
            if (computers[cur][i] == 1 && !visited[i]) {
                dfs(i, computers, visited, n);
            }
        }
    }
}
