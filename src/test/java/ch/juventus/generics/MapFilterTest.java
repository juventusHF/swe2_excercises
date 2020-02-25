package ch.juventus.generics;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapFilterTest {

    private final MapFilter mapFilter = new MapFilter();

    @Test
    public void testCleanup() {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "A");
        map.put(1, "B");
        map.put(2, "C");
        map.put(3, "D");
        map.put(4, "B");

        Map<Integer, String> filteredMap = mapFilter.cleanup(map, "B");

        assertEquals(2, filteredMap.size());
    }
}
