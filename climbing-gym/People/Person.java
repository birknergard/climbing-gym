package People;
import Technical.idCreator;
public abstract class Person implements idCreator {
    /**
     * Abstract class for implementation of the Climber and Setter classes.
     * Creates a personId for the classes and stores the general information of
     * the person.
     */
    private static int previousId = 1;
    private final Info info;
    private final String personId;

    private class Info{
        private final String name;
        private final String phoneNumber;

        Info(){
            this.name = "V V";
            this.phoneNumber = "12345678";
        }

        Info(String name, String phoneNumber){
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getName() {
            return this.name;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }

    }

    public Person(String name, String phoneNumber) {
        this.info = new Info(name, phoneNumber);
        this.personId = createId("P", previousId);
        previousId++;
    }

    public Person() {
        this.info = new Info();
        this.personId = createId("P", previousId);
        previousId++;
    }

    private Info getInfo(){
        return this.info;
    }

    public String getName(){
        return this.getInfo().getName();
    }
    public String getPhoneNumber(){
        return this.getInfo().getPhoneNumber();
    }

    public String createId(String prefix, int staticNumber) {
        return prefix + staticNumber;
    }
    public String getPersonId(){
        return this.personId;
    }
    public String getFirstName(){
        String[] fullName = this.getName().split(" ");
        return fullName[0];
    }

}