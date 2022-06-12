package com.example.projectone_1202397;

public class SNode <T extends Comparable<T>>{
    T data;
    SNode<T> next;

    public SNode(T data) {
        this.data = data;
        next = null;
    }

    public SNode(T data, SNode <T> next){
        this.next=next;
        this.data=data;
    }

    public SNode<T> getNext() {
        return next;
    }

    public void setNext(SNode<T> next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
