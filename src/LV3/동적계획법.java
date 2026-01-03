package LV3;

public class 동적계획법 {
    public int solution(int[][] triangle) {
        for (int i=1; i<triangle.length; i++) {
            for (int j=0; j<triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                }
                else if (j == triangle[i].length -1) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                }
                else {
                    int a = triangle[i-1][j-1];
                    int b = triangle[i-1][j];
                    if (a>=b) triangle[i][j] = a + triangle[i][j];
                    else triangle[i][j] = b + triangle[i][j];
                }

            }
        }
        int max = 0;
        for (int num : triangle[triangle.length-1]) {
            if (num > max) max = num;
        }
        return max;
    }
}
