/*
Nitin Gupta
Lab 04

Reverse Polish Calculator!
 */

public class LLStack<T> implements StackI<T> {

    private class ListNode
    {
        T data;
        ListNode link;

        public ListNode(T aData, ListNode aLink)
        {
            data = aData;
            link = aLink;
        }
    }

    private ListNode head;
    private int size;

    public LLStack()
    {
        head = null;
        size = 0;
    }

    // Other methods...

    /**
     * Takes in some generic data that is added to the top of the stack.
     * @param aData the data to be added
     */
    public void push(T aData)
    {
        if (aData == null)
            return;

        // create a new node that points to the head
        ListNode newNode = new ListNode(aData, head);
        head = newNode; // the new node is now the top element
        size ++;
    }

    /**
     * Removes and returns the first element’s element at the top of the stack
     * as long as the head is not null.
     * @return the first element in the stack
     */
    public T pop()
    {
        if (head == null)
            return null;

        T toReturn = head.data; // store the data at the top
        head = head.link; // update the head reference

        size --;
        return toReturn;
    }

    /**
     * Returns the first element’s data but does not remove the element.
     * @return the first element in the stack
     */
    public T peek()
    {
        if (head == null)
            return null;

        return head.data;
    }

    /**
     * Prints out the entire queue.
     */
    public void print()
    {
        for (ListNode temp = head; temp != null; temp = temp.link)
            System.out.println(temp.data);
    }

    /**
     * Returns a whole number value that corresponds to the number of items currently in the stack.
     * @return the number of elements in the stack
     */
    public int size()
    {
        return size;
    }

}
