import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<E> implements List<E> {
    private E element;
    private Object MyArray[];
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.MyArray = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int InitialSize) {
        this.MyArray = new Object[InitialSize];
    }

    @Override
    public E get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return (E) MyArray[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, E element) {
        Object temp;
        if (size() >= MyArray.length) {
            ensureCapacity();
        }
        for (int i=size-1; i<=index; i--) {
            MyArray[i] = MyArray[i+1];
        }
        MyArray[index] = element;
    }

    @Override
    public boolean add(E e) {
        if (size() >= MyArray.length) {
            ensureCapacity();
        }
        MyArray[size++] = e;
        return true;
    }
    public void ensureCapacity() {
        int newSize = MyArray.length*2;
        MyArray = Arrays.copyOf(MyArray, newSize);
    }
    public void reduceCapacity() {
        int newSize = MyArray.length / 4;
        MyArray = Arrays.copyOf(MyArray, newSize);
    }
    /*
    Error in remove!
     */
    @Override
    public boolean remove(Object o) {
        int i;
        for (i=0;i<size-1;i++) {
            if (MyArray[i] == o) {
                if (this.size() <= 1) {
                    MyArray[i] = null;
                }
                else {
                    for (int y = i; y < size - 2; y++) {
                        MyArray[y] = MyArray[y + 1];
                    }
                    this.size--;
                    if (size <= this.MyArray.length / 4) reduceCapacity();
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (this.size() <= 1) {
            MyArray[index] = null;
            return null;
        }
        for (int i=index; i<size-2; i++) {
            MyArray[i] = MyArray[i+1];
        }
        this.size--;
        if (size <= this.MyArray.length/4) reduceCapacity();
        return null;
    }

    @Override
    public void clear() {
        this.MyArray = new Object[0];
    }

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
    public boolean isEmpty() {
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
