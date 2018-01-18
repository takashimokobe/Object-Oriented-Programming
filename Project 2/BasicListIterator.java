/**
 * Filename: BasicListIterator.java
 *
 * Description: An interface that describes an iterator that is used in BasicLinkedList.   
 *
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */

import java.util.Iterator;

public interface BasicListIterator<E> extends Iterator<E> {
	boolean hasPrevious(); //returns true if the  iterator has a previous element. This method does not change the state of the iterator. Calling this method on a new BasicListIterator before any calls to next() will always return false. 
	E previous(); // returns the previous element and moves the iterator backward one position with O(1) performance. 
}