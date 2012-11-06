package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-11-6
 * Time: PM11:43
 * To change this template use File | Settings | File Templates.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n/2; i ++) {
            for (int j = i; j < n - 1 - i; j ++) {
                int value0 = matrix[i][j];
                int value1 = matrix[j][n - 1 - i];
                int value2 = matrix[n - 1 - i][n - 1 - j];
                int value3 = matrix[n - 1 - j][i];

                matrix[i][j] = value3;
                matrix[j][n - 1 - i] = value0;
                matrix[n - 1 - i][n - 1 - j] = value1;
                matrix[n - 1 - j][i] = value2;
            }
        }

    }
}
