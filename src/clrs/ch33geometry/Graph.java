package clrs.ch33geometry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Graph {
    public boolean topologicSort(int[][] g, List<Integer> list) {
        int len = g.length;
        int color[] = new int[len];
        //0 white, 1 gray, 2 black
        for (int i = 0; i < len; i ++) 
            if (color[i] == 0)
            if (!dfs(g, i, color, list))
                return false;
        return true;
    }

    private boolean dfs(int[][]g, int node, int[] color, List<Integer>list) {
        color[node] = 1;
        for (int i = 0; i < g.length; i ++) {
            if (g[node][i] == 1 && color[i] != 2) {
                if (color[i] == 1)
                    return false;
                if (!dfs(g, i, color, list))
                    return false;
            }
        }
        color[node] = 2;
        list.add(node);
        return true;
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


    public static void main(String args[]) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.clear();
        Graph g = new Graph();
        boolean ans = g.topologicSort(new int[][]{new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{0, 0, 0}}, ret);
        System.out.println(ans);
        if (ans)
            System.out.println(Arrays.deepToString(ret.toArray()));
        int[] ret1 = g.dijkstra(new int[][]{new int[]{0, 10, Integer.MAX_VALUE}, new int[]{1, 0, Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, 1, 0}}, 1);
        for(int x : ret1)
            System.out.print(x + " ");
    }
}
