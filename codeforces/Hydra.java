/**
* Created with IntelliJ IDEA.
* User: shenchen
* Date: 12-11-12
* Time: AM7:36
* To change this template use File | Settings | File Templates.
*/
import java.awt.image.AreaAveragingScaleFilter;
import java.io.*;
import java.util.*;

public class Hydra implements Runnable {

    BufferedReader in;
    PrintWriter out;
    StringTokenizer tok = new StringTokenizer("");

    public static void main(String[] args) {
        new Hydra().run();
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
        int m = readInt();
        int h = readInt();
        int t = readInt();

        int hs = Math.min(h, t);
        int tm = Math.max(h, t);


        final Node[] nodes = new Node[n + 1];
        Edge[] edges = new Edge[m + 1];

        for (int i = 1; i <= n; i ++)  {
            nodes[i] = new Node(i);
        }

        for (int i = 1; i <= m; i ++) {
            edges[i] = new Edge();
            int x = readInt();
            int y = readInt();
            if (x > y)
                x = x + y - (y = x);
            edges[i].x = x;
            edges[i].y = y;
            nodes[x].edges.add(y);
            nodes[y].edges.add(x);
        }

        List<Edge> good = new ArrayList<Edge>();
        for (Edge edge : edges) {
            int size1 = nodes[edge.x].edges.size();
            int size2 = nodes[edge.y].edges.size();
            if (size1 > size2)
                size1 = (size2 + size1) - (size2 = size1);

            if (size1 < hs + 1 || size2 < tm + 1)
                continue;

            good.add(edge);
        }

        Collections.sort(good, new Comparator<Edge>() {
            @Override
            public int compare(Edge edge, Edge edge1) {
                return (nodes[edge.x].edges.size() + nodes[edge.y].edges.size()) - (nodes[edge1.x].edges.size() + nodes[edge1.y].edges.size());
            }
        });

        for (int i = good.size() - 1; i >= 0; i --) {
            Edge edge = good.get(i);

            if (Math.max(nodes[edge.x].edges.size(), nodes[edge.y].edges.size()) > (h + t + 2)) {
                Node nodeBig = null;
                Node nodeSmall = null;
                Set<Integer> edgeSmall = new HashSet<Integer>() ;
                Set<Integer> edgeBig = new HashSet<Integer>() ;
                if (nodes[edge.x].edges.size() > h + t + 2) {
                    nodeBig = nodes[edge.x];
                    nodeSmall = nodes[edge.y];
                } else {
                    nodeBig = nodes[edge.y];
                    nodeSmall = nodes[edge.x];
                }

                for (Integer x : nodeSmall.edges) {

                    if (edgeSmall.size() == hs)
                        break;
                    if (x != nodeBig.id)
                        edgeSmall.add(x);
                }

                for (Integer y : nodeBig.edges) {

                    if (edgeBig.size() == tm)
                        break;
                    if (y != nodeSmall.id && !edgeSmall.contains(y))
                        edgeBig.add(y);
                }

                out.println("YES");
                if (hs == h) {
                    out.println(nodeSmall.id + " " + nodeBig.id);
                } else
                    out.println(nodeBig.id + " " + nodeSmall.id);


                StringBuilder sb = new StringBuilder();
                for (Integer x : edgeSmall) {
                    if (sb.length() != 0)
                        sb.append(" ");
                    sb.append(x);
                }
                String small = sb.toString();
                sb = new StringBuilder();
                for (Integer x : edgeBig) {
                    if (sb.length() != 0)
                        sb.append(" ");
                    sb.append(x);
                }
                String big = sb.toString();

                if (hs == h) {
                    out.println(small);
                    out.println(big);
                } else {
                    out.println(big);
                    out.println(small);
                }
                return;
            }

        }

         out.println("NO");

    };

    class Node {
        int id;
        List<Integer> edges;

        Node(int id) {
            this.id = id;
            edges = new ArrayList<Integer>();
        }
    }

    class Edge {
        int x;
        int y;

    }



}