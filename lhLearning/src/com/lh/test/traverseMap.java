package com.lh.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description: 遍历Map
 * @author LuoH
 * @date 2019/11/7
 */
public class traverseMap {
    public static void main(String[] args)
    {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("key", "value");
        hm.put("这是key","这是value");
        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String, String>> iter = entrySet.iterator();
        while (iter.hasNext())
        {
            Map.Entry<String, String> entry = iter.next();
            System.out.println(entry.getKey() + "\t" + entry.getValue());
        }
    }

}
