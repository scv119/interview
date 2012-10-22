package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: PM2:22
 * To change this template use File | Settings | File Templates.
 */
/*
if you have a grid
a b c e
d f a h
i j k l

and a dictionary with more than 10K words
print out all words in dictionary that can be obtained by visiting grid.

restriction: if a word is c1, c2, ..., cn, then c_(i+1) should be one of the
eight neighbors of c_i in the grid

*/

public class TRIE {
    static class Node {
        boolean isWord = false;
        char value;
        Node[] children = new Node[26];

        boolean isWord() {
            return this.isWord;
        }

        Node next(char c) {
            return children[c - 'a'];
        }
    }

    Node root;

    public TRIE() {
        root = new Node();
        root.value = '#';
    }

    public void addWord(String s) {
        Node now = root;

        for(int i = 0; i < s.length(); i++ ) {
            char c = s.charAt(i);
            if(now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new Node();
                now.children[c - 'a'].value = c;
            }
            now = now.children[c - 'a'];
        }

        now.isWord = true;
    }

    public static List<String> solve(List<String> dictionary, char [][] matrix) {
        TRIE trie = new TRIE();
        for(String s : dictionary) {
            trie.addWord(s);
        }

        List<String> result = new ArrayList<String>();

        int xLen = matrix.length;
        int yLen = matrix[0].length;

        boolean[][] visited = new boolean[xLen][yLen];

        for(int i = 0; i < xLen; i ++) {
            for(int j = 0; j < yLen; j ++) {
                visited[i][j] = true;

                Node now = trie.root.next(matrix[i][j]);
                if(now != null)
                    dfs(matrix, visited, i, j, now, result);

                visited[i][j] = false;
            }
        }
        return result;
    }

    public static void dfs(char[][] matrix, boolean[][] visited, int i, int j, Node cur, List<String> result) {
        //
    }



}