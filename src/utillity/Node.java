/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utillity;

/**
 * Project:
 * Author: Davin
 * Date: 29-Apr-2016
 * Teacher: Mr. Wachs 
 */
public class Node <T>{
    private T data;
    private Node next;
    private Node previous;

    
    /**
     * Make a new node with the given data
     * @param data Generic data
     */
    public Node(T data) {
        this(data, null, null);
    }
    /**
     * Creates a new node
     * @param data Generic data
     * @param next The next node, set null if end 
     * @param previous The previous node, set null if start
     */
    public Node(T data, Node next, Node previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }
    /**
     * Get the next node 
     * @return the next node
     */
    public Node getNext() {
        return next;
    }
    /**
     * Gets the nodes data(Generic)
     * @return the node's data
     */
    public T getData() {
        return data;
    }
    /**
     * Gets the previous node.
     * @return the previous node
     */
    public Node getPrevious() {
        return previous;
    }
    /**
     * Sets the node's data
     * @param data the new data 
     */
    public void setData(T data) {
        this.data = data;
    }
    /**
     * Sets the next node
     * @param next the new node
     */
    public void setNext(Node next) {
        this.next = next;
    }
    /**
     * Sets the previous node
     * @param previous the new node
     */
    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        if(data == null) return "null";
        return data.toString();
    }

    public boolean equals(Node node) {
        if(!data.equals(node.data)) return false; 
        //if(!next.equals(node.next)) return false;
        //if(!previous.equals(node.previous)) return false;
        return true;
    }

    protected Node clone() throws CloneNotSupportedException {
        return new Node(data, next, previous);
    }

    @Override
    protected void finalize(){
        if(next != null) next.setPrevious(previous);
        if(previous != null) next.setNext(next);
        data = null;
        next = null;
        previous = null;
    }
}
