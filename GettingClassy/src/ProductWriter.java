import java.util.ArrayList;
import java.util.Scanner;import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;

public class ProductWriter {
    public static void main(String[] args)
    {
        boolean doneInput = false;
        String ID = "";
        String Name = "";
        String Description = "";
        String product1 = "";
        Double Cost = 0.0;

        ArrayList<String> people = new ArrayList<String>();
        Scanner in = new Scanner(System.in);

        // create a loop to enter persons data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            Name = SafeInput.getNonZeroLenString(in, "Enter your name: ");
            Description = SafeInput.getNonZeroLenString(in, "Enter your products description: ");
            Cost = SafeInput.getRangedDouble(in, "Enter the total cost of your product: ", 0, 9999);
            product1 = ID + ", " + Name + ", " + Description + ", " + Cost;

            // Format the record into a table-like format
            product1 = String.format("%-5s%-10s%-10s%-5s", ID, Name, Description, Cost);

            // Table output to console
            String[] tableHeaders = {"ID", "Name", "Description", "Cost"};
            System.out.printf("%-5s%-10s%-10s%-5s\n", tableHeaders[0], tableHeaders[1], tableHeaders[2], tableHeaders[3]);
            System.out.println("-------------------------------------------------------------");

            System.out.println(product1);

            people.add(product1);

            doneInput = SafeInput.getYNConfirm(in, "Are you done entering people ");

        }while(!doneInput);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", "ProductTestData.txt");

        try
        {
            String[] tableHeaders = {"ID", "Name", "Description", "Cost"};

            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            writer.write(String.format("%-5s%-10s%-10s%-5s\n",tableHeaders[0], tableHeaders[1], tableHeaders[2], tableHeaders[3]));
            writer.write("-------------------------------------------------------------");

            for(String person : people)
            {
                writer.write(person, 0, person.length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}