/**
 * Filename: BasicLinkedList.java
 *
 * Description: A class that describes a BasicLinkedList, with methods.
 * @author Takahiro Shimokobe
 * 
 * 
 * 
 */

import java.util.*;

public class BasicLinkedList<E> implements BasicList<E>{
   private Node<E> head = new Node<E>();
   private int size;

   public BasicLinkedList(){
      head.next = head;
      head.previous = head;
   }

   private class Node<E>{
      public E object;
      public Node<E> next;
      public Node<E> previous;
   }

   private class It implements BasicListIterator<E>{

      private Node<E> cursor = head;

      public void remove(){
         throw new UnsupportedOperationException();
      }

      public boolean hasNext(){
         if (cursor == null){
            return (size != 0);
         }
         return (cursor.next != null);
      }

      public E next(){
         if(hasNext() == false){
            throw new NoSuchElementException();
         }
         E e = cursor.object;
         cursor = cursor.next;
         return e;
      }

      public boolean hasPrevious(){
         if (cursor == null){
            return (size != 0);
         }
         return (cursor.previous != null);
      }

      public E previous(){
         if(hasPrevious() == false){
            throw new NoSuchElementException();
         }
         E e = cursor.object;
         cursor = cursor.previous;
         return e;
      }
   }

   public void add(E element){
    Node<E> node = new Node<E>();

    node.object = element;
    node.next = head;
    node.previous = head.previous;

    head.previous.next = node;
    head.previous = node;

    size = size + 1;
 }

 public void add(int index, E element){
   if( index > size || index < 0){
      throw new IndexOutOfBoundsException();
   }
   
   Node<E> temp = head; /* Creating a Node that represents a temporary value */

   for(int i = 0; i <= index; i++){
      temp = temp.next;
   }

   Node<E> node = new Node<E>();

   node.object = element;
   node.previous = temp.previous;
   node.next = temp;

   temp.previous.next = node;
   temp.previous = node;

   size = size + 1;
}

public BasicListIterator<E> basicListIterator(){
   return new It();
}

public void clear(){
   head.next = head;
   head.previous = head;

   size = 0;
}

public boolean contains(E element){

      Node<E> temp = head;

      for(int i = 0; i < size; i++){

         temp = temp.next;

         if(temp.object.equals(null)){
            return true;
         }
         if(temp.object.equals(element)){
            return true;
         }
      }
      return false;
   }


public E get(int index){  
   if( index >= size || index < 0){
      throw new IndexOutOfBoundsException();
   }

   Node<E> node = head; 

   for(int i=0; i<=index; i++){
      node = node.next;
   } 
   return node.object;
}


public int indexOf(E element){
   if (size == 0){
      throw new NoSuchElementException();
   }

   Node<E> node = head;
   int index = 0;

   for (int i = 0; i < size; i ++){

      node = node.next;

      if (node.object.equals(null)){
         return index;
      }
      if (node.object.equals(element)){
         index = i;
         return index;
         }
      }
   throw new NoSuchElementException();
}

public Iterator<E> iterator(){
   return new It();
}

public E remove(int index){
   if( index >= size || index < 0){
      throw new IndexOutOfBoundsException();
   }

   Node<E> node = head;

   for(int i=0; i<=index; i++){
      node = node.next;
   }

   E elem = node.object;

   node.previous.next = node.next;
   node.next.previous = node.previous;
   size = size -1;
   return elem;
}

public E set(int index, E element){
   if( index >= size || index < 0){
      throw new IndexOutOfBoundsException();
   }
   
   Node<E> node = head;

   for(int i = 0; i <= index; i++){
      node = node.next;
   }

   E elem = node.object;
   node.object = element;

   return elem;
}

public int size(){
   return size;
}
}

