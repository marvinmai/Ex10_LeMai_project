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

        assertTrue(map.containsKey(23));
        assertFalse(map.containsKey(45));

        assertEquals(2457, (int) map.get(4));
        assertEquals(6, (int) map.get(23));

        System.out.println();
    }

}
