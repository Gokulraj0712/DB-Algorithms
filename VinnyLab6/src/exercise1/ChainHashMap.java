/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package exercise1;

import java.util.ArrayList;
import java.util.Random;

/*
 * Map implementation using hash table with separate chaining.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class ChainHashMap<K,V> extends AbstractHashMap<K,V> {
  // a fixed capacity array of UnsortedTableMap that serve as buckets
  private UnsortedTableMap<K,V>[] table;   // initialized within createTable

  // provide same constructors as base class
  /** Creates a hash table with capacity 11 and prime factor 109345121. */
  public ChainHashMap(double loadFactor) {
	    super(loadFactor);
  }
  /** Creates a hash table with given capacity and prime factor 109345121. */
  public ChainHashMap(int cap, double loadFactor) {
	    super(cap, loadFactor);
	  }

  /** Creates a hash table with the given capacity and prime factor. */
  public ChainHashMap(int cap, int p, double loadFactor) {
	    super(cap, p, loadFactor);
	  }

  /** Creates an empty table having length equal to current capacity. */
  @Override
  @SuppressWarnings({"unchecked"})
  protected void createTable() {
    table = (UnsortedTableMap<K,V>[]) new UnsortedTableMap[capacity];
  }

  /**
   * Returns value associated with key k in bucket with hash value h.
   * If no such entry exists, returns null.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @return   associate value (or null, if no such entry)
   */
  @Override
  protected V bucketGet(int h, K k) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null) return null;
    return bucket.get(k);
  }

  /**
   * Associates key k with value v in bucket with hash value h, returning
   * the previously associated value, if any.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @param v  the value to be associated
   * @return   previous value associated with k (or null, if no such entry)
   */
  @Override
  protected V bucketPut(int h, K k, V v) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null)
      bucket = table[h] = new UnsortedTableMap<>();
    int oldSize = bucket.size();
    V answer = bucket.put(k,v);
    n += (bucket.size() - oldSize);   // size may have increased
    return answer;
  }

  /**
   * Removes entry having key k from bucket with hash value h, returning
   * the previously associated value, if found.
   * @param h  the hash value of the relevant bucket
   * @param k  the key of interest
   * @return   previous value associated with k (or null, if no such entry)
   */
  @Override
  protected V bucketRemove(int h, K k) {
    UnsortedTableMap<K,V> bucket = table[h];
    if (bucket == null) return null;
    int oldSize = bucket.size();
    V answer = bucket.remove(k);
    n -= (oldSize - bucket.size());   // size may have decreased
    return answer;
  }

  /**
   * Returns an iterable collection of all key-value entries of the map.
   *
   * @return iterable collection of the map's entries
   */
  @Override
  public Iterable<Entry<K,V>> entrySet() {
    ArrayList<Entry<K,V>> buffer = new ArrayList<>();
    for (int h=0; h < capacity; h++)
      if (table[h] != null)
        for (Entry<K,V> entry : table[h].entrySet())
          buffer.add(entry);
    return buffer;
  }
  public static void main(String[] args) {
	    Random rand = new Random();

	    int n = 10000; // size of the key set
	    int numTrials = 10; // number of trials
	    double[] maxLoadFactors = {0.25, 0.5, 0.75, 0.9}; // maximum load factors to test

	    for (double maxLoadFactor : maxLoadFactors) {
	      long totalTime = 0;
	      for (int i = 0; i < numTrials; i++) {
	          ChainHashMap<Integer, Integer> map = new ChainHashMap<>(n, maxLoadFactor);
	          long startTime = System.nanoTime();

	          for (int j = 0; j < n; j++) {
	            int key = rand.nextInt();
	            int value = rand.nextInt();
	            map.put(key, value);
	          }

	          long endTime = System.nanoTime();
	          totalTime += endTime - startTime;
	        }
	        double avgTime = totalTime / (double) numTrials;
	        System.out.println("Max load factor: " + maxLoadFactor + ", Average time: " + avgTime + " nanoseconds");
	      }
  }
}

/***
 * The choice between ProbeHashMap and ChainHashMap depends on the specific requirements of the application and the characteristics of the data being stored.

ChainHashMap is generally more efficient than ProbeHashMap when the number of collisions is high because it avoids the overhead of linear probing, which can be expensive if many entries are hashed to the same location. ChainHashMap also has a smaller memory footprint because it only needs to store the key-value pairs and the linked lists for each bucket.

On the other hand, ProbeHashMap can be faster than ChainHashMap when the number of collisions is low, because it avoids the overhead of following a linked list for each lookup. In addition, ProbeHashMap has better cache locality, since all the entries are stored in a single array.

In general, ProbeHashMap is a good choice when the load factor is low or moderate and the keys have a good hash distribution, whereas ChainHashMap is a good choice when the load factor is high or the keys have a poor hash distribution.

It's worth noting that there are also other hash table implementations that may be more suitable for certain scenarios, such as open addressing with double hashing or cuckoo hashing. Therefore, it's important to consider the specific requirements of the application and to benchmark different implementations before making a decision.
 */
	    