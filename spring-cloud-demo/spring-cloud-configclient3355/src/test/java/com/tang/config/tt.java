package com.tang.config;

import java.util.HashMap;
import java.util.Map;

public class tt {
    public static void main(String[] args) {
        HashMap<MyM, MyM> map = new HashMap<MyM, MyM>(1);
        for (int i=0;i<100;i++){
            map.put(new MyM(),new MyM());
        }
        System.out.println("map length :"+map.size());
        System.out.println("map :"+map);
    }
}

class MyM<k,v> extends HashMap<k,v> {
    @Override
    public int hashCode() {
        return 1;
    }


}
