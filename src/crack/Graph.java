package crack;

import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

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
//        List<Integer> ret = new ArrayList<Integer>();
//        ret.clear();
        Graph g = new Graph();
//        boolean ans = g.topologicSort_hard(new int[][]{new int[]{0, 1, 1}, new int[]{0, 0, 1}, new int[]{0, 0, 0}}, ret);
//        System.out.println(ans);
//        if (ans)
//            System.out.println(Arrays.deepToString(ret.toArray()));
        int[] ret = g.dijkstra_hard(new int[][]{new int[]{0, 10, Integer.MAX_VALUE}, new int[]{1, 0, Integer.MAX_VALUE}, new int[]{Integer.MAX_VALUE, 1, 0}}, 0);
        for(int x : ret)
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

    public int[] dijkstra_hard(int[][] g, int start) {
        int len = g.length;
        int []ret = new int[len];
        boolean v[] = new boolean[len];
        Arrays.fill(v, false);
        Arrays.fill(ret, Integer.MAX_VALUE);
        ret[start]   = 0;
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < len; i ++)
            map.put(i, ret[i]);
        while (map.size() > 0) {
            int id = map.firstKey();
            int val = map.get(id);
            if (val == Integer.MAX_VALUE)
                break;
            map.remove(id);
            v[id] = true;
            for (int i = 0; i < len; i ++) {
                if (g[id][i] != Integer.MAX_VALUE && ret[i] > val + g[id][i]) {
                    ret[i] = val + g[id][i];
                    if (!v[i]) {
                        map.remove(i);
                        map.put(i, ret[i]);
                    }
                }
            }
        }
        return ret;
    }



}
