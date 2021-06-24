package com.tang.cloud.common.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * lru是一种缓存淘汰算法
 * 最近最少使用的数据被淘汰
 * 通常采用LinkedHashMap作为实现
 * public LinkedHashMap(int initialCapacity,
 *                          float loadFactor,
 *                          boolean accessOrder) {
 *         super(initialCapacity, loadFactor);
 *         this.accessOrder = accessOrder;
 *     }
 * accessOrder：为true表示按照对象的访问顺序排序
 *              为false表示按照对象的插入顺序排序
 */
public class LRU extends LinkedHashMap{

    private static int initialCapacity = 16;
    private static float loadFactor = 0.75f;
    private static boolean accessOrder = true;

    private static volatile LRU lru;


    private LRU(int initialCapacity){
        super(initialCapacity,loadFactor,accessOrder);
        this.initialCapacity = initialCapacity;
    }

    public static LRU getInstance(int initialCapacity){
        if (lru==null){
            synchronized (LRU.class){
                if (lru==null){
                    System.out.println("init the instance.................."+Thread.currentThread().getName());
                    lru = new LRU(initialCapacity);
                }
            }
        }
        return lru;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest){
        return size()>initialCapacity;
    }
}
