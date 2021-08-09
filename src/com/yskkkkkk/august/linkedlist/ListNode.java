package com.yskkkkkk.august.linkedlist;

class ListNode{
    private int data;    
    public ListNode link;
    
    public ListNode() {
        this.data = 0;
        this.link = null;
    }
    
    public ListNode(int data) {
        this.data = data;
        this.link = null;
    }
    
    public ListNode(int data, ListNode link) {
        this.data = data;
        this.link = link;
    }
    
    public int getData() {
        return this.data;
    }
}