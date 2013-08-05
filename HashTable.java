package com.ob.sort;

public class HashTable<K, V> {

	private Entry<K, V>[] table;
	private int tableSize;
	
	public HashTable() {
		this(10);
	}
	
	public HashTable(int size) {
		table = new Entry[size];
		tableSize = size;
		
		for (int i = 0; i < tableSize; i++)
			table[i] = null;
	}
	
	public void insertEntry(K key, V value) {
		int bucket = Math.abs(key.hashCode() % tableSize);
		
		if (table[bucket] == null)
			insertIntoEmptyBucket(bucket, key, value);
		else
			insertCollision(bucket, key, value);
	}
	
	public V get(K key) {
		int bucket = Math.abs(key.hashCode() % tableSize);
		
		Entry<K, V> cur = table[bucket];
		while (cur != null) {
			if (cur.getKey() == key)
				return cur.getData();
			cur = cur.getNext();
		}
		
		return null;
	}
	
	public void printTable() {
		for (int i = 0; i < tableSize; i++) {
			System.out.print("Bucket " + i + ": ");
			Entry<K, V> cur = table[i];
			while (cur != null) {
				System.out.print(cur.getData() + " ");
				cur = cur.getNext();
			}
			System.out.println();
		}
	}
	
	private void insertIntoEmptyBucket(int bucket, K key, V value) {
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		table[bucket] = newEntry;
	}
	
	private void insertCollision(int bucket, K key, V value) {
		Entry<K, V> endOfList = getLastEntryInList(table[bucket]);
		
		Entry<K, V> newEntry = new Entry<K, V>(key, value);
		newEntry.setPrev(endOfList);
		endOfList.setNext(newEntry);
	}
	
	private Entry<K, V> getLastEntryInList(Entry<K, V> head) {
		Entry<K, V> cur = head;
		
		while (cur.getNext() != null)
			cur = cur.getNext();
		
		return cur;
	}
	
	public static void main(String[] args) {
		HashTable<String, Integer> ht = new HashTable<String, Integer>();
		ht.insertEntry("thirty-four", 34);
		ht.insertEntry("hundred", 100);
		ht.insertEntry("thirty-seven", 37);
		ht.insertEntry("seven", 7);
		ht.insertEntry("five hundred fifty-four", 554);
		ht.insertEntry("three hundred forty-three", 343);
		ht.insertEntry("nine thousand nine hundred ninty", 9990);
		
		ht.printTable();
		
		Integer item = ht.get("three hundred forty-three");
		if (item != null) 
			System.out.println("Item is " + item);
	}
}
