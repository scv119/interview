public class Solution {
    int next[] = new int[]{-1, 0, 1, 0, 0, 1, 0, -1};
    
    public void solve(char[][] board) {
        int xLen = board.length;
        if (xLen == 0)
            return;
        int yLen = board[0].length;
        
        if (xLen <= 1 || yLen <= 1)
            return;
        
        boolean v[][] = new boolean[xLen][yLen];
        boolean o[][] = new boolean[xLen][yLen];
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for (int i = 0; i < xLen; i ++) {
            if (!v[i][0]) {
                v[i][0] = true;
                if (board[i][0] == 'O') {
                    o[i][0] = true;
                    queue.add(i);
                    queue.add(0);
                }
            }
            
            if (!v[i][yLen - 1]) {
                v[i][yLen - 1] = true;
                if (board[i][yLen - 1] == 'O') {
                    o[i][yLen - 1] = true;
                    queue.add(i);
                    queue.add(yLen - 1);
                }
            }
        }
        
        
        for (int j = 0; j < yLen; j ++) {
            if (!v[0][j]) {
                v[0][j] = true;
                if (board[0][j] == 'O') {
                    o[0][j] = true;
                    queue.add(0);
                    queue.add(j);
                }
            }
            
             if (!v[xLen - 1][j]) {
                v[xLen - 1][j] = true;
                if (board[xLen - 1][j] == 'O') {
                    o[xLen - 1][j] = true;
                    queue.add(xLen - 1);
                    queue.add(j);
                }
            }
        }
        
        while (queue.size()!=0) {
            int x = queue.poll();
            int y = queue.poll();
            for (int i = 0; i < 4; i ++) {
                int xOff = next[i*2] + x;
                int yOff = next[i*2 + 1] + y;
                
                if (xOff < 0 || xOff >= xLen || yOff < 0 || yOff >= yLen || v[xOff][yOff])
                    continue;
                v[xOff][yOff] = true;
                if (board[xOff][yOff] == 'O') {
                    o[xOff][yOff] = true;
                    queue.add(xOff);
                    queue.add(yOff);
                }
            }
        }
        
        for (int i = 0; i < xLen; i ++)
            for (int j = 0; j < xLen; ++j) {
                board[i][j] = (o[i][j]? 'O' : 'X');
            }
    }
}
