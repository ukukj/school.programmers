package LV2;

public class 타겟넘버 {
    int[] num;
    int sum = 0;
    int tar;
    int cnt;
    int[] afterPlusMax;
    public int solution(int[] numbers, int target) {
        num = numbers;
        tar = target;

        afterPlusMax = new int[num.length+1];
        for (int i=num.length-1; i>=0; i--) {
            afterPlusMax[i] = afterPlusMax[i+1] + Math.abs(num[i]);
        }

        dfs (0,0);
        return cnt;
    }
    private void dfs(int idx, int sum) {
        // 다 돌았고
        if (idx == num.length) {
            // target 같으면
            if (sum == tar) {
                cnt++;
            }
            return;
        }

        // 절대 tar 안나오는 경우 (이미 너무크거나 작음)
        if (afterPlusMax[idx] + sum < tar || sum - afterPlusMax[idx] > tar) {
            return;
        }
        dfs(idx + 1, sum + num[idx]);   // +
        dfs (idx +1, sum - num[idx]);   // -
    }
}
