/**
* Created with IntelliJ IDEA.
* User: shenchen
* Date: 12-11-12
* Time: AM7:36
* To change this template use File | Settings | File Templates.
*/
import java.io.*;
import java.util.*;

public class KingsPath implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new KingsPath().run();
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

    Set<pair> avail;
    Set<pair> visit;

    void solve() throws IOException {
        int x0, y0, x1, y1;
        x0 = readInt(); y0 = readInt(); x1 = readInt(); y1 = readInt();
        avail = new HashSet<pair>();
        visit = new HashSet<pair>();

        int n = readInt();
        for (int i = 0; i < n; i ++) {
            int r = readInt();
            int a = readInt();
            int b = readInt();
            for (int j = a; j <=b; j ++)
                avail.add(new pair(r, j));
        }

        Queue<Integer> q = new LinkedList<Integer>();
        avail.remove(new pair(x0, y0));
        q.add(x0);
        q.add(y0);
        q.add(0);
        int ret = -1;
        while (q.size() > 0) {
            int x = q.poll(); int y = q.poll(); int step = q.poll();
            if (x == x1 && y == y1)  {
                ret = step;
                break;
            }
            for (int j = -1; j <= 1; j ++ )
            for (int i = -1; i <= 1; i ++) {
                if (i == 0 && j == 0)
                    continue;
                int nx = x + i;
                int ny = y + j;
                pair p = new pair(nx, ny);
                if (avail.contains(p)) {
                    avail.remove(p);
                    q.add(nx);
                    q.add(ny);
                    q.add(step + 1);
                }
            }
        }
        out.println(ret);
    };

    class pair {
        int x;
        int y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof pair))
                return false;
            pair p1 = (pair)o;
            return p1.x == x && p1.y == y;
        }

        public int hashCode() {
            return x * 133 + y;
        }
    }

}