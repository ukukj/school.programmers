package LV2;

public class 프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] table = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                table[i][j] = board[i].charAt(j);
            }
        }
        while (true) {
            boolean[][] remove = new boolean[m][n];
            int removedThisRound = 0;
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    char c = table[i][j];
                    if (c == table[i][j+1] && c == table[i+1][j] && c == table[i+1][j+1]) {
                        remove[i][j] = true;
                        remove[i][j+1] = true;
                        remove[i+1][j] = true;
                        remove[i+1][j+1] = true;
                    }
                }
            }
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (remove[i][j] && table[i][j] != '0') {
                        table[i][j] = '0';
                        removedThisRound ++;
                    }
                }
            }

            if (removedThisRound == 0) break;

            answer += removedThisRound;

            /**
             c c b d e
             a a a d e
             a a a b f
             c c b b f
             **/
            for (int col=0; col<n; col++) {
                int writeRow = m-1;
                for (int row=m-1; row>=0; row--) {
                    if (table[row][col] != '0') {
                        table[writeRow][col] = table[row][col];
                        if (writeRow != row) table[row][col] = '0';
                        writeRow--;
                    }
                }
            }
        }
        return answer;
    }
}
