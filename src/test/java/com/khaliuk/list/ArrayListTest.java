package com.khaliuk.list;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayListTest {
    List<String> emptyList;
    List<String> notEmptyList;
    List<String> fullCapacityList;

    @Before
    public void setUp() {
        emptyList = new ArrayList<>();
        notEmptyList = new ArrayList<>();
        notEmptyList.add("one");
        notEmptyList.add("two");
        notEmptyList.add("three");
        fullCapacityList = new ArrayList<>();
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

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testExceptionThrownOnWrongIndex() {
        notEmptyList.get(5);
    }

    @Test
    public void testArrayListSuccessfullyResizeInternalArray() {
        // Fill tested list to default full capacity, 16
        for (int i = 0; i < 16; i++) {
            fullCapacityList.add("element");
        }
        // Add 17th element, method resizeGreater() should be called
        fullCapacityList.add("one more element");
        assertEquals(17, fullCapacityList.size());
        // Remove 9 elements to call resizeLess() method on array size 8
        for (int i = 0; i < 9; i++) {
            fullCapacityList.remove(fullCapacityList.size() - 1);
        }
        assertEquals(8, fullCapacityList.size());
    }
}
