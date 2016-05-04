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
	_queue.add(c);
	if (isEmpty()){return;}
	else{
	    for (int i=_queue.size()-1; i>0; i--){
		if (i == 0){
		    return;
		}
		else if (c.compareTo(_queue.get(i-1))<1){
		    return;
		}
		else {
		    swap(i, i-1);
		}
	    }
	}
		
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

    public String toString(){
	String ret = "[";
	for (Object x : _queue){
	    ret += x.toString()+", ";
	}
	return ret+"]";
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
    }
}
