package com.exercise1.Gokulraj.Venugopal;


import java.util.ArrayList;
import java.util.Random;

public class ProbeHashMap<K,V> extends AbstractHashMap<K,V> {
private MapEntry<K,V>[] table;
private MapEntry<K,V> DEFUNCT = new MapEntry<>(null,null);
//public ProbeHashMap() {super();}
public ProbeHashMap(int cap) {super(cap);}
public ProbeHashMap(int cap, int p) {super(cap,p);}

//Updated Constructor
public ProbeHashMap(int cap, int p, double loadFactor) {
    super(cap, p, loadFactor);
    table = new MapEntry[capacity];
    prime = prime-2;
  }

protected void createTable() {
	table = (MapEntry<K,V>[]) new MapEntry[capacity];
}
private boolean isAvailable(int j) {
	return (table[j] == null || table[j] == DEFUNCT);
}

private int findSlot(int h, K k) {
	int avail =-1;
	int j = h;
	do {
		if (isAvailable(j)) {
			if (avail ==-1) avail =j;
			if(table[j] == null) break;
		} else if (table[j].getKey().equals(k))
			return j;
		j = (j+1) % capacity;
	} while (j!=h);
	return -(avail+1);
}

@Override
protected V bucketGet(int h, K k) {
	int j = findSlot(h,k);
	if(j<0) return null;
	return table[j].getValue();
}

@Override
protected V bucketPut(int h, K k, V v) {
	int j = findSlot(h,k);
	if (j>=0)
		return table[j].setValue(v);
	table[-(j+1)] = new MapEntry<>(k,v);
	n++;
	return null;
}

@Override
protected V bucketRemove(int h, K k) {
	int j = findSlot(h,k);
	if (j<0) return null;
	V answer = table[j].getValue();
	table[j] = DEFUNCT;
	n--;
	return answer;
}

@Override
public Iterable<Entry<K, V>> entrySet() {
	ArrayList<Entry<K,V>> buffer = new ArrayList();
	for (int h=0; h<capacity; h++)
		if(!isAvailable(h)) buffer.add(table[h]);
	return buffer;
}

/** 
 *************************************************
 *************************************************
 ********Student Name: Gokulraj Venugopal*********
 ********Student ID: 301202722********************
 *************************************************
 *************************************************
 **/
public static void main(String[] args) {
	  Random rand = new Random();
      long start, end;
      for (double loadFactor = 0.1; loadFactor <= 0.9; loadFactor += 0.1) {
          ProbeHashMap<Integer, Integer> map = new ProbeHashMap<>(100000, 109345121, loadFactor);
          start = System.nanoTime();
          for (int i = 0; i < 100000; i++) {
              map.put(rand.nextInt(1000000), i);
          }
          end = System.nanoTime();
          System.out.printf("Load Factor: %.1f, Time: %d nanoseconds\n", loadFactor, end - start);
      }
  }
}

/***
 * Regarding whether ProbeHashMap or ChainHashMap is better, it depends on the 
 * specific use case and requirements. ProbeHashMap has the advantage of requiring
 * less memory overhead since it stores only the keys and values in the underlying 
 * array. However, it can suffer from clustering issues that may affect performance 
 * if the hash function is not well-designed. ChainHashMap, on the other hand, 
 * has the advantage of being able to handle collisions well since it uses 
 * separate chaining to store multiple values with the same hash code. 
 * However, it may require more memory overhead due to the use of linked lists 
 * for each bucket.

 * In general, ProbeHashMap is a good choice when memory usage is a concern, 
 * and the hash function can be well-designed to avoid clustering issues. 
 * ChainHashMap is a good choice when collisions are expected to occur frequently, 
 * and memory usage is not a concern.
*/
