package ru.balrom;

import java.util.Comparator;

public interface MyListInterface<T> {
    void addElement(T element);
    void addElement(int index, T element);
    T getElement(int index);
    boolean removeElement(T element);
    boolean removeElement(int index);
    void clean();
    int size();
    void sort();
    void sort(Comparator<T> comparator);
}
