/** 
* File Name: BasicList.java
* Description: BasicList is an interface that creates the methods needed in a list. 
*
* @author Takahiro Shimokobe
* @version 3/16/17
*
*/

import java.lang.*;
import java.util.*;

public interfact BasicList<E> extends Iterable<E>{
	void add(E element);
	void add(int index, E element);
	BasicListIterator<E> basicListIterator();
	void clear();
	boolean contains(E element);
	E get(int index);
	int indexOf(E element);
	Iterator<E> iterator();
	E remove(int index);
	E set(int index, E element);
	int size();
}