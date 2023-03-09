package LeetCode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 手写HashMap
 */
public class No706 {
    private class Pair{
        private int value;
        private int key;

        public Pair(int key, int value) {
            this.value = value;
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getKey() {
            return key;
        }

    }
    private static final int BASE = 769;
    private LinkedList[] list;
    public No706() {
        list = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            list[i] = new LinkedList<Pair>();
        }
    }

    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = list[h].iterator();
        // 如果找到对应的key值
        while (iterator.hasNext()){
            Pair pair = (Pair) iterator.next();
            if (pair.getKey() == key){
                pair.setValue(value);
                return;
            }
        }
        // 没有找到则新加入到其中
        list[h].offerLast(new Pair(key,value));
    }

    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = list[h].iterator();
        // 如果找到对应的key值
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if (pair.getKey() == key){
                return pair.value;
            }
        }
        // 没有找到则新加入到其中
       return -1;
    }

    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = list[h].iterator();
        // 如果找到对应的key值
        while (iterator.hasNext()){
            Pair pair = iterator.next();
            if (pair.key == key){
                list[h].remove(pair);
                return;
            }
        }
    }

    public static int hash(int key){
        return key % BASE;
    }
}
