package ru.balrom;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> implements MyListInterface<T> {
    private T[] array;
    private int size;
    private int numberOfElements;


    public MyArrayList() {
        numberOfElements = 0;
        this.size = 10;
        this.array = (T[]) new Object[size];

    }

    public MyArrayList(int size) {
        numberOfElements = 0;
        this.size = size;
        this.array = (T[]) new Object[size];
    }


    /* Добавление элемента*/
    @Override
    public void addElement(T element) {
        if (numberOfElements == size) {
            resizeArray();
        }
        array[numberOfElements] = element;
        numberOfElements++;
    }

    /* Добавление элемента по индексу*/
    @Override
    public void addElement(int index, T element) {
        if (index > numberOfElements || index < 0) {
            throw new IndexOutOfBoundsException("Index is bigger/less than length of array");
        }
        if (numberOfElements == size) {
            resizeArray();
        }
        if (array[index] == null) {
            setElement(index, element);
        } else {
            shiftRight(index);
            array[index] = element;
        }
        numberOfElements++;
    }

    /* Получение элемента по индексу*/
    @Override
    public T getElement(int index) {
        if (index > numberOfElements || index < 0) {
            throw new IndexOutOfBoundsException("Index is bigger/less than length of array");
        }
        return (T) array[index];
    }

    /* Удаление элемента*/
    @Override
    public boolean removeElement(T element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                index = i;
            }
        }
        if (index != -1) {
            removeElement(index);
            return true;
        }
        return false;
    }

    /* Удаление элемента по индексу*/
    @Override
    public boolean removeElement(int index) {
        if (index >= size || index < 0) {
            return false;
        }
        shiftLeft(index);
        numberOfElements--;
        return true;
    }

    /* Очистка листа*/
    @Override
    public void clean() {
        Arrays.fill(array, null);
    }


    /* Получение размера листа*/
    @Override
    public int size() {
        return size;
    }


    /* Сортировка в натуральном порядке*/
    @Override
    public void sort() {
        if (size == numberOfElements) {
            Arrays.sort(array);
        } else {
            T[] temp = (T[]) Arrays.stream(array).filter(Objects::nonNull).sorted().toArray();
            array = Arrays.copyOf(temp, size);
        }
    }


    /* Сортировка в заданном порядке*/
    @Override
    public void sort(Comparator<T> comparator) {
        if (size == numberOfElements) {
            Arrays.sort(array, comparator);
        } else {
            T[] temp = (T[]) Arrays.stream(array).filter(Objects::nonNull).sorted(comparator).toArray();
            array = Arrays.copyOf(temp, size);
        }
    }

    /* Вставка элемента по индексу*/
    public void setElement(int index, T element) {
        if (index>numberOfElements || index<0){
            throw new IndexOutOfBoundsException("Index is bigger/less than length of array");
        }
        array[index] = element;
    }

    /* Получение индекса элемента*/
    public int indexOf(T element) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    private void resizeArray() {
        size *= 2;
        array = Arrays.copyOf(array, size);
    }
    private void shiftRight(int index) {
        Object[] newArray = new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index, newArray, index + 1, size - index - 1);
        array = (T[]) newArray;
    }

    private void shiftLeft(int index) {
        Object[] newArray = new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - index - 1);
        array = (T[]) newArray;
    }

    public T[] getArray() {
        return array;
    }

    public int getSize() {
        return size;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }
}
