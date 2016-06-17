package utillity;

import java.io.Serializable;
import java.lang.reflect.Array;

/**
 * Project:
 * Author: Davin
 * Date: 25-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class LinkedList <T> implements Serializable{

    //add sublist(int, int)
    
    
    Node head;
    Node tail;
    int length;

    public LinkedList() {
        head = null;
        length = 0;
    }
    
    public LinkedList(T[] array) {
        fromArray(array);
    }
    
    public LinkedList(LinkedList<T> list) {
        fromLinkedList(list);
    }
    
    public boolean addDataFront(T data){
        if (head == null) {
            head = new Node(data, null, null);
            return true;
        }
        head.setPrevious(new Node(data, head, null));
        head = head.getPrevious();
        return true;
    }
    
    public boolean addDataEnd(T data){
        if (head == null) {
            head = new Node(data, null, null);
            tail = head;
            length++;
            return true;
        }
        tail.setNext(new Node(data, null, tail));
        tail = tail.getNext();
        length++;
        return true;
    }
    
    public boolean addDataAfter(T data, int index){
        
        if(head == null){
            head = new Node(data);
            length++;
            return true;
        } 
        
        if (index >= length) {
            return false;
        }   
        
        if (index == length) {
            addDataEnd(data);
        }   
        
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        
        Node newNode = new Node(data, n.getNext(), n);
        if (n.getNext() != null) {
            n.getNext().setPrevious(newNode);
        }        
        n.setNext(newNode);
        length++;
        return true;
    }
    
    public boolean addDataBefore(T data, int index){
        
        if(head == null){
            head = new Node(data);
            length++;
            return true;
        } 
        if(!inRange(index)) return false;
                
        if (index == 0) {
            addDataFront(data);
        } 
        
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
        }
        
        Node newNode = new Node(data, n, n.getPrevious());
        if (n.getPrevious()!= null) {
            n.getPrevious().setNext(newNode);
        }        
        n.setPrevious(newNode);
        length++;
        return true;
    }
    
    public void removeData(T data, int index){
        if(head == null) return;
        Node n = head;
        for (int i = 0; i < index; i++) {
            n = n.getNext();
            if (n == null) {
                return;
            }
        }
        if (n.equals(head)) {
            head = head.getNext();
        }
        if (n.getPrevious() != null) {
            n.getPrevious().setNext(n.getNext());
        }
        if (n.getNext()!= null) {
            n.getNext().setPrevious(n.getPrevious());
        }
        n.finalize();
        length--;
        return;
    }

    public int getLength() {
        return length;
    }
    
    public T getData(int index){
        if(!inRange(index)) return null;
        Node n = head;
        
        for (int i = 0; i < index; i++){
            if(n == null) return null; 
            n = n.getNext();
        }
        if (n==null) {
            return null;
            
        }
        return (T) n.getData();
    }
    
    public boolean setData(int index, T data){
        if (!inRange(index)) return false;
        Node n = head;
        for (int i = 0; i < index; i++){ 
            n = n.getNext();
        }
        n.setData(data);
        return true;
    }
    
    public void removeAll(T data){
        while (contains(data)){
            removeFirst(data);
        }
    }

    public boolean contains(T data) {
        return findFirst(data) != -1;
    }
    
    public int findFirst(T data){
        Node n = head;
        for (int i = 0; i < length; i++) {
            if (n == null) break;
            if (n.getData().equals(data)) return i;
            n = n.getNext();
        }
        return -1;
    }
    
    public int findLast(T data){
        Node n = tail;
        for (int i = 0; i < length; i++) {
            if (n == null) break;
            if (n.getData().equals(data)) return i;
            n = n.getNext();
        }
        return -1;
    }

    public void removeFirst(T data) {
        removeData(data, findFirst(data));
    }
    
    public void removeAll(T[] array){
        if (array == null) return;
        if (array.length == 0) return;
        
        for (int i = 0; i < array.length; i++) {
            removeAll(array[i]);
        }
    } 
    
    public void retainAll(T[] array){
        finalize();
        addAll(array);
    };
    
    public void addAll(T[] array) {
        for (int i = 0; i < array.length; i++) {
            addDataEnd(array[i]);
        }
    }
    
    public boolean containsAll(T[] array) {
        for (int i = 0; i < array.length; i++) {
            if(contains(array[i]) == false) return false;
        }
        return true;
    }
    
    public int numberOf(T data){
        Node n = head;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (n.getData().equals(data)) count++;
        }
        return count;
    }
    
    public void addAll(LinkedList<T> list) {
        for (int i = 0; i < list.getLength(); i++) {
            addDataEnd(list.getData(i));
        }
    }
    
    public void addAll(LinkedList<T> list, int index) {
        if(!inRange(index)) return;
        for (int i = 0; i < list.getLength(); i++) {
            addDataAfter(list.getData(i), index);
            index++;
        }
    }
    
    public boolean inRange(int index) {
        if(index > length) return false;
        if(index < 0) return false;
        return true;
    }
    
    public void fromArray(T[] array){
        finalize();
        for (int i = 0; i < array.length; i++) {
            this.addDataEnd(array[i]);
        }
    }
    
    public void fromLinkedList(LinkedList<T> list){
        finalize();
        for (int i = 0; i < list.length; i++) {
            this.addDataEnd(list.getData(i));
        }
    }
    
    public T[] toArray(T[] array){
        array = (T[])Array.newInstance(array.getClass().getComponentType(), length);
        for (int i = 0; i < length; i++) {
            array[i] = this.getData(i);
        }
        return array;
    }
    //----------------------
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < length; i++) {
            s += getData(i).toString()+", ";
        }
        s = s.substring(0, s.length()-2);
        return s;
    }

    public boolean equals(LinkedList list) {
        if(length != list.length) return false;
        for (int i = 0; i < length; i++) {
            if(!getData(i).equals(list.getData(i))) return false;
        }
        return true;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    protected void finalize() {
        for (int i = 0; i < length; i++) {
            removeAll(getData(i));
        }
    }


    
    
    
    
    

}
