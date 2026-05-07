package com.rga.q.crackingCodingQ.misc.cache;

import java.util.HashMap;

/** 
 * 
 * The Class implements Cache with 2 main methods
 * GetCacheValue(key) - returns the value for the key if it exists in the cache, otherwise returns null.
 * PutCacheValue(key, value) - adds a key-value pair to the cache. If
 * 
 * Cache is finite so 2 eviction policies are implemented
 * 1. LRU - Least Recently Used - Evict the least recently used item when the cache is full.
 * 2. TTL expires
 * 
 * DS used - HashMap for lookup and Doubly Linked List for maintaining the order of usage for LRU eviction policy.
 * timecomplexity - O(1) for get and put operations.
 * Space complexity - O(capacity) where capacity is the maximum number of items the cache can hold.
 * 
 * Thread Safety: All public methods are synchronized to ensure thread-safe operations.
 * 
*/

public class Cache {

    private final int capacity;
    private final HashMap<String, Node> cacheMap;
    private Node head;
    private Node tail; 
    private final long ttl; // Time to live for cache entries in milliseconds
    
    public Cache(int capacity, long ttl) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.ttl = ttl;
    }

    public synchronized String getCacheValue(String key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        Node node = cacheMap.get(key);
        if (System.currentTimeMillis() - node.timestamp > ttl) {
            cacheMap.remove(key);
            removeNode(node);
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public synchronized void putCacheValue(String key, String value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.value = value;
            node.timestamp = System.currentTimeMillis(); // Update timestamp on put
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addNode(newNode);
            if (cacheMap.size() > capacity) {
                removeTail();
            }
        }
    }


    private void moveToHead(Node node) {
        if (node == head) {
            return;
        }
        removeNode(node);
        addNode(node);
    }   

    private void addNode(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null) {
            tail = node;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    private void removeTail() {
        if (tail != null) {
            cacheMap.remove(tail.key);
            removeNode(tail);
        }
    }

    private static class Node {
        String key;
        String value;
        long timestamp;
        Node prev;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
            this.timestamp = System.currentTimeMillis();
        }
    }

}
