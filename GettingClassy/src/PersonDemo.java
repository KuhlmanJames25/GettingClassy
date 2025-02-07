public class PersonDemo {
    public static void main(String[] args) {
        Person person = new Person("01","John","doe","mr",2005);
        System.out.println(person.toXML());
        System.out.println(person.toJSON());
    }
}
