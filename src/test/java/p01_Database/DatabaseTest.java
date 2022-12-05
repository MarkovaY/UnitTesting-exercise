package p01_Database;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private Integer[] integerArray = {2, 5, 1, 4};

    @Test
    public void testConstructorCreatesValidDatabase() throws OperationNotSupportedException {
        database = new Database(integerArray);
        Integer[] dbElements = database.getElements();

        assertArrayEquals(integerArray, dbElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsWithMoreThanSixteenElements() throws OperationNotSupportedException {
        integerArray = new Integer[17];
        database = new Database(integerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsWithoutElements() throws OperationNotSupportedException {
        integerArray = new Integer[0];
        database = new Database(integerArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowsIsElementAddedIsNull() throws OperationNotSupportedException {
        database = new Database(integerArray);
        database.add(null);
    }

    @Test
    public void testDatabaseAddsElements() throws OperationNotSupportedException {
        database = new Database(integerArray);
        database.add(5);

        Integer[] integers = database.getElements();
        int expected = integers[integers.length - 1];
        assertEquals(expected, 5);
        assertEquals(integerArray.length + 1, integers.length);
    }

    @Test
    public void testDatabaseRemovesElements() throws OperationNotSupportedException {
        database = new Database(integerArray);
        database.remove();
        Integer[] elementsAfterRemove = database.getElements();
        assertEquals(integerArray.length - 1, elementsAfterRemove.length);
        int expectedLastElement = integerArray[integerArray.length - 2];
        int currentLastElement = elementsAfterRemove[elementsAfterRemove.length - 1];
        assertEquals(expectedLastElement, currentLastElement);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowsIfDBIsEmpty() throws OperationNotSupportedException {
        database = new Database(integerArray);
        for (int i = 0; i < integerArray.length; i++) {
            database.remove();
        }
        database.remove();
    }

}