package com.khaliuk.list;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LinkedListTest {
    List<String> emptyList;
    List<String> notEmptyList;

    @Before
    public void setUp() {
        emptyList = new LinkedList<>();
        notEmptyList = new LinkedList<>();
        notEmptyList.add("one");
        notEmptyList.add("two");
        notEmptyList.add("three");
    }

    @Test
    public void testSuccessfulAddElementToEmptyListAndGetIt() {
        String elementToAdd = "one";
        emptyList.add(elementToAdd);
        assertEquals(1, emptyList.size());
        assertEquals(elementToAdd, emptyList.get(0));
    }

    @Test
    public void testSuccessfulRemoveElementFromList() {
        notEmptyList.remove(1);
        assertEquals(2, notEmptyList.size());
        assertEquals("one", notEmptyList.get(0));
        assertEquals("three", notEmptyList.get(1));
    }

    @Test
    public void testSuccessfulRemoveElementFromStartOfList() {
        notEmptyList.remove(0);
        assertEquals(2, notEmptyList.size());
        assertEquals("two", notEmptyList.get(0));
        assertEquals("three", notEmptyList.get(1));
    }

    @Test
    public void testSuccessfulRemoveElementFromEndOfList() {
        notEmptyList.remove(2);
        assertEquals(2, notEmptyList.size());
        assertEquals("one", notEmptyList.get(0));
        assertEquals("two", notEmptyList.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownOnWrongIndex() {
        notEmptyList.get(5);
    }
}
