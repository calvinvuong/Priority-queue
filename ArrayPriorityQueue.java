/** Team Legendary Spoon - Calvin Vuong, Ruochong Wu, Zicheng Zhen
    APCS2 pd10
    HW35 -- Privileged Status Gets You to the Front of the Line 
    2016-05-04 **/

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayPriorityQueue implements PriorityQueue {
    /** Instance Variables **/
    ArrayList<Comparable> _queue; //reversely ordered; dequeue from end of array

    /** Default Constructor **/
    public ArrayPriorityQueue() {
	_queue = new ArrayList<Comparable>();
    }

    /** Methods **/
    /** add - adds comparable c to the _queue, such that the highest priority 
     *  element is at the end of the _queue array (which gets dequeued first)
     **/
    public void add(Comparable c) {
	_queue.add(c);
	// move c to the right position, such that element to the left is the
	// latest element with lower priority
	for (int i = _queue.size()-1; i > 0; i--) {
	    if (c.compareTo(_queue.get(i-1)) < 0)
		return;
	    else 
		swap(i, i-1); // bubble sort towards correct position
	}
    }

    /** removeMin() - dequeues the smallest element of the queue **/
    public Comparable removeMin() {
	if (isEmpty())
	    throw new NoSuchElementException();
	return _queue.remove(_queue.size()-1); // Removes last element
    }

    /** peekMin - returns the next element to be dequeued from the queue **/
    public Comparable peekMin() {
	if (isEmpty())
	    throw new NoSuchElementException();
	return _queue.get(_queue.size()-1);
    }

    /** isEmpty - returns a boolean indicating whether the queue is empty **/
    public boolean isEmpty() {
	return _queue.size() == 0;
    }

    /** swap - swaps locations of two objects in _queue **/
    private void swap(int j, int k) {
	Comparable tmp = _queue.get(j);
	_queue.set(j, _queue.get(k));
	_queue.set(k, tmp);
    }

    /** toString - overwrites existing toString() method **/
    public String toString(){
	return _queue.toString();
    }

    public static void main(String[] args){
	ArrayPriorityQueue test = new ArrayPriorityQueue();
	test.add(1);
	test.add(1);
	test.add(2);
	test.add(3);
	test.add(4);
	test.add(3);
	test.add(2);
	System.out.println(test);

	System.out.println( test.peekMin() );
	System.out.println( test.removeMin() );
	System.out.println(test);

	System.out.println( test.removeMin() );
	System.out.println( test.peekMin() );
	System.out.println( test.removeMin() );
	System.out.println(test);

	while (!test.isEmpty())
	    System.out.println("Next... " + test.removeMin());
	System.out.println("Removing minimum from empty queue:");
	test.removeMin();
    }
}
