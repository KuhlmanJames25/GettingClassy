public class ProductTest {
    public static void main(String[] args) {
        Product product = new Product("James", "James's mythical coffee", "000001", 200.0);
        System.out.println(product.ToXML());
        System.out.println(product.ToJSON());
    }
}