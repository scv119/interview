package leetcode2;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 9:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ClimbStairs {
    public int climbStairs(int n) {
        if (n <= 2)
            return n;
        int m[][] = new int[2][2];
        m[0][1] = 1;
        m[1][0] = m[1][1] = 1;
        int ret[][] = new int[2][1];
        ret[0][0] = 1;
        ret[1][0] = 2;
        ret = multi(pow(m, n - 2), ret);
        return ret[1][0];
    }

    int[][] multi(int[][] matrix1, int[][] matrix2) {
        int ret[][] = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < ret.length; i ++)
            for (int j = 0; j < ret[0].length; j ++)
                for (int k = 0; j < matrix2.length; k ++) {
                    ret[i][j] += matrix1[i][k] * matrix2[k][j];
                }
        return ret;
    }

    int[][] clone(int[][] matrix) {
        int[][] ret = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < ret.length; i ++)
            for (int j = 0; j < ret[0].length; j ++)
                ret[i][j] = matrix[i][j];
        return ret;
    }

    int [][] pow(int[][] matrix, int n) {
        if (n == 0)
            return clone(matrix);
        int [][] c = clone(matrix);
        int [][] ret = null;
        while (n != 0) {
            if (n % 2 == 1) {
                if (ret == null)
                    ret = clone(c);
                else
                    ret = multi(ret, c);
            }
            n = n / 2;
            c = multi(c, c);
        }
        return ret;
    }

    public static void main(String args[]) {
        ClimbStairs cs = new ClimbStairs();
        cs.climbStairs(3);
    }
}
