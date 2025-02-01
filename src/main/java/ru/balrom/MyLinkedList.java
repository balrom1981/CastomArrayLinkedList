package ru.balrom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyLinkedList<T> implements MyListInterface<T>{
    private MyNode<T> head;
    private MyNode<T> tail;

    private int numberOfElements;

    public MyLinkedList() {
        head = null;
        tail = null;
        numberOfElements = 0;
    }

    @Override
    public void addElement(T element) {
        if (size() == 0) {
            tail = new MyNode<T>(element, null, null);
            head = tail;
        } else {
            MyNode<T> previous = tail;
            tail = new MyNode<T>(element, null, previous);
            previous.next = tail;
        }
        numberOfElements++;
    }

    @Override
    public void addElement(int index, T element) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("There is no element with the index");
        }
        if (index == 0) {
            addFirstElement(element);
        } else if (index == size()) {
            addLastElement(element);
        } else {
            MyNode<T> current = head;
            int count = 0;
            while (current.next != null || current == tail) {
                if (count == index) {
                    MyNode<T> newElement = new MyNode<T>(element, current, current.previous);
                    current.previous.next = newElement;
                    current.previous = newElement;
                    break;
                }
                current = current.next;
                count++;
            }
            numberOfElements++;
        }
    }

    public void addFirstElement(T element) {
        if (size() == 0) {
            tail = new MyNode<T>(element, null, null);
            head = tail;
        } else {
            MyNode<T> current = head;
            head = new MyNode<>(element, current, null);
        }
        numberOfElements++;
    }

    public void addLastElement(T element) {
        addElement(element);
    }

    @Override
    public T getElement(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("There is no element with the index");
        }
        int count = 0;
        MyNode<T> current = head;
        while (count != index) {
            current = current.next;
            count++;
        }
        return current.val;
    }
    public T getFirstElement() {
        if (size() == 0) {
            throw new NullPointerException("MyLinkedList is empty");
        }
        return (T) head.val;
    }

    public T getLastElement() {
        if (size() == 0) {
            throw new NullPointerException("MyLinkedList is empty");
        }
        return (T) tail.val;
    }

    @Override
    public boolean removeElement(T element) {
        boolean result = false;
        if (size() == 0) {
            throw new NullPointerException("MyLinkedList is empty, there is nothing to remove");
        } else {
            MyNode<T> previous = head;
            MyNode<T> current = head;
            while (current.next != null || current == tail) {
                if (current.val.equals(element)) {
                    if (size() == 1) {
                        head = null;
                        tail = null;
                    } else if (current.equals(head)) {
                        head = head.next;
                        head.previous = null;
                    } else if (current.equals(tail)) {
                        tail = tail.previous;
                    } else {
                        previous.next = current.next;
                        previous.previous = current.previous;
                    }
                    numberOfElements--;
                    result = true;
                    break;
                }
                previous = current;
                current = previous.next;
            }
        }
        return result;
    }

    @Override
    public boolean removeElement(int index) {
        if (index > size() || index < 0) {
            throw new IndexOutOfBoundsException("There is no element with the index");
        }
        T element = getElement(index);
        return removeElement(element);
    }

    @Override
    public void clean() {
        if (size() == 0) {
            throw new NullPointerException("MyLinkedList is empty");
        } else {

            MyNode<T> current = head;
            while (current != null) {
                MyNode<T> temp = current;
                current = null;
                numberOfElements--;
                current = temp.next;
            }
        }
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public void sort() {
        T[] array = (T[]) new Object[numberOfElements];
        MyNode<T> current = head;
        int count = 0;
        while (count<numberOfElements){
            array[count] = current.val;
            current=current.next;
            count++;
        }
        Arrays.sort(array);
        clean();

        for (T t : array) {
            addElement(t);
        }
    }
    @Override
    public void sort(Comparator<T> comparator) {
        T[] array = (T[]) new Object[numberOfElements];
        MyNode<T> current = head;
        int count = 0;
        while (count<size()){
            array[count] = current.val;
            current=current.next;
            count++;
        }
        Arrays.sort(array,comparator);
        clean();
        for (T t : array) {
            addElement(t);
        }
    }
    public void printLinkedList() {
        if (size() == 0) {
            throw new NullPointerException("MyLinkedList is empty");
        } else {
            MyNode<T> current = head;
            int count = 0;
            while (count < size() ) {
                System.out.print(current + " ");
                current = current.next;
                count++;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyLinkedList<?> that = (MyLinkedList<?>) o;
        return numberOfElements == that.numberOfElements && Objects.equals(head, that.head) && Objects.equals(tail, that.tail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, numberOfElements);
    }

    public MyNode<T> getHead() {
        return head;
    }

    public MyNode<T> getTail() {
        return tail;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
