package com.rga.q.crackingCodingQ.misc.cache;

public class Node {
    String key;
    String value;
    Node prev;
    Node next;
    long timestamp; // Timestamp to track when the cache entry was created or last accessed

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
        this.timestamp = System.currentTimeMillis(); // Set the timestamp when the node is created
    }
    
}
