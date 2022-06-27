package de.unistuttgart.dsass2022.ex10.p6;

/**
 * Abstract class that realizes an key value pair class and suggests using an
 * array as the basic data structure for implementing hash maps.
 * 
 *
 * @param <V> the type of the values to be stored in the map
 */
public abstract class AbstractHashMap<V>
implements IHashMap<V>, Iterable<AbstractHashMap.KeyValuePair<V>> {

	protected KeyValuePair<V> map[];

	/**
	 * Key-value pairs are the entries in the hash map. The key is expected to be
	 * an integer and value is of generic type V.
	 *
	 * @param <V> the type of the value
	 */
	public static final class KeyValuePair<V> {

		private final int key;
		private final V value;

		/**
		 * Create a new key value pair.
		 * 
		 * @param key   key for the key value pair; cannot be null
		 * @param value the value associated with the given key
		 */
		public KeyValuePair(int key, V value) {
			this.key = key;
			this.value = value;
		}

		/**
		 * Gets the key of the pair
		 * 
		 * @return the key
		 */
		public int getKey() {
			return this.key;
		}

		/**
		 * Gets the value of the pair
		 * 
		 * @return the value
		 */
		public V getValue() {
			return this.value;
		}
	}
}
