package LV2;

public class n제곱배자르기 {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        int[][] arr2 = new int[n][n];
        for (int i=1; i<n+1; i++) {
            for (int j=0; j<i; j++) {
                for (int k=0; k<i; k++) {
                    if (arr2[j][k] == 0) {
                        arr2[j][k] = i;
                    }
                }
            }
        }
        int[] arr = new int[(int) Math.pow(n, 2)];
        int idx = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                arr[idx] = arr2[i][j];
                idx++;
            }
        }
        int idx2 = 0;
        for (int i = (int) left; i<right+1; i++) {
            answer[idx2] = arr[i];
            idx2 ++;
        }
        return answer;
    }
}
