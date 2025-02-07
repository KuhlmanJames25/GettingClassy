import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;

public class JUnitTestPerson {

    @Before
    public void setUp() {
        Person p = new Person("000001", "James", "Kuhlman", "Dr. ", 2005);
    }

    @Test
    public void testFullName() {
        Person p = new Person("000001", "James", "Kuhlman", "Dr. ", 2005);
        assertEquals("James Kuhlman", p.getFullName());
    }

    @Test
    public void testFormalName() {
        Person p = new Person("000001", "James", "Kuhlman", "Dr. ", 2005);
        assertEquals("Dr. James Kuhlman", p.getFormalName());
    }

    @Test
    public void testToCSV() {
        Person p = new Person("000001", "James", "Kuhlman", "Dr. ", 2005);
        assertEquals("000001, James, Kuhlman, Dr. , 2005", p.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("01","John","doe","mr",2005);

        assertEquals("{\n" +
                "  \"ID\": \"01\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"doe\",\n" +
                "  \"title\": \"mr\",\n" +
                "  \"YOB\": 2005\n" +
                "}", person.toJSON());

    }
        @Test
        public void testToXML() {
            // Create a new Person object
            Person person = new Person("01","John","doe","mr",2005);
            assertEquals("<Person>\n" +
                    "<ID>01</ID>\n" +
                    "<firstName>John</firstName>\n" +
                    "<lastName>doe</lastName>\n" +
                    "<title>mr</title>\n" +
                    "<YOB>2005</YOB>\n" +
                    "</Person>", person.toXML());

        }

}











