/**
* Created with IntelliJ IDEA.
* User: shenchen
* Date: 12-11-12
* Time: AM7:36
* To change this template use File | Settings | File Templates.
*/
import java.io.*;
import java.util.Locale;
import java.util.StringTokenizer;

public class PlayingWithPermutations implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new PlayingWithPermutations().run();
    }

    public void run() {
        try {
            long t1 = System.currentTimeMillis();
            if (System.getProperty("ONLINE_JUDGE") != null) {
                in = new BufferedReader(new InputStreamReader(System.in));
                out = new PrintWriter(System.out);
            } else {
                in = new BufferedReader(new FileReader("/Users/shenchen/input.txt"));
                out = new PrintWriter("/Users/shenchen/output.txt");
            }
            Locale.setDefault(Locale.US);
            solve();
            in.close();
            out.close();
            long t2 = System.currentTimeMillis();
            System.err.println("Time = " + (t2 - t1));
        } catch (Throwable t) {
            t.printStackTrace(System.err);
            System.exit(-1);
        }
    }

    String readString() throws IOException {
        while (!tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }

    void solve() throws IOException {
        int n = readInt();
        int k = readInt();
        int q[][] = new int[n][n];
        int s[][] = new int[n][n];
        int dig[][] = new int[n][n];
        for (int i = 0; i < n; i ++)
            dig[i][i] = 1;
        for (int i = 0; i < n; i ++)
            q[i][readInt()-1] = 1;
        for (int i = 0; i < n; i ++)
            s[i][readInt()-1] = 1;
        int qr[][] = reverse(q);
        int match = -1;
        if (equal(dig, s)) {
            out.println("NO");
            return;
        }

        int[][] tmp = clone(dig);
        for (int i = 1; i <= k; i ++) {
            tmp = multi(tmp, q);
            if (equal(tmp, s)) {
                match = i;
                break;
            }
        }

        if (match != -1 && match <= k && (k - match) % 2 == 0) {
            out.println("YES");
            return;
        }

        tmp = clone(dig);
        for (int i = 1; i <= k; i ++) {
            tmp = multi(tmp, qr);
            if (equal(tmp, s)) {
                match = i;
                break;
            }
        }

        if (match != -1 && match <= k && (k - match) % 2 == 0) {
            out.println("YES");
            return;
        }

        out.println("NO");
        return;
    };

    int[][] clone(int [][] matrix) {
        int x = matrix.length;
        int ret[][] = new int[x][x];
        for (int i = 0; i < x; i ++)
            for (int j = 0; j < x; j ++)
                ret[i][j] = matrix[i][j];
        return ret;
    }

    int[][] multi(int[][]m1, int[][]m2) {
        int len = m1.length;
        int ret[][] = new int[len][len];
        for (int i = 0; i < len; i ++)
            for (int j = 0; j < len; j ++)
                for (int k = 0; k < len; k ++)
                    ret[i][j] += m1[i][k] * m2[k][j];
        return ret;
    }

    boolean equal(int[][] m1, int [][] m2) {
        int len = m1.length;
        for (int i = 0; i < len; i ++ )
            for (int j = 0; j < len; j ++)
                if (m1[i][j] != m2[i][j])
                    return false;
        return true;
    }

    int[][] reverse(int[][] m) {
        int len = m.length;
        int[][] ret = new int[len][len];
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < len; j ++)
                if (m[i][j] == 1)
                    ret[j][i] = 1;
        }
        return ret;
    }

}