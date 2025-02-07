import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;

public class JUnitTestProduct {

    @Before
    public void setUp() {
        Product product = new Product("James", "James's mythical coffee", "000001", 200.0);
    }

    @Test
    public void testToCSV() {
        Product product = new Product("James", "James's mythical coffee", "000001", 200.0);
        assertEquals("James, James's mythical coffee, 000001, 200.0", product.toCSV());
    }

    @Test
    public void productToJSON() {
        Product product = new Product("James", "James's mythical coffee", "000001", 200.0);
        assertEquals("Product{\n" +
                "  \"name\": \"James\",\n" +
                "  \"description\": \"James's mythical coffee\",\n" +
                "  \"ID\": \"000001\",\n" +
                "  \"cost\": \"200.0\",\n" +
                "}", product.ToJSON());

    }

   @Test
  public void testToXML() {
       // Create a new Person object
      Product product = new Product("James", "James's mythical coffee", "000001", 200.0);
      assertEquals("<Product>\n" +
              "  <name>James</name>\n" +
              "  <description>James's mythical coffee</description>\n" +
              "  <ID>000001</ID>\n" +
              "  <cost>200.0</cost>\n" +
              "</Product>", product.ToXML());

   }
}
