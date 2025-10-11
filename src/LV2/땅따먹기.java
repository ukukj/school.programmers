package LV2;

public class 땅따먹기 {
    public int solution(int[][] land) {
        int[][] dp = new int[land.length][4];

        for (int i=0; i<4; i++) {
            dp[0][i] = land[0][i];
        }

        // 5 + max(dp[0][1], dp[0][2], dp[0][3])
        for (int i=1; i<land.length; i++) {
            for (int j=0; j<4; j++) {
                int best = 0;
                for (int k=0; k<4; k++) {
                    if (k==j) continue;
                    best = Math.max(best, dp[i-1][k]);
                }
                dp[i][j] = land[i][j] + best;
            }
        }
        int max = 0;
        for (int x : dp[land.length-1]) {
            max = Math.max(max, x);
        }
        return max;
    }
}
