package ru.balrom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class MyArrayListTest {

    @Test
    public void correctlyAddElements() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        Object[] actual = myArrayList.getArray();
        Object[] expected = {7, 12, 5, 3, 21};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addElementAtCorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(2);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(1, 67);

        Object[] actual = myArrayList.getArray();
        Object[] expected = {7, 67, 12, null};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addElementAtIncorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(2);
        myArrayList.addElement(7);
        myArrayList.addElement(12);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.addElement(10, 67));
    }


    @Test
    public void getElementFromCorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(2);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(67);

        int actual = myArrayList.getElement(0);
        int expected = 7;

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void getElementFromIncorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(2);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(67);

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> myArrayList.getElement(-1));
    }


    @Test
    public void removeCorrectElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        myArrayList.removeElement(new Integer(12));

        Object[] actual = myArrayList.getArray();
        Object[] expected = {7, 5, 3, 21, null};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeIncorrectElement() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        boolean actual = myArrayList.removeElement(new Integer(45));
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeElementFromCorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        myArrayList.removeElement(2);

        Object[] actual = myArrayList.getArray();
        Object[] expected = {7, 12, 3, 21, null};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void removeElementFromIncorrectIndex() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        boolean actual = myArrayList.removeElement(45);
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void sortArrayInNaturalOrder(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        myArrayList.sort();

        Object[] actual = myArrayList.getArray();
        Object[] expected = {3, 5, 7, 12, 21};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortArrayInNotNaturalOrder(){
        MyArrayList<Integer> myArrayList = new MyArrayList<>(5);
        myArrayList.addElement(7);
        myArrayList.addElement(12);
        myArrayList.addElement(5);
        myArrayList.addElement(3);
        myArrayList.addElement(21);

        myArrayList.sort((x,y) -> y-x);

        Object[] actual = myArrayList.getArray();
        Object[] expected = {21, 12, 7, 5, 3};

        Assertions.assertArrayEquals(expected, actual);
    }
}