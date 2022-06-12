package com.example.projectone_1202397;

public interface LinkedList<T extends Comparable<T>> {

    void add(T data) ;

    void add(int index ,T data);

    void addFirst(T element);

    public void addLast (T element);

    public void insertOrdered(T data);

    T get(int index);

    T getFirst() ;

    T getLast();

    boolean remove(int index);

    boolean removeFirst();

    boolean removeLast();

    void traverse (SNode<T> Current);

    void printList();

    int searchList (T x);

    int size();
}
