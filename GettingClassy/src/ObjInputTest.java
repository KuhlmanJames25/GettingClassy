import java.util.Scanner;

public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj in = new SafeInputObj();

        String firstName = in.getNonZeroLenString("Enter your name");
        int age = in.getRangedInt("Enter your age", 1, 120);
        int anyNumber = in.getInt("Enter any integer");
        double price = in.getRangedDouble("Enter a price", 0.01, 999.99);
        double anyDouble = in.getDouble("Enter any double");
        boolean confirm = in.getYNConfirm("Do you want to continue?");
        String zipCode = in.getRegExString("Enter your ZIP code (5 digits)", "\\d{5}");

        System.out.println("\nSummary:");
        System.out.println("Name: " + firstName);
        System.out.println("Age: " + age);
        System.out.println("Any Number: " + anyNumber);
        System.out.println("Price: " + price);
        System.out.println("Any Double: " + anyDouble);
        System.out.println("Continue? " + confirm);
        System.out.println("ZIP Code: " + zipCode);
    }
}
