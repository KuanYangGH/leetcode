package hard.question146;

import java.util.LinkedHashMap;

/**
 * LRU Cache
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key
 * if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * Example:
 * LRUCache cache = new LRUCache( 2  capacity );
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * * Your LRUCache object will be instantiated and called as such:
 * * LRUCache obj = new LRUCache(capacity);
 * * int param_1 = obj.get(key);
 * * obj.put(key,value);
 *
 * @author yangkuan
 */
public class LRUCache {
    private LinkedHashMap<Integer, Integer> cache = null;
    private int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, (float) 0.75, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        // 如果包含键，就返回键值，并删除该（key，value）添加到队尾
        if (cache.containsKey(key)) {
            int val = cache.get(key);
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (cache.size() == capacity && !cache.containsKey(key)) {
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 6);
        cache.put(1, 2);
        cache.put(1, 5);
        System.out.println(cache.get(6));
    }
}
