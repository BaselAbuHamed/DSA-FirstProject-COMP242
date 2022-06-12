package com.example.projectone_1202397;

public class SLinkedList <T extends Comparable<T>> implements LinkedList<T> {

    SNode<T> Front=null ,Back=null;
    private int Size =0;

    @Override
    public void add(T data) {
        add(size(),data);
    }

    @Override
    public void add(int index ,T data) {

        if (index==0) addFirst(data);

        else if (index>= size())addLast(data);

        else{
            SNode<T> newNode= new SNode<>(data);
            SNode<T> current=Front; //used to advance to proper position

            for (int i=0;i<index-1;i++)
                current=current.next;
            newNode.next=current.next;
            current.next=newNode;
            Size++;// update size
        }

    }

    @Override
    public void addFirst(T element){
        SNode<T> newNode;
        newNode= new SNode<>(element);
        if (Size ==0) {// Empty List
            Front=Back=newNode;
        }
        else{
            newNode.next=Front;
            Front=newNode;
        }
        Size++;// update Size
    }

    @Override
    public void addLast (T element){
        SNode<T> newNode;
        newNode= new SNode<>(element);
        if (Size ==0){// Empty List
            Front=Back=newNode;
        }
        else{
            Back.next=newNode;
            Back=newNode; // Or Back=Back.next;
        }
        Size++;// update Size
    }

    @Override
    public void insertOrdered(T data) {
        SNode<T> temp1 = new SNode<>(data);
        SNode<T> prev = null, curr = Front;
        for (; curr != null && curr.getData().compareTo(data) < 0; prev = curr, curr = curr.getNext())
            ;
        if (Front == null) // empty list
            Front = temp1;
        else if (prev == null) { // add at first
            temp1.setNext(Front);
            Front = temp1;
        } else if (curr == null) { // add at last
            prev.setNext(temp1);
        } else { // insert between previous and current
            temp1.setNext(curr);
            prev.setNext(temp1);
        }

    }

    @Override
    public T get(int index){

        if (Size ==0) return null; //empty list
        else if (index==0) return getFirst(); //first element
        else if (index== Size -1)return getLast(); //last element

        else if (index >0 && index< Size -1){
            SNode<T> current=Front;
            for (int i=0;i<index;i++)
                current=current.next;
            return current.data;
        }
        else
            return null; //out of boundary
    }

    @Override
    public T getFirst() {
        if (Size == 0)
            return null;
        else
            return Front.data;
    }

    @Override
    public T getLast(){
        if (Size ==0)
            return null;
        else
            return Back.data;
    }

    @Override
    public boolean remove(int index){

        if (Size ==0)return false;//empty linked list

        else if (index==0)return removeFirst(); //remove first element

        else if (index== Size -1)return removeLast();//remove last element

        else if (index >0 && index< Size -1){

            SNode<T> current=Front;

            for (int i=0;i<index-1;i++)
                current=current.next;
            current.next= current.next.next;
            Size--;
            return true;
        }
        else return false; // out of boundary(invalid index)
    }

    @Override
    public boolean removeFirst(){
        if (Size ==0)
            return false; //empty list
        else if (Size ==1) //one element inside list
            Front=Back=null;
        else
            Front=Front.next;
        Size--; //update size
        return true;
    }

    @Override
    public boolean removeLast(){
        if (Size ==0)
            return false; //empty list
        else if (Size ==1) // one element inside the list
            Front=Back=null;
        else{
            SNode<T> current= Front;
            for (int i = 0; i< Size -2; i++)
                current=current.next;
            current.next=null;
            Back=current;
        }
        Size--; //update size
        return true;
    }

    @Override
    public void traverse (SNode<T> Current){
        if(Current != null){
            System.out.println(Current.data);
            traverse(Current.next);
        }
    }

    @Override
    public void printList(){
        SNode<T> current = Front;
        while (current != null){
            System.out.print(current.data +" " );
            current = current.next;
        }
    }

    @Override
    public int searchList (T x){
        SNode<T>current =Front;
        int i=0;
        while ((current != null)&&(!current.data.equals(x))){
            current=current.next;
            i++;
        }
        return i;
    }

    @Override
    public int size() {
        return Size;
    }

}
