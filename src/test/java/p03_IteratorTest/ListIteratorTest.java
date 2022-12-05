package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;


import static org.junit.Assert.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] ELEMENTS = {"Take", "This", "String"};

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsWithNull() throws OperationNotSupportedException {
        new ListIterator( null);
    }

    @Test
    public void testConstructorCreatesListIterator() throws OperationNotSupportedException {
        listIterator = new ListIterator(ELEMENTS);
        assertEquals(ELEMENTS[0], listIterator.print());
        listIterator.move();
        assertEquals(ELEMENTS[1], listIterator.print());
        listIterator.move();
        assertEquals(ELEMENTS[2], listIterator.print());
    }

    @Test
    public void testHasNext() {
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertTrue(listIterator.hasNext());
        listIterator.move();
        assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMove() {
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
        assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintThrowsIfEmpty() throws OperationNotSupportedException {
        ListIterator emptyIterator = new ListIterator();
        emptyIterator.print();
    }

    @Test
    public void testPrint() {
        assertEquals(ELEMENTS[0], listIterator.print());
        listIterator.move();
        assertEquals(ELEMENTS[1], listIterator.print());
    }

}