package ru.balrom;

import java.util.Objects;

public class MyNode<T> {
    T val;
    MyNode<T> next;
    MyNode<T> previous;

    public MyNode() {
    }

    public MyNode(T val, MyNode<T> next, MyNode<T> previous) {
        this.val = val;
        this.next = next;
        this.previous = previous;

    }


    @Override
    public String toString() {
        return val.toString();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyNode<?> myNode = (MyNode<?>) o;
        return Objects.equals(val, myNode.val) && Objects.equals(next, myNode.next) && Objects.equals(previous, myNode.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next, previous);
    }
}
