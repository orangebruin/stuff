package com.ob.sort;

public class Entry<K, V> {

	private K key;
	private V data;
	private Entry<K, V> next;
	private Entry<K, V> prev;
	
	public Entry(K key, V data) {
		this.key = key;
		this.data = data;
		next = null;
		prev = null;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getData() {
		return data;
	}
	
	public Entry<K, V> getNext() {
		return next;
	}
	
	public void setNext(Entry<K, V> newNext) {
		next = newNext;
	}
	
	public Entry<K, V> getPrev() {
		return prev;
	}
	
	public void setPrev(Entry<K, V> newPrev) {
		prev = newPrev;
	}
}
