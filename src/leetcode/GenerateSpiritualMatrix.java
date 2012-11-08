package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-8
 * Time: AM8:04
 * To change this template use File | Settings | File Templates.
 */
public class GenerateSpiritualMatrix {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int len = n;
        int start = 1;

        for (int i = 0; i < (n + 1)/2; i ++) {
            if (len == 1) {
                matrix[i][i] = start ++;
                break;
            }

            for (int j = i; j < i + len - 1; j ++)
                matrix[i][j] = start ++;

            for (int j = i; j < i + len - 1; j ++)
                matrix[j][n - 1 - i] = start ++;

            for (int j = i; j < i + len - 1; j ++)
                matrix[n - 1 - i][n - 1 - j] = start ++;

            for (int j = i; j < i + len - 1; j ++)
                matrix[n - 1 - j][i] = start ++;

            len = len - 2;
        }
        return matrix;
    }
}
