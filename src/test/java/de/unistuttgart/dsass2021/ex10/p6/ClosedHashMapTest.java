package de.unistuttgart.dsass2021.ex10.p6;

import de.unistuttgart.dsass2022.ex10.p6.ClosedHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClosedHashMapTest {

    @Test
    public void test() {
        ClosedHashMap<Integer> map = new ClosedHashMap<>();

        map.put(4, 2457);
        map.put(23, 2345);
        map.put(23, 6);
        map.put(12, 6);
        map.put(33, 6);
        map.put(11, 6);
        map.put(3, 6);
        map.put(7, 6);
        map.put(123, 6);
        map.put(9, 6);
        map.put(2, 6);
        map.put(15, 6);
        map.put(21, 6);
        map.put(22, 6);
        map.put(14, 6);
        map.put(18, 6);
        map.put(17, 6);
        map.put(99, 6);
        map.put(101, 6);

        assertTrue(map.containsKey(23));
        assertFalse(map.containsKey(45));

        assertEquals(2457, (int) map.get(4));
        assertEquals(6, (int) map.get(23));

        // high capacity test
        for (int i = 200; i < 10000000; i++) {
            map.put(i, i/3);
        }
        for (int i = 200; i < 10000000; i++) {
            assertTrue(map.containsKey(i));
        }
        for (int i = 200; i < 10000000; i++) {
            assertEquals(i/3, (int) map.get(i));
        }
    }

}
