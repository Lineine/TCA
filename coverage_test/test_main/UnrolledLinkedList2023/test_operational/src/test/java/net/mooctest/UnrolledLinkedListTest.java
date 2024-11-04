package net.mooctest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class UnrolledLinkedListTest {
	
	private UnrolledLinkedList<Integer> list;

    @Before
    public void setUp() {
        list = new UnrolledLinkedList<>();
    }

    @Test
    public void testAddAndRemove() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));
        assertFalse(list.isEmpty());
        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
        assertFalse(list.contains(4));
        assertTrue(list.contains(1));
        assertTrue(list.contains(3));
        assertTrue(list.contains(1));
        assertFalse(list.contains(4));
    }

    @Test
    public void testToArray() {
        assertTrue(list.add(1));
        assertTrue(list.add(2));
        assertTrue(list.add(3));

        Object[] array = list.toArray();
        assertEquals(3, array.length);
        assertArrayEquals(new Object[] { 1, 2, 3 }, array);
    }
    @Test
    public void testContainsAll() {
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> collection1 = Arrays.asList(1, 2);
        assertTrue(list.containsAll(collection1));

        List<Integer> collection2 = Arrays.asList(2, 4);
        assertFalse(list.containsAll(collection2));

        List<Integer> collection3 = new ArrayList<>();
        assertTrue(list.containsAll(collection3));
    }

    @Test
    public void testAddAll() {
        List<Integer> collection1 = Arrays.asList(1, 2, 3);
        assertTrue(list.addAll(collection1));
        assertEquals(3, list.size());
        assertTrue(list.containsAll(collection1));

        List<Integer> collection2 = Arrays.asList(4, 5);
        assertTrue(list.addAll(collection2));
        assertEquals(5, list.size());
        assertTrue(list.containsAll(collection2));
    }

    @Test
    public void testRemoveAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> collection1 = Arrays.asList(2, 4);
        assertTrue(list.removeAll(collection1));
        assertEquals(2, list.size());
        assertTrue(list.containsAll(Arrays.asList(1, 3)));

        List<Integer> collection2 = Arrays.asList(5, 6);
        assertFalse(list.removeAll(collection2));
        assertEquals(2, list.size());
        assertTrue(list.containsAll(Arrays.asList(1, 3)));
    }

    @Test
    public void testRetainAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        List<Integer> collection1 = Arrays.asList(2, 4);
        assertTrue(list.retainAll(collection1));
        assertEquals(2, list.size());
        assertTrue(list.containsAll(collection1));

        List<Integer> collection2 = Arrays.asList(1, 3);
        assertEquals(2, list.size());
    }

    @Test
    public void testClear() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(1), list.get(0));
        assertEquals(Integer.valueOf(2), list.get(1));
        assertEquals(Integer.valueOf(3), list.get(2));
    }
    
    @Test
    public void testSet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.set(1, 5));
    }

    @Test
    public void testAddAtIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        list.add(1, 4);
    }

    @Test
    public void testRemove() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Integer.valueOf(2), list.remove(1));
    }

    @Test
    public void testIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }

    @Test
    public void testLastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        assertEquals(3, list.lastIndexOf(2));
        assertEquals(-1, list.lastIndexOf(4));
    }
    @Test
    public void testListIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator();
        assertTrue(iterator.hasNext());
        assertFalse(iterator.hasPrevious());

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(2), iterator.next());
        assertEquals(Integer.valueOf(1), iterator.previous());
        assertFalse(iterator.hasPrevious());
    }

    @Test
    public void testListIteratorWithIndex() {
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator(1);
        assertTrue(iterator.hasNext());
        assertTrue(iterator.hasPrevious());

    }
    @Test
    public void testIteratorRemove() {
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.next();
        iterator.remove();
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(3), list.get(1));
    }

    @Test
    public void testIteratorSet() {
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.next();
        iterator.set(4);
        //assertEquals(Integer.valueOf(4), list.get(0));
    }

    @Test
    public void testIteratorAdd() {
        list.add(1);
        list.add(2);
        list.add(3);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.next();
        iterator.add(4);
        assertEquals(4, list.size());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextNoSuchElement() {
        list.add(1);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.next();
        iterator.next(); 
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorPreviousNoSuchElement() {
        list.add(1);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.previous(); 
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testIteratorConcurrentModificationException() {
        list.add(1);
        list.add(2);

        ListIterator<Integer> iterator = list.listIterator();
        iterator.next();
        list.add(3); 
        iterator.next();
    }

}
