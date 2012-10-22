package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 12-10-22
 * Time: AM4:35
 * To change this template use File | Settings | File Templates.
 */
/*
    implement of hashmap
*/

public class HashMap<K, V> {
    private static final int DEFAULT_LEN = 10;
    private static final float RATE       = 0.8f;

    private int size;
    private int arrLen;
    private int capacity;
    private List[] arr;

    public HashMap() {
        size = 0;
        arrLen = DEFAULT_LEN;
        capacity = (int)(RATE * DEFAULT_LEN);
        arr = new List[arrLen];
    }

    public boolean put(K key, V value) {
        size ++;
        int hashcode = key.hashCode();
        int idx = hashcode%arrLen;
        if(arr[idx] == null)
            arr[idx] = new ArrayList();

        for(Object o : arr[idx]) {
            Pair pair = (Pair) o;
            K key1 = (K) pair.key;

            if(key.equals(key1))
                return  false;
        }

        Pair<K,V> pair = new Pair<K, V>();
        pair.key = key;
        pair.value = value;
        arr[idx].add(pair);
        resize();

        return  true;
    }

    public V get(K key) {
        V ret = null;
        int hashcode = key.hashCode();
        int idx = hashcode%arrLen;
        if(arr[idx] != null) {
            for(Object o : arr[idx]) {
                Pair pair = (Pair) o;
                if(pair.key.equals(key)) {
                    ret = (V)pair.value;
                    break;
                }
            }
        }
        return ret;
    }

    public int size() {
        return size;
    }

    private void resize() {
        if(size < capacity)
            return;
        arrLen = arrLen * 2;
        capacity = (int)(RATE * arrLen);
        List[] tmp = new List[arrLen];

        for(List list : arr) {
            if(list == null)
                continue;
            for(Object o : list) {
                Pair pair = (Pair) o;
                K key = (K) pair.key;

                int hashCode = key.hashCode();
                int idx = hashCode%arrLen;
                if(tmp[idx] == null)
                    tmp[idx] = new ArrayList();
                tmp[idx].add(pair);
            }
        }

        arr = tmp;

    }




    static class Pair<K, V>{
        K key;
        V value;
    }

    public static void main(String args[]) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < 10000; i ++) {
            map.put(i, i);
        }
        System.out.println(map.get(100));
    }

    public static long BKDRHash(String s) {
        long seed = 131;
        long hash = 0;
        for(int i = 0 ; i < s.length() ;i ++ ) {
            hash = (hash * seed) + s.charAt(i);
        }
        return hash;
    }

}