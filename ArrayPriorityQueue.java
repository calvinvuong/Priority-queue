/** Team Legendary Spoon - Calvin Vuong, Ruochong Wu, Zicheng Zhen
    APCS2 pd10
    HW35 -- Name / Desc 
    2016-05-04 **/

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
    /** Instance Variables **/
    ArrayList<Comparable> _queue; //reversely ordered; dequeue from end of array

    /** Default Constructor **/
    public ArrayPriorityQueue() {
	_queue = new ArrayList<Comparable>();
    }

    /** Methods **/
    public void add(Comparable c) {
	return;
    }

    public Comparable removeMin() {
	return _queue.remove(_queue.size()-1); // Removes last element
    }

    public Comparable peekMin() {
	return _queue.get(_queue.size()-1);
    }

    public boolean isEmpty() {
	return _queue.size() == 0;
    }

    /** swap - swaps locations of two objects in _queue **/
    private void swap(int j, int k) {
	Comparable tmp = _queue.get(j);
	_queue.set(j, _queue.get(k));
	_queue.set(k, tmp);
    }
}
