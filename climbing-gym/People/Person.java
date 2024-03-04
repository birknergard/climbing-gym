package People;
import Technical.idCreator;
public abstract class Person implements idCreator {
    private static int previousId = 1;
    private final String personId;
    private final String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.personId = createId("P");
        previousId++;
    }

    public Person() {
        this.name = "Vanlig Vanligsen";
        this.phoneNumber = "12345678";
        this.personId = createId("P");
        previousId++;
    }

    public String createId(String prefix) {
        return prefix + previousId;
    }
    public String getPersonId(){
        return this.personId;
    }
    public String getFirstName(){
        String[] fullName = this.getName().split(" ");
        return fullName[0];
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}