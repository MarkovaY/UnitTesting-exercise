package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private Database database;
    private final Person pesho = new Person(1, "Pesho");
    private final Person misho = new Person(2, "Misho");
    private final Person gosho = new Person(3, "Gosho");

    @Before
    public void prepare() throws OperationNotSupportedException {


        database = new Database(pesho, misho, gosho);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowFindByUsernameNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testThrowFindByUsernameMissing() throws OperationNotSupportedException {
        database.findByUsername("Sasho");
    }

    @Test
    public void testFindByUsernameReturnsName() throws OperationNotSupportedException {
        Person actual = database.findByUsername(pesho.getUsername());
        assertEquals(pesho.getId(), actual.getId());
        assertEquals(pesho.getUsername(), actual.getUsername());
    }
}