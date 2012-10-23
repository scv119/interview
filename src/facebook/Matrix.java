package facebook;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-23
 * Time: PM11:21
 * To change this template use File | Settings | File Templates.
 */
public class Matrix {
    public static void print(int n) {
        int [][] matrix = new int[n][n];
        int num = (n + 1)/2;
        int start = 1;
        for(int i = 0; i < num; i ++) {
            start = start + printSub(matrix, i,  i, n - i * 2, start );
        }
        for(int i = 0 ; i < n; i ++) {
            for(int j = 0; j < n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }

    }

    private static int printSub(int[][] matrix, int x, int y, int len, int start) {
        if(len == 1) {
            matrix[x][y] = start;
            return 1;
        }

        if(len == 2) {
            matrix[x][y] = start;
            matrix[x][y+1] = start + 1;
            matrix[x+1][y+1] = start + 2;
            matrix[x+1][y] =start + 3;
            return 4;
        }

        for(int i = 0 ; i <len; i ++) {
            matrix[x][y+i] = start ++;
        }

        for(int i = 1 ; i < len - 1; i ++) {
            matrix[x+i][y+len-1] = start ++;
        }

        for(int i = 0 ; i < len; i ++) {
            matrix[x+len-1][y+len-1-i] = start ++;
        }

        for(int i = 1; i < len - 1; i ++ ) {
            matrix[x + len - 1 - i][y] = start ++;
        }

        return len * 4 - 4;

    }

    public static void main(String args[]) {
        for(int i = 1; i < 10; i ++) {
            print(i);
        }
    }
}