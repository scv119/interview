package leetcode;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/12/12
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordSearch {
    int n;
    int m;
    boolean v[][];
    char word[];
    char board[][];

    private static final int[] next = new int []{0, 1, 1, 0, 0, -1, -1, 0  };

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        v = new boolean[n][m];
        this.board = board;
        this.word = word.toCharArray();

        if (word.length() == 0)
            return true;

        for (int i = 0; i < n; i ++)
            for (int j = 0; j < m; j ++) {
                if (solve(i, j, 0))
                    return true;
            }

        return false;
    }

    boolean solve (int x, int y, int idx) {
        if (idx == word.length)
            return true;

        if (x < 0 || x >= n || y < 0 || y >= m ||board[x][y] != word[idx] || v[x][y])
            return false;

        boolean ret = false;
        v[x][y] = true;

        for (int i = 0; i < 4; i ++) {
            ret = solve(x + next[i * 2], y + next[i * 2 + 1], idx + 1);
            if (ret)
                break;
        }

        v[x][y] = false;

        return ret;
    }

    public static void main(String args[]) {
        String []arr = "asdf.asdf".split("\\.");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}
