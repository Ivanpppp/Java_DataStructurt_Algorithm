package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;


/**
 * 手写HashSet
 */
public class No705 {
    private static final int BASE = 769; //取一个质数，方便进行相关操作
    private final LinkedList[] data;

    public No705() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer e = (Integer) iterator.next();
            if (e == key) return;
        }
        data[h].offerLast(key);
    }

    public void remove(int key){
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Integer e = (Integer) iterator.next();
            if (e == key) {
                data[h].remove(e);
                return;
            }
        }
    }

    public boolean contains(int key){
        int h = hash(key);
        Iterator iterator = data[h].iterator();
        while (iterator.hasNext()){
            if (key == (Integer)iterator.next()) {
                return true;
            }
        }
        return false;
    }

    public int hash(int k) {
        return k % BASE;
    }

}
