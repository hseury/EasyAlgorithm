package com.company.design;

import java.util.HashMap;

public class LRUCache {
    public class Node{
        int key;
        int value;
        Node prev;
        Node next;
    }

    private HashMap<Integer,Node> map;
    private int capacity;

    /**
     * 始终在头部，不存储数据
     */
    private Node head;
    /**
     * 始终在尾部，不存储数据
     */
    private Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;

        head = new Node();
        head.prev = null;
        tail = new Node();
        tail.next = null;

        head.next = tail;
        tail.prev = head;
    }

    private void addToHead(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node){
        if (node.prev != null){
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }


    /**
     * 移动到有效的数据头部
     * @param node
     */
    private void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }

    /**
     * 删除尾部的数据
     * @return
     */
    private Node popTail(){
        Node result = tail.prev;
        removeNode(result);
        return result;
    }

    public int get(int key) {
        Node result = map.get(key);

        if (result == null){
            return -1;
        }

        moveToHead(result);
        return result.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;

            map.put(key,newNode);
            addToHead(newNode);
            if (map.size() > capacity){
                Node tail = popTail();
                map.remove(tail.key);
            }
        }else{
            node.value = value; //update value
            moveToHead(node);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        assert(cache.get(1) == 1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        assert (cache.get(2) == -1);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        assert (cache.get(1) == -1);       // 返回 -1 (未找到)
        assert (cache.get(3) == 3);       // 返回 3
        assert (cache.get(4) == 4);       // 返回 4
    }
}
