package LV2;

public class 쿼드압후개수세기 {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int startRow, int startCol, int size) {
        int comp = arr[startRow][startCol];
        boolean isSame = true;
        for (int i=startRow; i<startRow+size; i++) {
            if (!isSame) break;
            for (int j=startCol; j<startCol+size; j++) {
                if (comp != arr[i][j]) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            answer[comp]++;
            return;
        }
        int half = size/2;
        compress(arr, startRow, startCol, half);
        compress(arr, startRow, startCol+half, half);
        compress(arr, startRow+half, startCol, half);
        compress(arr, startRow+half, startCol+half, half);
    }
}
