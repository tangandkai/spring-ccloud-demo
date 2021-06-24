package com.tang.cloud.common.cache;

import cn.hutool.core.lang.UUID;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;

public class GuaCache {

    public static void main(String[] args) throws ExecutionException {

        LoadingCache<String, String> cache = CacheBuilder.newBuilder().concurrencyLevel(3).build(new CacheLoader<String, String>() {
            @Override
            public String load(String s) throws Exception {
                System.out.println("start get cache............");
                return slowMethod(s);
            }
        });

        int i = 10;
        while (i>0){
            String hello = cache.get("hello");
            System.out.println(hello);
            if (i==5){
                cache.invalidate("hello");
            }
            i--;
        }

    }

    private static String slowMethod(String key) throws Exception {
        Thread.sleep(4000);
        return key + ".result"+ UUID.fastUUID().toString();
    }
}
