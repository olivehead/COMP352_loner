import java.util.*;

public class MyLinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> head;
    private Node<E> tail;

    class Node<E> {
        private E element;
        private Node next;
        private Node previous;

        public Node() {
            element = null;
            next = null;
            previous = null;
        }

        public Node(E el, Node nxt, Node prev) {
            element = el;
            next = nxt;
            previous = prev;
        }

    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        if (index > size - 1) {
            throw new NoSuchElementException();
        }
        int i=0;
        Node temp = head;
        while(i != index) {
            temp = temp.next;
            i++;
        }
        return (E) temp.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E el) {
        if((index > size - 1) && (size != 0)) {
            throw new NoSuchElementException();
        }
        int i = 0;
        Node temp = head;
        if (index == 0) {
            Node newNode = new Node(el, head, tail);
            head = newNode;
            newNode = null;
        }
        else {
            while(i != index -1) {
                temp = temp.next;
                i++;
            }
            Node newNode = new Node(el, temp.next, temp);
            temp.next.previous = newNode;
            temp.next = newNode;
            newNode = null;
        }
        size++;
    }

    @Override
    public boolean add(E e) {
        Node temp = new Node(e, null, tail);
        if(tail != null) {
            tail.next = temp;
        }
        tail = temp;
        if(head == null) {
            head = temp;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        Node temp = head;
        if (o.equals(temp.element)) {
            head = head.next;
            head.previous = null;
            size--;
            return true;
        }
        temp = null;
        Node temp1 = tail;
        if (o.equals(temp1.element)) {
            tail = tail.previous;
            tail.next = null;
            size--;
            return true;
        }
        if (size == 1) {
            head = tail = null;
            size--;
            return true;
        }
        for (Node<E> x = head; x != null; x = x.next) {
            if (o.equals(x.element)) {
                temp.next = temp.next.next;
                temp.next.previous = temp;
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if(index > size - 1) {
            throw new NoSuchElementException();
        }
        int i = 0;
        Node temp = head;
        if (size == 1) {
            head = tail = null;
            size--;
            return null;
        }
        if (index == 0) {
            head = head.next;
            head.previous = tail;
            tail.next = head;
        }
        else if (index == size - 1) {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
        }
        else {
            while (i != index - 1) {
                temp = temp.next;
                i++;
            }
            temp.next = temp.next.next;
            temp.next.previous = temp;
        }
        size --;
        return null;
    }

    public void DisplayList() {
        Node temp = head;
        int i=0;
        while (temp != tail) {
            System.out.println("Index: " + i + "\tValue:" + temp.element);
            temp = temp.next;
            i++;
        }
    }

    @Override
    public void clear() {
        for (Node<E> temp = head; temp != null; ) {
            Node<E> next = temp.next;
            temp.element = null;
            temp.next = null;
            temp.previous = null;
            temp = next;
        }
        head = tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { return size == 0;}

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        throw new UnsupportedOperationException();
    }


    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }
    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}
