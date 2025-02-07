import java.util.Objects;

public class Product {

    private String name = "";
    private String description = "";
    private String ID = "";
    private double cost = 0.0;

    public Product(String name, String description, String ID, double cost) {
        this.name = name;
        this.description = description;
        this.ID = ID;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String toCSV()
    {
        return name + ", " + description + ", " + ID + ", " + cost;
    }

    public String ToJSON() {
        return "Product{\n" +
                "  \"name\": \"" + name + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"ID\": \"" + ID + "\",\n" +
                "  \"cost\": \"" + cost + "\",\n" +
                "}";
    }

    public String ToXML() {
        return String.format("<Product>\n" +
                        "  <name>%s</name>\n" +
                        "  <description>%s</description>\n" +
                        "  <ID>%s</ID>\n" +
                        "  <cost>%s</cost>\n" +
                        "</Product>",
        this.name, this.description, this.ID, this.cost);
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ID='" + ID + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(cost, product.cost) == 0 && Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(ID, product.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, ID, cost);
    }
}
