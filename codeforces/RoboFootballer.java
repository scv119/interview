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

public class RoboFootballer implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new RoboFootballer().run();
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

    final double esp = 0.00000001d;
    void solve() throws IOException{

        double y1 = readInt();
        double y2 = readInt();
        double yw = readInt();
        double xb = readInt();
        double yb = readInt();
        double r = readInt();

        double xc = xb;
        double yy = yw - r;
        double yc = yy + (yy - yb);


        double dis2 = Math.sqrt(xc * xc + (yc - y2) * (yc - y2));
        double dis1 = Math.sqrt(xc * xc + (yc - y1) * (yc - y1));
        double arc2 = Math.atan(xc / (yc - y2)) - Math.asin(r / dis2);
        double arc1 = Math.atan(xc / (yc - y1) + Math.asin(r/dis1));

        if (arc1 >= (arc2 - esp)) {
            out.println(-1);
            return;
        }

        double ymid = (y1 + y2)/2;
        double xw  = (yy - ymid) / (yc - ymid) * xc;
        out.println(xw);

    };

}