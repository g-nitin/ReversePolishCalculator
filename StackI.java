/*
Nitin Gupta
Lab 04

Reverse Polish Calculator!
 */

public interface StackI<T> {

    public void push(T aData);
    public T pop();
    public T peek();
    public void print();
    public int size();

}
