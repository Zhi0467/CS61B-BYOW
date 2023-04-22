import edu.princeton.cs.algs4.In;

public class SLList {
    // this nested class should be made static since it does not access any outer instance variables or methods.
    public static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }

    }

    private IntNode sentinel;

    private int size;
    /**there is error in method addLast if we use "first" to write empty list costructor, the first node is
     *  null itself and doesn't have a next. So we should always have something to point at even
     *  before the "first" */
    public SLList(){
        sentinel = new IntNode(42,null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(42,null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds an item to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size++;
    }

    /** Retrieves the front item from the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds an item to the end of the list. */
    public void addLast(int x) {
        //iteratively use a pointer
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x,null);
        size++;
    }

    /** Returns the number of items in the list using recursion. */
    /**private static int size(IntNode p){
        if (p.next == null){
            return 1;
        }
        return 1 + size(p.next);
    }

    public int size(){
        return size(first);
    }*/
    // here a faster way to calculate size is to use so-called "cache". And use a public method to let the user access it
    public int size(){
        return size;
    }
}
