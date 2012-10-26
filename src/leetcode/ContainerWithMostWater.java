package leetcode;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-26
 * Time: PM9:48
 * To change this template use File | Settings | File Templates.
 */
public class ContainerWithMostWater {
    static class Line implements Comparable{
        int idx;
        int height;

        @Override
        public int compareTo(Object o) {
            return height - ((Line)o).height;
        }
    }

    public int maxArea(int[] height) {
        Line[] lines = new Line[height.length];
        for(int i = 0; i < height.length; i++) {
            lines[i] = new Line();
            lines[i].idx = i;
            lines[i].height = height[i];
        }

        Arrays.sort(lines);
        int min = 0;
        int max = 0;
        min = max = lines[lines.length - 1].idx;
        int ret = 0;
        for(int i = lines.length - 2; i >= 0; i --) {
            int idx = lines[i].idx;
            min = Math.min(idx, min);
            max = Math.max(idx, max);
            ret = Math.max(ret, Math.abs(idx - min) * lines[i].height);
            ret = Math.max(ret, Math.abs(max - idx) * lines[i].height);
        }

        return ret;

    }
}
