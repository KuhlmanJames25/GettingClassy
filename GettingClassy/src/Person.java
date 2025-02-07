import java.util.Objects;
import java.util.Calendar;

public class Person {
    /*
    String ID = "";
    String firstName = "";
    String LastName = "";
    String title = "";
    String rec = "";
    int YOB = 0;
     */

    private String ID = "";
    private String firstName = "";
    private String lastName = "";
    private String title = "";
    private int YOB = 0;

    public Person(String ID, String firstName, String lastName, String title, int YOB) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getFullName()
    {
        return this.getFirstName() + " " + this.getLastName();
    }

    public String getFormalName()
    {
        return title + "" + this.getFullName();
    }

    public String toCSV()
    {
        return ID + ", " + firstName + ", " + lastName + ", " + title + ", " + YOB;
    }

    public String getAge()
    {
        int thisYearValue = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(thisYearValue - this.YOB);
    }

    public String getAge(int year)
    {
        int age = year - YOB;
        return String.valueOf(age);
    }

    public String toJSON() {
        return String.format("{\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"firstName\": \"" + firstName + "\",\n" +
                "  \"lastName\": \"" + lastName + "\",\n" +
                "  \"title\": \"" + title + "\",\n" +
                "  \"YOB\": " + YOB + "\n" +
                "}",
        this.ID, this.firstName, this.lastName, this.title, this.YOB);
}

    public String toXML() {
        return String.format("<Person>\n" +
                        "<ID>%s</ID>\n" +
                        "<firstName>%s</firstName>\n" +
                        "<lastName>%s</lastName>\n" +
                        "<title>%s</title>\n" +
                        "<YOB>%d</YOB>\n" +
                        "</Person>",
                this.ID, this.firstName, this.lastName, this.title, this.YOB);
    }



    @Override
    public String toString() {
        return "Person{" +
                "ID='" + ID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", title='" + title + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return YOB == person.YOB && Objects.equals(ID, person.ID) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, firstName, lastName, title,YOB);
    }

}





