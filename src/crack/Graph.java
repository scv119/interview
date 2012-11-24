package crack;

import java.util.*;

public class Graph{
    public boolean topologicSort_hard(int g[][], List<Integer> ret) {
        int size = g.length;
        int visit[] = new int[size];
        for (int node = 0; node < size; node ++) {
            if (visit[node] != 0)
                continue;
            if (!dfs(node, g, ret, visit))
                return false;
        }
        return true;
    }

    boolean dfs(int node, int[][] g, List<Integer> ret, int visit[]) {
        visit[node] = 1;
        for (int next = 0; next < g.length; next ++) {
            if (g[node][next] == 1 && visit[next] != 2)
                if (visit[next] == 1)
                    return false; 
                else if (!dfs(next, g, ret, visit))
                    return false;
        }
        visit[node] = 2;
        ret.add(node);
        return true;
    }

    public static void main(String args[]) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.clear();
        Graph g = new Graph();
        boolean ans = g.topologicSort_hard(new int[][]{new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{0, 0, 0}}, ret);
        System.out.println(ans);
        if (ans)
            System.out.println(Arrays.deepToString(ret.toArray()));
        int[] ret1 = g.dijkstra(new int[][]{new int[]{0, 10, Integer.MAX_VALUE}, new int[]{1, 0, Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, 1, 0}}, 1);
        for(int x : ret1)
        System.out.print(x + " ");
    }

    //unconnected is Integer.MAX_VALUE;
    public int[][] floyd(int [][] g) {
        int[][] ret = new int[g.length][g.length];
        for (int i = 0; i < g.length; i ++)
            for (int j = 0; j < g.length; j ++)
                ret[i][j] = g[i][j];

        for (int k = 0; k < g.length ; k ++) {
            for (int i = 0; i < g.length; i ++)
                for (int j = 0; j < g.length; j ++)
                    if (ret[i][k] != Integer.MAX_VALUE && ret[k][j] != Integer.MAX_VALUE && ret[i][j] > (ret[i][k] + ret[k][j]))
                        ret[i][j] = ret[i][k] + ret[k][j];
        }
        return ret;
    }

    class Item implements Comparable {
        int id;
        int dis;
        boolean visit = false;

        Item(int id, int dis) {this.id = id; this.dis = dis;}

        @Override
        public int compareTo(Object o) {
            Item item = (Item)o;
            return this.dis - item.dis;
        }
    }

    public int[] dijkstra(int[][] g, int id) {
        int len = g.length;
        Item items[] = new Item[len];
        TreeSet<Item> set = new TreeSet<Item>();
        for (int i = 0; i < len; i ++) {
            items[i] = new Item(i, Integer.MAX_VALUE);
            if (i == id)
                items[i].dis = 0;
            set.add(items[i]);
        }

        while (set.size() > 0) {
            Item item = set.first();
            set.remove(item);
            item.visit = true;
            if (item.dis == Integer.MAX_VALUE)
                break;
            for (int i = 0; i < len; i ++) {
                if (g[item.id][i] != Integer.MAX_VALUE && items[i].dis > g[item.id][i] + item.dis) {
                    items[i].dis = g[item.id][i] + item.dis;
                    if (items[i].visit == false) {
                        set.remove(items[i]);
                        set.add(items[i]);
                    }
                }
            }
        }

        int ret[] = new int[len];
        for (int i = 0; i < len; i ++)
            ret[i] = items[i].dis;
        return ret;
    }


}
