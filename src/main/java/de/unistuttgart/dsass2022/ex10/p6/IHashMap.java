package de.unistuttgart.dsass2022.ex10.p6;

/**
 * Basic interface of a hash map that expects integer keys and a
 * value of type V.
 *
 * @param <V> the type of the value
 */
public interface IHashMap<V> {

	/**
	 * Adds a value with the given key to the hash map if enough space is
	 * available. Returns a the previous value if the hash map contained one with
	 * the same key. If the underlying array exeeds a certain threshold percentage,
	 * the map is rehashed into a bigger array, at least of double the size of the old
	 * one. Quadratic probing should be used.
	 * 
	 * @param key   current key
	 * @param value current value
	 * @return previous value if present, null otherwise
	 */
	public V put(int key, V value) throws IllegalStateException;

	/**
	 * Tests whether the hash map contains a given key or not.
	 * 
	 * @param key current key
	 * @return whether the hash map contains a given key or not
	 */
	public boolean containsKey(int key);

	/**
	 * Gets the value of a specified key if present, null otherwise.
	 * 
	 * @param key current key
	 * @return the value or null
	 */
	public V get(int key);

}
