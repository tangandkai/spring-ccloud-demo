package com.tang.cloud.common.cache;

public class LTRTest {

    public static void main(String[] args) {
        int i=20;
        while (i>0){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    LRU.getInstance(10);
                }
            }).start();
            i--;
        }
    }
}
