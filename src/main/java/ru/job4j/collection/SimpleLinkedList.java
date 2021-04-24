package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class SimpleLinkedList<E> implements List<E> {
    Node<E>[]container = new Node[3];
    int currentIndex = 0;
    int modCount;
    private class Node<E> {
        private E element;
        private Node<E> next;
        public void setNext(Node<E>node){
            next = node;
        }

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }
    }
    @Override
    public void add(E value) {
        Node<E>node = new Node<E>(value,null);
        container[currentIndex++]= node;
        if(container.length == currentIndex){
            Node<E>[]temp = new Node[container.length * 2];
            System.arraycopy(container,0,temp,0,container.length);
            container = temp;
        }
if(currentIndex > 1){
    container[currentIndex-2].setNext(node);

}
modCount++;
    }

    @Override
    public E get(int index) {
        return  container[Objects.checkIndex(index, currentIndex)].getElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new SimpleLinkedListIterator();
    }
    class SimpleLinkedListIterator implements Iterator<E> {
        boolean isFirst = true;
        int expectedModCount;
        SimpleLinkedList.Node currentNode = container[0];


        SimpleLinkedListIterator() {
            expectedModCount = modCount;

        }

        @Override
        public boolean hasNext() {
            if (isFirst||currentNode.next!=null) {
                return true;
            }
            return false;
        }

        @Override
        public  E next() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            SimpleLinkedList.Node result = currentNode;
if(isFirst){
    isFirst = false;
    return (E) currentNode.getElement();
}
            currentNode = result.next;
            return (E) currentNode.getElement();

        }

    }
}