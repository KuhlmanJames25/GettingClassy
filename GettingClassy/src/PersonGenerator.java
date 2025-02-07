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

public class PersonGenerator {
    public static void main(String[] args)
    {
        boolean doneInput = false;
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        String person1 = "";
        int YOB = 0;

        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        // create a loop to enter persons data
        do {
            ID = SafeInput.getNonZeroLenString(in, "Enter ID: ");
            firstName = SafeInput.getNonZeroLenString(in, "Enter First Name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name: ");
            title = SafeInput.getNonZeroLenString(in, "Enter Title: ");
            YOB = SafeInput.getRangedInt(in, "Enter Year of Birth: ", 0, 9999);
            person1 = ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;

            // Format the record into a table-like format
            person1 = String.format("%-5s%-10s%-10s%-10s%-5d", ID, firstName, lastName, title, YOB);

            // Table output to console
            String[] tableHeaders = {"ID", "Firstname", "Lastname", "Title", "YOB"};
            System.out.printf("%-5s%-10s%-10s%-10s%-5s\n", tableHeaders[0], tableHeaders[1], tableHeaders[2], tableHeaders[3], tableHeaders[4]);
            System.out.println("-------------------------------------------------------------");


            System.out.println(person1);

            Person person = new Person(ID, firstName, lastName, title, YOB);
            people.add(person);

            doneInput = SafeInput.getYNConfirm(in, "Are you done entering people ");

        }while(!doneInput);
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath(), "src", "PersonTestData.txt");

        try
        {
            //Table output
            String[] tableHeaders = {"ID", "Firstname", "Lastname", "Title", "YOB"};

            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            writer.write(String.format("%-5s%-10s%-10s%-10s%-5s\n",tableHeaders[0], tableHeaders[1], tableHeaders[2], tableHeaders[3], tableHeaders[4]));
            writer.write("-------------------------------------------------------------");

            // Finally can write the file LOL!

            for(Person person : people) {
                writer.write(person.toCSV());
            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }}