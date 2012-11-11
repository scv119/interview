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

public class XorSegment implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new XorSegment().run();
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
        Node root = build(1, n);
        for (int i = 0; i < n; i ++) {
            int value = readInt();
            set(root, i + 1, toBits(value));
        }

        int k = readInt();

        for (int i = 0 ; i < k ; i ++) {
            int type = readInt();
            if (type == 1) {
                int sum[] = sum(root, readInt(), readInt());
                long ret = 0;
                long x = 1;
                for (int j = 0; j < 32; j ++) {
                    ret += x * sum[j];
                    x = x << 1;
                }
                out.println(ret);

            } else {
                xor(root, readInt(), readInt(), readInt());
            }
        }

    };

    class Node {
        int[] bits = new int[32];
        int   carry = -1;

        int start;
        int mid;
        int end;

        Node left;
        Node right;
    }

    Node build(int s, int e) {
        Node node = new Node();
        node.start = s;
        node.mid   = (s + e)/2;
        node.end   = e;
        if (s == e)
            return node;
        node.left = build(s, node.mid);
        node.right = build(node.mid + 1, e);
        return node;
    }

    int[] toBits(int x) {
        int[] ret = new int[32];
        for (int i = 0 ; i < 32; i ++) {
            if (x == 0)
                break;
            ret[i] = x % 2;
            x = x/2;
        }
        return ret;
    }

    void add(int []b1, int []b2) {
        for (int i = 0; i < 32; i ++) {
            b1[i] += b2[i];
        }
    }

    void set(Node n, int k, int[] bits) {
        add(n.bits, bits);
        if (n.start == n.end)
            return;
        if (k <= n.mid)
            set(n.left, k, bits);
        else
            set(n.right, k, bits);
    }

    int[] xor(Node n, int s, int e, int value) {
        int []ret = new int[32];
        if (s == n.start && e == n.end) {
            int bits[]  = toBits(value);
            int count = e - s + 1;
            for (int i = 0; i < 32; i ++) {
                if (bits[i] == 1) {
                    int tmp = count - n.bits[i];
                    ret[i] =  tmp - n.bits[i];
                    n.bits[i] = tmp;
                }
            }
            if (n.carry == -1)
                n.carry = value;
            else
                n.carry ^= value;
        } else {
            if (n.carry != -1) {
                xor(n.left, n.left.start,  n.left.end, n.carry);
                xor(n.right, n.right.start, n.right.end, n.carry);
                n.carry = -1;
            }
            if (e <= n.mid) {
                ret = xor(n.left, s, e, value);
            } else if (s > n.mid) {
                ret = xor(n.right, s, e, value);
            } else {
                add(ret, xor(n.left, s, n.mid, value));
                add(ret, xor(n.right, n.mid + 1, e, value));
            }

            for (int i = 0; i < 32; i ++) {
                n.bits[i] += ret[i];
            }
        }

        return ret;
    }

    int[] sum(Node n, int s, int e) {
        int ret[] = new int[32];

        if (s == n.start && e == n.end)
            add(ret, n.bits);
        else {
            if (n.carry != -1) {
                xor(n.left, n.left.start,  n.left.end, n.carry);
                xor(n.right, n.right.start, n.right.end, n.carry);
                n.carry = -1;
            }

            if (e <= n.mid) {
                ret = sum(n.left, s, e);
            } else if (s > n.mid) {
                ret = sum(n.right, s, e);
            } else {
                add(ret, sum(n.left, s, n.mid));
                add(ret, sum(n.right, n.mid + 1, e));
            }
        }
        return ret;
    }

}