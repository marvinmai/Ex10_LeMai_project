package de.unistuttgart.dsass2022.ex10.p6;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * Realizes a basic hash map with closed hashing and quadratic probing. The hash
 * map is not expanded automatically on overflow. It extends
 * {@link AbstractHashMap} and uses its array of {@link KeyValuePair} as basic
 * data structure.
 *
 * @param <V> the type of the values to be added to the HashMap
 */
public class ClosedHashMap<V> extends AbstractHashMap<V> {

    private static final int DEFAULT_SIZE = 19;
	private static final double THRESHOLD = 0.9;

	private int fillCount = 0;

    /**
     * Initializes a ClosedHashMap with <code>DEFAULT_SIZE</code>
     *
     * @throws IllegalArgumentException
     */
    public ClosedHashMap() throws IllegalArgumentException {
        this(DEFAULT_SIZE);
    }

    /**
     * Initializes a ClosedHashMap with the defined size.
     * Size must be a prime congruent 3 mod 4.
     *
     * @param size the size of the map
     * @throws IllegalArgumentException
     */
    @SuppressWarnings("unchecked")
    public ClosedHashMap(int size) throws IllegalArgumentException {
        if (!isValidSize(size)) {
            throw new IllegalArgumentException("Invalid Size!");
        }
        this.map = new KeyValuePair[size];
    }

    @Override
    public V put(int key, V value) throws IllegalStateException {
        V previous = null;
        for (int i = 0; i < map.length; i++) {
            int index = quadraticProbing(key, i);
            if (map[index] == null) {
                map[index] = new KeyValuePair<>(key, value);
				fillCount++;
                break;
            } else if (map[index].getKey() == key) {
                previous = map[index].getValue();
                map[index] = new KeyValuePair<>(key, value);
                break;
            }
        }
        return previous;
    }

    @Override
    public boolean containsKey(int key) {
        for (int i = 0; i < map.length; i++) {
            int index = quadraticProbing(key, i);
            if (map[index] != null && map[index].getKey() == key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(int key) {
        for (int i = 0; i < map.length; i++) {
            int index = quadraticProbing(key, i);
            if (map[index] != null && map[index].getKey() == key) {
                return map[index].getValue();
            }
        }
        return null;
    }

    private int quadraticProbing(int key, int i) {
        int mod = (Integer.valueOf(key).hashCode() + (int) (Math.round(Math.pow(-1, i - 1) * Math.pow(i, 2)))) % map.length;
        return mod >= 0 ? mod : mod + map.length;
    }

    private boolean isValidSize(int size) {
        return size % 4 == 3 && isPrime(size);
    }

    private boolean isPrime(int number) {
        return number > 1
                && IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(n -> (number % n == 0));
    }

    public Iterator<KeyValuePair<V>> iterator() {
        return new Iterator<AbstractHashMap.KeyValuePair<V>>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                boolean result = false;
                int i = index;
                while (i < map.length && !result) {
                    result = (map[i] != null);
                    i++;
                }
                return result;
            }

            @Override
            public KeyValuePair<V> next() throws NoSuchElementException {
                int i = index;
                KeyValuePair<V> result = null;
                while (i < map.length && map[i] == null) {
                    index++;
                    i = index;
                }
                if (index >= map.length) {
                    throw new NoSuchElementException("No such element!");
                }
                result = map[i];
                index++;
                return result;
            }
        };
    }

}
