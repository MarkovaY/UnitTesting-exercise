package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @Before
    public void setUp(){
       list = new CustomLinkedList<>();
       list.add("This");
       list.add("Is");
       list.add("Unit");
    }
    @Test
    public void testAddToList() {
        list.add("Testing");
        assertEquals(list.getCount() - 1, list.indexOf("Testing"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithNegativeIndex() {
        list.get(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetShouldThrowWithHigherIndex() {
        list.get(list.getCount() + 1);
    }

    @Test
    public void testGetElementAtGivenIndex() {
        assertEquals("This", list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithNegativeIndex() {
        list.set(-2, "Fail");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetShouldThrowWithHigherIndex() {
        list.set(list.getCount() + 1, "Fail");
    }

    @Test
    public void testSetElementAtGivenIndex() {
        list.set(1, "Has to be");
        assertEquals("Has to be", list.get(1));
    }

    @Test
    public void testReturnsIndexOfGivenElement() {
        assertEquals(2, list.indexOf("Unit"));
    }

    @Test
    public void testDoesNotReturnIndexOfGivenElement() {
        assertEquals(-1, list.indexOf("Fail"));
    }

    @Test
    public void testContainsReturnsTrue() {
        assertTrue(list.contains("This"));
    }

    @Test
    public void testContainsReturnsFalse() {
        assertFalse(list.contains("Monkey"));
    }

    @Test
    public void testRemoveMissingElement() {
        assertEquals(-1, list.remove("Monkey"));
    }

    @Test
    public void testRemovesExistingElement() {
        int countBeforeRemove = list.getCount();
        assertEquals(0, list.remove("This"));
        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove -1, countAfterRemove);
        assertEquals(-1, list.indexOf("This"));
    }

    @Test
    public void testRemovesElementAtGivenIndex() {
        assertEquals(list.get(1), list.removeAt(1));

        int countBeforeRemove = list.getCount();
        list.removeAt(1);
        int countAfterRemove = list.getCount();
        assertEquals(countBeforeRemove - 1, countAfterRemove);
        assertEquals(-1, list.indexOf("Is"));
    }

}