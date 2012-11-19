/**
* Created with IntelliJ IDEA.
* User: shenchen
* Date: 12-11-12
* Time: AM7:36
* To change this template use File | Settings | File Templates.
*/
import java.io.*;
import java.util.*;

public class TheBrandNewFunction implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new TheBrandNewFunction().run();
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

    void solve() throws IOException{
        int n = readInt();
        Set<Long> set = new HashSet<Long>();
        List<Long> list = new ArrayList<Long>();
        for (int i = 0; i < n; i ++) {
            long x= readLong();
            if (list.size() == 0 || x != list.get(list.size() - 1))  {
                set.add(x);
                list.add(x);
            }
        }


        while(list.size() != 1) {
            List<Long> tmp = new ArrayList<Long>();
            for (int i = 0; i < list.size() - 1; i ++) {
                long value = list.get(i) | list.get(i + 1);
                if (tmp.size() == 0 || tmp.get(tmp.size() - 1) != value) {
                    set.add(value);
                    tmp.add(value);
                }
            }
            list = tmp;
        }

        out.println(set.size());
    };

}