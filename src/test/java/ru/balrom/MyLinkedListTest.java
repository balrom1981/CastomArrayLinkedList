package ru.balrom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest<T> {

    @Test
    public void addElementAtCorrectIndex() {
        MyLinkedList<Integer> actual = new MyLinkedList<>();
        actual.addElement(34);
        actual.addElement(15);
        actual.addElement(21);
        actual.addElement(56);

        actual.addElement(1, 111);

        MyLinkedList<Integer> expected = new MyLinkedList<>();
        expected.addElement(34);
        expected.addElement(111);
        expected.addElement(15);
        expected.addElement(21);
        expected.addElement(56);

        Assertions.assertArrayEquals(getArrayFromMyLinkedList(expected), getArrayFromMyLinkedList(actual));
    }

    @Test
    public void addElementAtIncorrectIndex() {
        MyLinkedList<Integer> actual = fillList();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> actual.addElement(7, 111));
    }


    @Test
    public void getElementFromCorrectIndex() {
        MyLinkedList<Integer> actual = fillList();

        String actualElement = actual.getElement(1).toString();
        String expectedElement = "15";

        Assertions.assertEquals(expectedElement, actualElement);
    }

    @Test
    public void getElementFromIncorrectIndex() {
        MyLinkedList<Integer> actual = fillList();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> actual.getElement(45));
    }

    @Test
    public void removeCorrectElement() {
        MyLinkedList<Integer> actual = fillList();

        actual.removeElement(new Integer(21));

        MyLinkedList<Integer> expected = new MyLinkedList<>();
        expected.addElement(34);
        expected.addElement(15);
        expected.addElement(56);

        Assertions.assertArrayEquals(getArrayFromMyLinkedList(expected), getArrayFromMyLinkedList(actual));
    }

    @Test
    public void removeElementFromIncorrectIndex() {
        MyLinkedList<Integer> actual = fillList();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> actual.removeElement(45));
    }

    @Test
    public void removeElementFromCorrectIndex() {
        MyLinkedList<Integer> actual = fillList();

        actual.removeElement(2);

        MyLinkedList<Integer> expected = new MyLinkedList<>();
        expected.addElement(34);
        expected.addElement(15);
        expected.addElement(56);

        Assertions.assertArrayEquals(getArrayFromMyLinkedList(expected), getArrayFromMyLinkedList(actual));
    }

    @Test
    public void sortArrayInNaturalOrder() {
        MyLinkedList<Integer> actual = fillList();
        actual.sort();

        MyLinkedList<Integer> expected = new MyLinkedList<>();
        expected.addElement(15);
        expected.addElement(21);
        expected.addElement(34);
        expected.addElement(56);

        Assertions.assertArrayEquals(getArrayFromMyLinkedList(expected), getArrayFromMyLinkedList(actual));
    }

    @Test
    public void sortArrayInNotNaturalOrder() {
        MyLinkedList<Integer> actual = fillList();
        actual.sort((x,y) -> y-x);

        MyLinkedList<Integer> expected = new MyLinkedList<>();
        expected.addElement(56);
        expected.addElement(34);
        expected.addElement(21);
        expected.addElement(15);

        Assertions.assertArrayEquals(getArrayFromMyLinkedList(expected), getArrayFromMyLinkedList(actual));
    }


    private Object[] getArrayFromMyLinkedList(MyLinkedList<Integer> myLinkedList) {
        Object[] array = null;
        if (myLinkedList.size() == 0) {
            throw new NullPointerException("MyLinkedList is empty");
        } else {
            array = new Object[myLinkedList.size()];
            MyNode<Integer> current = myLinkedList.getHead();
            int count = 0;
            while (count < myLinkedList.size()) {
                array[count] = current.val;
                current = current.next;
                count++;
            }
        }
        return array;
    }

    private MyLinkedList<Integer> fillList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addElement(34);
        myLinkedList.addElement(15);
        myLinkedList.addElement(21);
        myLinkedList.addElement(56);

        return myLinkedList;
    }

}