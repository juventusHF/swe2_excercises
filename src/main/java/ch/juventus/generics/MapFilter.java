package ch.juventus.generics;

import java.util.Iterator;
import java.util.Map;

public class MapFilter {

    public <K, V> Map<K, V> cleanup(Map<K, V> map, V value) {
        Iterator<Map.Entry<K, V>> itr = map.entrySet().iterator();
        while(itr.hasNext()) {
            Map.Entry<K, V> entry = itr.next();
            if(entry.getValue() != value) {
                itr.remove();
            }
        }
        return map;
    }
}
